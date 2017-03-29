package com.media.parser;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.media.dto.BaseMediaDTO;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

/**
 * Created by Kazimirov on 28.03.2017.
 */
@Component
public class JsonMediaParser implements MediaParser {

    @Override
    public <T extends BaseMediaDTO> Collection<T> parse(String json, String rootElement, Class<T> type) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNodeRoot = objectMapper.readValue(json, JsonNode.class)
                    .get(rootElement);
            if (jsonNodeRoot == null) {
                return null;
            }
            String jsonMedia = jsonNodeRoot.toString();
            CollectionType collectionType = TypeFactory.defaultInstance().constructCollectionType(List.class, type);
            return objectMapper.readValue(jsonMedia, collectionType);
        } catch (IOException e) {
            throw new RuntimeException("Parse json failure: ", e);
        }
    }
}
