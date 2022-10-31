package com.halit.controller;


import com.halit.dto.request.StockSaveRequestDto;
import com.halit.dto.request.StockUpdateRequestDto;
import com.halit.dto.response.StockResponseDto;
import com.halit.exception.ErrorType;
import com.halit.exception.StockManagerException;
import com.halit.repository.entity.Stock;
import com.halit.repository.enums.Status;
import com.halit.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

import static com.halit.constants.ApiUrls.*;


@RestController
@RequestMapping(STOCK)
@RequiredArgsConstructor
public class StockController {
    private final StockService stockService;
    @PostMapping(SAVE)
    public ResponseEntity<Boolean> save(@RequestBody StockSaveRequestDto dto){

        try {
            stockService.save(dto);
            return ResponseEntity.ok(true);
        }catch (Exception e){
            throw  new StockManagerException(ErrorType.STOCK_NOT_CREATED);
        }

    }
    @GetMapping(GETALL)
    public ResponseEntity<List<Stock>> getList(){
        return ResponseEntity.ok(stockService.findAll());
    }

    @GetMapping(FINDBYNAME)
    public ResponseEntity<StockResponseDto> findByName(String name){
        return ResponseEntity.ok(stockService.findOptionalByName(name));
    }
    @GetMapping(GETLIST)
    public ResponseEntity<List<StockResponseDto>> getListByStatus(Status status){
        return ResponseEntity.ok(stockService.findByStatus(status));
    }
    @PostMapping(UPDATE)
    public ResponseEntity<StockResponseDto> updateProfile(@RequestBody StockUpdateRequestDto dto){
        return ResponseEntity.ok(stockService.update(dto)) ;
    }
}

