package tech.noetzold.helpout.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.noetzold.helpout.client.NewsFeignClient;

@Service
public class NewsService {

    private final NewsFeignClient newsFeignClient;

    @Autowired
    public NewsService(NewsFeignClient newsFeignClient) {
        this.newsFeignClient = newsFeignClient;
    }


}
