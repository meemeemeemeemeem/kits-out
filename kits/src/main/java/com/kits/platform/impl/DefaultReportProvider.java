package com.kits.platform.impl;

import com.bstek.ureport.exception.ReportException;
import com.bstek.ureport.provider.report.ReportFile;
import com.bstek.ureport.provider.report.ReportProvider;
import com.kits.inms.utils.AppUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;
import java.io.*;
import java.util.*;


/**
 * @author 杨旭晖:1316185617@qq.com
 **/
public class DefaultReportProvider implements ReportProvider, ApplicationContextAware {

    private String prefix = "report:";
    private String fileRootDir = "reportFiles";
    private String fileStoreDir = "";
    private boolean disabled = false;

    @Override
    public InputStream loadReport(String file) {
        if (file.startsWith(prefix)) {
            file = file.substring(prefix.length(), file.length());
        }
        String fullPath = fileStoreDir + "/" + file;
        try {
            return new FileInputStream(fullPath);
        } catch (FileNotFoundException e) {
            throw new ReportException(e);
        }
    }

    @Override
    public void deleteReport(String file) {
        if (file.startsWith(prefix)) {
            file = file.substring(prefix.length(), file.length());
        }
        String fullPath = fileStoreDir + "/" + file;
        File f = new File(fullPath);
        if (f.exists()) {
            f.delete();
        }
    }

    @Override
    public List<ReportFile> getReportFiles() {
        File file = new File(fileStoreDir);
        List<ReportFile> list = new ArrayList<>();
        for (File f : file.listFiles()) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(f.lastModified());
            list.add(new ReportFile(f.getName(), calendar.getTime()));
        }
        Collections.sort(list, new Comparator<ReportFile>() {
            @Override
            public int compare(ReportFile f1, ReportFile f2) {
                return f2.getUpdateDate().compareTo(f1.getUpdateDate());
            }
        });
        return list;
    }

    @Override
    public String getName() {
        return "服务器文件系统";
    }

    @Override
    public void saveReport(String file, String content) {
        if (file.startsWith(prefix)) {
            file = file.substring(prefix.length(), file.length());
        }
        String fullPath = fileStoreDir + "/" + file;
        FileOutputStream outStream = null;
        try {
            outStream = new FileOutputStream(new File(fullPath));
            IOUtils.write(content, outStream, "utf-8");
        } catch (Exception ex) {
            throw new ReportException(ex);
        } finally {
            if (outStream != null) {
                try {
                    outStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public boolean disabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public void setFileStoreDir(String fileStoreDir) {
        this.fileStoreDir = fileStoreDir;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (applicationContext instanceof WebApplicationContext) {
            WebApplicationContext context = (WebApplicationContext) applicationContext;
            ServletContext servletContext = context.getServletContext();
            String basePath = servletContext.getRealPath("/");
            fileRootDir = basePath + "/" + fileRootDir;
        }
    }

    @Override
    public String getPrefix() {
        try {
            String compId = AppUtils.getLoginUser().getCompanyId();
            fileStoreDir = fileRootDir + "/" + compId;
            File file = new File(fileStoreDir);
            if (file.exists()) {
                return prefix;
            } else {
                file.mkdirs();
                return prefix;
            }
        } catch (NullPointerException e) {
            throw new ReportException("请先登录");
        }
    }

}
