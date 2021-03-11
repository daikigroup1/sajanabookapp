package com.sajana.bookapp.service;

import com.sajana.bookapp.dto.Author;
import com.sajana.bookapp.exception.InvalidDataException;
import com.sajana.bookapp.exception.RecordNotFoundException;
import com.sajana.bookapp.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AuthorService {

    @Autowired
    AuthorRepository repository;
    
    public Author add(Author object){
        if(object.getName() == null || object.getName().trim().isEmpty()){
            throw new InvalidDataException("Name not found");
        }
        return repository.save(object);
    }
    
    public Author update(Author object){
        if(object.getAuthorId() == 0){
            throw new InvalidDataException("Author id not found");
        }else if(getById(object.getAuthorId()) == null){
            throw new RecordNotFoundException(object.getAuthorId());
        }
        return repository.save(object);
    }
    
    public Author getById(int id){
        Author author = repository.get(id);
        if(author == null){
            throw new RecordNotFoundException(id);
        }
        return author;
    }
    
    public Author deleteById(int id){
        Author delete = repository.delete(id);
        if(delete == null){
            throw new RecordNotFoundException(id);
        }
        return delete;
    }
}
