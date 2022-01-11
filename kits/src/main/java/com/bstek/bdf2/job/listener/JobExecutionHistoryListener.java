package com.bstek.bdf2.job.listener;

import com.bstek.bdf2.job.executor.SpringBeanJobExecutorDetail;
import com.bstek.bdf2.job.model.JobHistory;
import com.bstek.bdf2.job.service.IJobDefinitionService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.quartz.*;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;
import java.util.UUID;

/**
 * @author Jacky.gao
 * @since 2013-3-10
 */
public class JobExecutionHistoryListener implements JobListener{
	private SessionFactory sessionFactory;
	public JobExecutionHistoryListener(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}
	private Date start;
	public String getName() {
		return "JobExecutionHistoryListener";
	}
	public void jobToBeExecuted(JobExecutionContext context) {
		this.start=new Date();
	}
	public void jobWasExecuted(JobExecutionContext context,
			JobExecutionException jobException) {
		JobDetail jobDetail=context.getJobDetail();
		if(!(jobDetail instanceof SpringBeanJobExecutorDetail)){
			return;
		}
		JobDataMap map=jobDetail.getJobDataMap();
		if(!map.containsKey(IJobDefinitionService.JOB_DEFINITION_ID)){
			return;
		}
		String nolog =  map.getString("nolog");
		if(!"true".equals(nolog)){
			Date end=new Date();
			String exception=getExceptionStackMessage(jobException);
			JobHistory history=new JobHistory();
			history.setSuccessful(exception==null?true:false);
			if(exception!=null){
				history.setExceptionMessage(exception.length()>1500?exception.substring(0, 1500):exception);			
			}
			history.setEndDate(end);
			history.setStartDate(start);
			history.setId(UUID.randomUUID().toString());
			history.setJobId(map.getString(IJobDefinitionService.JOB_DEFINITION_ID));
			Session session=this.sessionFactory.openSession();
			try{
				session.save(history);
			}finally{
				session.flush();
				session.close();
			}
		}
	}
	private String getExceptionStackMessage(JobExecutionException jobException){
		if(jobException!=null){
			StringWriter sw = new StringWriter();  
			PrintWriter pw = new PrintWriter(sw);
			jobException.printStackTrace(pw);
			return sw.toString();
		}else{
			return null;
		}
	}
	public void jobExecutionVetoed(JobExecutionContext context) {
		
	}
}
