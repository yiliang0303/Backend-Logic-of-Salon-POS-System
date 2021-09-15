/**
 * @(#)MemberPointSorter.java
 *
 *
 * @author 
 * @version 1.00 2019/8/12
 */

import java.util.Comparator;
public class MemberPointSorter implements Comparator<Member>{

    public MemberPointSorter() {
    }
    
    public int compare(Member m1, Member m2)
    {
    	int m1MemberPoint = (int)(m1.getMemberPoint()*1000);
    	int m2MemberPoint = (int)(m2.getMemberPoint()*1000); 
    	return m1MemberPoint - m2MemberPoint;
    }
}