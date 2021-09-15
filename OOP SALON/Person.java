/**
 * @(#)Person.java
 *
 *
 * @author 
 * @version 1.00 2019/7/23
 */

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Person {

	protected Name name = new Name();
	protected String icNo;
	protected String gender;
	protected Address address = new Address();
	protected Contact contact = new Contact();
	
    public Person() {
    }
    
    public Person(Name name, String icNo, Address address, Contact contact)
    {
    	this.name=name;
    	this.icNo=icNo;
    	this.address=address;
    	this.contact=contact;
    	setGender(icNo);
    }
    
    public void setGender(String icNo)
    {
    	if(icNo.charAt(icNo.length()-1)%2 == 0)
    		gender = "FEMALE";    		
    	else
			gender = "MALE";		
    }
    
    //getter / accessor 
    public Name getName()
    {
    	return name;
    }
    
    public String getIcNo()
    {
    	return icNo;
    }
    
    public String getGender()
    {
    	return gender;
    }
    
    public Address getAddress()
    {
    	return address;
    }
    
    public Contact getContact()
    {
    	return contact;
    }

    //setter / mutator
    public void setIcNo(String icNo)
    {
    	this.icNo =icNo;
    	if(icNo.charAt(icNo.length()-1)%2 == 0)
    		gender = "FEMALE";    		
    	else
			gender = "MALE";    		
    }
    
	public String toString(int sort)
	{
		if(sort == 3) //gender first
			return String.format("Gender \t\t\t  : %s\n%sIC No \t\t\t  : %s\n%s%s",gender, name.toString(), icNo, contact.toString(), address.toString());
		else //name first
			return String.format("%sIC No \t\t\t  : %s\nGender \t\t\t  : %s\n%s%s", name.toString(), icNo, gender, contact.toString(), address.toString());
	}
	
	public static boolean icNoValidation(String icNo)
    {
    	Pattern pattern = Pattern.compile("^\\d{6}\\-\\d{2}\\-\\d{4}$");
     	Matcher matcher = pattern.matcher(icNo);
     	
     	if(matcher.matches())
    		return true;
    	else
    	{
    		if(!icNo.equals("CANCLE"))
				System.out.println("***IC Number must be in the form XXXXXX-XX-XXXX***\n");
			return false;
    	}
    }
}