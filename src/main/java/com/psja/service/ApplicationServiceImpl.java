package com.psja.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.psja.entity.PaymentInfo;
import com.psja.repo.PaymentRepo;

@Service("Test")
public class ApplicationServiceImpl extends ApplicationService{

	@Autowired
	private PaymentRepo paymentRepo;
	
	@Override
	public List<PaymentInfo> getData( String page, String size ) {
	
		Pageable pageable = PageRequest.of(Integer.parseInt( page ), Integer.parseInt( size ));
		List<PaymentInfo> paymentInfoList = paymentRepo.findAll(pageable);
		
		return paymentInfoList;
	}

	@Override
	public List<PaymentInfo> getDataBankNameSort( String bankName, String page, String size ){
		
		
		Pageable pageable = PageRequest.of( Integer.parseInt(page), Integer.parseInt(size), Sort.by("amount").descending());
		List<PaymentInfo> paymentInfoList = paymentRepo.findByBankName(bankName, pageable);
		return paymentInfoList;
	}
	
	@Override
	public List<PaymentInfo> retrieveByAccountId( String accountId ){
		
		List<PaymentInfo> paymentInfoList = paymentRepo.retrieveByAccountId(accountId);
		return paymentInfoList;
	}
	
}
