/**
 * @(#)Staff.java
 *
 *
 * @author 
 * @version 1.00 2019/8/13
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Staff extends Person{

	private String staffID;
	private String spass;
	private double salary;
	private String idFormat;
	private static int countStaff = 1;
	
    public Staff(Name name,String icNo, Address address, Contact contact, String staffID, String spass, double salary) 
     {
    	super(name,icNo,address,contact);
    	this.staffID = staffID;
    	this.spass = spass;
    	this.salary = salary;
    	
    	countStaff++;
    	
    }
    
    public String getStaffID()
    {
    	return staffID;
    }
    
    public String getSPass()
    {
    	return spass;
    }
    
    public double getSalary()
    {
    	return salary;
    }
    
    public void setStaffID(String staffID)
    {
    	this.staffID = staffID;
    }
    
    public void setSPass(String spass)
    {
    	this.spass = spass;
    }
    
    public void setSalary(double salary)
    {
    	this.salary = salary;
    }
    
    public String toString()
    {
    	return String.format("%s\n" + "Staff ID\t\t\t: %s\n" + "Salary\t\t\t\t: RM%.2f\n" ,super.toString(0),staffID,salary);
    }
    
    public static boolean passValidator(String spass)
    {
    	Pattern pattern = Pattern.compile("((?=.*[a-z])(?=.*\\d)(?=.*[A-Z])(?=.*[@#$%!]).{8,12})");
    	Matcher matcher = pattern.matcher(spass);
    	if(matcher.matches())
    		return true;
    	else
    		return false;
    }
	
	public String generateStaffID()
	{
		
		staffID = "S18B00";
		for(int i=0; i<String.valueOf(countStaff).length();i++)
		{
			staffID = idFormat + countStaff;
		}
		return staffID;
	}
	
	
}