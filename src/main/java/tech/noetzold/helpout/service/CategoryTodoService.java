package tech.noetzold.helpout.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.noetzold.helpout.model.CategoryTodoModel;
import tech.noetzold.helpout.model.ItemTodoModel;
import tech.noetzold.helpout.repository.CategoryTodoRepository;
import tech.noetzold.helpout.repository.ItemTodoRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryTodoService {

    @Autowired
    CategoryTodoRepository categoryTodoRepository;

    @Autowired
    ItemTodoRepository itemTodoRepository;

    public List<CategoryTodoModel> getAllCategoryTodo() {
        LocalDate today = LocalDate.now();

        List<CategoryTodoModel> categoryTodoModels = categoryTodoRepository.findAll().stream()
                .filter(e -> isSameDay(e.getDate(), today))
                .collect(Collectors.toList());

        if (categoryTodoModels.isEmpty()) {
            LocalDate yesterday = today.minusDays(1);
            List<CategoryTodoModel> categoryTodoModelsToSave = categoryTodoRepository.findAllByDate(yesterday);

            if (categoryTodoModelsToSave == null || categoryTodoModelsToSave.isEmpty()) {
                return null;
            }

            return categoryTodoModelsToSave.stream()
                    .map(categoryTodoModel -> {
                        CategoryTodoModel newCategory = new CategoryTodoModel();
                        newCategory.setName(categoryTodoModel.getName());
                        newCategory.setDate(today);

                        List<ItemTodoModel> updatedItems = categoryTodoModel.getItems().stream()
                                .map(itemTodoModel -> {
                                    ItemTodoModel newItem = new ItemTodoModel();
                                    newItem.setDescription(itemTodoModel.getDescription());
                                    newItem.setCheck(false);
                                    return newItem;
                                })
                                .collect(Collectors.toList());

                        newCategory.setItems(updatedItems);
                        return categoryTodoRepository.save(newCategory);
                    })
                    .collect(Collectors.toList());
        }

        return categoryTodoModels;
    }

    private boolean isSameDay(LocalDate date1, LocalDate date2) {
        return date1.equals(date2);
    }


    public CategoryTodoModel getCategoryByName(String name){

        List<CategoryTodoModel> categories = categoryTodoRepository.findByName(name);

        List<CategoryTodoModel> filteredCategories = categories.stream()
                .filter(categoryTodoModel -> {
                    LocalDate categoryDate = categoryTodoModel.getDate();
                    LocalDate currentDate = LocalDate.now();

                    return categoryDate.getYear() == currentDate.getYear() && categoryDate.getDayOfYear() == currentDate.getDayOfYear();
                })
                .toList();


        if (!filteredCategories.isEmpty()) {
            return filteredCategories.get(0);
        } else {
            return null;
        }
    }

    public CategoryTodoModel saveCategoryTodo(CategoryTodoModel categoryTodoModel){
        return categoryTodoRepository.save(categoryTodoModel);
    }

    public String deleteCategoryTodo(String name){
        CategoryTodoModel categoryTodoModel = categoryTodoRepository.findByName(name).get(0);

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
