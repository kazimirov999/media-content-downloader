package com.media.repository;

import com.media.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Kazimirov on 28.03.2017.
 */
public interface MovieRepository extends JpaRepository<Movie, Integer> {
}
