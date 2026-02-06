package com.surya.linkltics_backend.controller;

import com.surya.linkltics_backend.models.UrlMapping;
import com.surya.linkltics_backend.service.UrlMappingService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpHeaders;

@RestController
@AllArgsConstructor
public class RedirectController {

    private UrlMappingService urlMappingService ;

    @GetMapping("/r/{shortUrl}")
    public ResponseEntity<Void> redirect( @PathVariable("shortUrl") String shortUrl) {
        UrlMapping urlMapping = urlMappingService.getOriginalUrl(shortUrl);
        if (urlMapping != null) {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Location", urlMapping.getOriginalUrl());
            return ResponseEntity.status(302).headers(httpHeaders).build();
        } else {
            return ResponseEntity.notFound().build();

        }
    }
}
