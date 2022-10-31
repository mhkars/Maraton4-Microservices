package com.halit.mapper;


import com.halit.dto.request.StockSaveRequestDto;
import com.halit.dto.request.StockUpdateRequestDto;
import com.halit.dto.response.StockResponseDto;
import com.halit.repository.entity.Stock;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.io.Serializable;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,componentModel = "spring")
public interface IStockMapper {
    IStockMapper INSTANCE = Mappers.getMapper(IStockMapper.class);

    Stock toStock(final StockSaveRequestDto dto);
    Stock toStock(final StockUpdateRequestDto dto);
    StockResponseDto toStockResponseDto(final Stock stock);
}
