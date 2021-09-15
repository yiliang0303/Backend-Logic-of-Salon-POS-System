/**
 * @(#)TransactionModule.java
 *
 *
 * @author
 * @version 1.00 2019/8/14
 */

import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class TransactionModule {

    public TransactionModule() {
    }

    public static void transactionModule
    (ArrayList<Member> member, ArrayList<Staff> staff, Product[] product, Service[] service, ArrayList<Transaction> transaction)
    {
		int oIndex = Transaction.getNoOfTransactionDetails();
    	//date
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		String stringDate = dateFormat.format(date);

		/*
   		//TransactionDetails
    	ArrayList<TransactionDetails> tdArray = new ArrayList<TransactionDetails>();
    	tdArray.add(new TransactionDetails(product[0],10));//0
    	tdArray.add(new TransactionDetails(product[0],3));//1
    	tdArray.add(new TransactionDetails(product[1],2));//2
    	tdArray.add(new TransactionDetails(product[1],3));//3
    	tdArray.add(new TransactionDetails(product[1],4));//4
    	tdArray.add(new TransactionDetails(product[2],3));//5
    	tdArray.add(new TransactionDetails(product[2],7));//6
    	tdArray.add(new TransactionDetails(product[2],1));//7
    	tdArray.add(new TransactionDetails(product[3],8));//8
    	tdArray.add(new TransactionDetails(product[3],1));//9
    	tdArray.add(new TransactionDetails(product[2],2));//10
    	tdArray.add(new TransactionDetails(service[0]));  //11
    	tdArray.add(new TransactionDetails(service[1]));  //12
    	tdArray.add(new TransactionDetails(service[2]));  //13

    	//Transactions
    	ArrayList<Transaction> transaction = new ArrayList<Transaction>();
    	transaction.add(new Transaction(member.get(0), staff.get(0), date));
    	transaction.get(0).addTransactionDetails(tdArray.get(0));
    	transaction.get(0).addTransactionDetails(tdArray.get(4));

    	transaction.add(new Transaction(member.get(1), staff.get(1), date));
    	transaction.get(1).addTransactionDetails(tdArray.get(1));
    	transaction.get(1).addTransactionDetails(tdArray.get(10));

    	transaction.add(new Transaction(member.get(1), staff.get(1), date));
    	transaction.get(2).addTransactionDetails(tdArray.get(9));
    	transaction.get(2).addTransactionDetails(tdArray.get(2));

    	transaction.add(new Transaction(member.get(1), staff.get(1), date));
    	transaction.get(3).addTransactionDetails(tdArray.get(3));
    	transaction.get(3).addTransactionDetails(tdArray.get(5));
    	transaction.get(3).addTransactionDetails(tdArray.get(8));

    	transaction.add(new Transaction(member.get(1), staff.get(1), date));
    	transaction.get(4).addTransactionDetails(tdArray.get(4));
    	transaction.get(4).addTransactionDetails(tdArray.get(6));
    	transaction.get(4).addTransactionDetails(tdArray.get(9));

    	transaction.add(new Transaction(member.get(1), staff.get(1), date));
    	transaction.get(5).addTransactionDetails(tdArray.get(11));
    	transaction.get(5).addTransactionDetails(tdArray.get(12));

    	transaction.add(new Transaction(member.get(1), staff.get(1), date));
    	transaction.get(6).addTransactionDetails(tdArray.get(1));
    	transaction.get(6).addTransactionDetails(tdArray.get(13));

		*/

    	Scanner s = new Scanner(System.in);

    	int select = 0, menuOptionTotal = 3;
    	boolean check = true;
    	do {
    		check = true;
	    	try {
	    		transactionMenu();
	    		select = s.nextInt();
	    		check = checkMenuInput(select, menuOptionTotal);
			}
			catch(Exception e) {
			 	System.out.printf("\nPlease Input in an Interger\n\n");
			 	s.next();
			}

			switch(select) {
	    		case 1: //Start Transaction
	    			cartMenu(member, staff, product, service, transaction);
	    			check = true;
	    			break;
	    		case 2: //Refund A Product
					refundProduct(member, staff, product, service, transaction);
					check = true;
					break;
				case 3:
					transactionReport(transaction, oIndex);
					break;
				case 4:
					break;
	    		default:
	    			break;
	    	}
    	}while(check);

    }

    public static void transactionMenu() {
		System.out.print("|=============================| \n");
    	System.out.print("|     TRANSACTION MODULE      | \n");
    	System.out.print("|=============================| \n");
    	System.out.print("| Start Transaction(Cart): (1)| \n");
    	System.out.print("| Refund A Product       : (2)| \n");
    	System.out.print("| Transaction Report     : (3)| \n");
   		System.out.print("| EXIT                   : (4)| \n");
   		System.out.print("|=============================| \n");
   		System.out.print("    You may select(1-3)  :  ");
    }

    public static boolean checkMenuInput(int select, int menuRange) {
		if (select > menuRange || select <= 0) {
			System.out.printf("\n<Invalid>.\nYour Input Must Be In Range(1-%d)\n\n", menuRange);
			return true;
		}
		else {
			return false;
		}
	}

	public static void displayCartMenu(int useCart) {
		System.out.printf("Current Transaction (cart) \n");
		System.out.println("=====================================");
		if(useCart == 0) {
			System.out.printf("Add Product : (1) \n");
			System.out.printf("   Go Back  : (2) \n");

		} else {
			System.out.printf("Add Product             : (1) \n");
			System.out.printf("Add Service(COMING SOON): (2) \n");
			//System.out.printf("Completely Remove Item  : () \n"); use public void removeTransactionDetail(int i);
			System.out.printf("Process Payment         : (3) \n");
			System.out.printf("Go Back                 : (4) \n");
		}
	}

	public static boolean cartMenu(ArrayList<Member> member, ArrayList<Staff> staff, Product[] product, Service[] service, ArrayList<Transaction> transaction)
	{
		Scanner s = new Scanner(System.in);
		boolean checkSelect = true;
		int select = 0, menuRange = 0, oIndex = Transaction.getNoOfTransactionDetails(), transactionDetailNo = transaction.get(oIndex+1).getNoOfTransaction();

		//GET STAFF AND MEMBER THEN ONLY transaction.add(new Transaction(member.get(i), staff.get(x)));
		//transaction.add(new Transaction());

		oIndex = Transaction.getNoOfTransactionDetails() - 1;
		System.out.println("");

		try {
	    	displayCartMenu(oIndex);
	    	if(oIndex == 0) {
	    		menuRange = 2;
	    	} else {
	    		menuRange = 4;
	    	}

	    	System.out.printf("Function(1-%d):", menuRange);
		    select = s.nextInt();
	    	checkSelect = checkMenuInput(select, menuRange);
		}
		catch(Exception e) {
			 System.out.printf("\nPlease Input an Interger Value \n\n");
			 s.nextLine();
		}


	switch(select){

		case 1:
	    	checkSelect = addProductToCart(product, transaction, oIndex);
	    	System.out.println(""); System.out.println("");
	    	break;
	    case 2:
	    	//checkSelect = addServiceToCart(service, transaction,transactionDetailNo,oIndex); //not enought time <COMING SOON>
	    	System.out.println(""); System.out.println("");
	    	break;
	    case 3:
	    	if(oIndex != 0) {
		    	System.out.printf("\nYour Cart\n");
		    	System.out.println("");
		    	System.out.printf("%s\n", transaction.get(oIndex).toString());
		    	System.out.println("\n");
		    	checkSelect = true;
	    	} else {
	    		transaction.remove(oIndex);
	    		transaction.get(oIndex).removeTransactionDetail(oIndex);
	    		System.out.print("\n");
	    	}
	    	System.out.println("");
	    	break;
	    case 4:
	    	System.out.println("");
	    	checkSelect = payment(member, staff, product, service, transaction, Transaction.getNoOfTransactionDetails() ,oIndex);
	    	System.out.println("");
	    	checkSelect = true;
	    	break;
	    case 5:
			System.out.println("");
	    	//removeFromCart(product, member, transaction,Transaction.getNoOfTransactionDetails(), oIndex);
	    	System.out.println("");
	    	break;
		}
		return true;
	}

	/*public static void removeFromCart(Product product[], ArrayList<Member> member,ArrayList<Transaction> transaction,int cartNo,int oIndex)
	{
		boolean check = true;
		int counter = 0;
		do{
			checkRange = true;
			try {
		    		System.out.printf("\nYour Current Cart\n");
					System.out.printf("\n===============================\n");
					System.out.printf("%s\n",transaciton.get(index).cartString());
					System.out.printf("  (ENTER -1 TO EXIT)\n");
					System.out.printf("Enter Item No Want to Remove(1-%d):",cartNo);

		    		chosenNo = s.nextInt();
		    		checkRange = check(counter,cartNo+1);
				}
				catch(Exception e) {
				 	System.out.printf("\n Please Input an Interger\n\n");
				}
		}while(check); //while(!check);
			product deleting = transaction.get(index).getTransactionDetails(counter - 1).getProduct();
			for(int i = 0; i < product.size(); i++)
			{
				if(deleting == product[i])
				{
					int stockBack = product[i].getQuantity();
					product[i].stockin(stockBack);
				}
			}
			System.out.printf("This Product has been removed successfully\n");
			transaction.get(index).removeTransactionDetails(counter - 1);
		}
	}*/

	public static boolean addProductToCart(Product product[], ArrayList<Transaction> transaction,int oIndex) {
		Scanner s = new Scanner(System.in);
		boolean checkRange = true, check = true;

		//Product[] product = new Product();

		int stock = 0, pIndex;
		int selectedProd = 0, i = 0, num = 0;


		System.out.printf("\n");
		int x = product.length;
		int[] checkQuantity = new int[x];

			selectedProd = 0;
			check = true;
			checkRange = true;
			x = product.length;
			checkQuantity = new int[x];

			System.out.printf("             Sellable Product             \n");
			System.out.printf("==========================================\n");
			i = 0;
			for(i = 0; i < product.length; i++) {
				if(product[i] == null) {
					break;
				}
				String prodName = product[i].getName();
				System.out.printf("%15s", prodName);
				//pIndex = ;
				if(product[i].getQuantity() == 0) {
					System.out.printf("(Out Of Stock)");
				} else {
					System.out.printf("(%-3d In Stock)", product[i].getQuantity());
				}
				System.out.printf(": (%d) \n", i+1);
				checkQuantity[i] = product[i].getQuantity();
				stock = product[i].getQuantity();
				num = i + 1;
			}
			String word = "BACK TO MODULE ";
			System.out.printf("%18s (%d) \n", word , num + 1);
			System.out.printf("Choose Product(1-%d):", num);
			do {
				try {
					selectedProd = 0;
					selectedProd = s.nextInt();

					check = checkMenuInput(selectedProd, num);

				}
				catch(Exception e) {
					System.out.printf("\nPlease Input an Interger\n");
					System.out.println("");
					check = false;
				}
				if(check == true) {


					if(checkQuantity[selectedProd - 1] == 0) {
						System.out.println("\n THIS PRODUCT IS OUT OF STOCK\n");
					}

				}
			}while(check == false);


		s.nextLine();
		//System.out.println("");
		int prodQty = 0;
		do{
			check = true;
			try {
					System.out.printf("Only %d In Stock \n(Enter -1 to exit) \nQuantity:", checkQuantity[selectedProd - 1]);
					prodQty = s.nextInt();
				}
				catch(Exception e) {
					 System.out.printf("\n Please Input an Interger\n\n");
					 check = false;
				}
				if(prodQty > checkQuantity[selectedProd-1]) {
					check = false;
					System.out.printf("\n%d <Invalid Quantity>\n\n", prodQty);
				} else {
					check = true;
				}
		} while(check == false);
		check = true;
		TransactionDetails transactionDetails = new TransactionDetails(product[i], prodQty);
		if (product[i] != null) {
			product[i].setQuantity(checkQuantity[selectedProd - 1] - prodQty);
		}


		for(int j = 0; j < Transaction.getNoOfTransactionDetails(); j++) {
			if(product[i] == transaction.get(Transaction.getNoOfTransactionDetails()).getTransactionDetails(j).getProduct()) {
				int bufferQty = (transaction.get(oIndex).getTransactionDetails(j).getProduct().getQuantity());
				transaction.get(oIndex).getTransactionDetails(j).getProduct().setQuantity( bufferQty + prodQty);
				check = false;
			}
		}

		if(check)
		{
			transaction.get(Transaction.getNoOfTransactionDetails()).addTransactionDetails(transactionDetails);
		}
		System.out.printf("Successfully Added To Cart \n");
		System.out.printf("\n");

		return true;
	}

	public static boolean  refundProduct(ArrayList<Member> member, ArrayList<Staff> staff, Product[] product, Service[] service, ArrayList<Transaction> transaction) {
		Scanner s = new Scanner(System.in);
		boolean check = true;
		int stock = 0;
		int selectedProd = 0, i = 0, num = 0;


		System.out.printf("\n");
		int x = product.length;
		int[] checkQuantity = new int[x];
		for(i = 0; i < product.length; i++) {
				if(product[i] == null) {
					break;
				}
				String prodID = product[i].getProdID();
				System.out.printf("%15s", prodID);
				//poIndex = ;
				if(product[i].getQuantity() == 0) {
					System.out.printf("(Out Of Stock)");
				} else {
					System.out.printf("(%-3d In Stock)", product[i].getQuantity());
				}
				System.out.printf(": (%d) \n", i+1);
				checkQuantity[i] = product[i].getQuantity();
				stock = product[i].getQuantity();
				num = i + 1;
			}
			String word = "BACK TO MODULE ";
			System.out.printf("%18s (%d) \n", word , num + 1);
			System.out.printf("Choose Product(1-%d):", num);
			do {
				try {
					selectedProd = 0;
					selectedProd = s.nextInt();

					check = checkMenuInput(selectedProd, num);

				}
				catch(Exception e) {
					System.out.printf("\nPlease Input an Interger\n");
					System.out.println("");
					check = false;
				}

			}while(check == false);
		int prodQty = 0;
		do{
			check = true;
			try {
					System.out.printf("\n(Enter -1 to exit) \nQuantity:", checkQuantity[selectedProd - 1]);
					prodQty = s.nextInt();
				}
				catch(Exception e) {
					 System.out.printf("\n Please Input an Interger\n\n");
					 check = false;
				}

		} while(check == false);
		product[i].stockin(prodQty);

		return true;

	}


	public static boolean payment(ArrayList<Member> member, ArrayList<Staff> staff, Product[] product, Service[] service, ArrayList<Transaction> transaction, int transactionDetailNo, int oIndex) {
		Scanner s = new Scanner(System.in);
		System.out.printf("\nPayment Detail\n");

		System.out.printf("%s \n",transaction.get(oIndex).toString());

		double transactionTotal = transaction.get(oIndex).calcGrandTotal();
		//System.out.print(transaction.get(oIndex));
		boolean check = true;
		double amountReceived = 0, amountBuffer = 0;

		do {
			check = true;
			try {
				System.out.printf("(ENTER -1 TO EXIT)\n");
				System.out.printf(" Amount Received: RM ");
				amountReceived = s.nextDouble();
				if(amountReceived == -1)
					return true;

				amountReceived = (Math.round(amountReceived * 100.00)/100.00);
				amountBuffer = amountReceived - transactionTotal;

				check = false;
			}
			catch(Exception e) {
				System.out.printf("\n<Invalid Input>\nPlease Input an Interger\n\n");
				s.nextLine();
			}
			if(check == true) {
				if((amountBuffer < 0.00) && (amountBuffer != 0.00) ) {
					System.out.printf("\nAmount Not Enought\n");
					System.out.printf("Grand Total: RM%.2f\n", transaction.get(oIndex).calcGrandTotal());
				}
			}
		}while(check == true);

		member.get(oIndex).topUp(transactionTotal);  //This is to accummulate points for membership
		System.out.printf("\n Payment Succesful \n");
		return true;
	}


	public static void transactionReport(ArrayList<Transaction> transaction, int oIndex)
    {
    	//date
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		String stringDate = dateFormat.format(date);


    	System.out.println("          Daily Transaction Report           ");
    	System.out.println("=============================================");
		System.out.printf("                 %s", stringDate);
    	System.out.println("=============================================");
    	String string = String.format(" %-4s %-36s      %-10s %-7d     %-10s \n","ID","Product/Service","Price","Quantity","Total Amount");
    	System.out.printf("%s", string);



    	for(int i = 0; i < transaction.size(); i++)
    	{
    		transaction.get(i).cartString();
    	}
    }

}