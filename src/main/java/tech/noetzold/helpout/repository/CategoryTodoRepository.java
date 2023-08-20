package tech.noetzold.helpout.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.noetzold.helpout.model.CategoryTodoModel;

@Repository
public interface CategoryTodoRepository extends JpaRepository<CategoryTodoModel, Long> {

}
