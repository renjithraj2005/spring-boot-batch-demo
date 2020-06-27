package com.demo.batch.controller;

import com.demo.batch.BatchApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobInvokerController {

    private static final Logger log = LoggerFactory.getLogger(JobInvokerController.class);

    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    Job job;

    @RequestMapping("/invoke-job")
    public ResponseEntity runJob() throws Exception{
        JobParameters parameters =  new JobParametersBuilder()
                .addString("JobID", String.valueOf(System.currentTimeMillis()))
                .toJobParameters();
        log.info("Starting the Job");
        jobLauncher.run(job, parameters);
        return new ResponseEntity(HttpStatus.OK);
    }
}
