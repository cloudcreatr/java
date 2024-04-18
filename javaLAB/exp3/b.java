package account1;

import java.util.Scanner;

class Account {
    protected String cname;
    int accno;
    char type;
    int bal;

    public Account() {
        cname = " ";
        accno = 0;
        type = ' ';
        bal = 0;
    }

    void entacc() {
        System.out.println("Enter cname");
        Scanner scan = new Scanner(System.in);
        cname = scan.nextLine();
        System.out.println("Enter Account No");
        accno = scan.nextInt();
        System.out.println("Enter Type");
        type = scan.next().charAt(0);
        System.out.println("Enter Balance");
        bal = scan.nextInt();
    }

    void dispacc() {
        System.out.println("Enter cname" + cname);
        System.out.println("Enter Account No" + accno);
        System.out.println("Enter Type" + type);
        System.out.println("Enter Balance" + bal);
    }

    void deposit() {
        int amt;
        System.out.println("Enter AMT");
        Scanner scan = new Scanner(System.in);
        amt = scan.nextInt();
        bal = bal + amt;
    }
}

class sav_acct extends Account {
    int inter;

    public int comp_int() {
        int time1, rate1;
        rate1 = 10;
        System.out.println("Enter TIME1");
        Scanner scan = new Scanner(System.in);
        time1 = scan.nextInt();
        int inter = (int) (bal * java.lang.Math.pow(1 + rate1 / 100.0, time1) - bal);
        return inter;
    }

    void update_bal() {
        bal = bal + comp_int();
    }

    void withdrawal() {
        int amt;
        System.out.println("Enter amount");
        Scanner scan = new Scanner(System.in);
        amt = scan.nextInt();
        if (bal >= amt) {
            bal = bal - amt;
        } else {
            System.out.println("\n The amount cannot be withdrawn");
        }
    }
}

class cur_acct extends Account {
    int chq_bk;
    int penal;

    public int min_bal() {
        int ret1 = 1;
        if (bal <= 500) {
            penal = 50;
            bal = bal - penal;
            ret1 = 0;
        } else {
            System.out.println("\n No penality imposed");
        }
        return ret1;
    }

    void withdrawal() {
        int amt;
        System.out.println("\n Enter the amount to withdrawn");

        System.out.println("Enter AMT");
        Scanner scan = new Scanner(System.in);
        amt = scan.nextInt();
        int k = min_bal();
        if (k == 1) {
            if (bal >= amt)
                bal = bal - amt;
        } else {
            System.out.println("\n The amount cannot be withdrawn");
        }
    }
}

class b {
    public static void main(String args[]) {
        cur_acct c1 = new cur_acct();
        sav_acct s1 = new sav_acct();
        c1.entacc();
        c1.dispacc();
        c1.deposit();
        c1.dispacc();
        c1.withdrawal();
        c1.dispacc();
        s1.entacc();
        s1.dispacc();
        s1.deposit();
        s1.dispacc();
        s1.withdrawal();
        s1.dispacc();
    }
}
