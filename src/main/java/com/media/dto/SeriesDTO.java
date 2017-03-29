package com.media.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

/**
 * Created by Kazimirov on 28.03.2017.
 */
@Setter
@Getter
@ToString(callSuper=true)
public class SeriesDTO extends BaseMediaDTO {

    @JsonProperty("Type")
    public String type;

    public Set<SeasonDTO> seasons;


}
