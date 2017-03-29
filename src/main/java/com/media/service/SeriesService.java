package com.media.service;

import com.media.entity.Series;

import java.util.Collection;

/**
 * Created by Kazimirov on 28.03.2017.
 */
public interface SeriesService {

    Collection<Series> save(Collection<Series> series);
}
