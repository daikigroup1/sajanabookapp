package com.sajana.bookapp.repository;

public interface BaseRepository<K> {
    K save(K object);
    K delete(int id);
    K get(int id);
}
