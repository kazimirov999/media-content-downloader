package com.media.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.Set;

/**
 * Created by Kazimirov on 28.03.2017.
 */
@Setter
@Getter
@ToString
public class SeasonDTO implements Serializable {

    @JsonProperty("Title")
    public String title;

    @JsonProperty("Season")
    public Integer season;

    @JsonProperty("totalSeasons")
    public int totalSeasons;

    @JsonProperty("Episodes")
    public Set<EpisodeDTO> episodes;

    public boolean exist(){
        return !StringUtils.isEmpty(title);
    }
}
