/**
 * @(#)PointAccumulatedSorter.java
 *
 *
 * @author 
 * @version 1.00 2019/8/14
 */

import java.util.Comparator;
public class PointAccumulatedSorter implements Comparator<Member>{

    public PointAccumulatedSorter() {
    }
    
    public int compare(Member m1, Member m2)
    {
    	int m1MemberPoint = (int)(m1.getPointAccumulated()*100);
    	int m2MemberPoint = (int)(m2.getPointAccumulated()*100); 
    	return m1MemberPoint - m2MemberPoint;
    }
}