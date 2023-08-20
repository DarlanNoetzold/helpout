package tech.noetzold.helpout.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TabnewsResponse {

    private String id;
    private String owner_id;
    private String parent_id;
    private String slug;
    private String title;
    private String status;
    private String source_url;
    private String created_at;
    private String updated_at;
    private String published_at;
    private String deleted_at;
    private Integer tabcoins;
    private String owner_username;
    private Integer children_deep_count;
}
