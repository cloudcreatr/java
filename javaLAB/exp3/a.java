import java.io.IOException;
import java.io.Scanner;
class  person
{
	private
		String name;
		int age;
		String address;
	public
		void get_pdata ( )
		{
			Scanner s=new Scanner(System.in);
			System.out.println("Enter the name:");
			name=in.nextLine();
			System.out.println("\nEnter the address:");
			address=in.nextLine();
		}
		void put_pdata ( )
		{
			System.out.println("Name: "+name);
			System.out.println("\nAddress: "+address);
		}
}
class student extends person
{
	private
		int rollno;
		float marks;
	public
		void get_stdata ( )
		{
			get_pdata ( );
			Scanner s=new Scanner(System.in);
			System.out.println("Enter the Roll no:");
			rollno=in.nextInt();
			System.out.println("\nEnter the Marks:");
			marks=in.nextInt();
		}
		void put_stdata ( )
		{
			System.out.println("Roll no: "+rollno);
			System.out.println("\nMarks: "+marks);
		}
}

class faculty extends person
{
	private
		String dept;
		float salary;
	public
		void get_fdata ( )
		{
			get_pdata ( );
			Scanner s=new Scanner(System.in);
			System.out.println("Enter the Department:");
			dept=in.nextLine();
			System.out.println("\nEnter the Salary:");
			salary=in.nextFloat();
		}
		void put_fdata ( )
		{
			put_pdata ( );
			System.out.println("Roll no: "+rollno);
			System.out.println("\nMarks: "+marks);
		}
}
class a
{
public static void main(String args[]) 
{
	student stobj=new student();
	faculty facobj=new faculty();
	System.out.println("Enter the details of the student:\n");
	stobj.get_stdata( );
	System.out.println("\nEnter the details of the faculty member:\n");
	facobj.get_fdata( );
	System.out.println("\nStudent info is:\n");
	stobj.put_stdata( );
	System.out.println("\nFaculty Member info is:\n");
	facobj.put_fdata( );
    
}
}
