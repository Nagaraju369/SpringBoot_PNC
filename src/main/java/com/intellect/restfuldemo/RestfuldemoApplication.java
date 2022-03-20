package com.intellect.restfuldemo;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;

@SpringBootApplication
public class RestfuldemoApplication {

	public static void main(String[] args) throws StreamWriteException, DatabindException, IOException {
		SpringApplication.run(RestfuldemoApplication.class, args);
		
		System.out.println("***********Server Started************");
		
		/* To perform Java Object to JSON Conversion */ 
		/* Invoice objInvoice =new Invoice();
		objInvoice.setInvoiceId("HB3");
		objInvoice.setPaidAmt("500");
		objInvoice.setCustomerName("Raju");
		objInvoice.setCustomerEmail("raju@gmail.com");
		objInvoice.setCustomerPhn("9003605274");
		
		ObjectMapper objectMapper=new ObjectMapper();
		objectMapper.writeValue(new File("invoiceTest.json"), objInvoice);
		System.out.println("***********Json File is Created***********");
		
		
		/* To perform  JSON to Java Object */
		/*ObjectMapper objectMapper1=new ObjectMapper();
		Invoice objInvoice1 =objectMapper1.readValue(new File("invoiceTest.json"), Invoice.class);
		System.out.println("***********Java Object is Created ***********\n "+objInvoice1); */
		
		System.out.println(" ***********POSTAMN SERVICE***********\n ");
		
		
		
	}

}
