package com.cskd.logic;

import org.quartz.InterruptableJob;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.util.Calendar;

public class TestJob implements Job {
    @SuppressWarnings("deprecation")
    public void execute(JobExecutionContext arg0) throws JobExecutionException {
        System.out.println(Calendar.getInstance().getTime().toLocaleString() + "★★★★★★★★★★★");
    }

    public static void main(String[] args) {
        QuartzController qm = new QuartzController();
        String ts = "com.cskd.logic.TestJob";
        qm.addJob("job", ts, "0/2 * * * * ?");

        Logger logger = LoggerFactory.getLogger(TestJob.class);
        logger.debug("debugger1");
        logger.info("info1");
        logger.error("error1");
        logger.warn("warn1");
        logger.trace("tracce1");
    }
}
