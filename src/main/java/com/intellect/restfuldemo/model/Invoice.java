package com.intellect.restfuldemo.model;

import lombok.Data;

@Data
public class Invoice {
	
	private String invoiceId;
	private String paidAmt;
	private String customerName;
	private String customerEmail;
	private String customerPhn;

	/*
	 * public String getInvoiceId() { return invoiceId; } public void
	 * setInvoiceId(String invoiceId) { this.invoiceId = invoiceId; } public String
	 * getPaidAmt() { return paidAmt; } public void setPaidAmt(String paidAmt) {
	 * this.paidAmt = paidAmt; } public String getCustomerName() { return
	 * customerName; } public void setCustomerName(String customerName) {
	 * this.customerName = customerName; } public String getCustomerEmail() { return
	 * customerEmail; } public void setCustomerEmail(String customerEmail) {
	 * this.customerEmail = customerEmail; } public String getCustomerPhn() { return
	 * customerPhn; } public void setCustomerPhn(String customerPhn) {
	 * this.customerPhn = customerPhn; }
	 * 
	 * public String toString() { return
	 * "JSON DATE IN JAVA OBJECT [invoiceId="+invoiceId+", paidAmt="
	 * +paidAmt+", customerName="+customerName+", customerEmail="+customerEmail+
	 * ",customerPhn="+customerPhn+"]"; }
	 */

}
