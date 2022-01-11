package com.kits.inms.utils;

import com.bstek.bdf2.core.orm.jdbc.dialect.OracleDialect;
import com.bstek.dorado.data.provider.Page;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate4.SessionFactoryUtils;

import java.sql.*;
import java.util.*;

/**
 * 将sql的查询结果封装成List<Map<K,V>>形式,或者转成实体类
 *
 * @author <a href="mailto:yaobangqi@whknow.cn">姚邦奇</a>
 * @version 1.0.0
 * @file QueryUtil.java
 * @date 2018-10-9 19:14:53
 */
public class QueryUtil {
    private OracleDialect dialect = new OracleDialect();
    private static Logger logger = LoggerFactory.getLogger(QueryUtil.class);
    private final StringBuilder sbSPA = new StringBuilder();
    private final StringBuilder sbSPB = new StringBuilder(" limit ? offset ?");
    private final StringBuilder sbSCA = new StringBuilder("SELECT count(1) count_ FROM ( ");
    private final StringBuilder sbSCB = new StringBuilder(") std_inner_count_");
    private BeanUtil beanUtil = BeanUtil.getInstance();
    private String sql;
    private PreparedStatement pst;
    private Session session;
    private Connection conn;
    private Boolean isAutoClose = true;
    private List<String> block;

    private QueryUtil(Builder builder) {
        setSql(builder.sql);
        setPst(builder.pst);
        setConn(builder.conn);
        setSession(builder.session);
        setBlockList(builder.blockList);
    }

    public static Connection getConnection(Session session) throws SQLException {
        SessionFactory sessionFactory = session.getSessionFactory();
        return SessionFactoryUtils.getDataSource(sessionFactory).getConnection();
    }

