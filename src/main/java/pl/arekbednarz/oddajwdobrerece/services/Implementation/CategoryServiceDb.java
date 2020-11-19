package pl.arekbednarz.oddajwdobrerece.services.Implementation;

import org.springframework.stereotype.Service;
import pl.arekbednarz.oddajwdobrerece.entity.Category;
import pl.arekbednarz.oddajwdobrerece.repositories.CategoryRepository;
import pl.arekbednarz.oddajwdobrerece.services.CategoryService;

import java.util.List;

@Service
public class CategoryServiceDb implements CategoryService {
    CategoryRepository categoryRepository;

    public CategoryServiceDb(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}
