package tech.noetzold.helpout.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import tech.noetzold.helpout.model.DolarResponse;

@FeignClient(name = "dolar-api", url = "https://economia.awesomeapi.com.br")
public interface DolarFeignClient {

    @GetMapping("/last/USD-BRL")
    DolarResponse getDolarRate();
}





