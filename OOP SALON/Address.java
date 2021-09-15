/**
 * @(#)Address.java
 *
 *
 * @author 
 * @version 1.00 2019/7/23
 */


public class Address {
	
	private String apartment, street, postcode, state, country;
	
    public Address() {
    }
    
    public Address(String apartment, String street, String postcode, String state, String country)
    {
    	this.apartment=apartment.toUpperCase();    
    	this.street=street.toUpperCase();
    	this.postcode=postcode;
    	this.state=state.toUpperCase();
    	this.country=country.toUpperCase();
    }    
    
    //getter / accessor
    public String getApartment()
    {
    	return apartment;
    }
	
    public String getStreet()
    {
    	return street;
    }    
    
    public String getPostcode()
    {
    	return postcode;
    }
    
	public String getState()
    {
    	return state;
    }
    
    public String getCountry()
    {
    	return country;
    }
    
    //setter / mutator
    public void setApartment(String apartment)
    {
    	this.apartment=apartment;
    }
	
    public void setStreet(String street)
    {
    	this.street=street;
    }    
    
    public void setPostcode(String postcode)
    {
    	this.postcode=postcode;
    }
    
	public void setState(String state)
    {
    	this.state=state;
    }
    
    public void setCountry(String country)
    {
    	this.country=country;
    }
    
    public String toString()
    {
    	return String.format("Address \t\t  : %s,\n\t\t\t\t\t%s,\n\t\t\t\t\t%s %s,\n\t\t\t\t\t%s.\n", apartment, street, postcode, state, country);
    }
    
    public static boolean postcodeValidation(String postcode)
    {
    	if(postcode.length()!=5 || postcode.charAt(0) == '0')
    		return false;
    	else
    	{
    		for(int k=0;k<postcode.length();k++)
    		{
    			if(!Character.isDigit(postcode.charAt(k)))
    				return false;
    		}
    		return true;
    	}
    }
}