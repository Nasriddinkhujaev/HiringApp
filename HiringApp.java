//Assign 4, HiringApp
package assign4_template;

import java.util.Scanner;

public class HiringApp {

    static Scanner input = new Scanner(System.in); // scanner to read user input and its static inside the class so it can be reached anywhere in the file
    public static int choice = 0;

    public static void main(String[] args) {

        // Define the data structures for 3 different groups of people:
        // new applicants
        // current employees (those who were hired),
        // past employees (those who were fired)
        //
        // Hint: for queue: Queue<Person>, ArrayDeque, LinkedList
        // for stack: Deque<Person> ArrayDeque, LinkedList

        // display the menu

        // get the menu choice
        // process user selected service request.

        // loop until the user decides to quit.

    }

    // other methods for code modularization
    // method for getting user choice
    public static int getChoice() { // maybe done ------------------------- user choice in main

        // display the menu
        System.out.println("Action (1 to accept, 2 to hire, 3 to fire): ");
        // get user choice
        String strChoice = input.nextLine();
        choice = Integer.parseInt(strChoice);
        // return user choice as an integer
        return choice;
    }

    // method for accepting an applicant and reurn this applicant as a Person object
    public static Person getApplication() {
        // display prompt for user to enter an applicant's name
        // get user input

        // display prompt for user to enter an applicant's degree
        // get user input

        // display prompt for user to enter an applicant's skill list
        // (first how many skills, then enter skill one by one)
        // use a loop to get each skill

        // create a Person object using the name, degree, skill list
        // and return this Person object

        return null;
    }

    // You can either implement hire and fire functionalities in main(...),
    // or implement them here as separate methods:
    // hire method
    // fire method
}