    /**
     * 执行sql
     *
     * @return 封装结果<br>
     * 注意:字段名要跟属性名对应上<br>
     * 例如:HELLO_WORLD_的属性名为helloWorld<br>
     * HE_LLO_WORLD_的属性名为heLloWorld<br>
     * HELLO_WORLD的属性名为helloWorld<br>
     * _HELLO_WORLD_的属性名为_HELLO_WORLD_<br>
     */
    public List<Map<String, Object>> getMapList() {
        List<Map<String, Object>> list = new ArrayList<>();
        try {
            PreparedStatement pst;
            if (this.pst == null) {
                // 得到connection
                if (conn == null) {
                    conn = getConnection();
                } else if (conn.isClosed()) {
                    conn = getConnection();
                }

                pst = conn.prepareStatement(sql);
            } else {
                pst = this.pst;
            }

            // 检查pst
            if (pst == null) {
                throw new RuntimeException("无法构建语句");
            }

            // 取得结果集
            ResultSet rs = pst.executeQuery();
            String[] colNames = getColNames(rs);

            // 遍历结果集
            while (rs.next()) {
                Map<String, Object> result = new HashMap<String, Object>();
                for (String colName : colNames) {
                    // 如果列名不在黑名单
                    if (!block.contains(colName)) {
                        // 得到属性名
                        String key = prefixStr(colName);
                        Object value = rs.getObject(colName);
                        // 特殊的数据类型转化
                        result.put(key, value);
                    }
                }
                list.add(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            autoClose();
        }
        return list;
    }

    public <T> List<T> getList() {
        List<T> list = new ArrayList<>();
        try {
            PreparedStatement pst;
            if (this.pst == null) {
                // 得到connection
                if (conn == null) {
                    conn = getConnection();
                } else if (conn.isClosed()) {
                    conn = getConnection();
                }

                pst = conn.prepareStatement(sql);
            } else {
                pst = this.pst;
            }

            // 检查pst
            if (pst == null) {
                throw new RuntimeException("无法构建语句");
            }

            // 取得结果集
            ResultSet rs = pst.executeQuery();

            // 遍历结果集
            while (rs.next()) {
                T value = (T) rs.getObject(1);
                list.add(value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            autoClose();
        }
        return list;
    }

    /**
     * 分页查询
     *
     * @param page dorado的page对象，Page(Map<String,Object>)
     */
    public void getPaging(Page<Map<String, Object>> page) {
        try {
            if (conn == null) {
                conn = getConnection();
            }
            if (sql == null) {
                throw new RuntimeException("sql为null");
            }
//            StringBuilder sb = new StringBuilder(sql);
//            sb.append(sbSPB);
//
//            pst = conn.prepareStatement(sb.toString());
//            int startIndex = (page.getPageNo() - 1) * page.getPageSize();
//            pst.setInt(1, page.getPageSize());
//            pst.setInt(2, startIndex);
            sql = dialect.getPaginationSql(sql, page.getPageNo(), page.getPageSize());

            List<Map<String, Object>> list = getMapList();
            page.setEntities(list);
            page.setEntityCount(querySQLCount());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            autoClose();
        }
    }

    /**
     * 分页查询
     *
     * @param page dorado的page对象，Page(Map<String,Object>)
     * @param para pst的参数
     */
    public void getPaging(Page<Map<String, Object>> page, List<String> para) {
        try {
            if (conn == null) {
                conn = getConnection();
            }
            if (sql == null) {
                throw new RuntimeException("sql为null");
            }
//            StringBuilder sb = new StringBuilder(sql);
//            sb.append(sbSPB);

//            pst = conn.prepareStatement(sb.toString());
            sql = dialect.getPaginationSql(sql, page.getPageNo(), page.getPageSize());
            for (int i = 1; i <= para.size(); i++) {
                pst.setObject(i, para.get(i - 1));
            }
//            int startIndex = (page.getPageNo() - 1) * page.getPageSize();
//            pst.setInt(para.size() + 1, page.getPageSize());
//            pst.setInt(para.size() + 2, startIndex);

            List<Map<String, Object>> list = getMapList();
            page.setEntities(list);
            page.setEntityCount(querySQLCount());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            autoClose();
        }
    }

    public Map<String, Object> getMap() {
        try {
            PreparedStatement pst;
            if (this.pst == null) {
                if (conn == null) {
                    // 得到connection
                    conn = getConnection();
                } else if (conn.isClosed()) {
                    conn = getConnection();
                }

                pst = conn.prepareStatement(sql);
            } else {
                pst = this.pst;
            }

            // 检查pst
            if (pst == null) {
                throw new RuntimeException("无法构建语句");
            }

            // 取得结果集
            ResultSet rs = pst.executeQuery();
            String[] colNames = getColNames(rs);

            // 遍历结果集
            Map<String, Object> result = new HashMap<String, Object>();
            while (rs.next()) {
                String key = rs.getString(colNames[0]);
                String value = rs.getString(colNames[1]);
                result.put(key, value);
            }
            return result;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        } finally {
            autoClose();
        }
        return null;
    }

    public <V> Map<String, V> getMap(Class<V> valueClass) {
        try {
            PreparedStatement pst;
            if (this.pst == null) {
                if (conn == null) {
                    // 得到connection
                    conn = getConnection();
                } else if (conn.isClosed()) {
                    conn = getConnection();
                }

                pst = conn.prepareStatement(sql);
            } else {
                pst = this.pst;
            }

            // 检查pst
            if (pst == null) {
                throw new RuntimeException("无法构建语句");
            }

            // 取得结果集
            ResultSet rs = pst.executeQuery();
            String[] colNames = getColNames(rs);

            // 遍历结果集
            Map<String, V> result = new HashMap<>();
            while (rs.next()) {
                String key = rs.getString(colNames[0]);
                V value = (V) rs.getObject(colNames[1]);
                result.put(key, value);
            }
            return result;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        } finally {
            autoClose();
        }
        return null;
    }

    public <T> List<T> getBeanList(Class<T> clazz) {
        List<T> result = new ArrayList<>();
        List<Map<String, Object>> list = getMapList();
        for (Map<String, Object> map : list) {
            T obj = beanUtil.transMap2Bean(map, clazz);
            result.add(obj);
        }
        return result;
    }

    /**
     * 获取结果总数
     *
     * @return
     */
    private int querySQLCount() {
        StringBuilder sb = new StringBuilder(sql);
        sb.insert(0, sbSCA);
        sb.append(sbSCB);
        try {
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sb.toString());
            if (rs.next()) {
                int rowCount = rs.getInt("count_");
                return rowCount;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            autoClose();
        }
        return 0;
    }

    /**
     * 获取列名
     *
     * @param rs
     * @return
     * @throws SQLException
     */
    private String[] getColNames(ResultSet rs) throws SQLException {
        // 获取结果集元数据
        ResultSetMetaData rsmd = rs.getMetaData();
        // 取得列数
        int colCount = rsmd.getColumnCount();
        String[] colNames = new String[colCount];
        // 得到列名
        for (int i = 0; i < colCount; i++) {
            colNames[i] = rsmd.getColumnLabel(i + 1);
        }

        return colNames;
    }

    /**
     * 关闭连接
     */
    public void close() {
        try {
            if (pst != null) {
                pst.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void autoClose() {
        if (isAutoClose) {
            close();
        }
    }

    /**
     * 对字段名中的下划线进行处理
     *
     * @param str 字段名
     * @return 处理结果 <br>
     * 例如：输入TB00_ID_则返回tb00Id <br>
     * 输入TB00_ID则返回tb00Id <br>
     * 如果以'_'开头，例如输入_TB00_ID_则原样返回
     */
    private String prefixStr(String str) {
        // 如果开头不 为'_'
        if (str.indexOf("_") > 0) {
            // 先全部转为小写
            str = str.toLowerCase();
            StringBuilder sb = new StringBuilder(str);
            // 查询str中的'_'
            for (int i = 0; i < sb.length(); i++) {
                // 找'_'
                int uIndex = sb.indexOf("_");
                // 如果'_'不在结尾
                if (uIndex + 1 < sb.length()) {
                    // 取出'_'后一个字符
                    char tarChar = sb.charAt(uIndex + 1);
                    // 将该字符转为大写
                    sb.setCharAt(uIndex + 1, (char) (tarChar - 32));
                    // 删除'_'
                    sb.deleteCharAt(uIndex);
                    // 当前index为选中的字符
                    i = uIndex;
                }
            }
            // 如果最后一个字符是'_'
            if (sb.lastIndexOf("_") + 1 == sb.length()) {
                sb.deleteCharAt(sb.length() - 1);
            }

            return sb.toString();
        } else {
            return str;
        }
    }

    private Connection getConnection() throws SQLException {
        return getConnection(getSession());

    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public PreparedStatement getPst() {
        return pst;
    }

    public void setPst(PreparedStatement pst) {
        this.pst = pst;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public List<String> getBlockList() {
        return block;
    }

    public void setBlockList(List<String> blockList) {
        this.block = blockList;
    }

    /**
     * 建造者
     *
     * @author <a href="mailto:yaobangqi@whknow.cn">姚邦奇</a>
     * @version 1.0
     * @file QueryUtil.java
     * @date 2018-5-27下午4:44:38
     */
    public static class Builder {
        private String sql;
        private PreparedStatement pst;
        private Session session;
        private Connection conn;
        private Boolean isAutoClose = true;
        private List<String> blockList = new ArrayList<>();

        /**
         * 构建建造者
         *
         * @param sql SQL是必须的
         */
        public Builder(String sql, Session session) {
            sql(sql);
            session(session);
        }

        /**
         * 构建建造者
         *
         * @param pst SQL是必须的
         */
        public Builder(PreparedStatement pst, Session session) {
            pst(pst);
            session(session);
        }

        /**
         * 构建QueryUtil
         *
         * @return 构建好的QueryUtil
         */
        public QueryUtil build() {
            return new QueryUtil(this);
        }

        public Builder sql(String sql) {
            this.sql = sql;
            return this;
        }

        public Builder pst(PreparedStatement pst) {
            this.pst = pst;
            return this;
        }

        public Builder session(Session session) {
            this.session = session;
            return this;
        }

        public Builder conn(Connection conn) {
            this.conn = conn;
            return this;
        }

        public Builder isAutoClose(boolean isAutoClose) {
            this.isAutoClose = isAutoClose;
            return this;
        }

        /**
         * 设置黑名单列表，在黑名单中的列名不会组装到Map里
         *
         * @param blockList
         */
        public Builder block(List<String> blockList) {
            if (blockList != null) {
                this.blockList = blockList;
                return this;
            }
            return null;
        }

        /**
         * 设置黑名单列表，在黑名单中的列名不会组装到Map里
         *
         * @param block
         */
        public Builder blockList(String[] block) {
            if (blockList != null) {
                block(Arrays.asList(block));
                return this;
            }
            return null;
        }
    }
}
