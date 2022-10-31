package com.halit.repository.entity;


import com.halit.repository.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name="tblstock")
@Entity
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(length = 64)
    String name;
    String type;
    String brand;
    String model;
    @Builder.Default
    Integer quantity=0;
    @Enumerated(EnumType.STRING)
    @Builder.Default
    Status status=Status.UNAVAILABALE;


}
