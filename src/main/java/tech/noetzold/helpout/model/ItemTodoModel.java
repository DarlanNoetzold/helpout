package tech.noetzold.helpout.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.persistence.*;

import javax.persistence.Entity;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class ItemTodoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private boolean check;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryTodoModel category;

}
