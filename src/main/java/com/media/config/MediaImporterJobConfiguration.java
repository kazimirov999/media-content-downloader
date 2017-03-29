package com.media.config;

import com.media.dto.MovieDTO;
import com.media.dto.SeriesDTO;
import com.media.entity.Movie;
import com.media.entity.Series;
import com.media.importer.MediaItemProcessor;
import com.media.importer.MediaItemReader;
import com.media.importer.MovieItemWriter;
import com.media.importer.SeriesItemWriter;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.scope.StepScope;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * Created by Kazimirov on 29.03.2017.
 */
@EnableBatchProcessing
@Configuration
public class MediaImporterJobConfiguration {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Bean
    public static StepScope scope() {
        return new StepScope();
    }

    @Bean
    @Scope("step")
    public MediaItemReader<MovieDTO> readerMovie() {
        return new MediaItemReader<>();
    }

    @Bean
    @Scope("step")
    public MediaItemReader<SeriesDTO> readerSeries() {
        return new MediaItemReader<>();
    }

    @Bean
    public ItemProcessor<MovieDTO, Movie> processorMovie() {
        return new MediaItemProcessor<>(Movie.class);
    }

    @Bean
    public ItemProcessor<SeriesDTO, Series> processorSeries() {
        return new MediaItemProcessor<>(Series.class);
    }

    @Bean
    public ItemWriter<Movie> writerMovie() {
        return new MovieItemWriter();
    }

    @Bean
    public ItemWriter<Series> writerSeries() {
        return new SeriesItemWriter();
    }

    @Bean
    @SuppressWarnings(value = "unchecked")
    public Step stepMovie(StepBuilderFactory stepBuilderFactory,
                      ItemReader readerMovie, ItemWriter writerMovie,
                      ItemProcessor processorMovie) {

        return stepBuilderFactory.get("stepMovie")
                .chunk(4)
                .reader(readerMovie)
                .processor(processorMovie)
                .writer(writerMovie).build();

    }

    @Bean
    @SuppressWarnings(value = "unchecked")
    public Step stepSeries(StepBuilderFactory stepBuilderFactory,
                      ItemReader readerSeries, ItemWriter writerSeries,
                      ItemProcessor processorSeries) {

        return stepBuilderFactory.get("stepSeries")
                .chunk(4)
                .reader(readerSeries)
                .processor(processorSeries)
                .writer(writerSeries).build();

    }

    @Bean
    public Job jobMovie(JobBuilderFactory jobBuilderFactory, Step stepMovie) {
        return jobBuilderFactory.get("jobMovie")
                .incrementer(new RunIdIncrementer())
                .flow(stepMovie)
                .end()
                .build();
    }

    @Bean
    public Job jobSeries(JobBuilderFactory jobBuilderFactory, Step stepSeries) {
        return jobBuilderFactory.get("stepSeries")
                .incrementer(new RunIdIncrementer())
                .flow(stepSeries)
                .end()
                .build();
    }

}
