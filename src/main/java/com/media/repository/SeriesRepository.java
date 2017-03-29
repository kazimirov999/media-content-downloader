package com.media.repository;

import com.media.entity.Series;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Kazimirov on 28.03.2017.
 */
public interface SeriesRepository extends JpaRepository<Series, String> {
}
