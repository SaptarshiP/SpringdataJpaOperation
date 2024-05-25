package com.psja.web;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

import com.psja.entity.PaymentInfo;
import com.psja.service.ApplicationService;

@RestController
public class ApplicationController {

	@Autowired
	@Qualifier("Test")
	private ApplicationService applicationService;
	
	@RequestMapping(value="/getData", method = RequestMethod.GET)
	public ResponseEntity<List<PaymentInfo>> getData( @RequestParam("page")String page, 
												@RequestParam("size")String size ){
		
		List<PaymentInfo> paymentInfoList = applicationService.getData(page, size);
		return ResponseEntity.status( HttpStatus.ACCEPTED )
								.contentType(MediaType.APPLICATION_JSON).body(paymentInfoList);
	}
	
	@RequestMapping(value="/getDataBankNameSort", method = RequestMethod.GET)
	public ResponseEntity<List<PaymentInfo>> getDataBankNameSort( @RequestParam("bankName")String bankName,
																	@RequestParam("page")String page,
																	@RequestParam("size")String size){
		
		List<PaymentInfo> paymentInfoList = applicationService.getDataBankNameSort(bankName, page, size);
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON)
														.body( paymentInfoList );
	}
	
	@RequestMapping(value = "/retrieveByAccountId", method = RequestMethod.GET)
	public ResponseEntity<List<PaymentInfo>> retrieveByAccountId( @RequestParam("accountId")String accountId ){
		
		List<PaymentInfo> paymentInfoList = applicationService.retrieveByAccountId(accountId);
		return ResponseEntity.status(HttpStatus.OK)
									.contentType(MediaType.APPLICATION_JSON).body(paymentInfoList);
	}
	
}
