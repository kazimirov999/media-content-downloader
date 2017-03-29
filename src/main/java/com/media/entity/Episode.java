package com.media.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Kazimirov on 28.03.2017.
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode(of="imdbID")
@Entity
public class Episode implements Serializable {

    @Id
    @Column(name = "imdb_id")
    private String imdbID;

    @Column(name = "title")
    private String title;

    @Column(name = "Year")
    private String year;

    @Column(name = "poster")
    private String poster;

    @Column(name = "released")
    private String released;

    @Column(name = "episode")
    private Integer episodeNumber;

    @Column(name = "imdb_rating")
    private String imdbRating;
}
