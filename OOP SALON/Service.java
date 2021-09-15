/**
 * @(#)Service.java
 *
 *
 * @author 
 * @version 1.00 2019/8/9
 */


public class Service extends Business{
	private String serviceID;
	public static int countSev;


    public Service(String name, String description, double price, String serviceID){
    	super(name,description,price);
    	this.serviceID=serviceID;
    	countSev++;
    }
    
    //getter
    public String getServiceID(){
    	return serviceID;
    	
    }
    
    public static int getCountSev(){
    	return countSev;
    }
    
    //setter
    public void setServiceID(String serviceID){
    	this.serviceID=serviceID;
    }
   
   public void setCountSev(int countSev){
   		this.countSev=countSev;
   }
    
    //toString
    public String toString(){
    	return String.format(
    		"%s\n"+
    		"ServiceID\t:%s\n",
    		super.toString(),serviceID);
    }
    
    
}