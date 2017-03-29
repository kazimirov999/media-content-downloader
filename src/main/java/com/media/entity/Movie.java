package com.media.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;

/**
 * Created by Kazimirov on 28.03.2017.
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode(of="imdbID")
@Entity
public class Movie implements Serializable{

    @Id
    @Column(name = "imdb_id")
    public String imdbID;

    @Column(name = "title")
    public String title;

    @Column(name = "year")
    public String year;

    @Column(name = "poster")
    public String poster;

    @Transient
    public String type;
}
