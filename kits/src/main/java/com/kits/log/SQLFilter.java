package com.kits.log;

import com.alibaba.druid.filter.FilterChain;
import com.alibaba.druid.filter.logging.Slf4jLogFilter;
import com.alibaba.druid.proxy.jdbc.ConnectionProxy;
import com.alibaba.druid.proxy.jdbc.PreparedStatementProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;

public class SQLFilter extends Slf4jLogFilter {
    private Logger logger = LoggerFactory.getLogger(SQLFilter.class);

    @Override
    public PreparedStatementProxy connection_prepareStatement(FilterChain chain, ConnectionProxy connection, String sql) throws SQLException {
        logger.info(sql);
        return super.connection_prepareStatement(chain, connection, sql);
    }
}
