//Assign 4, HiringApp
package assign4_template;

import java.util.ArrayList;
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

    // method for accepting an applicant and return this applicant as a Person object
    public static Person getApplication() {
        
        // display prompt for user to enter an applicant's name
        // get user input
        System.out.println("Enter the name of Applicant: ");
        String newName = input.nextLine();
        // display prompt for user to enter an applicant's degree
        // get user input
        System.out.println("Enter the degree of applicant: ");
        String newDegree = input.nextLine();
        // display prompt for user to enter an applicant's skill list
        // (first how many skills, then enter skill one by one)
        // use a loop to get each skill
        System.out.println("Enter how many skills applicant have: ");
        int numOfSkills = Integer.parseInt(input.nextLine()); // takes the whole line and castes to int, then no need to skip the remaining empty line 
        ArrayList<String> newSkills = new ArrayList<>();
        String skill;
        for (int i = 0; i < numOfSkills; i++) {
            System.out.println("enter skill " + i + ": ");
            skill = input.nextLine();
            newSkills.add(skill);
        }
        // create a Person object using the name, degree, skill list
        // and return this Person object
        Person newPerson = new Person(newName, newDegree, newSkills);


        return newPerson;
    }

    // You can either implement hire and fire functionalities in main(...),
    // or implement them here as separate methods:
    // hire method
    // fire method
}
