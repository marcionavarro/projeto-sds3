package com.marcionavarro.dsvendas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.marcionavarro.dsvendas.dto.SaleDTO;
import com.marcionavarro.dsvendas.dto.SaleSuccessDTO;
import com.marcionavarro.dsvendas.dto.SaleSumDTO;
import com.marcionavarro.dsvendas.entities.Sale;
import com.marcionavarro.dsvendas.repositories.SaleRepository;
import com.marcionavarro.dsvendas.repositories.SellerRepository;

@Service
public class SaleService {

	@Autowired
	private SaleRepository repository;

	@Autowired
	private SellerRepository sellerRepository;

	@Transactional(readOnly = true)
	public Page<SaleDTO> findAll(Pageable pagable) {
		sellerRepository.findAll();
		Page<Sale> result = repository.findAll(pagable);
		return result.map(x -> new SaleDTO(x));
	}

	@Transactional(readOnly = true)
	public List<SaleSumDTO> amountGroupedBySeller() {
		return repository.amountGroupedBySeller();
	}
	
	@Transactional(readOnly = true)
	public List<SaleSuccessDTO> successGroupedBySeller() {
		return repository.successGroupedBySeller();
	}

}
