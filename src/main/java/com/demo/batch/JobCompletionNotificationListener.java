package com.demo.batch;

import com.demo.batch.model.Person;
import com.demo.batch.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


@Component
public class JobCompletionNotificationListener extends JobExecutionListenerSupport {

    private static final Logger log = LoggerFactory.getLogger(JobCompletionNotificationListener.class);

    private final PersonRepository personRepository;

    @Autowired
    public JobCompletionNotificationListener(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public void beforeJob(JobExecution jobExecution) {
        log.info("!!! JOB Is going to start! " + jobExecution.getStatus());
        log.info("Db count before execution := "+ personRepository.count());
        super.beforeJob(jobExecution);
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        if(jobExecution.getStatus() == BatchStatus.COMPLETED) {
            log.info("!!! JOB FINISHED! Time to verify the results");
            log.info("Start Time : "+jobExecution.getStartTime());

            log.info("Db count after execution := "+ personRepository.count());
        }else if (jobExecution.getStatus() == BatchStatus.FAILED) {
            log.info("!!! JOB Failed!");
        }
    }
}
