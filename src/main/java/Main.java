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

    private static Queue<String> waitingList = new PriorityQueue<>();
    private static Queue<String> tables = new LinkedList<>();
    private final static int MAX_TABLES = 2;

    private static void checkIn(Scanner sc) {

    }

    private static void checkOut(Scanner sc) {

    }

}
