package com.media.importer;

import com.media.dto.BaseMediaDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

/**
 * Created by Kazimirov on 29.03.2017.
 */
@RequiredArgsConstructor
public class MediaItemProcessor<T extends BaseMediaDTO, O extends Serializable> implements ItemProcessor<T, O> {

    @Autowired
    private ModelMapper mapper;

    final Class<O> destinationType;

    @Override
    public O process(T mediaDTO) throws Exception {
        return mapper.map(mediaDTO, destinationType);
    }
}
