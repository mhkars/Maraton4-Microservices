package com.halit.service;



import com.halit.dto.request.StockSaveRequestDto;
import com.halit.dto.request.StockUpdateRequestDto;
import com.halit.dto.response.StockResponseDto;
import com.halit.exception.ErrorType;
import com.halit.exception.StockManagerException;
import com.halit.mapper.IStockMapper;
import com.halit.repository.IStockRepository;
import com.halit.repository.entity.Stock;
import com.halit.repository.enums.Status;
import com.halit.utility.ServiceManager;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StockService extends ServiceManager<Stock,Long> {
    private final IStockRepository stockRepository;

    public StockService(IStockRepository stockRepository) {
        super(stockRepository);

        this.stockRepository = stockRepository;
    }

    public Boolean save(StockSaveRequestDto dto) {
        Stock stock = save(Stock.builder()
                .name(dto.getName())
                .type(dto.getType())
                .brand(dto.getBrand())
                .model(dto.getModel())
                .quantity(0)
                .build());
        return true;
    }

    public StockResponseDto findOptionalByName(String name) {
        Optional<Stock> stock = stockRepository.findOptionalByName(name);

        if (stock.isPresent()) {
            return IStockMapper.INSTANCE.toStockResponseDto(stock.get());
        } else {

            throw new StockManagerException(ErrorType.STOCK_NOT_FOUND);
        }

    }

    public List<StockResponseDto> findByStatus(Status status) {


        return stockRepository.findAllByStatus(status).stream().
                map(x ->
                        IStockMapper.INSTANCE.toStockResponseDto(x)
                ).collect(Collectors.toList());
    }

    public StockResponseDto update(@RequestBody StockUpdateRequestDto dto) {
        Optional<Stock> stock = stockRepository.findOptionalByName(dto.getName());
        if (stock.isPresent()) {
            stock.get().setQuantity(dto.getQuantity());
            if(dto.getQuantity()>0){
                stock.get().setStatus(Status.AVALIABLE);
            }
            save(stock.get());
            return IStockMapper.INSTANCE.toStockResponseDto(stock.get());
        } else {
            throw new StockManagerException(ErrorType.STOCK_NOT_FOUND);
        }
    }


}


