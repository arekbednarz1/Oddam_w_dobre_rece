package pl.arekbednarz.oddajwdobrerece.services;

import pl.arekbednarz.oddajwdobrerece.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
}