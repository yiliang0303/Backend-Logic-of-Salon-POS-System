/**
 * @(#)Business.java
 *
 *
 * @author 
 * @version 1.00 2019/8/10
 */


public class Business {
	
	private String name;
	private String description;
	private double price;


    public Business(String name,String description,double price) {
    	this.name=name;
    	this.description=description;
    	this.price=price;
    }
    
    //getter
    public String getName()	{
 		return name;
 	}  
 	
 	public  String getDescription(){
 		return description;
 	}
    
    public double getPrice(){
    	return price;
    }
    
    //setter
    public void setName(String name)
    {
    	this.name=name;
    }
    
    public void setDescription(String description){
    	this.description=description;
    }
    
    public void setPrice(double price){
    	this.price=price;
    }
    
    
    //toString
    public String toString(){
    	return String.format(
    		"Name\t\t:%s\n"+
    		"Description\t:%s\n"+
    		"Price\t\t:RM%.2f",
    		name.toUpperCase(),description.toUpperCase(),price);
    }
    
    
    
    
    
    
    
}