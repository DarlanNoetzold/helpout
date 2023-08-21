package tech.noetzold.helpout.command;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import tech.noetzold.helpout.model.CategoryTodoModel;
import tech.noetzold.helpout.model.ItemTodoModel;
import tech.noetzold.helpout.service.CategoryTodoService;
import tech.noetzold.helpout.service.ItemTodoService;

import java.time.LocalDate;
import java.util.List;

@ShellComponent
public class TodoCommands {

    private final CategoryTodoService categoryTodoService;
    private final ItemTodoService itemTodoService;

    public TodoCommands(CategoryTodoService categoryTodoService, ItemTodoService itemTodoService) {
        this.categoryTodoService = categoryTodoService;
        this.itemTodoService = itemTodoService;
    }


    @ShellMethod(value = "Create a new CategoryTodo", key = {"addCategory"})
    public String addCategory(String name){
        LocalDate currentDate = LocalDate.now();
        LocalDate dateWithOnlyYearMonthDay = LocalDate.of(currentDate.getYear(), currentDate.getMonth(), currentDate.getDayOfMonth());

        categoryTodoService.saveCategoryTodo(new CategoryTodoModel(name, dateWithOnlyYearMonthDay));

        return "Category Created";
    }
    @ShellMethod(value = "Create an Item and add to a category", key = {"addItem"})
    public String addItem(String itemName, String categoryName){
        CategoryTodoModel categoryTodoModel = categoryTodoService.getCategoryByName(categoryName);
        itemTodoService.saveItemTodo(new ItemTodoModel(0L, itemName, false, categoryTodoModel));

        return "Item Created in a Category";
    }

    @ShellMethod(value = "Get all items separeted by Categories", key = {"getAllItems"})
    public String getAllItems(){
        StringBuilder response = new StringBuilder("All itens by Category: \n");
        List<CategoryTodoModel> categoryTodoModels = categoryTodoService.getAllCategoryTodo();
        if(categoryTodoModels == null) return null;
        categoryTodoModels.forEach(categoryTodoModel -> {
            response.append(" - ").append(categoryTodoModel.getName());
            categoryTodoModel.getItems().forEach(itemTodoModel -> {
                if(itemTodoModel.isCheck()){
                    response.append("\n\t").append("[X]");
                }else{
                    response.append("\n\t").append("[ ]");
                }
                response.append(" - ").append(itemTodoModel.getDescription());
            });
        });
        return response.toString();
    }

    @ShellMethod(value = "Check an Item by name", key = {"checkItem"})
    public String checkItem(String itemName){
        return itemTodoService.checkItemTodo(itemName);
    }

    @ShellMethod(value = "Remove an Item by name", key = {"deleteItem"})
    public String deleteItem(String itemName){
        return itemTodoService.deleteItemTodoByName(itemName);
    }

    @ShellMethod(value = "Remove an Category by name", key = {"deleteCategory"})
    public String deleteCategory(String categoryName){
        return categoryTodoService.deleteCategoryTodo(categoryName);
    }

}
