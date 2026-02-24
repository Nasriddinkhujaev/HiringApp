//Assign 4, HiringApp
/*
 * CIS2168 Data Structures
 * Section: 002
 * Name: Mukhammad Nasriddinkhujaev
 * Email: tut11887@temple.edu
 * Assignment: Assign 4
 * Program Name: HiringApp.java
 * Program Description: Implements a hiring/firing system using Queue and Stack.
 * Supports accepting new applicants, hiring (rehiring past employees first), firing,
 * and quitting. Uses a menu-driven interface and stores applicants, current employees, 
 * and past employees in appropriate data structures.
 */
package assign4_template;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList; // for applicants
import java.util.Queue; // for current and past employees (stack behavior)
import java.util.Scanner; // can implement Queue or Deque

public class HiringApp {

    static Scanner input = new Scanner(System.in); // scanner to read user input and its static inside the class so it
                                                   // can be reached anywhere in the file
    public static int choice = 0;

    // Applicants waiting to be hired (FIFO)
    static Queue<Person> applicants = new LinkedList<>();

    // Current employees (most recently hired at the top) → Stack behavior
    static Deque<Person> currentEmployees = new ArrayDeque<>();

    // Past employees (most recently fired at the top) → Stack behavior
    static Deque<Person> pastEmployees = new ArrayDeque<>();

    public static void main(String[] args) {

        // Define the data structures for 3 different groups of people:
        // new applicants
        // current employees (those who were hired),
        // past employees (those who were fired)
        //
        // Hint: for queue: Queue<Person>, ArrayDeque, LinkedList
        // for stack: Deque<Person> ArrayDeque, LinkedList

        // display the menu
        printMenu();
        // get the menu choice
        choice = getChoice();
        // process user selected service request.
        // loop until the user decides to quit.
        while (choice != 4) {
            if (choice == 1) {
                // accept an applicant and add this applicant to the queue of applicants
                Person newApplicant = getApplication();
                applicants.offer(newApplicant);
            } else if (choice == 2) {
                // hire an employee from the queue of applicants and add this employee to the
                // stack of current employees
                hire();
            } else if (choice == 3) {
                // fire an employee from the stack of current employees and add this employee to
                // the stack of employees
                fire();
            }
            printMenu();
            choice = getChoice();
        }
    }

    // other methods for code modularization
    // method for getting user choice
    public static int getChoice() {

        // get user choice
        String strChoice = input.nextLine();
        choice = Integer.parseInt(strChoice);
        // return user choice as an integer
        return choice;
    }

    // method for accepting an applicant and return this applicant as a Person
    // object
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
        int numOfSkills = Integer.parseInt(input.nextLine()); // takes the whole line and castes to int, then no need to
                                                              // skip the remaining empty line
        ArrayList<String> newSkills = new ArrayList<>();
        String skill;
        for (int i = 0; i < numOfSkills; i++) {
            System.out.println("enter skill " + (i + 1) + ": ");
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

    public static void hire() {

        if (!pastEmployees.isEmpty()) {
            Person hiredPerson = pastEmployees.pop(); // get the most recent past employee from the stack
            currentEmployees.push(hiredPerson); // add the hired person to the stack of current employees
            System.out.println("Hired: " + hiredPerson.getName() + " - " + hiredPerson.getDegree() + " - "
                    + hiredPerson.getSkills());
        } else {
            if (!applicants.isEmpty()) {
                Person hiredPerson = applicants.poll(); // get the next applicant from the queue
                currentEmployees.push(hiredPerson); // add the hired person to the stack of current employees
                System.out.println("Hired: " + hiredPerson.getName() + " - " + hiredPerson.getDegree() + " - "
                        + hiredPerson.getSkills());
            } else if (applicants.isEmpty()) {
                System.out.println("Memo to supervisor: There is nobody to hire");
            }
        }
    }

    public static void fire() {
        if (!currentEmployees.isEmpty()) {
            Person firedPerson = currentEmployees.pop(); // fire the least senior person from the stack
            System.out.println("Fired: " + firedPerson.getName() + " - " + firedPerson.getDegree() + " - "
                    + firedPerson.getSkills());
            pastEmployees.push(firedPerson); // add the fired person to the stack of past employees
        } else if (currentEmployees.isEmpty()) {
            System.out.println("Memo to supervisor: There is nobody to fire");
        }
    }

    public static void printMenu() {
        System.out.println("1. Accept Applicant");
        System.out.println("2. Hire Employee");
        System.out.println("3. Fire Employee");
        System.out.println("4. Quit");
    }

}