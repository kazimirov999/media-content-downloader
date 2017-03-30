package com.media.controller;

import com.media.type.MediaType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Kazimirov on 27.03.2017.
 */
@RestController
@RequestMapping("/media-type")
public class MediaTypeRestController {

    @RequestMapping(value = "/get/all", method = RequestMethod.GET)
    public ResponseEntity<List<MediaType>> getAllMediaTypes() {
        
        return new ResponseEntity<>(Arrays.asList(MediaType.values()), HttpStatus.OK);
    }
}
