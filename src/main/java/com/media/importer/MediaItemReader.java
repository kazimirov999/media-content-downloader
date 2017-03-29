package com.media.importer;

import com.media.bean.MediaImportBean;
import com.media.dto.BaseMediaDTO;
import com.media.service.impl.JsonMediaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.Iterator;

import static com.media.bean.MediaImportBean.*;

/**
 * Created by Kazimirov on 29.03.2017.
 */
public class MediaItemReader<T extends BaseMediaDTO> implements ItemReader<T> {

    @Autowired
    private JsonMediaService jsonMediaService;

    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Value("#{jobParameters[" + TITLE + "]}")
    String title;
    @Value("#{jobParameters[" + YEAR + "]}")
    String year;
    @Value("#{jobParameters[" + MEDIA_TYPE + "]}")
    String mediaType;

    private Iterator<T> mediaIterator;

    @Override
    public T read() throws Exception {
        if (mediaIsNotInitialized()) {
            mediaIterator = fetchMediaFromAPI();
        }
        T nextMovie = null;
        if (mediaIterator != null && mediaIterator.hasNext()) {
            nextMovie = mediaIterator.next();
        }
        return nextMovie;
    }

    private boolean mediaIsNotInitialized() {
        return this.mediaIterator == null;
    }

    private Iterator<T> fetchMediaFromAPI() {
        MediaImportBean mediaImportBean = new MediaImportBean(title, year, mediaType);
        Collection<T> media = jsonMediaService.getMedia(mediaImportBean, (Class<T>) mediaImportBean.getMediaType().getTypeDto());
        Iterator<T> mediaIterator = null;
        if (!CollectionUtils.isEmpty(media)) {
            mediaIterator = media.iterator();
        }
        LOG.info("Media: ", media);
        return mediaIterator;
    }
}
