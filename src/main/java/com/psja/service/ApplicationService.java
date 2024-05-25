package com.psja.service;

import java.util.List;

import com.psja.entity.PaymentInfo;

public abstract class ApplicationService {

	public abstract List<PaymentInfo> getData( String page, String size );
	public abstract List<PaymentInfo> getDataBankNameSort( String bankName, String page, String size );
	public abstract List<PaymentInfo> retrieveByAccountId( String accountId );
	
	public String getTest() {
		return "in test";
	}
	
}
