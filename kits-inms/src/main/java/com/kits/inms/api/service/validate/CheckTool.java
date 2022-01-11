package com.kits.inms.api.service.validate;

import java.math.BigDecimal;
import java.util.Date;

import com.kits.inms.api.expection.CheckException;
import com.kits.inms.bs.exception.ApiEnum;

/**
 * 数据校验工具类
 * @Author 张成
 * @create 2019-10
 */
public class CheckTool {
	public static void sendCodeAndMsg(String code, String msg) throws CheckException {
		throw new CheckException(code, msg);
	}
	
	
	/*1.必填项校验*/
	public static void checkNotNull(Object obj, String msg) throws CheckException{		
		if(obj==null || "".equals(obj)){
			sendCodeAndMsg(ApiEnum.NOT_NULL_CODE.code(), msg);
		}
	}
	
	/*2.数值转换与负值校验*/
	//2-1.BigDecimal校验
	//2-1-1.Object转换为BigDecimal
	public static BigDecimal fmtToBigDecimal(Object obj){
		BigDecimal bd = BigDecimal.ZERO;
		try{
			bd = new BigDecimal(String.valueOf(obj));
		} catch (Exception e) {
			return null;
		}
		return bd;
	}
	//2-1-2.类型转换校验
	public static void checkBigDecimal(BigDecimal bd, String msg) throws CheckException{
		if(bd==null){
			sendCodeAndMsg(ApiEnum.CLASS_CAST_CODE.code(), msg);
		}
	}
	//2-1-3.类型转换与负值校验
	public static void checkBigDecimal(BigDecimal bd, String msg1, String msg2) throws CheckException{
		if(bd==null){
			sendCodeAndMsg(ApiEnum.CLASS_CAST_CODE.code(), msg1);
		}else if(bd.compareTo(BigDecimal.ZERO)<0){
			sendCodeAndMsg(ApiEnum.NEGATIVE_CHECK_CODE.code(), msg2);
		}
	}
	
	//2-2.Integer校验
	//2-2-1.Object转换为Integer
	public static Integer fmtToInteger(Object obj){
		Integer in = 0;
		try{
			in = Integer.parseInt((String) obj);
		} catch (Exception e) {
			return null;
		}
		return in;
	}
	//2-2-2.类型转换校验
	public static void checkInteger(Integer in, String msg) throws CheckException{
		if(in==null){
			sendCodeAndMsg(ApiEnum.CLASS_CAST_CODE.code(), msg);
		}
	}
	//2-2-3.类型转换与负值校验
	public static void checkInteger(Integer in, String msg1, String msg2) throws CheckException{
		if(in==null){
			sendCodeAndMsg(ApiEnum.CLASS_CAST_CODE.code(), msg1);
		}else if(in<0){
			sendCodeAndMsg(ApiEnum.NEGATIVE_CHECK_CODE.code(), msg2);
		}
	}
	
	/*3.时间转换与时间起止校验*/
	//3-1.Object转换为Date
	public static Date fmtToDate(Object obj){
		Date t = null;
		try{
			t = new Date(Long.parseLong(String.valueOf(obj)));
		} catch (Exception e) {
			return null;
		}
		return t;
	}
	//3-2.类型转换校验
	public static void checkDateCast(Date t, String msg) throws CheckException{
		if(t==null){
			sendCodeAndMsg(ApiEnum.CLASS_CAST_CODE.code(), msg);
		}
	}
	//3-3.类型转换与时间起止校验
	public static void checkDateStartAndEnd(Date start, Date end, String msg1, String msg2) throws CheckException{
		if(start==null){
			sendCodeAndMsg(ApiEnum.CLASS_CAST_CODE.code(), msg1);
		}
		if(end==null){
			sendCodeAndMsg(ApiEnum.CLASS_CAST_CODE.code(), msg2);
		}
		if(start.getTime()>=end.getTime()){
			sendCodeAndMsg(ApiEnum.DATE_START_END_CHECK_CODE.code(), ApiEnum.DATE_START_END_CHECK_CODE.msg());
		}
	}
	
	/*4.状态码校验*/
	//状态码0、1校验
	public static void checkZeroOne(String code, String msg) throws CheckException{
		if("0,1".indexOf(code)<0){
			sendCodeAndMsg(ApiEnum.STATUS_CHECK_CODE.code(), msg);
		}
	}
	//状态码0、1、2校验
	public static void checkZeroOneTwo(String code, String msg) throws CheckException{
		if("0,1,2".indexOf(code)<0){	//0:所有,1:有效,2:失效
			sendCodeAndMsg(ApiEnum.STATUS_CHECK_CODE.code(), msg);
		}
	}
	//状态码1、2校验
	public static void checkOneTwo(String code, String msg) throws CheckException{
		if("1,2".indexOf(code)<0){
			sendCodeAndMsg(ApiEnum.STATUS_CHECK_CODE.code(), msg);
		}
	}
	//状态码1、2、3校验
	public static void checkOneTwoThree(String code, String msg) throws CheckException{
		if("1,2,3".indexOf(code)<0){
			sendCodeAndMsg(ApiEnum.STATUS_CHECK_CODE.code(), msg);
		}
	}
	//状态码1、2、3、4校验
	public static void checkOne2Four(String code, String msg) throws CheckException{
		if("1,2,3".indexOf(code)<0){
			sendCodeAndMsg(ApiEnum.STATUS_CHECK_CODE.code(), msg);
		}
	}
	//状态码3、4、5、9校验
	public static void checkThreeFourFiveNine(String code, String msg) throws CheckException{
		if("3,4,5,9".indexOf(code)<0){	//3:公开,4:撤销,5:截止,9:关闭
			sendCodeAndMsg(ApiEnum.STATUS_CHECK_CODE.code(), msg);
		}
	}
	
	//状态码A、B、C、D校验
	public static void checkABCD(String code, String msg) throws CheckException{
		if("A,B,C,D".indexOf(code)<0){
			sendCodeAndMsg(ApiEnum.STATUS_CHECK_CODE.code(), msg);
		}
	}
	
	
	
}