package com.halit.mapper;

import com.halit.dto.request.ProductSaveRequestDto;
import com.halit.dto.request.StockSaveRequestDto;
import com.halit.dto.response.ProductResponseDto;
import com.halit.repository.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IProductMapper {
    IProductMapper INSTANCE= Mappers.getMapper(IProductMapper.class);
    Product toProduct(final ProductSaveRequestDto dto);
    Product toProduct(final StockSaveRequestDto dto);
    StockSaveRequestDto toStockSaveRequestDto ( final Product product);
    ProductResponseDto toProductResponseDto (final Product product);

}
