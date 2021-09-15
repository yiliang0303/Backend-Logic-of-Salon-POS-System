/**
 * @(#)Name.java
 *
 *
 * @author 
 * @version 1.00 2019/7/23
 */


public class Name {

	private String firstName, lastName;
  
    public Name() {
    }
    
    //gettter / accessor
 	public Name(String firstName, String lastName)	
 	{
 		this.firstName=firstName.toUpperCase();
 		this.lastName=lastName.toUpperCase();
 	}   
 		
 	public String getFirstName()
 	{
 		return firstName;
 	}
 	
 	public String getLastName()
 	{
 		return lastName;
 	}
 	
 	//setter / mutator
 	public void setFirstName(String firstName)
 	{
 		this.firstName=firstName;
 	}
 	
 	public void setLastName(String lastName)
 	{
 		this.lastName=lastName;
 	}
 	
 	public String toString()
 	{
 		return String.format("Name \t\t\t  : %s %s\n", firstName, lastName);
 	}
}