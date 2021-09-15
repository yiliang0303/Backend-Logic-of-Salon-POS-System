/**
 * @(#)Member.java
 *
 *
 * @author 
 * @version 1.00 2019/7/29
 */

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Member extends Person{
	
	final private static double normal = 5000, diamond = 10000, platinum = 15000;
	private String memberID, grade;
	private double memberPoint = 0, pointAcumulated = 0;
	private static int countMember, countMale, countFemale, countNormal, countDiamond, countPlatinum;
	
	public Member(){
	}
	
    public Member
    (Name name, String icNo, Address address, Contact contact, char grade) 
    {
    	super(name, icNo, address, contact);
    	setGrade(grade);
    	this.memberPoint=memberPoint;
    	countMember++;
    	countGender(icNo);
    	generateMemberID();
    }
    
    //for constructor
    public void generateMemberID()
	{
		final int IDlength = 4;
		Calendar calendar = new GregorianCalendar();
		
		int year = calendar.get(Calendar.YEAR)%100;
		if(getGender()=="MALE")
		{
			memberID = year + "M";
		}
		else
		{
			memberID = year +"F";
		} 
		
		memberID += String.format("%04d", countMember);
		/*for(int i = 0; i< (IDlength-String.valueOf(countMember).length()) ;i++)
		{
			memberID = memberID + 0;		
		}
		memberID = memberID + countMember;*/
	}
	
	public void setGrade(char grade)
	{
		if(grade == 'N')
		{
			pointAcumulated += normal;
			countNormal++;			
			this.grade = "NORMAL";
		}
		else if(grade == 'D')
		{
			pointAcumulated+=diamond;
			countDiamond++;
			this.grade = "DIAMOND";
		}
		else
		{
			pointAcumulated+=platinum;
			countPlatinum++;
			this.grade="PLATINUM";
		}
	}
	
	public void countGender(String icNo)
	{
		if(icNo.charAt(icNo.length()-1)%2 == 0)
			countFemale++;
		else
			countMale++;
	}
	
	public void editIcNo(String icNo)
	{
		super.setIcNo(icNo);
		if(icNo.charAt(icNo.length()-1)%2 == 0)
		{
			countFemale++;
			countMale--;
		}
		else
		{
			countFemale--;
			countMale++;
		}
		
	}
	
	//not for constructor
	//getter
    public String getMemberID()
    {
    	return memberID;
    }
    
    public String getGrade()
    {
    	return grade;
    }
	
	public double getMemberPoint()
	{
		return memberPoint;
	}
	
	public double getPointAccumulated()
	{
		return pointAcumulated;
	} 
		
	public static int getCountMember()
	{
		return countMember;
	}
	
	public static int getCountMale()
	{
		return countMale;
	}
	public static int getCountFemale()
	{
		return countFemale;
	}
	public static int getCountNormal()
	{
		return countNormal;
	}
	public static int getCountDiamond()
	{
		return countDiamond;
	}
	public static int getCountPlatinum()
	{
		return countPlatinum;
	}
	
	public static double getNormal()
	{
		return normal;
	}
	
	public static double getDiamond()
	{
		return diamond;
	}
	
	public static double getPlatinum()
	{
		return platinum;
	}
	
	//for void main function
	public void topUp(double price)
	{
		memberPoint+=price*10;
		pointAcumulated+= price*10;
	}
	
	public void useUp(double price)
	{
		memberPoint-=price*10;
	}
	
	public void editGrade(String oldGrade, char newGrade)
	{
		if(newGrade == 'N')
		{
			countNormal++;
			grade = "NORMAL";
		}
		else if(newGrade == 'D')
		{
			countDiamond++;
			grade = "DIAMOND";			
		}
		else
		{
			countPlatinum++;
			grade = "PLATINUM";	
		}
			
		if(oldGrade == "NORMAL")
			countNormal--;
		else if(oldGrade == "PLATINUM")
			countDiamond--;
		else
			countPlatinum--;
	}
	
	
	
	public String toString(int sort)
	{			
		if(sort == 3)//gender
			return String.format("Member ID \t\t  : %s\n%sGrade \t\t\t  : %s\nCurrent Point \t  : %.1f\nPoint Acumulated  : %.1f\n\n", memberID, super.toString(sort), grade, memberPoint, pointAcumulated);
		else if(sort == 4)//grade
			return String.format("Member ID \t\t  : %s\nGrade \t\t\t  : %s\n%sCurrent Point \t  : %.1f\nPoint Acumulated  : %.1f\n\n", memberID, grade, super.toString(sort), memberPoint, pointAcumulated);
		else if(sort == 5)//member point
			return String.format("Member ID \t\t  : %s\nCurrent Point \t  : %.1f\nPoint Acumulated  : %.1f\nGrade \t\t\t  : %s\n%s\n", memberID, memberPoint, pointAcumulated, grade, super.toString(sort));
		else //name
			return String.format("Member ID \t\t  : %s\n%sGrade \t\t\t  : %s\nCurrent Point \t  : %.1f\nPoint Acumulated  : %.1f\n\n", memberID, super.toString(sort), grade, memberPoint, pointAcumulated);
	}
	
	//plus
	public static void plusMale()
	{
		countMale++;
	}
	
	public static void plusFemale()
	{
		countFemale++;
	}
	
	//minus
	public static void minusMale()
	{
		countMale--;
	}
	
	public static void minusFemale()
	{
		countFemale--;
	}
	
	public static void minusNormal()
	{
		countNormal--;
	}
	
	public static void minusDiamond()
	{
		countDiamond--;
	}
	
	public static void minusPlatinum()
	{
		countPlatinum--;
	}
	
	public static void delete()
	{
		countMember--;
	}
}