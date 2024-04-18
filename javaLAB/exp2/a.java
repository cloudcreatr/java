package javaLAB.exp2;

public class a {
    int rollno;
    String name;
    String branch;
    String sem;

    void getdata(int r, String n, String b, String s) {
        rollno = r;
        name = n;
        branch = b;
        sem = s;
    }

 void displaydata(){System.out.println(“Rollno=”+rollno+" "+”Name=”+name+”Branch=”+branch+”Sem=”+sem);}

    class TestStudent4 {
 public static void main(String args[]){  
  a s1=new a();  
  a s2=new a();  
  s1.getdata (111,"Karan","Computer","third");  
  s2.getdata (222,"Aryan","ETC","fourth");  
  s1.displaydata();  
  s2.displaydata ();  
 }
}
