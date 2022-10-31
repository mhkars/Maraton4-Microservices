package com.halit.manager;

import com.halit.dto.request.StockSaveRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static com.halit.constants.ApiUrls.SAVE;

@FeignClient(name = "stock-service",
        url= "http://localhost:9052/api/v1/stock",
        decode404 = true)
public interface IStockManager {
    @PostMapping(SAVE)
    ResponseEntity<Boolean> save(@RequestBody StockSaveRequestDto dto);

}
