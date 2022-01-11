package com.kits.inms.utils;


import com.jcraft.jsch.*;
import com.jcraft.jsch.ChannelSftp.LsEntry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class SftpUtils {

  private static final Logger logger = LoggerFactory.getLogger(SftpUtils.class);

  /**
   * 连接sftp服务�?
   *
   * @param host 主机
   * @param port 端口
   * @param username 用户�?
 * @throws JSchException 
   */
  public static ChannelSftp connect(String host, int port, String username, String password,String passwordType) throws JSchException {
    ChannelSftp sftp = null;
      JSch jsch = new JSch();
      
      Session sshSession = jsch.getSession(username, host, port);  
      System.out.println("Session created.");  
      Properties sshConfig = new Properties();  
      sshConfig.put("StrictHostKeyChecking", "no");
      if(passwordType.equals("key")){
    	  jsch.addIdentity(password);
      }else{
    	  sshSession.setPassword(password);
      }
      System.out.println(host+":"+port+":"+username+":"+password);
      sshSession.setConfig(sshConfig);  
      sshSession.connect();
      System.out.println("Session connected.");
      System.out.println("Opening Channel.");
      Channel channel = sshSession.openChannel("sftp");
      channel.connect();
      sftp = (ChannelSftp) channel;
      System.out.println("Connected to " + host + ".");
      return sftp;
  }

  /**
   * 上传文件
   *
   * @param directory 上传的目�?
   * @param uploadFile 要上传的文件
   */
  public static void upload(String directory, String uploadFile,
      ChannelSftp sftp) {
/*mkDir(directory, sftp);
    InputStream in = null;
    try {
      sftp.cd(directory);
      File file = new File(uploadFile);
      in = new FileInputStream(file);
      sftp.put(new FileInputStream(file), file.getName());
    } catch (Exception e) {
      //ExceptionUtils.marshException(e);
    } finally {
      try {
        in.close();
      } catch (IOException e) {
       // ExceptionUtils.marshException(e);
      }
    }*/
    try {
    	mkDir(directory, sftp);
    	sftp.cd(directory);
    	File file = new File(uploadFile);
    	sftp.put(uploadFile, file.getName());
	} catch (Exception e) {
		e.printStackTrace();
    	logger.error("上传文件失败:"+e);
	}
  }

  /**
   * 下载文件
   *
   * @param directory 下载目录
   * @param downloadFile 下载的文�?
   */
  public static InputStream download(String directory, String downloadFile,
      ChannelSftp sftp) {
    InputStream in = null;
    try {
      sftp.cd(directory);
      in = sftp.get(downloadFile);
    } catch (Exception e) {
    	e.printStackTrace();
    	logger.error("下载文件失败:"+e);
    }
    return in;
  }
  
  /** 
   * 下载文件 
   * @param directory 下载目录 
   * @param downloadFile 下载的文�? 
   * @param saveFile 存在本地的路�? 
   * @param sftp 
 * @throws SftpException 
 * @throws IOException 
   */  
  public static void download(String directory, String downloadFile,String saveFile, ChannelSftp sftp) throws SftpException, IOException {  
          sftp.cd(directory);  
          File file=new File(saveFile);
          if(!file.isDirectory()){
          	file.createNewFile();
          }
          sftp.get(downloadFile, new FileOutputStream(file));
  } 
  /** 
   * 下载文件 
   * @param directory 下载目录 
   * @param downloadFile 下载的文�? 
   * @param saveFile 存在本地的路�? 
   * @param sftp 
   * @throws SftpException 
   * @throws IOException 
   */  
  public static String  downloadChinaPay(String directory, String downloadFile,String savePath, ChannelSftp sftp) throws SftpException, IOException {  
	  sftp.cd(directory);  
	  Vector aa = sftp.ls(directory);
	  for (Iterator<LsEntry> iterator = aa.iterator(); iterator.hasNext();) {
		  LsEntry str = iterator.next();
		  String filename = str.getFilename();
		  if(filename.length()!=46){
			  continue;
		  }else{
			  if(filename.substring(0,24).equals(downloadFile)){
				  downloadFile = filename;
				  break;
			  }else{
				  continue;
			  }
		  }
	  }
	  File file=new File(savePath+downloadFile);
	  if(!file.isDirectory()){
		  file.createNewFile();
	  }
	  sftp.get(downloadFile, new FileOutputStream(file));
	  
	  return downloadFile;
	  
  } 
  
  /** 
   * 下载文件 
   * @param directory 下载目录 
   * @param downloadFile 下载的文�? 
   * @param saveFile 存在本地的路�? 
   * @param sftp 
   * @throws SftpException 
   * @throws IOException 
   */  
  public static List downloadAll(String directory,String savePath, ChannelSftp sftp) throws SftpException, IOException {  
	  List<String> nameList = new ArrayList(); 
	  Vector aa = listFiles(directory, sftp);
	  sftp.cd(directory);
	  for (Iterator<LsEntry> iterator = aa.iterator(); iterator.hasNext();) {
		  LsEntry str = iterator.next();
		  String filename = str.getFilename();
		  if(filename.length()<5){
			  continue;
		  }
		  File file=new File(savePath+filename);
		  if(!file.isDirectory()){
			  file.createNewFile();
		  }
		  sftp.get(filename, new FileOutputStream(file));
		  delete(directory, filename, sftp);
		  nameList.add(filename);
		  logger.info(filename+"下载完成�?");
	  }
	  
	  return nameList;
  }
  
  /**
   * 删除文件
   *
   * @param directory 要删除文件所在目�?
   * @param deleteFile 要删除的文件
   */
  public static void delete(String directory, String deleteFile,
      ChannelSftp sftp) {
    try {
      sftp.cd(directory);
      sftp.rm(deleteFile);
    } catch (Exception e) {
      //ExceptionUtils.marshException(e);
    }
  }

  /**
   * 列出目录下的文件
   *
   * @param directory 要列出的目录
   */
  public static Vector listFiles(String directory, ChannelSftp sftp)
      throws SftpException {
    return sftp.ls(directory);
  }

  /**
   * 获取目录name
   */
  public static List<String> buildFiles(Vector ls) throws Exception {
    if (ls != null && ls.size() >= 0) {
      List<String> list = new ArrayList<String>();
      for (int i = 0; i < ls.size(); i++) {
        LsEntry f = (LsEntry) ls.get(i);
        String nm = f.getFilename();
        if (nm.equals(".") || nm.equals("..")) {
          continue;
        }
        list.add(nm);
      }
      return list;
    }
    return null;
  }

  /**
   * 打开指定目录
   *
   * @param directory directory
   * @return 是否打开目录
   */
  public static boolean openDir(String directory, ChannelSftp sftp) {
    try {
      sftp.cd(directory);
      return true;
    } catch (SftpException e) {
      logger.error(e.getMessage());
      return false;
    }
  }

  /**
   * 创建指定文件�?
   *
   * @param dirName dirName
   */
  public static void mkDir(String dirName, ChannelSftp sftp) {
    String[] dirs = dirName.split("/");

    try {
      String now = sftp.pwd();
      sftp.cd("/");
      for (int i = 0; i < dirs.length; i++) {
        if (AppUtils.isNotEmpty(dirs[i])) {
          boolean dirExists = openDir(dirs[i], sftp);
          if (!dirExists) {
            sftp.mkdir(dirs[i]);
            sftp.cd(dirs[i]);
          }
        }
      }
      sftp.cd(now);
    } catch (SftpException e) {
     // ExceptionUtils.marshException(e);
    }
  }

}
