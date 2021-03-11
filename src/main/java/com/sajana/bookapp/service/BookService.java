package com.sajana.bookapp.service;

import com.sajana.bookapp.dto.Book;
import com.sajana.bookapp.exception.InvalidDataException;
import com.sajana.bookapp.exception.RecordNotFoundException;
import com.sajana.bookapp.repository.AuthorRepository;
import com.sajana.bookapp.repository.BookRepository;
import com.sajana.bookapp.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class BookService {

    @Autowired
    BookRepository repository;

    @Autowired
    PublisherRepository publisherRepository;

    @Autowired
    AuthorRepository authorRepository;

    public Book add(Book object){
        if(object.getName() == null || object.getName().trim().isEmpty()){
            throw new InvalidDataException("Name not found");
        }
        return repository.save(object);
    }

    public Book update(Book object){
        if(object.getBookId() == 0){
            throw new InvalidDataException("Book id not found");
        }else if(getById(object.getBookId()) == null){
            throw new RecordNotFoundException(object.getBookId());
        }else if(publisherRepository.get(object.getPublisherId())== null){
            throw new InvalidDataException("Publisher id not found");
        }else if(authorRepository.get(object.getAuthorId())== null){
            throw new InvalidDataException("Author id not found");
        }
        return repository.save(object);
    }

    public Book getById(int id){
        Book book = repository.get(id);
        if(book == null){
            throw new RecordNotFoundException(id);
        }
        return book;
    }

    public Book deleteById(int id){
        Book delete = repository.delete(id);
        if(delete == null){
            throw new RecordNotFoundException(id);
        }
        return delete;
    }

    public ArrayList<Book> getBooksByAuthor(int authorId){
        if(authorRepository.get(authorId) == null){
            throw new InvalidDataException("Invalid author id");
        }

        return repository.getBooksByAuthorId(authorId);
    }

    public ArrayList<Book> getBooksByPublisher(int publisherId){
        if(publisherRepository.get(publisherId) == null){
            throw new InvalidDataException("Invalid publisher id");
        }

        return repository.getBooksByPublisherId(publisherId);
    }
}
