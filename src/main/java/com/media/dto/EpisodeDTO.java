package com.media.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by Kazimirov on 28.03.2017.
 */
@Setter
@Getter
@ToString(callSuper=true)
public class EpisodeDTO extends BaseMediaDTO {

    @JsonProperty("Released")
    public String released;

    @JsonProperty("Episode")
    public Integer episodeNumber;

    @JsonProperty("imdbRating")
    public String imdbRating;
}
