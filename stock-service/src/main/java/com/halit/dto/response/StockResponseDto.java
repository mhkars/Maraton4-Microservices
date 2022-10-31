package com.halit.dto.response;

import ch.qos.logback.core.status.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class StockResponseDto {
    private String name;
    private String type;
    private String brand;
    private String model;
    private Integer quantity;
    private String status;
}
