package tech.noetzold.helpout.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tech.noetzold.helpout.model.CategoryTodoModel;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface CategoryTodoRepository extends JpaRepository<CategoryTodoModel, Long> {

    List<CategoryTodoModel> findByName(String name);

    List<CategoryTodoModel> findAllByDate(LocalDate date);
}
