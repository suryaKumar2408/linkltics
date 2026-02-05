package com.surya.linkltics_backend.repository;

import com.surya.linkltics_backend.models.ClickEvent;
import com.surya.linkltics_backend.models.UrlMapping;
import com.surya.linkltics_backend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
@Repository
public interface ClickEventRepository extends JpaRepository<ClickEvent,Long>{
    List<ClickEvent>findByUrlMappingAndClickDateBetween(UrlMapping mapping, LocalDateTime startDate, LocalDateTime endDate);
    List<ClickEvent>findByUrlMappingInAndClickDateBetween(List<UrlMapping>urlMappings, LocalDateTime startDate, LocalDateTime endDate);

}
