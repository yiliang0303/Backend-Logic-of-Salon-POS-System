/**
 * @(#)TransactionDetails.java
 *
 *
 * @author
 * @version 1.00 2019/8/12
 */

import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class TransactionDetails{
	private Product product;
	private int prodQty;
	private Service service;
	private static int countTransactionDetails = 0;

	//date
	Date date = new Date();
	DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
	String stringDate = dateFormat.format(date);


    public TransactionDetails(Product product, int prodQty) {
    	this.product = product;
    	this.prodQty = prodQty;
    	countTransactionDetails++;
    	//countProduct++;
    }
    public TransactionDetails(Service service) {
    	this.service = service;
    	countTransactionDetails++;
    	//countService++;
    }

	public void setProduct(Product product) {
    	this.product = product;
    }
    public void setProdQty(int prodQty) {
    	this.prodQty = prodQty;
    }
    public void setService(Service service) {
    	this.product = product;
    }

	public double calcTotalPrice() {
    	return product.getPrice() * (double)prodQty;
    }

	public Product getProduct() {
    	return product;
    }
    public int getProdQty() {
    	return prodQty;
    }
    public Service getService() {
    	return service;
    }
    /*
    public static int getCountTransactionDetails() {
    	return countTransactionDetails;
    }
    public static int getCountProduct() {
    	return countProduct;
    }
    public static int getCountService() {
    	return countService;
    }
	*/

	public String toString(Product product) {
    	return String.format(" %-4s %-36s   RM %-10.2f %-7d   RM%-10.2f \n",
    	product.getProdID(), product.getName(), product.getPrice(), prodQty, calcTotalPrice());
    }
    public String toString(Service service) {
    	return String.format(" %-4s  %-36s  RM %-10.2f %-7d   RM%-10.2f \n",
    	service.getServiceID(), service.getName(), service.getPrice(), 1, calcTotalPrice());
    }

}