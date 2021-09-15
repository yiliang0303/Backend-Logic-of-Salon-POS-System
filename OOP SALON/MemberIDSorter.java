/**
 * @(#)MemberIDSorter.java
 *
 *
 * @author 
 * @version 1.00 2019/8/12
 */

import java.util.Comparator;
public class MemberIDSorter implements Comparator<Member>{

    public MemberIDSorter() {
    }
    
    @Override
    public int compare(Member m1, Member m2)
    {
    	return m1.getMemberID().compareTo(m2.getMemberID());
    }
}