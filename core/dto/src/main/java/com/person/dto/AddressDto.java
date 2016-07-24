package com.person.dto;

/**
 * Hello world!
 *
 */

import java.text.MessageFormat;


public class AddressDto
{
	private String address_street_number;
	private String address_barangay;
	private String address_city;
	private String address_zipcode;
	
	public AddressDto(){}
	
	public AddressDto(String streetNumber, String barangay, String city, String zipcode){
		address_street_number=streetNumber;
		address_barangay=barangay;
		address_city=city;
		address_zipcode=zipcode;
	}
	
	public void setAddress_street_number(String streetNumber){
		address_street_number=streetNumber;
	}
	public String getAddress_street_number(){
		return address_street_number;
	}
	
	public void setAddress_barangay(String barangay){
		address_barangay=barangay;
	}
	public String getAddress_barangay(){
		return address_barangay;
	}
	
	public void setAddress_city(String city){
		address_city=city;
	}
	public String getAddress_city(){
		return address_city;
	}
	
	public void setAddress_zipcode(String zipCode){
		address_zipcode=zipCode;
	}
	public String getAddress_zipcode(){
		return address_zipcode;
	}
	
	@Override
	public String toString(){
		return MessageFormat.format("{2} {1} {0} {3}",  this.address_city, this.address_barangay, this.address_street_number, this.address_zipcode);
	}
}
