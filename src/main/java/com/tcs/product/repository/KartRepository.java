package com.tcs.product.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.product.entity.Kart;

public interface KartRepository extends JpaRepository<Kart, Integer>{

	Optional<Kart> findByCustomerIdAndProductId(Integer cid, Integer pid);

}
