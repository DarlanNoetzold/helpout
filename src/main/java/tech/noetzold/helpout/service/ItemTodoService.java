package tech.noetzold.helpout.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.noetzold.helpout.model.ItemTodoModel;
import tech.noetzold.helpout.repository.ItemTodoRepository;

import java.util.List;

@Service
public class ItemTodoService {

    @Autowired
    ItemTodoRepository itemTodoRepository;


    public List<ItemTodoModel> getAllItemsTodo(){
        return itemTodoRepository.findAll();
    }

    public ItemTodoModel getItemTodoById(Long id){
        return itemTodoRepository.findById(id).orElse(null);
    }

    public ItemTodoModel saveItemTodo(ItemTodoModel itemTodoModel){
        return itemTodoRepository.save(itemTodoModel);
    }

    public String deleteItemTodoByName(String name){
        ItemTodoModel itemTodoModel = itemTodoRepository.findByDescription(name).orElse(null);
        if(itemTodoModel == null) return "ItemTodo don't exist!";
        itemTodoRepository.deleteById(itemTodoModel.getId());
        return "ItemTodo removed with success";
    }

    public String checkItemTodo(String name){
        ItemTodoModel itemTodoModel = itemTodoRepository.findByDescription(name).orElse(null);
        if(itemTodoModel == null) return "Item don't exist!";

        itemTodoModel.setCheck(true);

        itemTodoRepository.save(itemTodoModel);

        return "ItemTodo checked!";
    }


}
