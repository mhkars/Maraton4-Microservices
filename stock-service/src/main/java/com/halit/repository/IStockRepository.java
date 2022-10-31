package com.halit.repository;


import com.halit.repository.entity.Stock;
import com.halit.repository.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IStockRepository extends JpaRepository<Stock,Long> {
    Optional<Stock> findOptionalByName(String name);
    List<Stock> findAllByStatus(Status status);

}
