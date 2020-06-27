package com.demo.batch.task;

import com.demo.batch.BatchApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

public class DemoTask implements Tasklet {

    private static final Logger log = LoggerFactory.getLogger(DemoTask.class);

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        log.info("DemoTask start.."+chunkContext.toString());

        return RepeatStatus.FINISHED;
    }
}
