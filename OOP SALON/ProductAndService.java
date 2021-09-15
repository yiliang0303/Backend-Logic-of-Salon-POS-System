/**
 * @(#)ProductAndService.java
 *
 *
 * @author 
 * @version 1.00 2019/8/14
 */

import java.util.Scanner;
public class ProductAndService {

    public ProductAndService() {
    }
    
     public static void productAndService(Product[] product, Service[] service){
   		
   		//ask user choose PRODUCT OR SERVICE
   		int ask =0;
   		//ask user which FUNCTION
   		int choice, choice1;
   		Scanner s = new Scanner(System.in);
   		/*Product[] product = new Product[100];
   		Service[] service = new Service[100];
   	
   		
   		//	create and initialize the info example
   		product[Product.getCountProduct()] = new Product("Colt Badlab","hair wax",55.00,"pz01",40);
   		product[Product.getCountProduct()] = new Product("Oribe Dry Texturizing Spray","hair spray",30.00,"pz02",30);
   		product[Product.getCountProduct()] = new Product("Living Proof Dry Shampoo","hair shampoo",45.00,"pz03",60);
   		product[Product.getCountProduct()] = new Product("Christophe Robin Volumizing Conditioner","hair conditioner",60.00,"pz04",20);
   		
   		
   		service[Service.getCountSev()] = new Service("Wash And Cut","hair cut",35.00,"SV01");
   		service[Service.getCountSev()] = new Service("Dye Colour","dye hair colour",89.00,"SV02");
   		service[Service.getCountSev()] = new Service("Hair Styling","style hair",60.00,"SV03");*/
   		
   		
   		System.out.print("\nProduct or Service(1/2):");	ask = s.nextInt();

   	
   		
   			if(ask == 1)
   			{
   				do
   				{
			   		
			   		do {
    					System.out.println("\n-------------------------------------\n"+
	   								"\t\tPRODUCT FUNCTION\t\t\t|\n"+
	   								"-------------------------------------\n"+
	   								"1.Add new Stock\t\t\t\t\t\t|\n"+
	   								"2.Edit Stock\t\t\t\t\t\t|\n"+
	   								"3.Search Stock\t\t\t\t\t\t|\n"+
	   								"4.Show Stock\t\t\t\t\t\t|\n"+
	   								"5.Stock Return\t\t\t\t\t\t|\n"+
	   								"6.Product Stock Level Report\t\t|\n"+
			   						"7.Back\t\t\t\t\t\t\t\t|\n"+
			   						"-------------------------------------\n");
			   				System.out.print("Choose any function(1-5):");
    			
 			  			 while (!s.hasNextInt()) {       //validate the valid quantity
  			    			  	System.out.println("\n------------Invalid Number-----------\n");
  			   				  	System.out.println("-------------------------------------\n"+
	   									"\t\tPRODUCT FUNCTION\t\t\t|\n"+
	   									"-------------------------------------\n"+
	   									"1.Add new Stock\t\t\t\t\t\t|\n"+
	   									"2.Edit Stock\t\t\t\t\t\t|\n"+
	   									"3.Search Stock\t\t\t\t\t\t|\n"+
	   									"4.Show Stock\t\t\t\t\t\t|\n"+
	   									"5.Stock Return\t\t\t\t\t\t|\n"+
			   							"6.Back\t\t\t\t\t\t\t\t|\n"+
			   							"-------------------------------------\n");
			   					System.out.print("Choose any function(1-6):");
     						  	s.next(); // this is important!
  					 }
  			  		choice = s.nextInt();
				} while (choice <= 0);
			   		
				   		if(choice == 1)
				   			addProduct(product);
				   		else if(choice == 2)
				   			editProduct(product);
				   		else if(choice == 3)
				   			searchProduct(product);
				   		else if(choice == 4)
				   			showProduct(product);
				   		else if(choice == 5)
							stockReturn(product);
   				}while(choice!=6);
   				
   				
			   			
   		}
   		else if(ask == 2)
   		{
   			do
   			{	
	   			System.out.println("\n1.Search service\n"+
	   								"2.Show service \n"+
	   								"3.Back\n");
	   			System.out.print("Choose any function(1-3):");
	   			choice1 = s.nextInt();
	   			
	   				if(choice1 == 1)
	   					searchService(service);
	   				else if(choice1 == 2)
	   					showService(service);
	   		}while(choice1!=3);	
   		}
   				
   		
   
   		
   	
   		
   	
   	
   
}
    

    
 /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////   
	public static void addProduct(Product[] product){
		
		Scanner s = new Scanner(System.in);
		String name,description,prodID;
		double price;
		int quantity;
		char ans;
		boolean found = false;
		
		do{
			System.out.println("\n----------------------------------\nAdding new Product\n----------------------------------");
			System.out.print("Name\t\t:");
			name = s.nextLine();
			
			System.out.print("Description\t:");
			description = s.nextLine();
			
			do {
    			System.out.print("Price\t:");
    			
 			   while (!s.hasNextDouble()) {
  			      System.out.println("------------Invalid price-----------");
  			      System.out.print("Price\t:");
     			  s.next(); // this is important!
  			  }
  			  price = s.nextDouble();
			} while (price <= 0);
			
			
			s.nextLine();
			System.out.print("ProductID\t:");
			prodID = s.nextLine();
		
		
			do {
    			System.out.print("Quantity\t:");
    			
 			   while (!s.hasNextInt()) {       //validate the valid quantity
  			      System.out.println("------------Invalid quantity-----------");
  			      System.out.print("Quantity\t:");
     			  s.next(); // this is important!
  			  }
  			  quantity = s.nextInt();
			} while (quantity <= 0);
			
			System.out.println();
			
			
			product[Product.getCountProduct()] = new Product(name,description,price,prodID,quantity);
			System.out.println("\nSuccessfully Add Product ");
			System.out.println(product[Product.getCountProduct()-1].toString());
			
			System.out.print("Continue to add Product (Y=yes,(other)=no)? ");
		    ans = s.next().charAt(0);
		    s.nextLine();
		    
		}while(Character.toUpperCase(ans)=='Y')	;
		
		
		    
	}
	
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	public static void editProduct(Product[] product){
		
		Scanner s = new Scanner(System.in);
		String prodID;
		int x =0;
		int choice;
		char sure, ask = ' ';
		String name, editName;
		String description, editDes;
		double price, editPrice;
		boolean found, input = true;
		
		do{
			found = false;
			System.out.println();
		    System.out.println("---------------------------------------------------------");
		    System.out.print("Enter Product ID That you want to edit:");
		    prodID=s.nextLine();
       		String ID = prodID.toUpperCase();
        
	        for(int i = 0; i < product.length; i++)
	        {
	        	if(product[i].getProdID().equalsIgnoreCase(ID)){
	        		System.out.println(product[i].toString());
	        		x = i;
	        		found = true;
	        	
	               
		        	do{
		        		
		        			do {
    								System.out.println("---------------------------------------------------------\n"+
		        									"Edit By?\n"+
		        									"-----------\n"+
		        									"1.Name\n"+
		        									"2.Description\n"+
		        									"3.Price\n"+
		        									"4.Exit\n");
		        	
		        					System.out.print("Which data that you want to edit(1-3)>");
    			
 			   						while (!s.hasNextInt()) {       //validate the valid quantity
  			    					 		System.out.println("---------------------------------------------------------\n"+
		        												"Edit By?\n"+
		        												"-----------\n"+
		    				    								"1.Name\n"+
		        												"2.Description\n"+
		        												"3.Price\n"+
		        												"4.Exit\n");
		        	
		        							System.out.print("Which data that you want to edit(1-3)>");
     										  s.next(); // this is important!
  									  }
  									  choice = s.nextInt();
							} while (choice <= 0);
		        		
		        		
		        		
		        		
		        		
		        		
		        		
	        		
	        			//Choose to change name
	        			if(choice == 1)
	        			{
	        				s.nextLine();
	        				System.out.print("Enter the new Product Name:");
	        				editName = s.nextLine();
	        				name = editName.toUpperCase();
	        				
	        				do
	        				{
	        					try
		        				{
		        					System.out.printf("Sure to change?(Y/N)  ");
		        					ask = s.nextLine().charAt(0);
		        					input=true;
		        				}
		        				catch(Exception xe)
		        				{
		        					input=false;
		        					System.out.print("Input the correct input\n");
		        				}
	        				}while(!input);
	        				
	        		
	        					if(Character.toUpperCase(ask) == 'Y')
	        					{
	        						product[x].setName(name);
	        						System.out.println("\nSuccessfully modified Product Name ");
	        					}
	        					System.out.println();
		   	        			System.out.println(product[x].toString());
	        			}
	        			//choose to change description
	        			else if(choice == 2)
	        			{
	        				s.nextLine();
	        				System.out.print("Enter the new Description:");
	        				editDes = s.nextLine();
	        				description = editDes.toUpperCase();
	        				
	        				do
	        				{
	        					try
		        				{
		        					System.out.printf("Sure to change?(Y/N)  ");
		        					ask = s.nextLine().charAt(0);
		        					input=true;
		        				}
		        				catch(Exception xe)
		        				{
		        					input=false;
		        					System.out.print("Input the correct input\n");
		        				}
	        				}while(!input);
	        				
	        		
	        					if(Character.toUpperCase(ask) == 'Y')
	        					{
	        						product[x].setDescription(description);
	        						System.out.println("\nSuccessfully modified Description ");
	        					}
	        					System.out.println();
		   	        			System.out.println(product[x].toString());
	        			}
	        			//choose to change price
	        			else if(choice == 3)
	        			{
	        				
	        				
							do {
					    		System.out.print("Enter the new Price:");
					    			
					 			 while (!s.hasNextDouble()) {       //validate the valid quantity
					  			     System.out.println("------------Invalid price-----------");
					  			      System.out.print("Enter the new Price\t:");
					     			  s.next(); // this is important!
					  			  }
					  			  editPrice = s.nextDouble();
								} while (editPrice<= 0);
								price = editPrice;
						        				
	        				
	        				do
	        				{
	        					try
		        				{
		        					System.out.printf("Sure to change?(Y/N)  ");
		        					ask = s.nextLine().charAt(0);
		        					input=true;
		        				}
		        				catch(Exception xe)
		        				{
		        					input=false;
		        					System.out.print("Input the correct input\n");
		        				}
	        				}while(!input);
	        				
	        		
	        					if(Character.toUpperCase(ask) == 'Y')
	        					{
	        						product[x].setPrice(price);
	        						System.out.println("\nSuccessfully modified Price ");
	        					}
	        					System.out.println();
		   	        			System.out.println(product[x].toString());
	        			}
	        		
	        		
	        		}while(choice== 1 || choice ==2 || choice ==3);
	        		break;
	        	}//if
	        }//for
			       	if(found == false)
			       	{
			       		 System.out.println("Product ID not found");
			       		 
			       	}	 
	       	s.nextLine();
	       	System.out.println("\nContinue to modify other Product (Y=yes,N=no)?:");
	        sure = s.nextLine().charAt(0);
	        		
		}while(Character.toUpperCase(sure) == 'Y');
		
	
        	
		
	}
	
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	 public static void searchProduct(Product[] product){
       	Scanner s = new Scanner(System.in);
       	int choice,search = 0;
       	boolean found;
       	double searchPrice;
       	
       do{
		       	found=false;
   	       
   	     	do {
		    		System.out.println("\nSearch By?");
					System.out.println("------------");
				    System.out.println("1.PRODUCT ID");
				    System.out.println("2.PRODUCT NAME");
				    System.out.println("3.PRICE");
				    System.out.println("4.DESCRIPTION");
				    System.out.println("5.BACK");
				    System.out.print("Select one (1-5) > ");
    			
 			   while (!s.hasNextInt()) {       //validate the valid quantity
  			      System.out.println("\n------------Invalid number-----------\n");
  			        System.out.println("\nSearch By?");
			    	System.out.println("------------");
		        	System.out.println("1.PRODUCT ID");
		  	        System.out.println("2.PRODUCT NAME");
		   	     	System.out.println("3.PRICE");
		   	     	System.out.println("4.DESCRIPTION");
		   	     	System.out.println("5.BACK");
		   	    	System.out.print("Select one (1-5) > ");
     			  s.next(); // this is important!
  			  }
  			  search = s.nextInt();
			} while (search <= 0);
   	       
   	       
   	       
   	       
   	       
   	       
   	        if(search==1){
   	        	s.nextLine();
   	        	System.out.print("Enter The Product ID That You Want To Search:");
   	        	String searchID=s.nextLine();
                 String iD=searchID.toUpperCase();
   	        	for(int i=0;i<Product.getCountProduct();i++)
   	        	{  	        	
   	        	  if(product[i].getProdID().equalsIgnoreCase(iD)){
   	        	  	  found=true;
   	        	  	  System.out.println();
   	        		  System.out.println(product[i].toString());  	
   	        	  }
   	           }
   	        }
   	        else if(search==2){
   	        	s.nextLine();
   	        	System.out.print("Enter The Product Name That You Want To Search:");
   	        	String searchName=s.nextLine();
   	        	String name=searchName.toUpperCase();
   	        	for(int i=0;i<Product.getCountProduct();i++)
   	        	{  	        	
   	        	    if(product[i].getName().equalsIgnoreCase(name)){
   	        	      found=true;
   	        	      System.out.println();
   	        		  System.out.println(product[i].toString());
   	        	    } 	        	
   	            }
   	        }
   	        else if(search==3){
   	   	
		   	       do {
		    			System.out.print("Enter The Product Price That You Want To Search:");
		    			
		 			   while (!s.hasNextDouble()) {
		  			      System.out.println("------------Invalid price-----------");
		  			      System.out.print("Enter The Product Price That You Want To Search:");
		     			  s.next(); // this is important!
		  			  }
		  			  searchPrice = s.nextDouble();
					} while (searchPrice <= 0);
   	        	
   	        	
   	        	for(int i=0;i<Product.getCountProduct();i++)
   	        	{   	        	
   	        	  if(product[i].getPrice()==searchPrice){
   	        	  	found=true;
   	        	  	System.out.println();
   	        		System.out.println(product[i].toString());
   	        	  } 	           	        	
   	        	}
   	       }
    	    else if(search==4){
    	    		s.nextLine();
   	        	  System.out.print("\nEnter The Description That You Want To Search :");
   	        	  String searchCategory=s.next();
   	        	  String ctg=searchCategory.toUpperCase();
   	        	  for(int i=0;i<Product.getCountProduct();i++)
   	        	  {   	        	
   	        	     if(product[i].getDescription().equalsIgnoreCase(ctg)){
   	        	      found=true;
   	        	      System.out.println();
   	        		  System.out.println(product[i].toString());
   	        	     } 	           	        	
   	              }
   	       }   	       
   	       	if(found==false&&search!=5)
			System.out.println("Product record not found");	
      }while(search!=5);
       	
      }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/*public static void delProduct(Product[] product){
		
		Product[] product = new Product();

		
	}*/
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	 public static void showProduct(Product[] product){
	 
		//element header
		System.out.println("\n----------------------------------\nProduct\n----------------------------------");
		
	
     	for(int i=0;i<Product.getCountProduct();i++)
   			System.out.println(product[i].toString());	
	}
	

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static void stockReturn(Product[] product){
		
		Scanner s = new Scanner(System.in);
		String prodID;
		boolean input, found = false;
		int stockinQtty, x = 0;
		char ask =' ', ans;
		
		do{
			System.out.println();
		    System.out.println("---------------------------------------------------------");
		    System.out.print("Enter Product ID That you want to stock-in:");
		    prodID=s.nextLine();
       		String ID = prodID.toUpperCase();
       		for(int i=0;i<Product.getCountProduct();i++)
   	        {  	        	
   	        	  if(product[i].getProdID().equalsIgnoreCase(ID))
   	        	  {
   	        	  	  found=true;
   	        	  	  System.out.println();
   	        		  System.out.println(product[i].toString()); 
   	        		  x=i;
   	        		  		
   	        	  }
   	        	  
   	        }
   	        
   	       	do {
    			System.out.print("Enter the Stock-In Quantity\t:");
    			
 			   while (!s.hasNextInt()) {       //validate the valid quantity
  			      System.out.println("------------Invalid quantity-----------");
  			      System.out.print("Enter the Stock-In Quantity\t:");
     			  s.next(); // this is important!
  			  }
  			  stockinQtty = s.nextInt();
			} while (stockinQtty <= 0);
   	        
   	      			  	do
	        				{
	        					try
		        				{
		        					System.out.printf("Sure to change?(Y/N)  ");
		        					ask = s.nextLine().charAt(0);
		        					input=true;
		        				}
		        				catch(Exception xe)
		        				{
		        					input=false;
		        					System.out.print("Input the correct input\n");
		        				}
	        				}while(!input);
   	        
	      		
	      		if(Character.toUpperCase(ask) == 'Y')
	        	{
	        		product[x].stockin(stockinQtty);
	        		System.out.println("\nSuccessfully Stock-in quantity ");
	        	}
	        		System.out.println();
		   	       	System.out.println(product[x].toString());
		   	       	
		   	System.out.print("Continue to stock-in Product (Y=yes,(other)=no)? ");
		    ans = s.next().charAt(0);
		    s.nextLine();
   	       
   	        
       		
       		
		}while(Character.toUpperCase(ans)=='Y');
		
		
		
		
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static void generateReport(Product[] product){
		
	Scanner s = new Scanner(System.in);
	int quantity;
	boolean found;
	

		do {
    			System.out.print("---------------------------------------\nEnter the quantity Of Stock\t:");
    			
 			   while (!s.hasNextInt()) {       //validate the valid quantity
  			      System.out.println("------------Invalid quantity-----------");
  			      System.out.print("Quantity\t:");
     			  s.next(); // this is important!
  			  }
  			  quantity = s.nextInt();
			} while (quantity <= 0);
		
		System.out.print("\n--------------------------------------------------\n");
		System.out.print("\t\t\tPRODUCT STOCK LEVEL REPORT\t\t\t\n");
		System.out.print("--------------------------------------------------\n");
		
		for(int i=0;i<Product.getCountProduct();i++)
		{
			if(product[i].getQuantity()<=quantity)
			{
				 found=true;
	   	         System.out.println();
	   	         System.out.println(product[i].toString()); 
			}
				
		}
   	        
	
		System.out.print("--------------------------------------------------\n");
		System.out.print("-REPORT GENERATED-\n");

	
	
	
	
	}
		
		
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static void searchService(Service[] service){
		
	Scanner s = new Scanner(System.in);
       	int search;
       	boolean found;
       do{
	       	found=false;
	       	System.out.println("\nSearch By?");
		    System.out.println("------------");
	        System.out.println("1.SERVICE ID");
	        System.out.println("2.SERVICE NAME");
	        System.out.println("3.PRICE");
	        System.out.println("4.DESCRIPTION");
	        System.out.println("5.BACK");
	   	    System.out.print("Select one (1-5) > ");
	   	       search=s.nextInt();
	   	       s.nextLine();
	   	        if(search==1){
	   	        	System.out.print("Enter The Service ID That You Want To Search:");
	   	        	String searchID=s.nextLine();
	                 String iD=searchID.toUpperCase();
	   	        	for(int i=0;i<Service.getCountSev();i++)
	   	        	{  	        	
	   	        	  if(service[i].getServiceID().equals(iD)){
	   	        	  	  found=true;
	   	        	  	  System.out.println();
	   	        		  System.out.println(service[i].toString());  	
	   	        	  }
	   	           }
	   	        }
	   	        else if(search==2){
	   	        	System.out.print("Enter The Service Name That You Want To Search:");
	   	        	String searchName=s.nextLine();
	   	        	String name=searchName.toUpperCase();
	   	        	for(int i=0;i<Service.getCountSev();i++)
	   	        	{  	        	
	   	        	    if(service[i].getName().equalsIgnoreCase(name)){
	   	        	      found=true;
	   	        	      System.out.println();
	   	        		  System.out.println(service[i].toString());
	   	        	    } 	        	
	   	            }
	   	        }
	   	        else if(search==3){
	   	        	System.out.print("Enter The Service Price That You Want To Search:");
	   	        	double searchPrice=s.nextDouble();
	   	        	for(int i=0;i<Service.getCountSev();i++)
	   	        	{   	        	
	   	        	  if(service[i].getPrice()==searchPrice){
	   	        	  	found=true;
	   	        	  	System.out.println();
	   	        		System.out.println(service[i].toString());
	   	        	  } 	           	        	
	   	        	}
	   	       }
	    	    else if(search==4){
	   	        	  System.out.print("\nEnter The Description That You Want To Search :");
	   	        	  String searchCategory=s.next();
	   	        	  String ctg=searchCategory.toUpperCase();
	   	        	  for(int i=0;i<Service.getCountSev();i++)
	   	        	  {   	        	
	   	        	     if(service[i].getDescription().equalsIgnoreCase(ctg)){
	   	        	      found=true;
	   	        	      System.out.println();
	   	        		  System.out.println(service[i].toString());
	   	        	     } 	           	        	
	   	              }
	   	       }   	       
	   	       	if(found==false&&search!=5)
				System.out.println("Service record not found");	
      }while(search!=5);
		
		
		
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static void showService(Service[] service){
		
			//element header
		System.out.println("\n----------------------------------\nService\n----------------------------------");
		
	
     	for(int i=0;i<Service.getCountSev();i++)
   			System.out.println(service[i].toString());	
   				
   		System.out.println("------------------------------------");
	}
	

}