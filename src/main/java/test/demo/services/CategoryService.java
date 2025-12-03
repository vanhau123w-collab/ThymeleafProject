package test.demo.services;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import test.demo.entity.Category;

public interface CategoryService {

    // Các phương thức chuẩn của JpaRepository
    List<Category> findAll();

    <S extends Category> S save(S entity);

    Optional<Category> findById(Integer id);

    long count();

    void deleteById(Integer id);

    // Các phương thức custom từ CategoryRepository
    List<Category> findByCategoryNameContaining(String name);

    Page<Category> findByCategoryNameContaining(String name, Pageable pageable);
}