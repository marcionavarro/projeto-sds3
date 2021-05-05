package com.marcionavarro.dsvendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marcionavarro.dsvendas.entities.Seller;

public interface SellerRepository extends JpaRepository<Seller, Long> {

}
