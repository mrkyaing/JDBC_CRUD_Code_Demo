import java.util.Scanner;
public class HRMSTest {
	public static void main(String[] args) {
		DBOperations dboperation=new DBOperations();
		System.out.println("Welcome to HRMS Application");		
		Scanner sc=new Scanner(System.in);	
        int choice=0;
        System.out.println("Please choice to save data (1:save,2:show data,3:Update data,4:Delete data,0:cancel)");
        choice=sc.nextInt();
        if(choice==1) {	
        	sc=new Scanner(System.in);
    		System.out.print("Enter Staff Name:");
            String name=sc.nextLine();
            System.out.print("Enter Salary :");
            double salary=sc.nextDouble();
            sc=new Scanner(System.in);
            System.out.print("Enter Email:");
            String email=sc.nextLine();
            sc=new Scanner(System.in);
            System.out.print("Enter Address:");
            String address=sc.nextLine();
            sc=new Scanner(System.in);
            System.out.print("Enter Phone:");
            String phone=sc.nextLine();
        	dboperation.SaveStaff(name, salary, email, address, phone);
        }
        else if(choice==2) {
        	dboperation.SelectStaff();
        }else if(choice==3) {
        	dboperation.SelectStaff();
        	System.out.print("Enter Staff Id do you want to update:");
        	sc=new Scanner(System.in);
        	int staffid=sc.nextInt();//for where condition
        	//to save data
        	sc=new Scanner(System.in);
    		System.out.print("Enter Staff Name:");
            String name=sc.nextLine();
            System.out.print("Enter Salary :");
            double salary=sc.nextDouble();
            sc=new Scanner(System.in);
            System.out.print("Enter Email:");
            String email=sc.nextLine();
            sc=new Scanner(System.in);
            System.out.print("Enter Address:");
            String address=sc.nextLine();
            sc=new Scanner(System.in);
            System.out.print("Enter Phone:");
            String phone=sc.nextLine();
            //
        	dboperation.UpdateStaff(name, salary, email, address, phone, staffid);
        }else if(choice==4) {
        	dboperation.SelectStaff();
        	System.out.print("Enter Staff Id do you want to Delete:");
        	sc=new Scanner(System.in);
        	int staffid=sc.nextInt();
        	dboperation.DeleteStaff(staffid);
        }
        else {
        	System.out.println("you have been canceled your process!!!");
        }
	}

}
