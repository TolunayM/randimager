package com.example.randompic;

import org.springframework.stereotype.Service;

@Service
public class RandomService {

    public String generateRandom(){
        String base = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        int lengthURL = 5;
        String random = "";
        String url = "";

        for(int i = 0; i < lengthURL;i++){
            random += base.charAt((int) (Math.random() * base.length()));
        }

        url ="https://i.imgur.com/" + random + ".jpg";
        return url;
    }
}
