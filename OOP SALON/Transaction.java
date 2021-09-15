/**
 * @(#)Transaction.java
 *
 *
 * @author
 * @version 1.00 2019/8/9
 */

import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Transaction {
	private String transactionID;
	private Member member;
	private Staff staff;
	private ArrayList<TransactionDetails> tdArray = new ArrayList<TransactionDetails>();
	private int noOfTransaction = 0;
	private static int noOfTransactionDetails = 0;

	//date
	Date date = new Date();
	DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
	String stringDate = dateFormat.format(date);

	public Transaction() {

    }
    public Transaction(Member member, Staff staff, Date date) {
		setTransactionID();
		this.member = member;
		this.staff = staff;

		//transactionDetails = new TransactionDetails[noOfTransaction];
		noOfTransactionDetails++;
		setTransactionID();
    }
    public Transaction(Member member, Date date) {
		this.transactionID = transactionID;
		this.member = member;
		this.staff = staff;

    	//transactionDetails = new TransactionDetails[noOfTransaction];
		noOfTransactionDetails++;
    	setTransactionID();
    }
    public Transaction(Staff staff, Date date) {
		this.transactionID = transactionID;
		this.staff = staff;
    	//transactionDetails = new TransactionDetails[noOfTransaction];

    	setTransactionID();
    }

    public void setTransactionID() {
    	SimpleDateFormat simpleDateFormatday = new SimpleDateFormat("dd");
    	SimpleDateFormat simpleDateFormatmonth = new SimpleDateFormat("MM");
    	SimpleDateFormat simpleDateFormatyear = new SimpleDateFormat("yy");

    	String serialNo = String.format("%04d", noOfTransaction);

    	this.transactionID = simpleDateFormatyear.format(date).toUpperCase() + simpleDateFormatmonth.format(date).toUpperCase() +
    		simpleDateFormatday.format(date).toUpperCase() + serialNo;
    }
    public void setMember() {
    	this.member = member;
    }
    public void setStaff() {
    	this.staff = staff;
    }

	/*public void setNoOfTransaction(int noOfTransaction){
    	Transaction.noOfTransaction = noOfTransaction;
    }*/

    public void removeNoOfTransaction(){
    	noOfTransaction--;
    }

	//To add a new transactionDetails[]
    public void addTransactionDetails(TransactionDetails transactionDetails){
    	tdArray.add(transactionDetails);
    	noOfTransactionDetails++;
    }
    //To remove a transactionDetails[]
    public void removeTransactionDetail(int i){
    	tdArray.remove(i);
    	noOfTransactionDetails--;
    }

	public String getTransactionID() {
		return transactionID;
	}
	public Member getMember() {
		return member;
	}
	public Staff getStaff() {
		return staff;
	}
	public TransactionDetails getTransactionDetails(int i) {
    	return tdArray.get(i);
    }
    public int getNoOfTransaction() {
    	return noOfTransaction;
    }
    public static int getNoOfTransactionDetails() {
    	return Transaction.noOfTransactionDetails;
    }

	//Calculate Base Total Amount
	public double calcTotalAmount(){
    	double totalAmount = 0;
    	for(int i = 0; i < tdArray.size();i++)
    	{
    		totalAmount += (tdArray.get(i)).calcTotalPrice();
    	}

    	return totalAmount;
    }
    //Calculate Amount Tax
    public double calcTax() {
    	final double tax = 0.05;
    	double taxAmount = (Math.round((calcTotalAmount() * tax)*100))/100.00;
    	return taxAmount;
    }
	//Calculate Amount Of Discount If Transaction Is Under A Registed Member
	public double calcMemberDiscount()
    {
    	double discount = 0.00, discountAmount = 0.00;
    	if(member.getGrade() == "PLATINUM") {
    		discount = 0.15;
    	} else if(member.getGrade() == "DIAMOND") {
    		discount = 0.10;
    	} else if(member.getGrade() == "NORMAL") {
    		discount = 0.05;
    	} else {
    		discount = 0.00;
    	}
    	if(member == null) {
    		return 0.00;
    	} else {
    		discountAmount = (Math.round(((calcTotalAmount() + calcTax()) * discount)*100))/100.00;
    		return discountAmount;
    	}
    }
	//Calculate Grand Total
	public double calcGrandTotal() {
    	double grandTotal = 0.00, rounding = 0.00;
    	grandTotal = calcTotalAmount() + calcTax() - calcMemberDiscount();
    	rounding = (int)Math.round(grandTotal*100.00)%5;
    	rounding *= 0.01;

    	if(rounding > 0.02) {
    		grandTotal += (0.05 - rounding);
    	} else{
    		grandTotal -= rounding;
    	}
    	return Math.round(grandTotal * 100.00)/100.00;
    }

	//Used To Display product/service inside a Transaction(cart)
	public String cartString() {
    	String string = String.format(" %-4s %-36s      %-10s %-7d     %-10s \n","ID","Product/Service","Price","Quantity","Total Amount");
    	for(int i = 0; i < tdArray.size(); i++) {
    		string += (tdArray.get(i)).toString();
    	}
    	return String.format("%s", string);
	}

	public String toString() {

    	return String.format(
    		"Transaction ID:%s\n" +
    		"Date: %s\n\n" +
    		"%s\n" +
    		"     Base Total : RM%10.2f\n\n" +
    		"  Amount Of Tax : RM%10.2f\n" +
    		"Member Discount :-RM%10.2f\n\n" +
    		"   Rounding Off :  %10.2f\n" +
    		"    Grand Total : RM%10.2f",
    		transactionID, stringDate, cartString(), calcTotalAmount(), calcTax(), calcMemberDiscount(),
    		calcGrandTotal()-(calcTotalAmount() + calcTax() - calcMemberDiscount()), calcGrandTotal());
    }
}