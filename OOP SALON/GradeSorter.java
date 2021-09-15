/**
 * @(#)GradeSorter.java
 *
 *
 * @author 
 * @version 1.00 2019/8/12
 */


import java.util.Comparator;
public class GradeSorter implements Comparator<Member> {

    public GradeSorter() {
    }
    
    @Override
    public int compare(Member m1, Member m2)
    {
    	final String normal="1", diamond="2", platinum="3";
    	String m1Level, m2Level;
    	
    	if(m1.getGrade().equals("NORMAL"))
    		m1Level=normal;
    	else if(m1.getGrade().equals("DIAMOND"))
    		m1Level = diamond;
    	else
    		m1Level = platinum;
    		
    	if(m2.getGrade().equals("NORMAL"))
    		m2Level=normal;
    	else if(m2.getGrade().equals("DIAMOND"))
    		m2Level = diamond;
    	else
    		m2Level = platinum;
    	return m1Level.compareTo(m2Level);
    }
}