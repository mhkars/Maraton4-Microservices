package com.halit.service;

import com.halit.dto.request.ProductSaveRequestDto;
import com.halit.dto.request.StockSaveRequestDto;
import com.halit.dto.response.ProductResponseDto;
import com.halit.manager.IStockManager;
import com.halit.mapper.IProductMapper;
import com.halit.repository.entity.Product;
import com.halit.utility.ServiceManager;
import org.mapstruct.factory.Mappers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService extends ServiceManager<Product,Long> {
    private final IStockManager stockManager;

    public ProductService(JpaRepository<Product, Long> repository, IStockManager stockManager) {
        super(repository);
        this.stockManager = stockManager;
    }
    public ProductResponseDto save(ProductSaveRequestDto dto){
        Product product= IProductMapper.INSTANCE.toProduct(dto);
        save(product);

        stockManager.save(StockSaveRequestDto.builder()
                        .name(product.getName())
                        .brand(product.getBrand())
                        .type(product.getType())
                        .productid(product.getId())
                        .model(product.getModel())
                        .build());
        return  IProductMapper.INSTANCE.toProductResponseDto(product);

    }
}
