/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstatm;

import java.util.Scanner;

/**
 *
 * @author miklostoth
 */
public class FirstAtm {

    public static Scanner sc = new Scanner(System.in);
    
    public static String checkID(String acctNum, String pwd)
    {
        String result = "error";

        String a = "1996-02 jelszo1 520.36";
        String b = "1997-01 jelszo2 48.20";
        String c = "1991-08 jelszo3 96.74";

        if (acctNum.equals(a.substring(0, a.indexOf(" "))) && 
                pwd.equals(a.substring(a.indexOf(" ")+1,a.lastIndexOf(" "))))
            return result = a.substring(a.lastIndexOf(" ") + 1);

        if (acctNum.equals(b.substring(0, b.indexOf(" "))) && 
                pwd.equals(b.substring(b.indexOf(" ")+1,b.lastIndexOf(" "))))
            return result = b.substring(b.lastIndexOf(" ") + 1);

        if (acctNum.equals(c.substring(0, c.indexOf(" "))) && 
                pwd.equals(c.substring(c.indexOf(" ") + 1,c.lastIndexOf(" "))))
            return result = c.substring(c.lastIndexOf(" ") + 1);

        return result;
    }

    public static int menu()
    {
        int menuChoice;
        do
        { 
            System.out.print("\nKérem válasszon a következő lehetőségek közül:"
                    + "\n 1. Egyenleglekérdezés \n 2. Befizetés"
                    + "\n 3. Készpénz felvétel\n 4. Kilépés\n\n");

            menuChoice = sc.nextInt();

            if (menuChoice < 1 || menuChoice > 4){
                System.out.println("Hibaüzenet! Érvénytelen kód (Nem létező opció).");
            }

        }while (menuChoice < 1 || menuChoice > 4);

        return menuChoice;
    }

    public static void displayBalance(double x)
    {
        System.out.printf("\nRendelkezésre álló összeg: $%.2f\n", x);
    }

    public static double deposit(double x, double y)
    {
        double depositAmt = y, currentBal = x;
        double newBalance = depositAmt + currentBal;

        System.out.printf("A rendelkezésre álló összeg: $%.2f\n",  newBalance);

        return newBalance;
    }

    public static double withdraw(double x, double y)
    {
        double withdrawAmt = y, currentBal = x, newBalance;

        newBalance = currentBal - withdrawAmt;
        System.out.printf("A rendelkezésre álló összg: %.2f\n",newBalance);

        return newBalance;  
    }

    public static void main(String[] args) {

        String accNum, pass, origBal = "Hibaüzenet!";
        int count = 0, menuOption = 0;
        double depositAmt = 0, withdrawAmt = 0, currentBal=0; 
        boolean  foundNonDigit;
        //loop that will count the number of login attempts
        //you make and will exit program if it is more than 3.
        //as long as oriBal equals an error.  
        do{
            foundNonDigit = false;
            System.out.println("Kérem a használni kívánt kártya számát: ");
            accNum = sc.next();

            System.out.println("Kérem a jelszót: ");
            pass = sc.next();

            origBal = checkID(accNum, pass);

            count++;

            if (count >= 3 && origBal.equals("Hibaüzenet!")){
                System.out.print("Három sikertelen bejelentkezési kísérlet után a kártyáját felfüggesztettük.");
                System.exit(0);
            }
            if (!(origBal.equals("Hibaüzenet!"))){
                System.out.println("\nA rendelkezésre álló összeg: $ "+ origBal);
            }
            else
                System.out.println(origBal);


        }while(origBal.equals("Hibaüzenet!"));

        currentBal=Double.parseDouble(origBal);
        //Itt lehet megadni a parancsokat a menuben..

        while (menuOption != 4)
        { 
            menuOption=menu();
            switch (menuOption)
            {
            case 1:
                displayBalance(currentBal);
                break;
            case 2:
                System.out.print("\nKérem a befizetni kívánt összeget: $ ");
                depositAmt = sc.nextDouble();
                currentBal=deposit(depositAmt, currentBal);
                break;
            case 3:
                System.out.print("\nKérem a felvenni kívánt összeget: $ ");
                withdrawAmt = sc.nextDouble();
                double k = withdrawAmt;
                int x = (int) k;
                double y = 0;
                System.out.println("A kiadott címletek:");
                while(x != 0) {
                
                    y = x / 100;
                if (x != 0) {
                    if (x/100 >= 1) {
                        
                    
                    System.out.println("100$: "+x/100);
                    }
                    else{
                        
                    }
                    x = (int) (x - y*100);
                }
                
                    y = x / 50;
                if (x != 0) {
                    if (x / 50 >= 1) {
                    System.out.println("50$: "+x/50);
                    }
                    else{
                        
                    }
                    x = (int) (x - y*50);
                }
                                
                    y = x / 20;
                if (x != 0) {
                    if (x/20 >= 1) {
                    System.out.println("20$: "+x/20);
                    }
                    else{
                        
                    }
                    x = (int) (x - y*20);
                }
                                                
                    y = x / 10;
                if (x != 0) {
                    if (x/10 >= 1) {
                    System.out.println("10$: "+x/10);
                    }
                    else{
                        
                    }
                    x = (int) (x - y*10);
                }
                                                                
                    y = x / 5;
                if (x != 0) {
                    if (x/5 >= 1) {
                    System.out.println("5$: "+x/5);
                    }
                    else{
                        
                    }
                    x = (int) (x - y*5);
                }
                                                                                
                    y = x / 2;
                if (x != 0) {
                    if (x/2 >= 1) {
                    System.out.println("2$: "+x/2);
                    }
                    else{
                        
                    }
                    x = (int) (x - y*2);
                }
                                                                                                
                    y = x / 1;
                if (x != 0) {
                    if (x/1 >= 1) {
                    System.out.println("1$: "+x/1);
                    }
                    else{
                        
                    }
                    x = (int) (x - y*1);
                }
                }

                while(withdrawAmt>currentBal){
                    System.out.println("HIBA: Fedezethiány! Nincs elegendő összeg a készpénzfelvételhez!");
                    System.out.println("Kérem adjon adja meg az új felvenni kívánt összeget: $");
                            

                    withdrawAmt = sc.nextDouble();
                    
                    
                }

                currentBal = withdraw(currentBal, withdrawAmt);
                break;
            case 4:
                System.out.println("\nKöszönjük, hogy használta a bankunk szolgáltatásait. Viszontlátásra!");
                System.exit(0);
                break;
            }
        }
    }
}