package com.halit.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductSaveRequestDto {
    String name;
    String type;
    String brand;
    String model;
    Double price;
}
