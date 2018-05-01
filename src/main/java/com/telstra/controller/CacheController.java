package com.telstra.controller;

import com.telstra.entity.ConfigurationEntity;
import com.telstra.entity.DocumentsEntity;
import com.telstra.service.ICacheService;
import com.telstra.service.IConfigurationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;


@RestController
@RequestMapping("telstra")
@Slf4j
public class CacheController {


    @Autowired
    private IConfigurationService configurationService;

    @Autowired
    private ICacheService cacheService;

    @PostMapping("/messages")
    public ResponseEntity messages( @RequestBody DocumentsEntity document){
        log.info(document.toString());
        document.setCreatedTs(new Date());
        cacheService.save(document);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/messages/{id}")
    public ResponseEntity getMessages(@PathVariable(value = "id") int id){
        log.info(String.format("Getting document with ID: %d",id));
        Optional<DocumentsEntity> optionalDocumentsEntity = cacheService.getDocumentById(id);
        if(!optionalDocumentsEntity.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        DocumentsEntity documentsEntity = optionalDocumentsEntity.get();

        Date createdDate = documentsEntity.getCreatedTs();
        Calendar calendar = Calendar.getInstance(); // creates calendar
        calendar.setTime(documentsEntity.getCreatedTs()); // sets calendar time/date
        calendar.add(Calendar.SECOND, configurationService.getTimeToLive().get().getTimeToLive()); // adds one hour
        calendar.getTime();


        Calendar current = Calendar.getInstance();
        log.info(documentsEntity.toString());

        if(current.after(calendar)) {
            cacheService.delete(documentsEntity);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }else
            return ResponseEntity.ok(documentsEntity);
    }

    @PostMapping("/timeToLive")
    public ResponseEntity messages( @RequestParam int timeToLive){
        log.info(String.valueOf(timeToLive));
        Optional<ConfigurationEntity> optionalConfigurationEntity = configurationService.getTimeToLive();
        ConfigurationEntity configurationEntity;
        if(optionalConfigurationEntity.isPresent())
            configurationEntity= optionalConfigurationEntity.get();
        else
            configurationEntity = new ConfigurationEntity();
        configurationEntity.setTimeToLive(timeToLive);
        configurationService.save(configurationEntity);
        return ResponseEntity.ok().build();
    }


}
