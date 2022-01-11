package com.kits.inms.utils;

import com.bstek.bdf2.core.business.IUser;
import com.bstek.bdf2.core.context.ContextHolder;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;
import com.kits.orm.entity.system.Bdf2User;
import com.kits.util.UserUtil;
import org.hibernate.annotations.common.util.StringHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.UUID;

public class AppUtils {

    public static Logger logger = LoggerFactory.getLogger(AppUtils.class);
    

    /**
     * 从SFTP下载文件
     *
     * @param host         IP
     * @param port         端口
     * @param username     账号
     * @param password     密码
     * @param directory    下载目录
     * @param downloadFile 下载的文�?
     * @param saveFile     保存的目�?
     * @throws Exception
     */
    @SuppressWarnings("static-access")
    public static void download(String host, int port, String username, String password, String directory, String downloadFile, String saveFile, String passwordType) throws Exception {
        SftpUtils sftp = new SftpUtils();
        try {
            //获取SFTP连接
            ChannelSftp channelSftp = sftp.connect(host, port, username, password, passwordType);
            //下载文件
            sftp.download(directory, downloadFile, saveFile, channelSftp);  //下载文件
        } catch (JSchException e) {
            throw new Exception("sftp连接失败�?", e);
        } catch (SftpException e) {
            throw new Exception("下载失败�?", e);
        } catch (IOException e) {
            throw new Exception("文件" + downloadFile + "读写失败�?", e);
        }
        //ChannelSftp channelSftp = sftp.connect("b2bftpt.apple.com", 23, "kits","E:/key/kits.rsa");
    }

    /**
     * 从SFTP下载文件
     *
     * @param host         IP
     * @param port         端口
     * @param username     账号
     * @param password     密码
     * @param directory    下载目录
     * @param downloadFile 下载的文件名�?
     * @param saveFilePath 保存的目�?
     * @throws Exception
     */
    @SuppressWarnings("static-access")
    public static String downloadChinaPay(String host, int port, String username, String password, String directory, String downloadFile, String saveFilePath, String passwordType) throws Exception {
        SftpUtils sftp = new SftpUtils();
        String fileName = "";
        try {
            //获取SFTP连接
            ChannelSftp channelSftp = sftp.connect(host, port, username, password, passwordType);
            //下载文件
            fileName = sftp.downloadChinaPay(directory, downloadFile, saveFilePath, channelSftp);  //下载文件
            return fileName;
        } catch (JSchException e) {
            throw new Exception("sftp连接失败�?", e);
        } catch (SftpException e) {
            throw new Exception("下载失败�?", e);
        } catch (IOException e) {
            throw new Exception("文件" + downloadFile + "读写失败�?", e);
        }
        //ChannelSftp channelSftp = sftp.connect("b2bftpt.apple.com", 23, "kits","E:/key/kits.rsa");
    }


    /**
     * 上传文件到SFTP
     *
     * @param host       IP
     * @param port       端口
     * @param username   账号
     * @param password   密码
     * @param directory  上传的目�?
     * @param uploadFile 上传的文�?
     * @throws Exception
     */
    @SuppressWarnings("static-access")
    public static void upload(String host, int port, String username, String password, String directory, String uploadFile, String passwordType) throws Exception {
        SftpUtils sftp = new SftpUtils();
        try {
            //获取SFTP连接
            ChannelSftp channelSftp = sftp.connect(host, port, username, password, passwordType);
            //上传文件
            sftp.upload(directory, uploadFile, channelSftp);  //文件
        } catch (JSchException e) {
            throw new Exception("sftp连接失败�?", e);
        } catch (Exception e) {
            throw new Exception("文件上传失败�?", e);
        }
    }

    /**
     * 上传文件到SFTP
     *
     * @param directory  上传的目�?
     * @param uploadFile 上传的文�?
     * @throws Exception zjw-2018-1-24 重写此方法使得sftp只获�?1�?
     */
    @SuppressWarnings("static-access")
    public static void upload(SftpUtils sftp, ChannelSftp channelSftp, String directory, String uploadFile) throws Exception {
        try {
            //上传文件
            sftp.upload(directory, uploadFile, channelSftp);  //文件
        } catch (Exception e) {
            throw new Exception("文件上传失败�?", e);
        }
    }

    /**
     * @return 长度32的唯�?字符�?
     */
    public static String getUUIDKey() {
       return UUID.randomUUID().toString();
    }
    
    /**
     * @return 取得租户ID
     */
    public static String getCompId() {
        String compId = UserUtil.getLoginUser().getCompanyId();
    	return  compId;
    }

    /**
     * 判断�?个String是否为空（NULL/null/""�?
     * 该方法�?�助了Hibernate的StringHelper.isNotEmpty(str)
     *
     * @param str
     * @return
     */
    public static boolean isNotEmpty(String str) {
        boolean result = false;
        if (StringHelper.isNotEmpty(str) && !"null".equals(str)
                && !"".equals(str)) {
            result = true;
        }
        return result;
    }

    /**
     * 获取当前已登录的用户编号
     *
     * @return String 返回已登录的用户�?
     */
    public static String getLoginUserName() {
        IUser user = getLoginUser();
        return user.getUsername();
    }

    /**
     * 从Session当中取到User对象
     *
     * @return
     */
    public static IUser getLoginUser() {
        IUser loginUser = ContextHolder.getLoginUser();
        if (loginUser == null) {
            loginUser = new Bdf2User();
        }
        return loginUser;
    }
}
