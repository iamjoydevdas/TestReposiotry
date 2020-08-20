package com.bank.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.*;
import java.util.Date;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "customer")
public class Customer {

	@Id
	@Min(value = 10)
	@NotNull
	private String customerId;
	@Max(value = 40)
	@NotNull
	private String customerName;
	@Pattern(regexp = "[A-Z] {5}[0-9] {4}[A-z]")
	@NotNull
	private String customerPAN;
	
	@NotNull
//	@DateTimeFormat(iso = , pattern = "MM-DD-YYYY")
	private Date dateOfBirth;
	@Email
	private String customerMail;
	@Size(min = 10, max = 13)
	private String mobileNumber;
	
	@NotNull
	@Min(value = 8)
	@Max(value = 16)
	private String password;
	@NotNull
	@Size(min =3,max = 40)
	private String address;

	List<Loan> loans;

	public Customer(Customer updatedCustomer){
		this.customerId = updatedCustomer.customerId;
		this.address = updatedCustomer.address;
		this.customerName = updatedCustomer.customerName;
		this.customerMail = updatedCustomer.customerMail;
		this.setLoans(updatedCustomer.getLoans());
		this.dateOfBirth = updatedCustomer.dateOfBirth;
		this.mobileNumber = updatedCustomer.mobileNumber;
		this.password = updatedCustomer.password;
		this.customerPAN = updatedCustomer.customerPAN;
	}
}