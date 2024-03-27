class Students {
    String name;
    int rollNo;
    String branch;
    String Sem;

    void setData (String n, int r, String b, String s) {
        name = n;
        rollNo = r;
        branch = b;
        Sem = s;
    }
    void showData() {
        System.out.println("Name: "+name);
        System.out.println("Roll No: "+rollNo);
        System.out.println("Branch: "+branch);
        System.out.println("Semester: "+Sem);
    }
}

public class Student{
    public static void main(String[] args) {
        Students s1 = new Students();
        s1.setData("John", 2, "CSE", "3rd");
        s1.showData();
    }
}


