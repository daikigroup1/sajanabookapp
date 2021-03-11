package com.sajana.bookapp.controller;

import com.sajana.bookapp.dto.Author;
import com.sajana.bookapp.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @PostMapping
    public ResponseEntity<Author> addNewRecord(@RequestBody Author record){
        Author addedRecord = authorService.add(record);
        return ResponseEntity.ok(addedRecord);
    }

    @PutMapping
    public ResponseEntity<Author> updateRecord(@RequestBody Author record){
        Author updatedRecord = authorService.update(record);
        return ResponseEntity.ok(updatedRecord);
    }

    @GetMapping
    public ResponseEntity<Author> getRecordById(@RequestParam int id){
        Author record = authorService.getById(id);
        return ResponseEntity.ok(record);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteRecordById(@RequestParam int id){
        authorService.deleteById(id);
        return ResponseEntity.ok("Record deleted successfully");
    }
}
