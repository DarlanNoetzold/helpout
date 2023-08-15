package tech.noetzold.helpout.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.noetzold.helpout.model.DolarResponse;
import tech.noetzold.helpout.client.DolarFeignClient;

import java.math.BigDecimal;

@Service
public class DolarService {
    private final DolarFeignClient dolarFeignClient;

    @Autowired
    public DolarService(DolarFeignClient dolarFeignClient) {
        this.dolarFeignClient = dolarFeignClient;
    }

    public BigDecimal getDolarRate() {
        DolarResponse dolarResponse = dolarFeignClient.getDolarRate();
        return dolarResponse.getUSDBRL().getAsk();
    }
}

