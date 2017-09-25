package com.epam.study.module1;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Date;

public class Main {

    private static final Logger LOG = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {
        ApplicationContext context = new GenericXmlApplicationContext("spring-db.xml", "spring-batch.xml");
        Job job = (Job) context.getBean("personJob");
        JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");
        JobParameters jobParameters = new JobParametersBuilder()
                .addDate("jobDate", new Date())
                .toJobParameters();

        jobLauncher.run(job, jobParameters);
    }

}
