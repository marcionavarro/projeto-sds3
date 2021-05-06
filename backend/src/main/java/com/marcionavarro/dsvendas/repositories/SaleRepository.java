package com.marcionavarro.dsvendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marcionavarro.dsvendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long>  {

}
