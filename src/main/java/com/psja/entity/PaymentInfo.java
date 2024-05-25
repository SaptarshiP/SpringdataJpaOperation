package com.psja.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.NamedQuery;

@Entity
@Table(name = "payment_info")
@NamedQuery( name = "PaymentInfo.retrieveByAccountId", 
						query = "select p from PaymentInfo p where p.accountId = :accountId" )
public class PaymentInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;
	@Column(name = "bank_id")
	private String bankId;
	@Column(name = "bank_name")
	private String bankName;
	@Column(name = "account_id")
	private String accountId;
	@Column(name = "account_name")
	private String accountName;
	@Column( name = "amount" )
	private String amount;
	
	public String getUid() {
		return this.id;
	}
	public void setUid( String id ) {
		this.id = id;
	}
	
	public String getBankId() {
		return this.bankId;
	}
	public void setBankId( String bankId ) {
		this.bankId = bankId;
	}
	
	public String getBankName() {
		return this.bankName;
	}
	public void setBankName( String bankName ) {
		this.bankName = bankName;
	}
	
	public String getAccountId() {
		return this.accountId;
	}
	public void setAccountId( String accountId ) {
		this.accountId = accountId;
	}
	
	public String getAccountName() {
		return this.accountName;
	}
	public void setAccountName( String accountName ) {
		this.accountName = accountName;
	}
	
	public String getAmount() {
		return this.amount;
	}
	public void setAmount( String amount ) {
		this.amount = amount;
	}
}
