package com.media.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.media.dto.EpisodeDTO;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by Kazimirov on 28.03.2017.
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode(of={"id", "title"})
@Entity
public class Season implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "season")
    private Integer season;

    @Column(name = "total_seasons")
    private Integer totalSeasons;

    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinColumn(name = "season_id")
    private Set<Episode> episodes;
}
