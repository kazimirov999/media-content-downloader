package com.media.importer;

import com.media.entity.Movie;
import com.media.service.MovieService;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kazimirov on 29.03.2017.
 */
public class MovieItemWriter implements ItemWriter<Movie> {

    @Autowired
    private MovieService movieService;

    @Override
    public void write(List<? extends Movie> list) throws Exception {
        movieService.save(new ArrayList<>(list));
    }
}