package com.sajana.bookapp.repository;

import com.sajana.bookapp.dto.Book;
import com.sajana.bookapp.dto.Publisher;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Component
public class BookRepository implements BaseRepository<Book>{
    private static int idSeq;
    private static Map<Integer, Book> books = new HashMap<>();

    @Override
    public Book save(Book object) {
        if(object.getBookId() == 0){
            object.setBookId(++idSeq);
        }
        books.put(object.getBookId(),object);
        return object;
    }

    @Override
    public Book delete(int id) {
        return books.remove(id);
    }

    @Override
    public Book get(int id) {
        return books.get(id);
    }

    public ArrayList getBooksByPublisherId(int publisherId){

        ArrayList<Book> bookList = new ArrayList<>();

        for (int id:books.keySet()) {
            if(books.get(id).getPublisherId() == publisherId){
                bookList.add(books.get(id));
            }
        }
        return bookList;
    }

    public ArrayList getBooksByAuthorId(int authorId){

        ArrayList<Book> bookList = new ArrayList<>();

        for (int id:books.keySet()) {
            if(books.get(id).getAuthorId() == authorId){
                bookList.add(books.get(id));
            }
        }
        return bookList;
    }
}
