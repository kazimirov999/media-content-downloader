package com.media.entity;

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
@EqualsAndHashCode(of="imdbID")
@Entity
public class Series  implements Serializable {

    @Id
    @Column(name = "imdb_id")
    private String imdbID;

    @Column(name = "title")
    private String title;

    @Column(name = "year")
    private String year;

    @Column(name = "poster")
    private String poster;

    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinColumn(name = "series_imdb_id")
    private Set<Season> seasons;

    @Transient
    private String type;
}
