package com.media.controller;

import com.media.bean.MediaImportBean;
import com.media.type.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.OK;


/**
 * Created by Kazimirov on 27.03.2017.
 */
@RestController
@RequestMapping("/media-content")
public class MediaContentRestController {

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job jobMovie;

    @Autowired
    private Job jobSeries;

    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @ResponseBody
    @RequestMapping(value = "/import", method = RequestMethod.POST)
    public ResponseEntity<String> importMedia(@RequestBody MediaImportBean mediaImportBean) {
        JobExecution jobExecution;
        try {
            MediaType mediaType = mediaImportBean.getMediaType();
            Job executedJob = (MediaType.MOVIE == mediaType) ? jobMovie : jobSeries;
            JobParameters jobParameters = mediaImportBean.asJobParameters();
            jobExecution = jobLauncher.run(executedJob, jobParameters);
        } catch (Exception e) {
            LOG.error("Import media failure", e);
            return new ResponseEntity<>(INTERNAL_SERVER_ERROR);
        }
        String executeStatus = jobExecution.getStatus().getBatchStatus().toString();
        return new ResponseEntity<>(executeStatus, OK);
    }
}
