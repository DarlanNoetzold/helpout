package tech.noetzold.helpout.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.noetzold.helpout.repository.CategoryTodoRepository;

@Service
public class CategoryTodoService {

    @Autowired
    CategoryTodoRepository categoryTodoRepository;


}
