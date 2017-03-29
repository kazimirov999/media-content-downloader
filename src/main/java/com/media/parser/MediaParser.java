package com.media.parser;

import com.media.dto.BaseMediaDTO;

import java.util.Collection;

/**
 * Created by Kazimirov on 28.03.2017.
 */
public interface MediaParser {

    <T extends BaseMediaDTO> Collection<T> parse(String json, String rootElement, Class<T> type);
}
