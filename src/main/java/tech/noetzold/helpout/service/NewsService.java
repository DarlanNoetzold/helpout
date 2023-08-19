package tech.noetzold.helpout.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.noetzold.helpout.client.NewsFeignClient;
import tech.noetzold.helpout.model.TabnewsResponse;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NewsService {

    private final NewsFeignClient newsFeignClient;

    @Autowired
    public NewsService(NewsFeignClient newsFeignClient) {
        this.newsFeignClient = newsFeignClient;
    }

    public String getNews(){
        List<TabnewsResponse> tabnewsResponse = newsFeignClient.getNews("1", "20", "relevant");
        return tabnewsResponse.stream()
                .map(TabnewsResponse::getTitle)
                .collect(Collectors.joining("\n"));
    }

}
