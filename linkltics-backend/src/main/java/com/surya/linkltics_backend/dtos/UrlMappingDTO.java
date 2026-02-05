package com.surya.linkltics_backend.dtos;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UrlMappingDTO {
    private Long id;
    private String originalUrl;
    private String shortUrl;
    private int ClickCount;
    private LocalDateTime createdDate;
    private String Username ;
}
