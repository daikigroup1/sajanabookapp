package com.sajana.bookapp.controller;

import com.sajana.bookapp.dto.Publisher;
import com.sajana.bookapp.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/publisher")
public class PublisherController {
    @Autowired
    PublisherService publisherService;

    @PostMapping
    public ResponseEntity<Publisher> addNewRecord(@RequestBody Publisher record){
        Publisher addedRecord = publisherService.add(record);
        return ResponseEntity.ok(addedRecord);
    }

    @PutMapping
    public ResponseEntity<Publisher> updateRecord(@RequestBody Publisher record){
        Publisher updatedRecord = publisherService.update(record);
        return ResponseEntity.ok(updatedRecord);
    }

    @GetMapping
    public ResponseEntity<Publisher> getRecordById(@RequestParam int id){
        Publisher record = publisherService.getById(id);
        return ResponseEntity.ok(record);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteRecordById(@RequestParam int id){
        publisherService.deleteById(id);
        return ResponseEntity.ok("Record deleted successfully");
    }
}
