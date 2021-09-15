/**
 * @(#)Contact.java
 *
 *
 * @author 
 * @version 1.00 2019/7/23
 */
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Contact {

	private String phoneNo, emergencyNo, email;
	
    public Contact() {
    }
    
    public Contact(String phoneNo, String emergencyNo, String email)
    {
    	this.phoneNo=phoneNo;
    	this.emergencyNo=emergencyNo;
    	this.email=email;	
    }
    
    //getter / accessor
    public String getPhoneNo()
    {
    	return phoneNo;
    }
    
    public String getEmergencyNo()
    {
    	return emergencyNo;
    }
    
    public String getEmail()
    {
    	return email;
    }
    
    //setter / mutator
    public void setPhoneNo(String phoneNo)
    {
    	this.phoneNo=phoneNo;
    }
    
    public void setEmergencyNo(String emergencyNo)
    {
    	this.emergencyNo=emergencyNo;
    }
    
    public void setEmail(String email)
    {
    	this.email=email;
    }
    
    public String toString()
    {
    	return String.format("Contact No \t\t  : %s\nEmergency Contact : %s\nEmail \t\t\t  : %s\n", phoneNo, emergencyNo, email);
    }
    
    public static boolean phoneNoValidation(String phoneNo)
    {
		Pattern pattern1 = Pattern.compile("\\d{3}-\\d{8}");
     	Matcher matcher1 = pattern1.matcher(phoneNo);
		Pattern pattern2 = Pattern.compile("\\d{3}-\\d{7}");
     	Matcher matcher2 = pattern2.matcher(phoneNo);
      
		if (matcher1.matches() || matcher2.matches()) 
		{
			return true;
		}
		else
		{
			if(!phoneNo.equals("CANCLE"))
				System.out.println("***Phone Number must be in the form XXX-XXXXXXXX***\n");
			return false;
		}
	}
	
	public static boolean emailValidation(String email)
	{
		Pattern pattern = Pattern.compile("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$");
		Matcher matcher = pattern.matcher(email);
		
		if(matcher.matches())
			return true;
		else
		{
			if(!email.equals("CANCLE"))
				System.out.println("***Invalid Email Format***\n");
			return false;
		}
	}
}