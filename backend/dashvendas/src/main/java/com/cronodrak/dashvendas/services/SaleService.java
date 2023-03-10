package com.cronodrak.dashvendas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cronodrak.dashvendas.dto.SaleDTO;
import com.cronodrak.dashvendas.dto.SaleSuccessDTO;
import com.cronodrak.dashvendas.dto.SaleSumDTO;
import com.cronodrak.dashvendas.entities.Sale;
import com.cronodrak.dashvendas.respositories.SaleRepository;
import com.cronodrak.dashvendas.respositories.SellerRepository;

@Service
public class SaleService {

	@Autowired
	private SaleRepository saleRepository;

	@Autowired
	private SellerRepository sellerRepository;

	@Transactional(readOnly = true)
	public Page<SaleDTO> findAll(Pageable pageable) {
		sellerRepository.findAll();
		Page<Sale> result = saleRepository.findAll(pageable);
		return result.map(x -> new SaleDTO(x));
	}

	@Transactional(readOnly = true)
	public List<SaleSumDTO> amountGroupedBySeller() {
		return saleRepository.amountGroupedBySeller();
	}
	

	@Transactional(readOnly = true)
	public List<SaleSuccessDTO> successtGroupedBySeller() {
		return saleRepository.successGroupedBySeller();
	}

}
