package com.marcionavarro.dsvendas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.marcionavarro.dsvendas.dto.SaleSuccessDTO;
import com.marcionavarro.dsvendas.dto.SaleSumDTO;
import com.marcionavarro.dsvendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long>  {
	
	@Query("SELECT new com.marcionavarro.dsvendas.dto.SaleSumDTO(obj.seller, SUM(obj.amount))"
			+ " FROM Sale As obj GROUP BY obj.seller")
	List<SaleSumDTO> amountGroupedBySeller();	

	@Query("SELECT new com.marcionavarro.dsvendas.dto.SaleSuccessDTO(obj.seller, SUM(obj.visited), SUM(obj.deals))"
			+ " FROM Sale As obj GROUP BY obj.seller")
	List<SaleSuccessDTO> successGroupedBySeller();	
	
}
