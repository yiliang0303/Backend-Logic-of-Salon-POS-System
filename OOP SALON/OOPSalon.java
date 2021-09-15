/**
 * @(#)OOPSalon.java
 *
 *
 * @author 
 * @version 1.00 2019/8/14
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
public class OOPSalon {

    public OOPSalon() {
    }
    
    public static void main(String[] args)
    {
    	Name[] mName =
    	{
    		new Name("Ong", "YiLiang"),
    		new Name("Lee", "Jia Zhe"),
    		new Name("Wayne", "Chong"),
    		new Name("Melvin", "Tan"),
    		new Name("Ooi", "Ke Yi"),
    		new Name("Mabel", "Heng"),
    		new Name("Xiao", "Ming"),
    		new Name("Ng", "Mei Xin"),
    		new Name("Brian", "Eng"),
    		new Name("Tan", "Siew Mei")
    	};
    	
    	String[] mIcNo =
    	{
    		"000303-07-1093",
    		"001025-07-6549",
    		"000605-07-5465",
    		"000102-07-8713",
    		"001209-07-5112",
    		"010331-07-4658",
    		"990123-07-3211",
    		"981110-07-3482",
    		"021208-07-3211",
    		"020228-07-9758"
    	};
    	
    	Contact[] mContact = 
    	{
    		new Contact("011-16552294", "016-4114899", "ongyiliang13616@gmail.com"),
    		new Contact("010-12345678", "010-1234567", "leejiazhe@hotmail.com"),
    		new Contact("012-13456789", "012-3456789", "waynechong@yahoo.com"),
    		new Contact("013-12456789", "013-4567891", "melvintan@gmail.com"),
    		new Contact("014-12356789", "014-1235678", "ooikeyi@hotmail.com"),
    		new Contact("015-12346789", "015-6789123", "mabelheng@gmail.com"),
    		new Contact("016-12345789", "016-7891234", "xiaoming@yahoo.com"),
    		new Contact("017-12345689", "017-8912345", "ngmeixin@gmail.com"),
    		new Contact("018-12345679", "018-1234567", "brianeng@yahoo.com"),
    		new Contact("019-12345678", "019-1234567", "tansiewmei@hotmail.com")
    	};
    	
    	Address[] mAddress = 
    	{
    		new Address("1-23A-11 HARMONY VIEW", "LINTANG SLIM", "11600", "GEORGETOWN", "MALAYSIA"),
    		new Address("2-04-03 THE LIGHT", "JELUTONG", "11601", "GEORGETOWN", "MALAYSIA"),
    		new Address("1-12-10 DIAMOND VILLA", "JALAN TANJUH", "12345", "TANJUNG BUNGAH", "MALAYSIA"),
    		new Address("1-05-08 AMAN", "TAMAN BAIK", "11500", "GELUGOR", "MALAYSIA"),
    		new Address("1-12-11 TAMAN KHENG TEAN", "LINTANG SLIM", "11600", "GEORGETOWN", "MALAYSIA"),
    		new Address("1-16-12 AMAN", "TAMAN BAIK", "11500", "GELUGOR", "MALAYSIA"),
    		new Address("1-26-13 DIAMOND VILLA", "JALAN TANJUH", "12345", "TANJUNG BUNGAH", "MALAYSIA"),
    		new Address("1-12-11 TAMAN KHENG TEAN", "LINTANG SLIM", "11600", "GEORGETOWN", "MALAYSIA"),
    		new Address("1-03-08 AMAN", "TAMAN BAIK", "11500", "GELUGOR", "MALAYSIA"),
    		new Address("1-23A-10 HARMONY VIEW", "LINTANG SLIM", "11600", "GEORGETOWN", "MALAYSIA")
    	};
    	
    	char[] grade = {'P', 'N', 'D', 'P', 'N', 'D', 'D', 'N', 'P', 'D'};
    	
    	double[] memberPoint = {2035.35,1236,651,831,1056.5,1269,925.3,975.9,540.5,235};
    	
    	ArrayList<Member> member=new ArrayList<Member>();
    	
    	for(int i=0;i<mName.length;i++)
    	{
    		member.add(new Member(mName[i], mIcNo[i], mAddress[i], mContact[i], grade[i]));
    		member.get(i).topUp(memberPoint[i]);
    	}
    	
    	//STAFF
    	Name[] name = 
    	{
    		new Name("Calvin","Lim"),
    		new Name("Tommy","Lu"),
    		new Name("Brian","Wong")
    	};
    	
    	String[] icNo =
    	{
    		"001210020129",
    		"991203040913",
    		"990921010195"
    	};
    	
    	Contact[] contact =
    	{
    		new Contact("0143020994","0164341139","calvinlim@gmail.com"),
    		new Contact("0194157126","0102626003","tommylu@gmail.com"),
    		new Contact("0163939887","0162929838","brianwong@gmail.com")
    	};
    	
    	Address[] address =
    	{
    		new Address("46-8-2, GREENLANE HEIGHTS", "JALAN BESI", "11600", "GEORGETOWN", "MALAYSIA"),
    		new Address("8-07-01, THE LIGHT", "JELUTONG", "11601", "GEORGETOWN", "MALAYSIA"),
    		new Address("96-01-02, KINGFISHERS", "JALAN TANJUH", "12345", "GEORGETOWN", "MALAYSIA"),    		
    	};
    	
    	String[] staffID =
    	{
    		"S18A001",
    		"S18A002",
    		"S18B001"
    	};
    	
    	String[] spass=
    	{
    		"abc123*",
    		"lol@123",
    		"ggez123*"
    	};
    	
    	double[] salary=
    	{
    		2000.00,
    		2000.00,
    		1800.00
    	};
    	
    	ArrayList<Staff> staff=new ArrayList<Staff>();
    	
    	for(int i=0;i<name.length;i++)
    	{
    		staff.add(new Staff(name[i], icNo[i], address[i], contact[i], staffID[i], spass[i], salary[i]));
    	}
    	
    	//PRODUCT AND SERVICE
    	Product[] product = new Product[100];
   		Service[] service = new Service[100];
   		//	create and initialize the info example
   		product[Product.getCountProduct()] = new Product("Colt Badlab","hair wax",55.00,"pz01",40);
   		product[Product.getCountProduct()] = new Product("Oribe Dry Texturizing Spray","hair spray",30.00,"pz02",30);
   		product[Product.getCountProduct()] = new Product("Living Proof Dry Shampoo","hair shampoo",45.00,"pz03",60);
   		product[Product.getCountProduct()] = new Product("Christophe Robin Volumizing Conditioner","hair conditioner",60.00,"pz04",20);
   		   		
   		service[Service.getCountSev()] = new Service("Wash And Cut","hair cut",35.00,"SV01");
   		service[Service.getCountSev()] = new Service("Dye Colour","dye hair colour",89.00,"SV02");
   		service[Service.getCountSev()] = new Service("Hair Styling","style hair",60.00,"SV03");
   		
   		//TRANSACTION
   		//date
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		String stringDate = dateFormat.format(date);

   		//PAYMENT
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

    	int choice;
    	boolean loop = true;
    	SalesPerson.loginScreen(staff);
    	do
    	{
    		choice = selectModule();
    		switch(choice)
    		{
    			case 1: //member
    				Registration.registration(member, product); p("\n");
    				break;
    			case 2: //payment
    				TransactionModule.transactionModule(member, staff, product, service, transaction);
    				break;
    			case 3: //stock
    				ProductAndService.productAndService(product, service); p("\n");
    				break;
    			case 4: //staff
    				SalesPerson.salesPerson(staff); p("\n");
    				break;
    			case 5:
    				//genrateReport;
    				int select = selectReport();
    				switch(select)
    				{
    					case 1:
    						Registration.memberSummaryReport(member);
    						break;
    					case 2:
    						Registration.memberExceptionReport(member);
    						break;
    					case 3: 
    						ProductAndService.generateReport(product);
    						break;
    					case 4:
    						SalesPerson.salesReport(staff);
    						break;
    					default:
    						break;
    				}
    				p("\n");
    				break;
    			default:
    				loop = false;
    				break;
    		}
    	}while(loop);
    }
    
    public static int selectModule()
    {
    	Scanner s = new Scanner(System.in);
    	int choice=0;
    	
    	p("OOP SALON\n---------\n");
    	p("Member Module       : (1)\n");
    	p("Payment             : (2)\n");
    	p("Product AND Service : (3)\n");
    	p("Staffing            : (4)\n");
    	p("Generate Report     : (5)\n");
    	boolean input = false;
    	do
    	{	
    		try
    		{
    			p("Please select an integer : ");
    			choice = s.nextInt();
    			input = true;
    		}
    		catch(Exception ex)
    		{
    			input = false;	
    			p("***Incorrect input : An integer is required***\n\n");
    			s.nextLine();
    		}
    	}while(!input);
    	
    	return choice;
    }
    
    public static int selectReport()
    {
    	Scanner s = new Scanner(System.in);
    	int select=0;
    	
    	p("\nGENERATE REPORT\n---------------\n");
    	p("MEMBER GRADE SUMMARY : (1)\n");
    	p("TOP PURCAHSE MEMBER  : (2)\n");
    	p("STOCK LEVEL          : (3)\n");
    	p("SALES REPORT         : (4)\n");
    	boolean input = false;
    	do
    	{	
    		try
    		{
    			p("Please select an integer : ");
    			select = s.nextInt();
    			input = true;
    		}
    		catch(Exception ex)
    		{
    			input = false;	
    			p("***Incorrect input : An integer is required***\n\n");
    			s.nextLine();
    		}
    	}while(!input);
    	return select;
    }
    
    public static void p(String printing)
    {
    	System.out.print(printing);
    }
}