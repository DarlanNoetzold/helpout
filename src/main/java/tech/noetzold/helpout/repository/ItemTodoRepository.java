package tech.noetzold.helpout.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.noetzold.helpout.model.ItemTodoModel;

import java.util.Optional;

@Repository
public interface ItemTodoRepository extends JpaRepository<ItemTodoModel, Long> {
    Optional<ItemTodoModel> findByDescription(String description);
}
