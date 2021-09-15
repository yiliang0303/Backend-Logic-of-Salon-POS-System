/**
 * @(#)NameSorter.java
 *
 *
 * @author 
 * @version 1.00 2019/8/12
 */

import java.util.Comparator;
public class NameSorter implements Comparator<Member> {

    public NameSorter() {
    }
    
    @Override
    public int compare(Member m1, Member m2)
    {
    	Name[] name = 
    	{
    		m1.getName(),
    		m2.getName() 
    	};
    	
    	String m1Name = name[0].getFirstName() + name[0].getLastName();
    	String m2Name = name[1].getFirstName() + name[1].getLastName();
    	return m1Name.compareTo(m2Name);
    }
}