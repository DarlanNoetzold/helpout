package tech.noetzold.helpout.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.noetzold.helpout.model.ItemTodoModel;

public interface ItemTodoRepository extends JpaRepository<ItemTodoModel, Long> {
}
