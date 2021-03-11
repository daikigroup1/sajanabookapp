package com.sajana.bookapp.service;

import com.sajana.bookapp.dto.Publisher;
import com.sajana.bookapp.exception.InvalidDataException;
import com.sajana.bookapp.exception.RecordNotFoundException;
import com.sajana.bookapp.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublisherService {
    @Autowired
    PublisherRepository repository;

    public Publisher add(Publisher object){
        if(object.getName() == null || object.getName().trim().isEmpty()){
            throw new InvalidDataException("Name not found");
        }
        return repository.save(object);
    }

    public Publisher update(Publisher object){
        if(object.getPublisherId() == 0){
            throw new InvalidDataException("Publisher id not found");
        }else if(getById(object.getPublisherId()) == null){
            throw new RecordNotFoundException(object.getPublisherId());
        }
        return repository.save(object);
    }

    public Publisher getById(int id){
        Publisher publisher = repository.get(id);
        if(publisher == null){
            throw new RecordNotFoundException(id);
        }
        return publisher;
    }

    public Publisher deleteById(int id){
        Publisher delete = repository.delete(id);
        if(delete == null){
            throw new RecordNotFoundException(id);
        }
        return delete;
    }
    
}
