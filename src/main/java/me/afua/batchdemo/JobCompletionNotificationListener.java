package me.afua.batchdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class JobCompletionNotificationListener extends JobExecutionListenerSupport {

    private static final Logger log = LoggerFactory.getLogger(JobCompletionNotificationListener.class);

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JobCompletionNotificationListener(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate =jdbcTemplate;
    }

    @Autowired
     PersonRepository personRepository;

    @Override
    public void afterJob(JobExecution jobExecution)
    {
        if(jobExecution.getStatus() == BatchStatus.COMPLETED)
            log.info("!!! JOB FINISHED! Time to verify the results");

           for(Person person :personRepository.findAll())
        {
            log.info("Found <"+person+"> in the database.");
        }
    }


}
