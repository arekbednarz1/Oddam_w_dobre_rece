package pl.arekbednarz.oddajwdobrerece.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.arekbednarz.oddajwdobrerece.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}