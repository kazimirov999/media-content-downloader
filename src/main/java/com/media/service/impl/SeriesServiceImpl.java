package com.media.service.impl;

import com.media.entity.Series;
import com.media.repository.SeriesRepository;
import com.media.service.SeriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by Kazimirov on 28.03.2017.
 */
@Service
public class SeriesServiceImpl implements SeriesService {

    @Autowired
    private SeriesRepository seriesRepository;

    @Override
    public Collection<Series> save(Collection<Series> series) {
        return seriesRepository.save(series);
    }
}
