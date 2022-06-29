/*
 * Let's create a lightweight, simplified, restaurant reservation system:
 * Our restaurant has 2 tables
 
 * In an input loop, ask the user if they want to check someone in or check someone out
 * If they want to check someone in, check if a table is available.
    * If a table is available, check them in
    * If a table is not available, put them on a waiting list
 * If they want to check someone out:
    * Free one of the table that is taken
    * Immediately assign the table to the next person on the waiting list
 
 * Hints:
    * You can use an array, a list, a map or a queue for your tables - each data structure has pros and cons, but you can make each one work for the list of tables
    * Use a queue for your wait list, as that's the most natural data structure for this type of scenario
    * You may want to use a class named Restaurant that holds both your table list and your waitlist
    * Your Restaurant class will have a method you might call 'checkin' and a method called 'checkout' that will be responsible for implementing the logic we described above
 */

import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
import java.util.PriorityQueue;

public class Main {

    private static Queue<String> waitingList = new PriorityQueue<>(); // stores name of the customer who are in the waiting list
    private static Queue<String> tables = new LinkedList<>(); // stores open tables in a restaurant
    private final static int MAX_TABLES = 2; // restaurant only has two tables

    /*
     * checkIn method addes customer to either table or waiting list depending on the condition 
     * If they want to check someone in, check if a table is available.
     * If a table is available, check them in
     * If a table is not available, put them on a waiting list
     */
    private static void checkIn(Scanner sc) {

            // System.out.println("What is the name of the customer?");
            String customer = "";

            while (customer.equals("")) { // if user doesn't enter name, ask again 
                System.err.print("Enter your name: ");
                customer = sc.nextLine().trim();

            }

            if (tables.size() < MAX_TABLES) { // if there's available table, accomodate a customer
                System.out.println("There is a table you can seat - Please follow me");
                tables.add(customer);
            } else { // otherwise, put a customer into a waiting list
                System.out.println("Table is currently full - Please be seated in the waiting seat");
                waitingList.add(customer);
            }

    }

    /* 
     * checkOut method removes customer from either waiting list or table depending on the condition 
     * Free one of the table that is taken
     * Immediately assign the table to the next person on the waiting list
    */
    private static void checkOut(Scanner sc) {

        // checkout isnot made possible when there is no table occupied
        if (tables.size() < 1) {
            System.out.println("You cannot check-out an empty table!");
            return;
        }

        // if there is a open table and is at least one customer waiting
        // remove a customer from waiting list and direct them to a table
        if (tables.size() <= MAX_TABLES && waitingList.size() > 0) {
            tables.remove();
            tables.add(waitingList.remove());
        } else { // if not, just remove a table
            tables.remove();
        }
    
    }

    /* Main Method */
    public static void main(String[] args) {

        boolean processing = true;
        Scanner sc = new Scanner(System.in);

        while (processing) {

            System.out.println("Enter 1 to CHECK-IN a customer");
            System.out.println("Enter 2 to CHECK-OUT a customer");
            System.out.println("Enter 3 to END");

            try {
            
                int choice = Integer.parseInt(sc.nextLine());
        
                if ( !(choice == 1 || choice == 2 || choice == 3) ) 
                    throw new Exception();
                
                if ( choice == 1 ) {
                    checkIn(sc);
                } else if ( choice == 2 ) {
                    checkOut(sc);
                } else if ( choice == 3 ) {
                    return;
                }
        
                System.out.println("Tables: " + tables);
                System.out.println("Waiting List: " + waitingList);

            } catch (Exception e) {

                System.out.println("Enter a valid number!");
                e.printStackTrace();
                sc.next();
                
            }

        }
        sc.close();
    }

}
