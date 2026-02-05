package com.surya.linkltics_backend.repository;

import com.surya.linkltics_backend.models.UrlMapping;
import com.surya.linkltics_backend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UrlMappingRepository extends JpaRepository<UrlMapping , Long> {
    UrlMapping findByShortUrl(String shortUrl);
    List<UrlMapping>findByUser(User user);
}
