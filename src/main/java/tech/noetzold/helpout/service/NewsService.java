package tech.noetzold.helpout.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.noetzold.helpout.client.NewsFeignClient;
import tech.noetzold.helpout.model.TabnewsResponse;

@Service
public class NewsService {

    private final NewsFeignClient newsFeignClient;

    @Autowired
    public NewsService(NewsFeignClient newsFeignClient) {
        this.newsFeignClient = newsFeignClient;
    }

    public String getNews(){
        TabnewsResponse tabnewsResponse = newsFeignClient.getNews("1", "20", "relevant");
        return tabnewsResponse.getTitle();
    }

}
