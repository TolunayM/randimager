package com.example.randompic;


import org.apache.commons.io.IOUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.CacheControl;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.InputStream;

@RestController
public class PictureController {


    private RandomService randomService;

    private PictureController(RandomService randomService){
        this.randomService = randomService;
    }
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/image",
            produces = MediaType.IMAGE_PNG_VALUE
    )

    public ResponseEntity<byte[]> RandomImage() throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<byte[]> responseEntity = restTemplate.getForEntity(randomService.generateRandom(),byte[].class);


        System.out.println(responseEntity.getHeaders().getContentType().getSubtype());
        if(responseEntity.getHeaders().getContentType().getSubtype().equals("png")){
            System.out.println(randomService.generateRandom());

            while(!(responseEntity.getHeaders().getContentType().getSubtype().equals("jpeg"))){
                responseEntity = restTemplate.getForEntity(randomService.generateRandom(),byte[].class);
            }


        }
        return ResponseEntity
                .status(responseEntity.getStatusCode())
                .headers(responseEntity.getHeaders())
                .body(responseEntity.getBody());
    }

    @GetMapping("/imageURL")
    public String getURL(){
        return randomService.generateRandom();
    }


}
