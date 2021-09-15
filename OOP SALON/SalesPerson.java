/**
 * @(#)SalesPerson.java
 *
 *
 * @author 
 * @version 1.00 2019/8/13
 */


import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;
public class SalesPerson {

    public static void salesPerson(ArrayList<Staff> staff)
    {
    	/*Name[] name = 
    	{
    		new Name("Calvin","Lim"),
    		new Name("Tommy","Lu"),
    		new Name("Brian","Ong")
    	};
    	
    	String[] icNo =
    	{
    		"001210020129",
    		"991203040913",
    		"990921010195"
    	};
    	
    	Contact[] contact =
    	{
    		new Contact("0143020994","0164341139","calvinlim@gmail.com"),
    		new Contact("0194157126","0102626003","tommylu@gmail.com"),
    		new Contact("0163939887","0162929838","brianwong@gmail.com")
    	};
    	
    	Address[] address =
    	{
    		new Address("46-8-2, GREENLANE HEIGHTS", "JALAN BESI", "11600", "GEORGETOWN", "MALAYSIA"),
    		new Address("8-07-01, THE LIGHT", "JELUTONG", "11601", "GEORGETOWN", "MALAYSIA"),
    		new Address("96-01-02, KINGFISHERS", "JALAN TANJUH", "12345", "GEORGETOWN", "MALAYSIA"),    		
    	};
    	
    	String[] staffID =
    	{
    		"S18A001",
    		"S18A002",
    		"S18B001"
    	};
    	
    	String[] spass=
    	{
    		"abc123*",
    		"lol@123",
    		"ggez123*"
    	};
    	
    	double[] salary=
    	{
    		2000.00,
    		2000.00,
    		1800.00
    	};
    	
    	ArrayList<Staff> staff=new ArrayList<Staff>();
    	
    	for(int i=0;i<name.length;i++)
    	{
    		staff.add(new Staff(name[i], icNo[i], address[i], contact[i], staffID[i], spass[i], salary[i]));
    	}*/
    	
    	staffMenuScreen(staff);
    }
    
    public static void staffMenuScreen(ArrayList<Staff> staff)
    {
    	int choice=0;
    	boolean menurun = true;
    	Scanner s = new Scanner(System.in);
    	do
    	{
    		System.out.println("-------------------------------");
    		System.out.println("| 1.Login (Existing staff)    |");
    		System.out.println("| 2.Register (New staff)      |");
    		System.out.println("| 3.Search staff info         |");
    		System.out.println("| 4.Modify staff info         |");
    		System.out.println("| 5.Display existing staff    |");
    		System.out.println("| 6.Generate sales report     |");
    		System.out.println("| 7.Exit                      |");
    		System.out.println("-------------------------------");
    		System.out.print("Please enter your choice: ");
    		choice = s.nextInt();
    		switch(choice)
    		{
    			case 1:
    				loginScreen(staff);
    				break;
    			case 2:
    				registerScreen();
    				break;
    			case 3:
    				searchScreen(staff);
    				break;
    			case 4:
    				modifyScreen(staff);
    				break;
    			case 5:
    				displayScreen(staff);
    				break;
    			case 6:
    				salesReport(staff);
    				break;
    			case 7:
    				System.out.println("Thank you");
    				break;
    			default:
    				menurun=false;
    				break;
    		}
    	}while(menurun);
    }    
    
   public static void loginScreen(ArrayList<Staff> staff)
    {
    	Scanner s = new Scanner(System.in);
    	String inputStaffID;
    	boolean found = false;
    	System.out.println("---Login---");
    	do
    	{
    	
	    	System.out.println("Enter staff ID: ");
	    	inputStaffID = s.nextLine();
	    	for(int i=0;i< staff.size();i++)
	    	{
	    		if(inputStaffID.matches(staff.get(i).getStaffID()))
	    		{
	    			found = true;
	    			int count = 0;
	    			do
	    			{
	    				System.out.print("Please enter your password: ");
	    				String inputSPass = s.nextLine();
	    				s.nextLine();
	    				if(inputSPass.matches(staff.get(i).getSPass()))
	    				{
	    					System.out.println("Login successful. ");
	    					break;
	    				}
	    				else
	    				{
	    					System.out.println("Password do not match. Please try again.");
	    					System.out.print("Please enter your password: ");
	    					inputSPass = s.nextLine();
	    					s.nextLine();
	    				}
						count++;
	    			}while(count <3);
	    		}
	    		else
	    		{
	    			System.out.println("Invalid staff ID. Please try again.");
	    			System.out.print("Please enter your staff ID: ");
	    			inputStaffID = s.nextLine();
	    		}
	    	}
    	}while(!found);
    }
    public static void registerScreen()
    {
    	Scanner s = new Scanner(System.in);	
    	char respond;
    	do
    	{
    	System.out.println("---Register new staff---"); 
    	System.out.print("Enter first name: ");
    	String firstName = s.nextLine();
    	System.out.print("Enter last name: ");
    	String lastName = s.nextLine();	
    	
    	boolean inputvalue;
    	do{
    		try
    		{
    			System.out.print("Enter I.C Number: ");
    			String icNo = s.nextLine();
    			inputvalue = true;
    		}
    		catch(Exception e)
    		{
    			inputvalue = false;
    			System.out.print("Only numbers allowed..");
    		}
    	}while(!inputvalue);
    	
    	System.out.print("Enter address(apartment): ");
    	String apartment = s.nextLine();
    	System.out.print("Enter address(street): ");
    	String street = s.nextLine();
    	System.out.print("Enter address(postcode): ");
    	String postcode = s.nextLine();
    	System.out.print("Enter address(state): ");
    	String state = s.nextLine();
    	System.out.print("Enter address(country): ");
    	String country = s.nextLine();   	
    		
		System.out.print("Enter phone number: ");
    	String phoneNo = s.nextLine();

    	System.out.print("Enter emergency number: ");
    	String emergencyNo = s.nextLine();
    	
    	System.out.print("Enter e-mail: ");
    	String email = s.nextLine();
    	Contact.emailValidation(email);
    	if(Contact.emailValidation(email)==false)
    	{    		
    		System.out.println("E-mail invalid. Please try again.");
    		System.out.print("Enter e-mail: ");
    		email = s.nextLine();
    	}
    	
    	
    	System.out.println("*Requirements(Between 8-12 chars, contain at least one digit,lowercase letter,uppercase letter and special symbol)");
    	System.out.print("Please create a password for your account: ");
    	String spass = s.nextLine();
    	Staff.passValidator(spass);
    		if(Staff.passValidator(spass)==false)
    		{    		
    			System.out.println("Password invalid. Please try again.");
    			System.out.print("Create your password: ");
    			spass = s.nextLine();
    		}
    		
    	Name name = new Name(firstName,lastName);
    	Address address = new Address(apartment,street,postcode,state,country);
    	Contact contact = new Contact(phoneNo,emergencyNo,email);
    	    		 			
    			System.out.println("Password is valid.");
    			System.out.println("You have sucessfully registered an account.");
    			System.out.println("Would you like to add another staff?? (Press Y to continue, others to exit) >> ");
				respond = s.nextLine().charAt(0);
    		
    	}while(respond=='y'||respond=='Y');
    }
    
