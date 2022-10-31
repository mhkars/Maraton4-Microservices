package com.halit.dto.request;

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
public class StockUpdateRequestDto {
    private String name;
    private Integer quantity;

}
