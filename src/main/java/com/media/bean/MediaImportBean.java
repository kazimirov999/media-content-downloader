package com.media.bean;

import com.media.type.MediaType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;

import java.io.Serializable;

/**
 * Created by Kazimirov on 27.03.2017.
 */
@Setter
@Getter
@ToString
@AllArgsConstructor
public class MediaImportBean implements Serializable {

    public static final String TITLE = "title";
    public static final String YEAR = "year";
    public static final String MEDIA_TYPE ="mediaType";
    public static final String TIME ="time";

    private String title;
    private Integer year;
    private MediaType mediaType;

    public MediaImportBean() {
    }

    public MediaImportBean(String title, String year, String mediaType) {
        this.title = title;
        this.year = (year != null) ? Integer.valueOf(year) : null;
        this.mediaType = MediaType.valueOf(mediaType.toUpperCase());
    }

    public JobParameters asJobParameters() {
        return new JobParametersBuilder()
                .addString(TITLE, title)
                .addString(YEAR, year != null ? String.valueOf(year) : null)
                .addString(MEDIA_TYPE, mediaType.asString())
                .addLong(TIME, System.currentTimeMillis()).toJobParameters();
    }

}
