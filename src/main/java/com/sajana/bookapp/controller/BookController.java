package com.sajana.bookapp.controller;

import com.sajana.bookapp.dto.Book;
import com.sajana.bookapp.service.BookService;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping
    public ResponseEntity<Book> addNewRecord(@RequestBody Book record){
        Book addedRecord = bookService.add(record);
        return ResponseEntity.ok(addedRecord);
    }

    @PutMapping
    public ResponseEntity<Book> updateRecord(@RequestBody Book record){
        Book updatedRecord = bookService.update(record);
        return ResponseEntity.ok(updatedRecord);
    }

    @GetMapping
    public ResponseEntity<Book> getRecordById(@RequestParam int id){
        Book record = bookService.getById(id);
        return ResponseEntity.ok(record);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteRecordById(@RequestParam int id){
        bookService.deleteById(id);
        return ResponseEntity.ok("Record deleted successfully");
    }

    @GetMapping(path = "/getByPublisher")
    public ResponseEntity<ArrayList<Book>> getBooksByPublisher(@RequestParam int publisherId){
        return ResponseEntity.ok(bookService.getBooksByPublisher(publisherId));
    }

    @GetMapping(path = "/getByAuthor")
    public ResponseEntity<ArrayList<Book>> getBooksByAuthor(@RequestParam int authorId){
        return ResponseEntity.ok(bookService.getBooksByAuthor(authorId));
    }
}
