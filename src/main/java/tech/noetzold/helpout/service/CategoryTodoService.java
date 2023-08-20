package tech.noetzold.helpout.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.noetzold.helpout.model.CategoryTodoModel;
import tech.noetzold.helpout.model.ItemTodoModel;
import tech.noetzold.helpout.repository.CategoryTodoRepository;
import tech.noetzold.helpout.repository.ItemTodoRepository;

import java.util.List;

@Service
public class CategoryTodoService {

    @Autowired
    CategoryTodoRepository categoryTodoRepository;

    @Autowired
    ItemTodoRepository itemTodoRepository;

    public List<CategoryTodoModel> getAllCategoryTodo(){
        return categoryTodoRepository.findAll();
    }

    public CategoryTodoModel getCategoryById(Long id){
        return categoryTodoRepository.findById(id).orElse(null);
    }

    public CategoryTodoModel saveCategoryTodo(CategoryTodoModel categoryTodoModel){
        return categoryTodoRepository.save(categoryTodoModel);
    }

    public List<ItemTodoModel> getAllItemsByCategoryTodo(Long id){
        CategoryTodoModel categoryTodoModel = categoryTodoRepository.findById(id).orElse(null);

        return categoryTodoModel != null ? categoryTodoModel.getItems() : null;
    }

    public String deleteCategoryTodo(Long id){
        CategoryTodoModel categoryTodoModel = categoryTodoRepository.findById(id).orElse(null);

        if(categoryTodoModel == null) return "Category do not exist!";

        if(categoryTodoModel.getItems().isEmpty()){
            categoryTodoRepository.delete(categoryTodoModel);
            return "Category removed with success!";
        }else{
            categoryTodoModel.getItems().forEach(e -> itemTodoRepository.delete(e));
            categoryTodoRepository.delete(categoryTodoModel);
            return "Category and all his items are removed with success!";
        }
    }
}
