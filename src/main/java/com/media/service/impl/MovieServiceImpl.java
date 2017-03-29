package com.media.service.impl;

import com.media.entity.Movie;
import com.media.repository.MovieRepository;
import com.media.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by Kazimirov on 28.03.2017.
 */
@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public Collection<Movie> save(Collection<Movie> movies){
        return movieRepository.save(movies);
    }
}
