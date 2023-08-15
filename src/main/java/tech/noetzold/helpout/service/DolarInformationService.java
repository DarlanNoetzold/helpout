package tech.noetzold.helpout.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.noetzold.helpout.model.DolarResponse;
import tech.noetzold.helpout.repository.DolarFeignClient;

import java.math.BigDecimal;

@Service
public class DolarInformationService {
    private DolarFeignClient dolarFeignClient;

    @Autowired
    public void dolarService(DolarFeignClient dolarFeignClient) {
        this.dolarFeignClient = dolarFeignClient;
    }

    public BigDecimal getDolarRate() {
        DolarResponse dolarResponse = dolarFeignClient.getDolarRate();
        return dolarResponse.getUSD().getAsk();
    }
}
