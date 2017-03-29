package com.media.type;

import com.media.dto.BaseMediaDTO;
import com.media.dto.MovieDTO;
import com.media.dto.SeriesDTO;
import lombok.AllArgsConstructor;

/**
 * Created by Kazimirov on 27.03.2017.
 */
@AllArgsConstructor
public enum MediaType {

    MOVIE("movie"), SERIES("series");

    private final String name;

    public String asString() {
        return name;
    }

    public  Class<? extends BaseMediaDTO> getTypeDto() {
        if (this == MOVIE) {
            return  MovieDTO.class;
        } else if (this == SERIES) {
            return SeriesDTO.class;
        }
        return null;
    }
}
