package com.kits.inms.bs.bo;

import com.bstek.bdf2.core.orm.hibernate.HibernateDao;
import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.data.entity.EntityState;
import com.bstek.dorado.data.entity.EntityUtils;
import com.bstek.dorado.data.provider.Page;
import com.bstek.dorado.uploader.UploadFile;
import com.bstek.dorado.uploader.annotation.FileResolver;
import com.kits.inms.bs.domain.Tbbs024;
import com.kits.inms.utils.AppUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class Bsjc024BO extends HibernateDao{



	private static final Logger logger = LoggerFactory.getLogger(Bsjc024BO.class);

	//查询商品表信息
    @SuppressWarnings("unchecked")
    @DataProvider
    public void queryBs024(Page<Tbbs024> page, Map<String, Object> map) throws Exception {
        String hql = " from Tbbs024 where 1=1";

        if (map != null) {
        	//商品名称
            String productName = (String) map.get("productName") == null ? "" : (String) map.get("productName");
            if (StringUtils.isNotBlank(productName)) {
                hql += " and productName like '%" + productName + "%'";
            }
            //商品编号
            String productNo = (String) map.get("productNo") == null ? "" : (String) map.get("productNo");
            if (StringUtils.isNotBlank(productNo)) {
            	hql += " and productNo like '%" + productNo + "%'";
            }
            //商品状态
            String status = (String) map.get("status") == null ? "" : (String) map.get("status");
            if (StringUtils.isNotBlank(status)) {
            	if ("A".equals(status)) {
            		hql += " and status != '" + status + "' ";
				}else{
					hql += " and status = '" + status + "' ";
				}
        	}
            //产品大类
            String tradeName = (String) map.get("tradeName") == null ? "" : (String) map.get("tradeName");
            if (StringUtils.isNotBlank(tradeName)) {
            	hql += " and tradeName like '%" + tradeName + "%'";
            }
       }
        hql += " order by tradeName " ; 
        List<Tbbs024> list = (List<Tbbs024>) this.query(hql, null, page.getPageNo(), page.getPageSize());
        page.setEntities(list);
        page.setEntityCount(this.query(hql).size());
    }
    
    //商品表保存,删除,修改
    @DataResolver
    @Transactional(rollbackFor = Exception.class)
    public void saveBs024(Collection<Tbbs024> dataList,Map<String, Object> map) throws Exception {
		try {
			for (Tbbs024 dm11 : dataList) {
				EntityState state = EntityUtils.getState(dm11);
				if (state == EntityState.NEW) {
					// 保存
					//状态已建立
					dm11.setStatus("00");
					dm11.setPkBs024(AppUtils.getUUIDKey());
					this.getSession().save(dm11);
					
				} else if (state == EntityState.DELETED) {
	
					this.getSession().delete(dm11);
				} else if (state == EntityState.MODIFIED) {
					// 设置修改日期 修改人
					/*dm11.setUpdateDate(new Date());
					dm11.setUpdateEmp(UserUtil.getLoginUserName());*/
					this.getSession().update(dm11);
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			throw e;
		}
	}
    
    //Excel 文件导入

	@FileResolver
	@Transactional(rollbackFor = Exception.class)
	public void process(UploadFile file, Map<String, Object> map) throws IOException {
		try {
			// 文件系统
			POIFSFileSystem fs = null;
			// 工作簿
			HSSFWorkbook wb = null;
			// 工作表
			HSSFSheet sheet = null;
			// 表行
			HSSFRow row = null;
			
			InputStream is = file.getInputStream();
			
			// 创建一个表一行对应的实体对象
			try {
				fs = new POIFSFileSystem(is);
				wb = new HSSFWorkbook(fs);
			} catch (IOException e) {
				e.printStackTrace();
			}
			sheet = wb.getSheetAt(0);
			// 第一行
			row = sheet.getRow(1);
			// 得到总行数
			int rowNum = sheet.getLastRowNum() + 1;
			// row = sheet.getRow(0);
			int colNum = row.getPhysicalNumberOfCells();
			// 正文内容应该从第二行开始
			for (int i = 1; i < rowNum; i++) {
				Tbbs024 bs024 = new Tbbs024();
				row = sheet.getRow(i);
				for (int j = 0; j < colNum; j++) {
					switch (j) {
					case 0:
						// 商品编号
						bs024.setProductNo(getCellFormatValue(row.getCell(j)).trim());
						break;
					case 1:
						// 商品名称
						bs024.setProductName(getCellFormatValue(row.getCell(j)).trim());
						break;
					case 2:
						// 产品大类
						bs024.setTradeName(getCellFormatValue(row.getCell(j)).trim());
						break;
//					case 3:
//						//长
//						bs024.setLength(new BigDecimal(getCellFormatValue(row
//								.getCell(j)) == "" ? "0" : getCellFormatValue(row
//										.getCell(j))));
//						break;
//					case 4:	
//						//宽
//						bs024.setWidth(new BigDecimal(getCellFormatValue(row
//								.getCell(j)) == "" ? "0" : getCellFormatValue(row
//										.getCell(j))));
//						break;
//					case 5:		
//						//厚
//						bs024.setThick(new BigDecimal(getCellFormatValue(row
//								.getCell(j)) == "" ? "0" : getCellFormatValue(row
//										.getCell(j))));
//						break;
//					case 6:		
//						//内径
//						bs024.setInnerDiameter(new BigDecimal(getCellFormatValue(row
//								.getCell(j)) == "" ? "0" : getCellFormatValue(row
//										.getCell(j))));
//						break;
//					case 7:		
//						//外径
//						bs024.setOuterDiameter(new BigDecimal(getCellFormatValue(row
//								.getCell(j)) == "" ? "0" : getCellFormatValue(row
//										.getCell(j))));
//						break;	
//					case 8:		
//						//重量
//						bs024.setInvWgt(new BigDecimal(getCellFormatValue(row
//								.getCell(j)) == "" ? "0" : getCellFormatValue(row
//										.getCell(j))));
//						break;
//					case 9:
//						//计价方式
//						bs024.setPriceType("1".equals(getCellFormatValue(row.getCell(j)).trim() ) ? "01" : "02" );
//					case 10:
//						//技术标准
//						bs024.setTechNorms(getCellFormatValue(row.getCell(j)).trim());
//						break;	
					case 3:
						//质量标准
						if("1".equals(getCellFormatValue(row.getCell(j)).trim())){
							bs024.setQualNorms("01");
						}else if("2".equals(getCellFormatValue(row.getCell(j)).trim())){
							bs024.setQualNorms("02");
						}else{
							bs024.setQualNorms("03");
						}
					case 4:
						//产地
						bs024.setDefs01((getCellFormatValue(row.getCell(j)).trim()));
						break;	
					case 5:
						//材质
						bs024.setTexture(getCellFormatValue(row.getCell(j)).trim());
						break;
					case 6:
						//长
						bs024.setLength(new BigDecimal(getCellFormatValue(row
								.getCell(j)) == "" ? "0" : getCellFormatValue(row
										.getCell(j))));
						break;
					case 7:	
						//宽
						bs024.setWidth(new BigDecimal(getCellFormatValue(row
								.getCell(j)) == "" ? "0" : getCellFormatValue(row
										.getCell(j))));
						break;
					case 8:		
						//厚
						bs024.setThick(new BigDecimal(getCellFormatValue(row
								.getCell(j)) == "" ? "0" : getCellFormatValue(row
										.getCell(j))));
						break;
					case 9:
						//牌号
						bs024.setShopSign(getCellFormatValue(row.getCell(j)).trim());
						break;	
					case 10:
						//用途
						bs024.setPurpose(getCellFormatValue(row.getCell(j)).trim());
						break;	
					case 11:
						//备注
						bs024.setDesrc(getCellFormatValue(row.getCell(j)).trim());
						break;		
					}	
				}
//				if("01".equals(bs024.getPriceType())){
//					bs024.setMeaUnit("01");
//				}else if("02".equals(bs024.getPriceType())){
//					bs024.setMeaUnit("02");
//				}
				bs024.setPkBs024(AppUtils.getUUIDKey());
				bs024.setStatus("00");
				this.getSession().save(bs024);
				this.getSession().beginTransaction().commit();
			}
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			throw e;
		}	
}

    
	/**
	 * 根据HSSFCell类型设置数据
	 * @param cell
	 * @return
	 */
	private String getCellFormatValue(HSSFCell cell) {
		String cellvalue = "";
		if (cell != null) {
			// 判断当前Cell的Type
			switch (cell.getCellType()) {
			// 如果当前Cell的Type为NUMERIC
			case HSSFCell.CELL_TYPE_NUMERIC:
			case HSSFCell.CELL_TYPE_FORMULA: {
				// 判断当前的cell是否为Date
				if (HSSFDateUtil.isCellDateFormatted(cell)) {
					// 如果是Date类型则，转化为Data格式
					// 方法1：这样子的data格式是带时分秒的：2011-10-12 0:00:00
					// cellvalue = cell.getDateCellValue().toLocaleString();
					// 方法2：这样子的data格式是不带带时分秒的：2011-10-12
					Date date = cell.getDateCellValue();
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					cellvalue = sdf.format(date);
				}
				// 如果是纯数字
				else {
					// 取得当前Cell的数值
					cell.setCellType(XSSFCell.CELL_TYPE_STRING);
					cellvalue = cell.getStringCellValue();
				}
				break;
			}
			// 如果当前Cell的Type为STRIN
			case HSSFCell.CELL_TYPE_STRING:
				// 取得当前的Cell字符串
				cellvalue = cell.getRichStringCellValue().getString();
				break;
			// 默认的Cell值
			default:
				cellvalue = " ";
			}
		} else {
			cellvalue = "";
		}
		return cellvalue;
	}




    /**
     * 提供并下载模板(bs024商品表)
     * @param response
     * @param request
     * @throws IOException
     */
    @SuppressWarnings("unchecked")
    @RequestMapping("/exportPoItemModel024")
    public void exportMatrlModel(HttpServletResponse response,
                                                HttpServletRequest request) throws IOException {
        try {
            String fileName = "商品表模板.csv";
            //导出excel
            response.setContentType("application/csv,charset=utf-8");
            response.setHeader("Content-Disposition", "attachment;filename=\""
                    + new String(fileName.getBytes(), "iso-8859-1") + "\"");
            ServletOutputStream out = response.getOutputStream();
            try {
                exportMWExcel(out);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (out != null) {
                out.close();
            }
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
            throw e;
        } 
    }

    /**
     * 生成汇入模板
     * @param out
     * @throws Exception
     */
    public static void exportMWExcel(ServletOutputStream out) throws Exception {

        // 1.创建工作薄
        HSSFWorkbook workbook = new HSSFWorkbook();
        // 2.创建工作表
        HSSFSheet sheet = workbook.createSheet("采购合同明细表");
        //sheet.setColumnWidth(0, 15 * 256);

        // 设置默认列宽
        sheet.setDefaultColumnWidth(20);
        // 写列标题
//        String[] titles = {"商品名称","品名" , "长度", "宽度", "厚度","内径","外径","重量",
//                "计价方式(以重量计价为1,单位:吨 ; 以数量计价为2,单位:件)","技术标准","材质","质量标准","用途","牌号",
//                "备注说明"};
        String[] titles = {"商品编号","商品名称","产品大类" ,"质量标准(1为厂标,2为国标,3为不分)" ,"产地" ,"材质" , "长度", "宽度", "厚度","牌号",
                			"用途","备注说明"};
        // 创建列标题行
        HSSFRow row = sheet.createRow(1);
        //row.setHeight((short) 250);
        for (int i = 0; i < titles.length; i++) {
            // 创建单元格
            HSSFCell cell1 = row.createCell(i);
            // 向单元格写入数据
            cell1.setCellValue(titles[i]);
            //cell1.setCellStyle(createStyle1(workbook, 12));
        }
        // 6.写入硬盘文件
        workbook.write(out);
        workbook.close();
    }
    
    

}
