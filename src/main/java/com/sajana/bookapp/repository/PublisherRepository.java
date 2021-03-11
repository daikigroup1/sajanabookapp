package com.sajana.bookapp.repository;

import com.sajana.bookapp.dto.Publisher;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class PublisherRepository implements BaseRepository<Publisher> {
    private static int idSeq;
    private static Map<Integer, Publisher> publishers = new HashMap<>();


    @Override
    public Publisher save(Publisher object) {
        if(object.getPublisherId() == 0){
            object.setPublisherId(++idSeq);
        }
        publishers.put(object.getPublisherId(),object);
        return object;
    }

    @Override
    public Publisher delete(int id) {
        return publishers.remove(id);
    }

    @Override
    public Publisher get(int id) {
        return publishers.get(id);
    }
}
