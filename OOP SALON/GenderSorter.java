/**
 * @(#)MemberPointSorter.java
 *
 *
 * @author 
 * @version 1.00 2019/8/12
 */

import java.util.Comparator;
public class GenderSorter implements Comparator<Member> {

    public GenderSorter() {
    }
    
    @Override
    public int compare(Member m1, Member m2)
    {
    	return m1.getGender().compareTo(m2.getGender());
    }
}