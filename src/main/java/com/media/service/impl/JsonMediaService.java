package com.media.service.impl;

import com.media.bean.MediaImportBean;
import com.media.dto.BaseMediaDTO;
import com.media.dto.SeasonDTO;
import com.media.dto.SeriesDTO;
import com.media.parser.MediaParser;
import com.media.service.MediaService;
import com.media.type.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Kazimirov on 28.03.2017.
 */
@Service
public class JsonMediaService implements MediaService {

    @Autowired
    private MediaParser mediaParser;

    @Autowired
    private RestTemplate restTemplate;

    public final String TITLE_KEY = "{title}";
    public final String YEAR_KEY = "{year}";
    public final String TYPE_KEY = "{type}";
    public final String IMDB_ID_KEY = "{imdbID}";
    public final String SEASON_NUMBER_KEY = "{seasonNumber}";
    public final String SEARCH_ATTR = "Search";

    private final String URL;
    private final String MEDIA_URN;
    private final String SEASON_URN;

    public JsonMediaService(@Value("${media.url}") String URL,
                            @Value("${media.urn}") String MEDIA_URN,
                            @Value("${season.urn}") String SEASON_URN) {
        this.URL = URL;
        this.MEDIA_URN = MEDIA_URN;
        this.SEASON_URN = SEASON_URN;
    }

    @SuppressWarnings("unchecked")
    public <T extends BaseMediaDTO> Collection<T> getMedia(MediaImportBean importBean, Class<T> type) {
        Collection<T> media = null;
        MediaType mediaType = importBean.getMediaType();
        String jsonResponse = sendRequest(importBean);

        if (MediaType.MOVIE == mediaType) {
            media = mediaParser.parse(jsonResponse, SEARCH_ATTR, type);
        } else if (MediaType.SERIES == mediaType) {
            Collection<SeriesDTO> series = mediaParser.parse(jsonResponse, SEARCH_ATTR, SeriesDTO.class);
            if (!CollectionUtils.isEmpty(series)) {
                media = (Collection<T>) series.stream()
                        .map(this::initSeasonsForSeries)
                        .collect(Collectors.toList());
            }
        }
        return media;
    }

    private String sendRequest(MediaImportBean importBean) {
        MediaType mediaType = importBean.getMediaType();
        final String MEDIA_URI = buildMediaUri(importBean.getTitle(), importBean.getYear(), mediaType);

        String jsonRequest = restTemplate.getForObject(MEDIA_URI, String.class);

        return jsonRequest;
    }

    private SeriesDTO initSeasonsForSeries(SeriesDTO seriesDTO) {
        Set<SeasonDTO> seasons = new HashSet<>();
        if (seriesDTO.hasImdbID()) {
            for (int seasonNumber = 1, count = 1; seasonNumber <= count; seasonNumber++) {
                String uri = buildSeasonUri(seriesDTO.imdbID, seasonNumber);
                SeasonDTO season = restTemplate.getForObject(uri, SeasonDTO.class);
                if (season != null && season.exist()) {
                    count = season.totalSeasons;
                    seasons.add(season);
                }
            }
            seriesDTO.setSeasons(seasons);
        }
        return seriesDTO;
    }

    private String buildMediaUri(String title, Integer year, MediaType mediaType) {
        final String URI = URL.concat(MEDIA_URN)
                .replace(TITLE_KEY, !StringUtils.isEmpty(title) ? title : "")
                .replace(YEAR_KEY, year != null ? String.valueOf(year) : "")
                .replace(TYPE_KEY, mediaType.asString());
        return URI;
    }

    private String buildSeasonUri(String imdbID, int seasonNumber) {
        final String URI = URL.concat(SEASON_URN)
                .replace(IMDB_ID_KEY, imdbID)
                .replace(SEASON_NUMBER_KEY, String.valueOf(seasonNumber));
        return URI;
    }
}
