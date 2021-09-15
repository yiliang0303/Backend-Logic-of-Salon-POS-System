/**
 * @(#)Product.java
 *
 *
 * @author 
 * @version 1.00 2019/8/9
 */


public class Product extends Business {
	
	private String prodID;
	private int quantity;
	private static int countProduct;
	
		

    public Product(String name,String description, double price, String prodID, int quantity) {
    	super(name,description,price);
    	this.prodID=prodID;
    	this.quantity=quantity;
    	countProduct++;
    	
    }
    
    //getter
    public String getProdID(){
    	return prodID;
    }
    
    public int getQuantity(){
    	return quantity;
    }
    
    public static int getCountProduct(){
    	return countProduct;
    }
    
    
    //setter
    public void setProdID(String prodID){
    	this.prodID=prodID;
    }
    
    public void setQuantity(int quantity){
    	this.quantity=quantity;
    }
    
    public static void setCountProduct(int countProduct){
		Product.countProduct=countProduct;
	}
    //toString
    public String toString(){
    	return String.format(
    		"%s\n"+
    		"ProductID\t:%s\n"+
    		"Quantity\t:%d\n",
    		super.toString(),prodID.toUpperCase(),quantity);
    }
    
  public void stockin(int quantity){
  	this.quantity+=quantity;
  }
  
  public void stockout(int quantity){
  	this.quantity-=quantity;
  }  
    
    
}