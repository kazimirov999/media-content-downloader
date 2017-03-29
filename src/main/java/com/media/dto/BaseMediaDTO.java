package com.media.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.util.StringUtils;

import java.io.Serializable;

/**
 * Created by Kazimirov on 28.03.2017.
 */

@Setter
@Getter
@ToString
@EqualsAndHashCode(of={"imdbID"})
@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseMediaDTO implements Serializable {

    @JsonProperty("Title")
    public String title;

    @JsonProperty("Year")
    public String year;

    @JsonProperty("imdbID")
    public String imdbID;

    @JsonProperty("Poster")
    public String poster;

    public boolean hasImdbID(){
        return !StringUtils.isEmpty(imdbID);
    }

}
