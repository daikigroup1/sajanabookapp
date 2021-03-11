package com.sajana.bookapp.repository;

import com.sajana.bookapp.dto.Author;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class AuthorRepository implements BaseRepository<Author> {
    private static int idSeq;
    private static Map<Integer, Author> authors = new HashMap<>();

    @Override
    public Author save(Author object) {
        if(object.getAuthorId() == 0){
            object.setAuthorId(++idSeq);
        }
        authors.put(object.getAuthorId(),object);
        return object;
    }

    @Override
    public Author delete(int id) {
        return authors.remove(id);
    }

    @Override
    public Author get(int id) {
        return authors.get(id);
    }
}
