package com.media.importer;

import com.media.entity.Movie;
import com.media.entity.Series;
import com.media.service.MovieService;
import com.media.service.SeriesService;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kazimirov on 29.03.2017.
 */
public class SeriesItemWriter implements ItemWriter<Series> {

    @Autowired
    private SeriesService seriesService;

    @Override
    public void write(List<? extends Series> list) throws Exception {
        seriesService.save(new ArrayList<>(list));
    }
}
