package com.kits.platform.impl;

import com.bstek.bdf2.core.context.ContextHolder;
import com.bstek.bdf2.job.model.JobDefinition;
import com.bstek.bdf2.job.service.IJobDataService;

import java.util.List;

public class DefaultJobDataService implements IJobDataService {

	@Override
    public List<JobDefinition> filterJobs(List<JobDefinition> jobs) {
        return jobs;
    }
    @Override
    public String getCompanyId() {
        return ContextHolder.getLoginUser().getCompanyId();
    }

}