   	public static void modifyScreen(ArrayList<Staff> staff)
    {
    	Scanner s = new Scanner(System.in);
    	String modifyID;
    	int choice = 0,x=0;
    	boolean found;
    	
    	do
    	{
    	found = false;
    	System.out.println("Enter staff ID of staff to modify info: ");
    	modifyID = s.nextLine();
	    	for(int i=0; i<staff.size();i++)
	    	{
	    		do
	    		{
	    			found = true;
		    		if(modifyID.matches(staff.get(i).getStaffID()))
		    		{
		    			x=i;
		    			Contact contact = staff.get(i).getContact();
		    			System.out.println("1.Phone No.");
		    			System.out.println("2.Email");
		    			System.out.print("Select information to modify: ");
		    			choice = s.nextInt();
		    			switch(choice)
		    			{
		    				case 1:
		    					System.out.println("Enter new phone number: ");
		    					s.nextLine();
		    					String newPhone = s.nextLine();
		    					contact.setPhoneNo(newPhone);
		    					System.out.println("Modification complete.");
		    					staffMenuScreen(staff);
		    					break;
		    					
		    				case 2:
		    					System.out.println("Enter new email: ");
		    					s.nextLine();
		    					String newEmail = s.nextLine();
		    					contact.setEmail(newEmail);
		    					System.out.println("Modification complete.");
		    					staffMenuScreen(staff);
		    					break;
		    				default:
		    					System.out.println("Thank you.");
		    					break;
		  				}
		  				break;
		    		}
	    		}while(choice == 1 || choice == 2);
	    		
	    	}
	    	
	    	if(!found)
	    		System.out.println("Invalid staff ID.");
    	}while(!modifyID.matches(staff.get(x).getStaffID()));
    }
    
    public static void searchScreen(ArrayList<Staff> staff)
    {
    	Scanner s = new Scanner(System.in);
    	String searchID;
    	boolean found;
    	
    	do
    	{
    		found = false;
    		System.out.println("Enter staff ID of staff to search: ");
    		searchID = s.nextLine();
    		for(int i=0;i<staff.size();i++)
    		{

    			
    			if(searchID.matches(staff.get(i).getStaffID()))
    			{
    				found = true;
    				System.out.printf("%s", staff.get(i).toString());
    				break;
    			}  
    		}
    		
    		if(!found)
    			System.out.println("Invalid staff ID.");
    	}while(!found);
    		
    }	
    
    public static void displayScreen(ArrayList<Staff> staff)
    {
    	System.out.println("Staff ID\t\tStaff Name");
    	System.out.println("===============================");
    	for(int i=0;i<staff.size();i++)
    	{    
    		Name name = staff.get(i).getName(); 
    		System.out.printf("%s\t\t\t%s\t%s\n",staff.get(i).getStaffID(), name.getFirstName(), name.getLastName());
    	}
    }
	
    		
    public static void salesReport(ArrayList<Staff> staff)  //not done, need transaction part
    {
    	int transactionTtl=1; //temporary only
    	System.out.println("=============================================");
    	System.out.println("              Daily Sales Report             ");
    	System.out.println("=============================================");
    	System.out.println(java.time.LocalDate.now());
    	System.out.println("=============================================");
    	System.out.println("Staff ID\t\tStaff Name\t\t\tTransaction Total");
    	
    	for(int i=0;i<staff.size();i++)
    	{
    		Name name = staff.get(i).getName(); 
    		System.out.printf("%s\t\t\t%s\t%s\t\t\t%d\n",staff.get(i).getStaffID(), name.getFirstName(), name.getLastName(),transactionTtl);	    				
    	}
    }
	
    		
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}