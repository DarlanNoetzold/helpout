package tech.noetzold.helpout.repository;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import tech.noetzold.helpout.model.DolarResponse;

@FeignClient(name = "dolar-api", url = "https://api.awesomeapi.com.br")
public interface DolarFeignClient {

    @GetMapping("/json/dolar")
    DolarResponse getDolarRate();
}





