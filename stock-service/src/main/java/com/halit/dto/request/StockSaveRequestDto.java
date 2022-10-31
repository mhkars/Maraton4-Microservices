package com.halit.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class StockSaveRequestDto {

    private Long productid;
    private String name;
    private String type;
    private String brand;
    private String model;
//    private Integer quantity;


}
