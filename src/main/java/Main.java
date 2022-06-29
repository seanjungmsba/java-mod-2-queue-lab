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
import java.util.InputMismatchException;
import java.util.Queue;
import java.util.PriorityQueue;

public class Main {

    private static Queue<String> waitingList = new PriorityQueue<>(); // stores name of the customer who are in the waiting list
    private static Queue<String> tables = new LinkedList<>(); // stores open tables in a restaurant
    private final static int MAX_TABLES = 2; // restaurant only has two tables

    /*
     * If they want to check someone in, check if a table is available.
     * If a table is available, check them in
     * If a table is not available, put them on a waiting list
     */
    private static void checkIn(Scanner sc) {

        String customer;
        customer = sc.nextLine().trim();
        if (customer.equals("")) { // if user doesn't enter name, ask again 
            System.err.println("Enter your name again.");

            while ( !(sc.nextLine().trim().equals("")) ) // keep asking until valid name is provided 
                customer = sc.nextLine();
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
     * Free one of the table that is taken
     * Immediately assign the table to the next person on the waiting list
    */
    private static void checkOut(Scanner sc) {

        // if there is a open table and is at least one customer waiting
        // remove a customer from waiting list and direct them to a table
        if (tables.size() < MAX_TABLES && waitingList.size() > 0) {
            tables.add(waitingList.remove());
        } else { // if not, just remove a table
            tables.remove();
        }
    
    }

}
