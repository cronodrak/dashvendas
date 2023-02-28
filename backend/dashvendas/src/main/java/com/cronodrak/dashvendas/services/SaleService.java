package com.cronodrak.dashvendas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cronodrak.dashvendas.dto.SaleDTO;
import com.cronodrak.dashvendas.entities.Sale;
import com.cronodrak.dashvendas.respositories.SaleRepository;

@Service
public class SaleService {
	
	@Autowired
	private SaleRepository saleRepository;
	
	public Page<SaleDTO> findAll(Pageable pageable){
		Page<Sale> result = saleRepository.findAll(pageable);
		return result.map(x -> new SaleDTO(x));
	}

}
