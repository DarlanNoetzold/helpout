package tech.noetzold.helpout.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tech.noetzold.helpout.model.TabnewsResponse;

@FeignClient(name = "news", url = "https://www.tabnews.com.br/api/v1")
public interface NewsFeignClient {

    @GetMapping("/contents")
    TabnewsResponse getNews(@RequestParam("page") String page, @RequestParam("per_page") String perPage, @RequestParam("strategy") String strategy);

}
