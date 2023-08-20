package tech.noetzold.helpout.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.noetzold.helpout.repository.ItemTodoRepository;

@Service
public class ItemTodoService {

    @Autowired
    ItemTodoRepository itemTodoRepository;


}
