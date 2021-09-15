/**
 * @(#)Registration.java
 *
 *
 * @author 
 * @version 1.00 2019/8/2
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Registration {
	
    public Registration() {
    }//Done
    
    public static void registration(ArrayList<Member> member, Product[] product)
    {
    	/*Name[] name =
    	{
    		new Name("Ong", "YiLiang"),
    		new Name("Lee", "Jia Zhe"),
    		new Name("Wayne", "Chong"),
    		new Name("Melvin", "Tan"),
    		new Name("Ooi", "Ke Yi"),
    		new Name("Mabel", "Heng"),
    		new Name("Xiao", "Ming"),
    		new Name("Ng", "Mei Xin"),
    		new Name("Brian", "Eng"),
    		new Name("Tan", "Siew Mei")
    	};
    	
    	String[] icNo =
    	{
    		"000303-07-1093",
    		"001025-07-6549",
    		"000605-07-5465",
    		"000102-07-8713",
    		"001209-07-5112",
    		"010331-07-4658",
    		"990123-07-3211",
    		"981110-07-3482",
    		"021208-07-3211",
    		"020228-07-9758"
    	};
    	
    	Contact[] contact = 
    	{
    		new Contact("011-16552294", "016-4114899", "ongyiliang13616@gmail.com"),
    		new Contact("010-12345678", "010-1234567", "leejiazhe@hotmail.com"),
    		new Contact("012-13456789", "012-3456789", "waynechong@yahoo.com"),
    		new Contact("013-12456789", "013-4567891", "melvintan@gmail.com"),
    		new Contact("014-12356789", "014-1235678", "ooikeyi@hotmail.com"),
    		new Contact("015-12346789", "015-6789123", "mabelheng@gmail.com"),
    		new Contact("016-12345789", "016-7891234", "xiaoming@yahoo.com"),
    		new Contact("017-12345689", "017-8912345", "ngmeixin@gmail.com"),
    		new Contact("018-12345679", "018-1234567", "brianeng@yahoo.com"),
    		new Contact("019-12345678", "019-1234567", "tansiewmei@hotmail.com")
    	};
    	
    	Address[] address = 
    	{
    		new Address("1-23A-11 HARMONY VIEW", "LINTANG SLIM", "11600", "GEORGETOWN", "MALAYSIA"),
    		new Address("2-04-03 THE LIGHT", "JELUTONG", "11601", "GEORGETOWN", "MALAYSIA"),
    		new Address("1-12-10 DIAMOND VILLA", "JALAN TANJUH", "12345", "TANJUNG BUNGAH", "MALAYSIA"),
    		new Address("1-05-08 AMAN", "TAMAN BAIK", "11500", "GELUGOR", "MALAYSIA"),
    		new Address("1-12-11 TAMAN KHENG TEAN", "LINTANG SLIM", "11600", "GEORGETOWN", "MALAYSIA"),
    		new Address("1-16-12 AMAN", "TAMAN BAIK", "11500", "GELUGOR", "MALAYSIA"),
    		new Address("1-26-13 DIAMOND VILLA", "JALAN TANJUH", "12345", "TANJUNG BUNGAH", "MALAYSIA"),
    		new Address("1-12-11 TAMAN KHENG TEAN", "LINTANG SLIM", "11600", "GEORGETOWN", "MALAYSIA"),
    		new Address("1-03-08 AMAN", "TAMAN BAIK", "11500", "GELUGOR", "MALAYSIA"),
    		new Address("1-23A-10 HARMONY VIEW", "LINTANG SLIM", "11600", "GEORGETOWN", "MALAYSIA")
    	};
    	
    	char[] grade = {'P', 'N', 'D', 'P', 'N', 'D', 'D', 'N', 'P', 'D'};
    	
    	double[] memberPoint = {2035.5,1236,651,831,1056.5,1269,925.3,975.9,540.5,235};
    	
    	ArrayList<Member> member=new ArrayList<Member>();
    	
    	for(int i=0;i<name.length;i++)
    	{
    		member.add(new Member(name[i], icNo[i], address[i], contact[i], grade[i]));
    		member.get(i).topUp(memberPoint[i]);
    	}*/
    	
    	
    	
       	boolean loop = true;
    	do
    	{
    		int choice = selectFunction();
    		switch(choice)
    		{
    			case 1: addMember(member); break;
    			case 2: searchMember(member); break;
    			case 3: modifyMember(member); break;
    			case 4: displayMember(member); break;
    			case 5: upgradeMembership(member); break;
    			case 6: redeemProduct(member, product); break;
    			case 7: memberExceptionReport(member); break;
    			default : loop = false; break;
    		}
    	}while(loop);
    } //Done
    
    public static void addMember(ArrayList<Member> oldMember)
    {
	    Scanner s = new Scanner(System.in);
	    String firstName, lastName, icNo, phoneNo, emergencyNo, email, apartment, street, postcode, state, country;
    	char grade = ' ', yesno ='n';
    	boolean input;
    		
    	p("\nWARM REMINDER\n--------------\n");
    	p(">Enter 'CANCLE' for String type to EXIT\n");
    	p(">Enter 'X' for Character type to EXIT\n");
    	p(">Enter NEGATIVE NUMBER(-1) for numerical type to EXIT");
	   	do
    	{
    		boolean exist = false;
    		p("\n\n______________________________________________________\n");
    	
    		do
    		{
    			p("IC No             : ");
    			icNo = s.nextLine();
    		}while(!Person.icNoValidation(icNo) && !icNo.equals("CANCLE"));
    		if(icNo.equals("CANCLE"))
    			break;
    		
    		for(int i = 0 ;i<Member.getCountMember();i++)
    		{
    			if(oldMember.get(i).getIcNo().equals(icNo))
    			{
    				exist = true;
    				break;
    			}
    		}
    		
    		if(exist == false)
    		{
    			p("Name >\n");
    			do
    			{	
			    	p("First Name        : ");
		    		firstName = s.nextLine();
    			}while(firstName.isEmpty());
	    		if(firstName.equals("CANCLE"))
	    			break;
	 
	 			do
	 			{
	 				p("Last Name         : ");
	    			lastName = s.nextLine();
	 			}while(lastName.isEmpty());
	    		if(lastName.equals("CANCLE"))
	    			break;
	    	
	    		do
	    		{
	    			p("Contact Number    : ");
	    			phoneNo = s.nextLine();
		    	}while(!Contact.phoneNoValidation(phoneNo) && !phoneNo.equals("CANCLE"));
	    		if(phoneNo.equals("CANCLE"))
	    			break;
	   
	    		do
	    		{
	    			p("Emergency Contact : ");
	    			emergencyNo = s.nextLine();
		    	}while(!Contact.phoneNoValidation(phoneNo) && !emergencyNo.equals("CANCLE"));
	    		if(emergencyNo.equals("CANCLE"))
	    			break;
	    		
	    		do
	    		{
	    			p("Email             : ");
		    		email = s.nextLine();
	    		}while(!Contact.emailValidation(email) && !email.equals("CANCLE"));
	    		if(email.equals("CANCLE"))
	    			break;
	    	
	    		p("Address >\n");
	    		p("Apartment         : ");
		    	apartment = s.nextLine();
	    		if(apartment.equals("CANCLE"))
	    			break;
	    		
	    		p("Street            : ");
		    	street =s.nextLine();
	    		if(street.equals("CANCEL"))
	    			break;
	    	
	    		do
	    		{
	    			p("Postcode          : ");
		    		postcode = s.nextLine();
	    			if(postcode.equals("CANCLE"))
	    				break;
	    		}while(!Address.postcodeValidation(postcode));
		    	if(postcode.equals("CANCLE"))
	    			break;
	    			
	    		p("State             : ");
		    	state = s.nextLine();
	    		if(state.equals("CANCLE"))
	    			break;
	
	   			p("Country           : ");
	    		country = s.nextLine();
	   			if(country.equals("CANCLE"))
	    			break;
	    		
	    		p("\n>Please select n/N(normal) | d/D(Diamond) | p/P(Platinium)<\n");
	    		do
	    		{
	    			String inputGrade;
		    		do
		    		{
		    			p("Grade (N/D/P)     : ");
		   				inputGrade = s.nextLine();
		    		}while(inputGrade.length()!=1);
		    		grade = inputGrade.charAt(0);
	    		}while( Character.toUpperCase(grade) != 'N' && Character.toUpperCase(grade) != 'P' && Character.toUpperCase(grade) != 'D' && grade != 'X');
	    		if(grade == 'X')
	    			break;
	    		else
	    			grade = Character.toUpperCase(grade);
	    	   		
	    		Name name = new Name(firstName.toUpperCase(), lastName.toUpperCase());
		    	Address address = new Address(apartment.toUpperCase(), street.toUpperCase(), postcode, state.toUpperCase(), country.toUpperCase());
	    		Contact contact = new Contact(phoneNo, emergencyNo, email);
	    		oldMember.add(new Member(name, icNo, address, contact, grade));
	    		System.out.printf("\nREGISTRATION SUCCESS\n====================\n%s", oldMember.get(Member.getCountMember()-1).toString(0));
    		}	
    		else
    			p("***Member Exist***\n");
    		    
    		String inputYesno;
	    	do
	    	{
	    		p("\nAdd Member (y/Y=YES)? ");
	    		inputYesno = s.nextLine();
	    	}while(inputYesno.length()!=1);
	    	yesno = Character.toUpperCase(inputYesno.charAt(0));
    		
    	}while(Character.toUpperCase(yesno) =='Y');
    	
    	p("\n");
    }//registration date
    
    public static void deleteMember(int i, ArrayList<Member> member)
    {
    	Name name = member.get(i).getName();
    	String firstName=name.getFirstName(), lastName = name.getLastName();
    	
    	//minus gender
    	if(member.get(i).getGender().equals("MALE"))
    		Member.minusMale();
    	else
    		Member.minusFemale();
    	
    	//minus grade
    	if(member.get(i).getGrade().equals("NORMAL"))
    		Member.minusNormal();
    	else if(member.get(i).getGrade().equals("DIAMOND"))
    		Member.minusDiamond();
    	else
    		Member.minusPlatinum();
    		
    	//delete member;
    	member.remove(i);
   		Member.delete(); //minus Countmember;
   		System.out.printf("\n%s %s has been remove from Member List.\n", firstName, lastName);
    }//DONE
    
    public static int selectSearch(int exclude)
    {
    	Scanner s = new Scanner(System.in);
    	int choice = 0;
		int number = 0;
		
		//exclude will be 0 for the first search, insert argurment by programmer.
		//the exclude of second search is the choice of first search.
		//every patient have their own ID and IC so filter is not needed.
		p("\nSEARCH\n======\n");
		if (exclude == 0) 
			System.out.printf("Member ID    : (%d)\n", ++number);
		if (exclude != 2)
			System.out.printf("Name         : (%d)\n", ++number);
		if (exclude == 0)
			System.out.printf("IC No.       : (%d)\n", ++number);
		if (exclude != 4)
			System.out.printf("Gender       : (%d)\n", ++number);
		if (exclude != 5)
			System.out.printf("Postcode     : (%d)\n", ++number);
		if(exclude != 6)
			System.out.printf("Grade        : (%d)\n", ++number);
		if(exclude != 7)
			System.out.printf("Member Point : (%d)\n", ++number);
		p("Exit         : Others\n");
		
		boolean input = false;
	    do
	    {	
	    	try
	    	{
	    		p("Please select an integer : ");
	    		choice = s.nextInt();
	    		input = true;
	    	}
	    	catch(Exception ex)
	    	{
	    			input = false;
	    			p("***Incorrect input : An integer is required***\n\n");
	    			s.nextLine();
	    	}
    	}while(!input || choice <0);
    	
    	//adjust the choice to the correct switch case.
		if (choice != 0 && exclude != 0)
		{
			if (exclude == 2)
				choice += 3;
			else if (exclude == 4)
			{
				if(choice == 1)
					choice+=1;
				else if (choice >= 2)
					choice += 3;
			}
			else if (exclude == 5)
			{
				if (choice == 1 || choice == 2)
					choice += choice;
				else if(choice >= 3)
					choice+=3;
			}
			else if(exclude == 6)
			{
				if(choice == 1)
					choice+=1;
				else if(choice == 2 || choice == 3)
					choice+=2;
				else if(choice == 4)
					choice += 3;
			}
			else if(exclude == 7)
			{
				if(choice == 1)
					choice +=1;
				else if(choice >= 2)
					choice +=2;
			}
		}
    	
    	return choice;
    }//DONE
    public static void searchMember(ArrayList<Member> member)
    {
    	Scanner s = new Scanner(System.in);
    	ArrayList<Member> storeSearch = new ArrayList<Member>();
    	ArrayList<Member> memberClone = new ArrayList<Member>();
    	String memberID, firstName, lastName, icNo, postcode, memeberPoint;
    	String sgender, sgrade;
    	int choice = 0, i, loop=0;
    	char yesno = 'n', gender = ' ', grade =' ';
    	double max=0, min=0;
    	boolean found, filter, defaultSearch = true, cancle = false;
    	
    	p("\nWARM REMINDER\n--------------\n");
    	p(">Enter 'CANCLE' for String type to EXIT\n");
    	p(">Enter 'X' for Character type to EXIT\n");
    	p(">Enter NEGATIVE NUMBER(-1) for numerical type to EXIT\n");
    	do
    	{
    		yesno = 'n';
    		cancle = false;//always assume no cancle
    		found = false;//always assume not found
    	
    		if(defaultSearch)
    		{
    			loop = 0;
    			choice = 0;// choice is always 0 when new search
    			storeSearch.clear(); //storeSearch is always clean and clear for new search
		    	for(Member m : member)//DEEP COPY //the first search is always all of the member
		    	{
		    		storeSearch.add(m);	
		    	}
    		}
    		else
    			loop++;
		    
		    memberClone.clear(); // memberClone is always clean and clear first
	    	//copy the searched member list to memberclone();
    		for(Member m : storeSearch) //DEEP COPY
    		{
    			memberClone.add(m);
    		}
    		storeSearch.clear();//clear to store the filter member list
    		    		
    		choice = selectSearch(choice);
    		switch(choice)
    		{
	    		case 1 : //memberID
	    			filter = false;
	    			do
			    	{
			    		p("\nEnter Member ID : ");
			    		memberID = s.nextLine();
			    	}while(memberID.length()!=7 && !memberID.equals("CANCLE"));
			    	
			    	if(memberID.equals("CANCLE"))
			    	{
			    		cancle = true;
			    		break; //break this case
			    	}
			    	else
			    	{
			    		for(Member m : memberClone)
			    		{
			    			if(m.getMemberID().equalsIgnoreCase(memberID))
			    			{
			    				found = true;
			    				System.out.printf("\n1.\n%s", m.toString(0));
			    				break; //break the search (for loop) because ID are unique
			    			}
			    		}
			    	}
			    	break;
	    		case 2 : //name
	    			filter = true;
	    			p("\nName >\n");
			    	p("First Name        : ");
		    		firstName = s.nextLine();
		    		if(firstName.equals("CANCLE"))
		    		{
			    		cancle = true;
			    		break; //break this case
			    	}
		 
			    	p("Last Name         : ");
		    		lastName = s.nextLine();
		    		if(lastName.equals("CANCLE"))
		    		{
			    		cancle = true;
			    		break; //break this case
			    	}
		    		else
		    		{
		    			for(Member m : memberClone)
		    			{
		    				Name name = m.getName();
		    				if(name.getFirstName().equalsIgnoreCase(firstName) && name.getLastName().equalsIgnoreCase(lastName))
		    				{
		    					found = true;
		    					storeSearch.add(m);
		    				}
		    			}
		    		}
	    			break;
	    		case 3 : //icNo
	    			filter = false;
		    		do
		    		{
		    			p("\nIC No : ");
		    			icNo = s.nextLine();
		    		}while(!Person.icNoValidation(icNo) && !icNo.equals("CANCLE"));
		    		if(icNo.equals("CANCLE"))
		    		{
			    		cancle = true;
			    		break; //break this case
			    	}
		    		else
		    		{
		    			for(Member m : memberClone)
		    			{
		    				if(m.getIcNo().equals(icNo))
		    				{
		    					found = true;
		    					System.out.printf("\n1.\n%s", m.toString(0));
			    				break; //break the search (for loop) because ID are unique
		    				}
		    			}
		    		}
	    			break;
	    		case 4 ://Gender
	    			filter = true;
	    			p("\n");
	    			do
	    			{
	    				String inputGender;
		    			do
		    			{
		    				p("Gender (M/F) : ");	
		    				inputGender = s.nextLine();
		    			}while(inputGender.length() != 1);
		   				gender = inputGender.charAt(0);
	    			}while(Character.toUpperCase(gender) != 'M' && Character.toUpperCase(gender) != 'F' && gender != 'X');
	    			
	    			if(gender == 'X')
	    			{
			    		cancle = true;
			    		break; //break this case
			    	}
	    			else
	    			{
	    				gender = Character.toUpperCase(gender);
	    				if(gender == 'M')
	    					sgender = "MALE";
	    				else
	    					sgender = "FEMALE";
	    					
		    			for(Member m : memberClone)
		    			{
		    				if(m.getGender().equals(sgender))
		    				{
		    					found = true;
		    					storeSearch.add(m);
		    				}		    				
		    			}
	    			}
	    			break;
	    		case 5 ://postcode
	    			filter = true;
	    			p("\n");
	    			do
		    		{
		    			p("Postcode          : ");
			    		postcode = s.nextLine();
		    			if(postcode.equals("CANCLE"))
		    				break;
		    		}while(!Address.postcodeValidation(postcode));
			    	
			    	if(postcode.equals("CANCLE"))
		    		{
			    		cancle = true;
			    		break; //break this case
			    	}
		    		else
		    		{
		    			for(Member m : memberClone)
		    			{
		    				Address address = m.getAddress();
		    				if(address.getPostcode().equals(postcode))
		    				{
		    					found = true;
		    					storeSearch.add(m);
		    				}
		    			}
		    		}
		    		break;
	    		case 6 ://grade
	    			filter = true;
	    			p("\n>Please select n/N(normal) | d/D(Diamond) | p/P(Platinium)<\n");
		    		do
		    		{
		    			String inputGrade;
		    			do
		    			{
		    				p("Grade (N/D/P)     : ");
		   					inputGrade = s.nextLine();
		    			}while(inputGrade.length() != 1);
		    			grade = inputGrade.charAt(0);
		    		}while( Character.toUpperCase(grade) != 'N' && Character.toUpperCase(grade) != 'P' && Character.toUpperCase(grade) != 'D' && grade != 'X');
		    		
		    		if(grade == 'X')
		    		{
			    		cancle = true;
			    		break; //break this case
			    	}
		    		else
		    		{
		    			grade = Character.toUpperCase(grade);
		    			if(grade == 'N')
		    				sgrade = "NORMAL";
		    			else if(grade == 'D')
		    				sgrade = "DIAMOND";
		    			else
		    				sgrade = "PLATINUM";
		    				
		    			for(Member m : memberClone)
		    			{
		    				if(m.getGrade().equals(sgrade))
		    				{
		    					found = true;
		    					storeSearch.add(m);
		    				}
		    			}	
		    		}
		    		break;
	    		case 7 ://memberPoints
	    			filter = true;
	    			boolean input;
	    			do
	    			{
	    				do
				    	{
					    	try
					    	{
		    					input = true;
					    		p("\nRange of Member Point -> MIN : ");
		    					min=s.nextDouble();
					    	}
					    	catch(Exception xe)
					    	{
					    		input = false;
					    		p("***Only Number are acceptable***\n");
					    		s.nextLine();
					    	}	
				    	}while(!input);
		    			if(min<0)
		    			{
				    		cancle = true;
				    		break; //break this loop
				    	}
				    	
				    	do
				    	{
					    	try
					    	{
					    		input = true;
					    		p("\t\t\t\t\t\t MAX : ");
			    				max = s.nextDouble();
					    	}
					    	catch(Exception xe)
					    	{
					    		input = false;
					    		p("\t\t\t***Only Number are acceptable***\n\n");
					    		s.nextLine();
					    	}	
				    	}while(!input);
		    			if(max < 0)
		    			{
				    		cancle = true;
				    		break; //break this loop
				    	}
				    	
				    	if(max < min)
				    		p("\n***Max cannot be smaller than MIN***");
				    		
	    			}while(max < min);
					if(max<0 || min <0)
						break; //break this case
						
		    		for(Member m : memberClone)
		    		{
		    			if(m.getMemberPoint() >= min && m.getMemberPoint() <= max)
		    			{
		    				found = true;
		    				storeSearch.add(m);
		    			}
		    		}	
	    			break;
	    		default : 
	    			found = true;
	    			loop++;
	    			filter = true;
	    			break;
    		}
    		
    		if(found && (choice == 2 || choice >= 4 && choice <= 7))
    			displayMember(storeSearch);
    		
    		if(!found && !cancle)
	    		p("\n***Please make registration at Module(1) --> Funtion(1)***\n");
    		
    		boolean input;
    		if(found && filter && loop == 0)
    		{
    			String inputYesno;
	    		do
	    		{
	    			p("\nFilter this list(y/Y=YES)? ");
	    			inputYesno = s.nextLine();
	    		}while(inputYesno.length()!=1);
	    		yesno = Character.toUpperCase(inputYesno.charAt(0));
		    	
		    	if(yesno == 'Y')
		    	{
					defaultSearch = false;	
					filter = true;
					cancle = false;
					found = true;	    		
		    		loop++;
		    	}
    		}
    		
    		if(loop >= 2 || !filter || cancle || !found)
		    {
		   	 	defaultSearch = true;
		    	loop = 0;
		    	yesno = 'Y';
		    }
    	}while(Character.toUpperCase(yesno) == 'Y' || ((choice >= 1 && choice<=7) || choice == 999) );
    	p("\n");
    }//DONE
    
    public static int selectModify()
    {
    	Scanner s = new Scanner(System.in);
    	int choice = 0;
    	
    	p("DELETE patient             : (999)\n");
		p("Edit Name                  : (1)\n");
		p("Edit IC No.                : (2)\n");
		p("Edit Contact No.           : (3)\n");
		p("Edit Emergency Contact No. : (4)\n");
		p("Edit Email                 : (5)\n");
		p("Edit Address               : (6)\n");
		p("        ***EXIT***         : Others\n");
	
		boolean input = false;
	    do
	    {	
	    	try
	    	{
	    		p("Please select an integer : ");
	    		choice = s.nextInt();
	    		input = true;
	    	}
	    	catch(Exception ex)
	    	{
	    			input = false;
	    			p("***Incorrect input : An integer is required***\n\n");
	    			s.nextLine();
	    	}
    	}while(!input);

    	return choice;
    }//done
    public static void modifyMember(ArrayList<Member> member)
    {
    	Scanner s = new Scanner(System.in);
    	int choice, index=0;
    	char yesno = ' ';
    	boolean input, delete, edit;
    	String memberID; 
    	
    	p("\nWARM REMINDER\n--------------\n");
    	p(">Enter 'CANCLE' for String type to EXIT\n");
    	p(">Enter 'X' for Character type to EXIT\n");
    	p(">Enter NEGATIVE NUMBER(-1) for numerical type to EXIT\n");
    	do
    	{
    		edit = false;
    		delete =false;
    		boolean out = false;
    		do
    		{
    			p("\nEnter Member ID : ");
    			memberID = s.nextLine();	
    		}while(memberID.length()!=7 && !memberID.equals("CANCLE"));
    		if(memberID.equals("CANCLE"))
    			break; //break do while loop to get out from modify
    		
    		for(int i = 0 ;i<member.size();i++)
    		{
	    		if(member.get(i).getMemberID().equalsIgnoreCase(memberID))
	    		{
	    			index=i;
	    			Name name = member.get(i).getName();
		    		Contact contact = member.get(i).getContact();
	    			Address address = member.get(i).getAddress();
	    			String firstName, lastName, icNo, phoneNo, emergencyNo, email, apartment, street, postcode, state, country;
		   			
		   			System.out.printf("\nOLD RECORD\n----------\n%s", member.get(i).toString(0));
		   			do
				   	{
		   				choice = selectModify();
					   	switch(choice)
					   	{
					   		case 1: //name
					   			p("\nName >\n");
						    	p("First Name : ");
					    		firstName = s.nextLine();
					    		if(firstName.equals("CANCLE"))
					    			break; //break this case
					 
						    	p("Last Name  : ");
					    		lastName = s.nextLine();
					    		if(lastName.equals("CANCLE"))
					    			break; //break this case
							   			
					   			name.setFirstName(firstName);
					   			name.setLastName(lastName);
					   			edit = true;
					   			break;
					   		case 2: //icNo
					   			do
					    		{
					    			p("\nIC No : ");
					    			icNo = s.nextLine();
					    		}while(!Person.icNoValidation(icNo) && !icNo.equals("CANCLE"));
					    		if(icNo.equals("CANCLE"))
					    			break; //break this case
								   			
					   			member.get(i).editIcNo(icNo);
					   			edit = true;
					   			break;
					   		case 3: //contact
					   			do
					    		{
					    			p("\nContact Number : ");
					    			phoneNo = s.nextLine();
						    	}while(!Contact.phoneNoValidation(phoneNo) && !phoneNo.equals("CANCLE"));
					    		if(phoneNo.equals("CANCLE"))
					    			break;	
					    		
					    		contact.setPhoneNo(phoneNo);
					    		edit = true;
							   	break;
					   		case 4: //emergency contact
					   			do
					    		{
					    			p("\nEmergency Contact : ");
					    			emergencyNo = s.nextLine();
						    	}while(!Contact.phoneNoValidation(emergencyNo) && !emergencyNo.equals("CANCLE"));
					    		if(emergencyNo.equals("CANCLE"))
					    			break;
					    		
					    		contact.setEmergencyNo(emergencyNo);
					   			break;
					   		case 5: //email
					   			do
					    		{
					    			p("\nEmail : ");
						    		email = s.nextLine();
					    		}while(!Contact.emailValidation(email) && !email.equals("CANCLE"));
					    		if(email.equals("CANCLE"))
					    			break;
					    		
					    		contact.setEmail(email);
					    		edit = true;
					   			break;
					   		case 6 : //address
						   		p("Address >\n");
					    		p("Apartment         : ");
						    	apartment = s.nextLine();
					    		if(apartment.equals("CANCLE"))
					    			break;
					    		
					    		p("Street            : ");
						    	street =s.nextLine();
					    		if(street.equals("CANCEL"))
					    			break;
					    	
					    		do
					    		{
					    			p("Postcode          : ");
						    		postcode = s.nextLine();
					    			if(postcode.equals("CANCLE"))
					    				break;
					    		}while(!Address.postcodeValidation(postcode));
						    	if(postcode.equals("CANCLE"))
					    			break;
					    			
					    		p("State             : ");
						    	state = s.nextLine();
					    		if(state.equals("CANCLE"))
					    			break;
					
					   			p("Country           : ");
					    		country = s.nextLine();
					   			if(country.equals("CANCLE"))
					    			break;
					    		
					    		address.setApartment(apartment);
					    		address.setStreet(street);
					    		address.setPostcode(postcode);
					    		address.setState(state);
					    		address.setCountry(country);
					    		edit = true;
							   	break;
					   		case 999:
	    						 //ask for comfirm to delete member
					    		String inputYesno;
					    		do
					    		{
					    			System.out.printf("Remove %s %s as a member (y/Y=YES)? ", name.getFirstName(), name.getLastName());
					    			inputYesno = s.nextLine();
					    		}while(inputYesno.length()!=1);
					    		yesno = Character.toUpperCase(inputYesno.charAt(0));
							    			
				    			if(yesno == 'Y')
				    			{
					   				deleteMember(i, member);
				    				delete = true;
				    			}	
					   			break;
					   		default:
					   			out = true;
					   			break;						
					   	} //end case
					   	
					   	if(!out && !delete)
						{ 
						   	String inputYesno;
				    		do//ask for modify same member again
				    		{
				    			p("\nContinue to edit this member(y/Y=YES)? ");
				    			inputYesno = s.nextLine();
				    		}while(inputYesno.length()!=1);
				    		yesno = Character.toUpperCase(inputYesno.charAt(0));
						}
				   		else
				   			yesno = 'n';
			   		}while(Character.toUpperCase(yesno) == 'Y');
			   		break; //break the search loop, when found member and done the function
	    		}
	    		else //member not found with ID
	    		{
	    			//only print the statement when last member search still not found.
	    			if(i == (member.size()-1))
	    				p("\n***Please make registration at Module(1) --> Funtion(1)***\n");
	    		} //end if
    		} //end for loop
    		
    		if(edit)
    		{
    			System.out.printf("\nNEW RECORD\n----------\n%s", member.get(index).toString(0));
    		}
    		
    	
    		String inputYesno;
	    	do
	    	{
	    		p("\nContinue to edit other member(y/Y=YES)? ");
	    		inputYesno = s.nextLine();
	    	}while(inputYesno.length()!=1);
	    	yesno = Character.toUpperCase(inputYesno.charAt(0));
    		
    	}while(yesno == 'Y'); 
    	p("\n");
    }//DONE
    
    public static int sortMember(ArrayList<Member> storeSort)
    {
    	Scanner s = new Scanner(System.in); 
 		int AorD = 0, choice = 0;
 		boolean input;
 		
    	p("\nSORT BY >\n");
    	p("---------\n");
    	p("Member ID    : (1)\n");
    	p("Name         : (2)\n");
    	p("Gender       : (3)\n");
    	p("Grade        : (4)\n");
    	p("Member Point : (5)\n");
    	p("   Default   : Other\n");
    	
    	do
    	{
	    	try
	    	{
	    		p("Select an integer : ");
	    		choice = s.nextInt();
	    		input = true;
	    	}
	    	catch(Exception xe)
	    	{
	    		input = false;
	    		p("***Incorrect input : An integer is required***\n\n");
	    		s.nextLine();
	    	}
    	}while(!input);
 		
 		p("\nOrder\n-----");
 		p("\nASCENDING  (>) : (1)\n");
 		p("DESCENDING (<) : (2)\n");
    	do
    	{
	    	try
	    	{
	    		p("Select an integer(1/2) : ");
	    		AorD = s.nextInt();
	    		input = true;
	    	}
	    	catch(Exception xe)
	    	{
	    		input = false;
	    		p("***Incorrect input : An integer (1/2) is required***\n\n");
	    		s.nextLine();
	    	}
    	}while(!input || AorD != 1 && AorD != 2);
    	
    	switch(choice) // ASCENDING
    	{
    		case 1://memberID
    			storeSort.sort(new MemberIDSorter());
    			break;
    		case 2://name
    			storeSort.sort(new NameSorter());
    			break;
    		case 3://gender
    			storeSort.sort(new GenderSorter());
    			break;
    		case 4://grade
    			storeSort.sort(new GradeSorter());
    			break;
    		case 5://memberpoint
    			storeSort.sort(new MemberPointSorter());
    			break;
    		default: //orignial list
    			break;
    	}
    	
    	if(AorD == 2) //DESCENDING
    		Collections.reverse(storeSort);
    	
    	return choice;
    }//DONE
    public static void displayMember(ArrayList<Member> member)
    {
    	Scanner s = new Scanner(System.in); 
    	ArrayList<Member> storeSort = new ArrayList<Member>();
    	for(Member m : member) //deep copy
    	{
    		storeSort.add(m);
    	}
    	
    	int choice = sortMember(storeSort);
    	
    	p("\nMEMBER LIST\n");
    	p("===========\n\n");
    	for(int i =0; i<member.size(); i++)
    	{
    			System.out.printf("%d.\n%s",(i+1), storeSort.get(i).toString(choice));
    	}
    	
    	if(member.size()== Member.getCountMember())
    	{
    		System.out.printf("Total Member : %d\nMALE : %-7dFEMALE : %d\nNORMAL : %-5dDIAMOND : %-5dPLATINUM : %d\n", 
    							Member.getCountMember(), Member.getCountMale(), Member.getCountFemale(), Member.getCountNormal(), Member.getCountDiamond(), Member.getCountPlatinum());
	    	p("\nPress any key to continue...");
	    	s.nextLine();
	    	p("\n");	
    	}
    } //Done
    
    public static double topUpMemberPoint()
    {
    	Scanner s = new Scanner(System.in);
    	double price =0;
    	boolean input;
    	
    	do
    	{
    		try
	    	{
	    		p("Enter amount for TOP UP(RM) : ");
	    		price = s.nextDouble();
	    		input = true;
	    	}
	    	catch(Exception xe)
	    	{
	    		input = false;
	    		p("***Only Number are acceptable***\n");
				s.nextLine();
	    	}
    	}while(!input);
    	
    	return price;
    } //DONE ,validate price with only can input two decimal places
    
    public static void redeemProduct(ArrayList<Member> member, Product[] product)
    {
    	Scanner s = new Scanner(System.in);
    	String memberID;
    	ArrayList<Product> storeRedeem = new ArrayList<Product>();
    	int[] storeQty = new int[100];
    	int choice=0, qty=0, x=0, count, productLength=0;
    	double totalPrice = 0;
    	char yesno;
    	boolean found = false, cancle, redeem = false;
    	
    	p("\nWARM REMINDER\n--------------\n");
    	p(">Enter 'CANCLE' for String type to EXIT\n");
    	p(">Enter 'X' for Character type to EXIT\n");
    	p(">Enter NEGATIVE NUMBER(-1) for numerical type to EXIT\n");
    	do
    	{
    		cancle = false;
    		found = false;
    		do
	    	{
	    		p("\nEnter Member ID : ");
	    		memberID = s.nextLine();	
	    	}while(memberID.length()!=7 && !memberID.equals("CANCLE"));
	    	if(memberID.equals("CANCLE"))
	    		break;	
	    	
	    	for(int i = 0 ;i<member.size();i++)
	    	{
		    	if(member.get(i).getMemberID().equalsIgnoreCase(memberID))
		    	{
		    		count = 0;
		    		found = true;
		    		x=i;
		    		p("\n");
    				for(int k = 0;i<product.length;k++)
    				{
    					if(product[k] != null)
    					{
    						String name = product[k].getName();
    						if(name.length()>20)
    							name = name.substring(0,20);
							System.out.printf("%-20s RM%-7.2f: (%d)\n", name, product[k].getPrice(), k+1);    						
    					}
    					else
    					{
    						productLength = k;	
    						break;
    					}
    				}
    				p("\n");
    				do
    				{
	    				boolean input;
	    				do
	    				{
		    				try
	    					{
	    						p("Select a product : ");
	    						choice = s.nextInt();
	    						input = true;
	    					}
	    					catch(Exception xe)
	    					{
	    						input = false;
	    						p("***Please select an integer***\n");
	    						s.nextLine();
	    					}
	    				}while(!input || choice > productLength);
	    				if(choice <= 0 && totalPrice == 0)
	    				{
	    					cancle = true;
	    					break;
	    				}
	    				//System.out.printf("\n%d\n", product[choice-1].getQuantity());
	    				if(choice > 0)
	    				{
		    				do
		    				{
			    				try
		    					{
		    						p("Quantity         : ");
		    						qty = s.nextInt();
		    						input = true;
		    					}
		    					catch(Exception xe)
		    					{
		    						input = false;
		    						p("***Please select an integer***\n");
		    						s.nextLine();
		    					}
		    				}while(!input || qty == 0);
		    				if(qty < 0)
		    				{
		    					p("***Redeemtion for this product is cancled***\n");
		    				}
		    				else
		    				{
			    				if(qty > product[choice-1].getQuantity())
			    					p("***Not enough Stock***\n");
			    				else
			    				{
			    					totalPrice += (product[choice-1].getPrice()*qty);
			    					if((totalPrice*10) > member.get(i).getMemberPoint())
			    					{
			    						p("***Member Point not enough***\n");
			    						System.out.printf("Current Point : %.1f\n", member.get(i).getMemberPoint());
			    						System.out.printf("Point Needed  : %.1f\n", totalPrice*10);
			    						System.out.printf("Point Lack    : %.1f\n", member.get(i).getMemberPoint()-totalPrice*10);
			    						totalPrice -= (product[choice-1].getPrice()*qty);
			    					}
			    					else 
			    					{
			    						redeem = true;
			    						storeRedeem.add(product[choice-1]);
			    						storeQty[count] = qty;
			    						product[choice-1].stockout(qty);
			    						count++;
			    					}
			    				}
			    			}
	    				}
	    				
	    				String inputYesno;
	    				s.nextLine();
	    				do
	    				{
	    					p("\nContinue to redeem product(y/Y=YES)? ");
	    					inputYesno = s.nextLine();
	    				}while(inputYesno.length()!=1);
	    				yesno = Character.toUpperCase(inputYesno.charAt(0));
    				}while(yesno == 'Y');
    				
    				break;
    			}
    		}
    		
    		if(redeem)
    		{
    			for(int i =0;i<storeRedeem.size();i++)
    					System.out.printf("%d.%s\t*  %d\n", i+1, storeRedeem.get(i).getName(), storeQty[i]);

    			System.out.printf("Total Point Use: %.1f\n", totalPrice*10);
    			
    			String inputYesno;
    			do
    			{
    				p("\nComfirm to redeem these products(y/Y=YES)? ");
    				inputYesno = s.nextLine();
    			}while(inputYesno.length()!=1);
    			yesno = inputYesno.charAt(0);
    			
    			if(Character.toUpperCase(yesno) == 'Y')
    			{
    				member.get(x).useUp(totalPrice);
    				p("\n>>Redeemtion successful<<\n");
    			}
    			else
    			{
    				for(int k=0;k<storeRedeem.size();k++)
    				{
    					storeRedeem.get(k).stockin(storeQty[k]);
    				}
    				p("\n***Redeemtion Cancle***\n");
    			}
    			
    			System.out.printf("\nCurrent Point : %.1f\n", member.get(x).getMemberPoint());
    		}
    		if(!found)
	    		p("\n***Please make registration at Module(1) --> Funtion(1)***\n");
	    	
	    	storeRedeem.clear();
    	}while(!found || cancle);
	} 
	//DONE 
    
    public static void upgradeMembership(ArrayList<Member> member)
    {
    	Scanner s = new Scanner(System.in);
    	String memberID;
    	double gradePoint, pointNeeded, pointLack;
    	char grade = ' ';
    	boolean found = false, cancle;
		
		p("\nWARM REMINDER\n--------------\n");
    	p(">Enter 'CANCLE' for String type to EXIT\n");
    	p(">Enter 'X' for Character type to EXIT\n");
    	p(">Enter NEGATIVE NUMBER(-1) for numerical type to EXIT\n");
    	do
    	{
    		cancle = false;
    		found = false;
    		do
	    	{
	    		p("\nEnter Member ID : ");
	    		memberID = s.nextLine();	
	    	}while(memberID.length()!=7 && !memberID.equals("CANCLE"));
	    	if(memberID.equals("CANCLE"))
	    		break;	
	    	
	    	for(int i = 0 ;i<member.size();i++)
	    	{
		    	if(member.get(i).getMemberID().equalsIgnoreCase(memberID))
		    	{
		    		found = true;
		    		if(member.get(i).getGrade().equals("PLATINUM"))
		    		{
		    			p("\n***This member have reach the highest position of membership***\n");
		    		}
		    		else
		    		{
			    		p("\n>Please select n/N(normal) | p/P(Platinium) | d/D(Diamond)<\n");
			    		do
			    		{
			    			String inputGrade;
			    			do
			    			{
			    				p("Grade (N/P/D)     : ");
			   					inputGrade = s.nextLine();
			    			}while(inputGrade.length()!=1);
			    			grade = inputGrade.charAt(0);
			    		}while( Character.toUpperCase(grade) != 'N' && Character.toUpperCase(grade) != 'P' && Character.toUpperCase(grade) != 'D' && grade != 'X');
			    		
			    		grade = Character.toUpperCase(grade);
			    		if(grade == 'X')
			    		{
			    			cancle = true;
			    			break;
			    		}
			    		
			    		if(grade == 'N')
			    			gradePoint = Member.getNormal();
			    		else if(grade == 'D')
			    			gradePoint = Member.getDiamond();
			    		else
			    			gradePoint = Member.getPlatinum();
			    			
			    		if(member.get(i).getGrade().equals("NORMAL"))
			    			pointNeeded = gradePoint - Member.getNormal();
			    		else if(member.get(i).getGrade().equals("DIAMOND"))
			    			pointNeeded = gradePoint - Member.getDiamond();
			    		else
			    			pointNeeded = gradePoint - Member.getPlatinum();
			    		
			    		if(pointNeeded == 0)
			    		{
			    			p("\n***Upgrade membership to the same level is not allowed***\n");
			    		}
			    		else if(pointNeeded < 0)
			    		{
			    			p("\n***Downgrade membership is not allowed***\n");
			    		}
			    		else
			    		{
				    		if(member.get(i).getMemberPoint() < pointNeeded)
				    		{
				    			pointLack = pointNeeded - member.get(i).getMemberPoint();
				    			p("\n***Please TOP UP***\n");
				    			System.out.printf("Current Point : %.1f\n", member.get(i).getMemberPoint());
				    			System.out.printf("Point Needed  : %.1f\n", pointNeeded);
				    			System.out.printf("Point Lack    : -%.1f\n", pointLack);
				    		}
				    		else
				    		{
				    			double oldPoint = member.get(i).getMemberPoint();
				    			member.get(i).useUp(pointNeeded/10);
				    			String oldGrade=member.get(i).getGrade();
				    			member.get(i).editGrade(oldGrade, grade);
				    			System.out.printf("\n%s successes to upgrade membership from %s to %s\n",member.get(i).getMemberID(), oldGrade, member.get(i).getGrade());
				    			System.out.printf("Old Point     :  %.1f\n", oldPoint);
				    			System.out.printf("Point Needed  : -%.1f\n", pointNeeded);
				    			System.out.printf("Current Point :  %.1f\n", member.get(i).getMemberPoint());
				    		}
			    		}
		    		}
		    		break;
		    	}
	    	}
	    	
	    	if(!found)
	    		p("\n***Please make registration at Module(1) --> Funtion(1)***\n");
    	}while(!found || cancle);
   		
   		p("\n");
    } //DONE
    
    public static void memberExceptionReport(ArrayList<Member> member)
    {
    	Scanner s = new Scanner(System.in);
    	ArrayList<Member> storeSort = new ArrayList<Member>();
    	int top = 0;
    	for(Member m : member) //deep copy
    	{
    		storeSort.add(m);
    	}
    	
    	storeSort.sort(new PointAccumulatedSorter());
    	Collections.reverse(storeSort);
    	
    	p("\nTOP PURCHASE MEMBER\n===================\n");
    	boolean input = false;
    	do
    	{	
    		try
    		{
    			System.out.printf("Enter a number for TOP PURCHASE MEMBER\n(more than 4 and less than %d): ", member.size()+1);
    			top = s.nextInt();
    			input = true;
    		}
    		catch(Exception ex)
    		{
    			input = false;	
    			p("***Incorrect input : An integer is required***\n\n");
    			s.nextLine();
    		}
    		if(top <0)
    		{
    			p("\n");
    			return;
    		}
    		
    		if(top > member.size())
    			System.out.printf("The total member are %d\n\n", member.size());
    	}while(!input || top <5 || top>member.size());
    	
    	Calendar calendar = new GregorianCalendar();
    	System.out.printf("\n\t\t\t\t\t\tTOP %d Most Purchase Member\n", top);
    	System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t  "+calendar.get(Calendar.DATE)+"/"+calendar.get(Calendar.MONTH)+"/"+calendar.get(Calendar.YEAR)+"\t"+
    						calendar.get(Calendar.HOUR_OF_DAY)+":"+calendar.get(Calendar.MINUTE));
    	p("___________________________________________________________________________\n");
    	p("|\t   NAME\t     |  GRADE  |\t\t\tEMAIL\t\t\t   |TOTAL PURCHASE|\n");
    	p("---------------------------------------------------------------------------\n");
    	for(int i = 0; i<top;i++)
    	{
    		Name name = storeSort.get(i).getName();
    		Contact contact = storeSort.get(i).getContact();
    		String names = name.getFirstName()+" "+name.getLastName();
    		System.out.printf("|%-15s |%-8s |%-30s |   RM%-9.2f|\n", names, storeSort.get(i).getGrade(), contact.getEmail(), storeSort.get(i).getPointAccumulated()/10);
    		p("---------------------------------------------------------------------------\n");
    	}
    	p("\t\t\t\t\t\t\t\tEND OF REPORT\n\n");
    } //DONE
    
    public static void memberSummaryReport(ArrayList<Member> member)
    {	
    	Scanner s = new Scanner(System.in);
    	ArrayList<Member> normal = new ArrayList<Member>();
    	ArrayList<Member> diamond = new ArrayList<Member>();
    	ArrayList<Member> platinum = new ArrayList<Member>();
    	
    	int year=0;
    	boolean input;
    	do
    	{	
    		try
    		{
    			System.out.printf("Enter for a YEAR : ");
    			year = s.nextInt();
    			input = true;
    			//System.out.printf("%s \t %c",String.valueOf(year), String.valueOf(year).charAt(0));
    		}
    		catch(Exception ex)
    		{
    			input = false;	
    			p("***Incorrect input : An integer is required***\n\n");
    			s.nextLine();
    		}
    		if(year <0)
    		{
    			p("\n");
    			return;
    		}
    	}while(!input || String.valueOf(year).length() != 4);
    
    	//System.out.printf("%s\t %d\n", member.get(0).getMemberID().substring(0,2), year%100);
    	for(int i = 0;i<member.size();i++)
    	{
    		if(member.get(i).getMemberID().substring(0,2).equals(String.valueOf(year%100)))
    		{
				if(member.get(i).getGrade().equals("NORMAL"))
    				normal.add(member.get(i));
    			else if (member.get(i).getGrade().equals("DIAMOND"))
    				diamond.add(member.get(i));
    			else
    				platinum.add(member.get(i));    			
    		}
    	}
    	
    	normal.sort(new MemberPointSorter());
    	diamond.sort(new MemberPointSorter());
    	platinum.sort(new MemberPointSorter());
    	
    	if(normal.size() == 0 && diamond.size() == 0 && platinum.size() == 0)
    		p("***No Member Registration on this year***\n");
    	else
    	{
	    	System.out.printf("\n\n\tMEMBER GRADE SUMMARY REPORT IN %d\n", year);
	    	p("__________________________________________\n");
	    		p("|  GRADE   |      NAME       |   POINT   |\n");
	    	for(int i =0;i<3;i++)	
	    	{
	    		p("|----------|-----------------|-----------|\n");
	    		if(i==0)
	    		{
	    			p("|  NORMAL  |");
	    			for(int k =0;k<normal.size();k++)
	    			{
	    				Name name = normal.get(k).getName();
	    				String names = name.getFirstName() + " " + name.getLastName();
	    				if(k==0)
	    				{
	    					System.out.printf(" %-15s | %-10.1f|\n", names, normal.get(k).getMemberPoint());
	    					p("|          |-----------------|-----------|\n");
	    				}	
	    				else
	    				{
	    					System.out.printf("|\t\t   | %-15s | %-10.1f|\n", names, normal.get(k).getMemberPoint());
	    					p("|          |-----------------|-----------|\n");
	    				}
	    					
	    				if(k == normal.size()-1)
	    				{
	    					System.out.printf("|\t\t   |\t\tTOTAL MEMBER : %6d|\n", normal.size());
	    				}
	    			}
	    		}
	    		else if(i==1)
	    		{
	    			p("| DIAMOND  |");
	    			for(int k =0;k<diamond.size();k++)
	    			{
	    				Name name = diamond.get(k).getName();
	    				String names = name.getFirstName() + " " + name.getLastName();
	    				if(k==0)
	    				{
	 						System.out.printf(" %-15s | %-10.1f|\n", names, diamond.get(k).getMemberPoint());   					
	    					p("|          |-----------------|-----------|\n");
	    				}
	    				else
	    				{
	    					System.out.printf("|\t\t   | %-15s | %-10.1f|\n", names, diamond.get(k).getMemberPoint());
	    					p("|          |-----------------|-----------|\n");
	    				}
	    					
	    			
	    				if(k == diamond.size()-1)
	    				{
	    					System.out.printf("|\t\t   |\t\tTOTAL MEMBER : %6d|\n", diamond.size());
	    				}
	    			}
	    		}
	    		else
	    		{
	    			p("| PLATINUM |");
	    			for(int k =0;k<platinum.size();k++)
	    			{
	    				Name name = platinum.get(k).getName();
	    				String names = name.getFirstName() + " " + name.getLastName();
	    				if(k==0)
	    				{
	    					System.out.printf(" %-15s | %-10.1f|\n", names, platinum.get(k).getMemberPoint());
	    					p("|          |-----------------|-----------|\n");
	    				}
	    				else
	    				{
	    					System.out.printf("|\t\t   | %-15s | %-10.1f|\n", names, platinum.get(k).getMemberPoint());
	    					p("|          |-----------------|-----------|\n");
	    				}
	    					
	    			
	    				if(k == platinum.size()-1)
	    				{
	    					System.out.printf("|\t\t   |\t\tTOTAL MEMBER : %6d|\n", platinum.size());
	    				}
	    			}
	    		}	
	    	}
	    	p("------------------------------------------\n\n");
    	}
    } //DONE
    
    public static void registrationMenu()
    {
    	p("\nMEMBERSHIP MODULE\n----------------------\n");
    	p("Registration       : (1)\n");
    	p("Search Member      : (2)\n");
    	p("Modify Member      : (3)\n");
    	p("Display Member     : (4)\n");
    	p("Upgrade Membership : (5)\n");
    	p("Product Redeemtion : (6)\n");
    	p("    ***EXIT***     : Other\n");
    } //Done
    public static int selectFunction()
    {
    	Scanner s = new Scanner(System.in);
    	int choice = 0;
    	
    	registrationMenu();
    	boolean input = false;
    	do
    	{	
    		try
    		{
    			p("Please select an integer : ");
    			choice = s.nextInt();
    			input = true;
    		}
    		catch(Exception ex)
    		{
    			input = false;	
    			p("***Incorrect input : An integer is required***\n\n");
    			s.nextLine();
    		}
    	}while(!input);
    	
    	return choice;
    } //Done
    
    public static void p(String printing)
    {
    	System.out.print(printing);
    } //Done
}