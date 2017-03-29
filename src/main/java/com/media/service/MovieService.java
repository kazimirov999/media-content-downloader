package com.media.service;

import com.media.entity.Movie;

import java.util.Collection;

/**
 * Created by Kazimirov on 28.03.2017.
 */
public interface MovieService {

    Collection<Movie> save(Collection<Movie> movies);
}
