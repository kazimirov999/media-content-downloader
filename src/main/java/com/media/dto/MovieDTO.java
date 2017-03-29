package com.media.dto;

/**
 * Created by Kazimirov on 28.03.2017.
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString(callSuper=true)
public class MovieDTO extends BaseMediaDTO{

    @JsonProperty("Type")
    public String type;
}