package com.psja.repo;

import java.util.List;

import org.springframework.data.repository.Repository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.psja.entity.PaymentInfo;

public interface PaymentRepo extends Repository<PaymentInfo, String>{

	public List<PaymentInfo> findAll(Pageable pageable);
	
	public List<PaymentInfo> findByBankName( String bankName, Pageable pageable );
	
	public List<PaymentInfo> retrieveByAccountId( String accountId );
	
}
