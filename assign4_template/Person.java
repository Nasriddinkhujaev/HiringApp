//Assign 4, Peron class.
/*
 * CIS2168 Data Structures
 * Section: 002
 * Name: Mukhammad Nasriddinkhujaev
 * Email: tut11887@temple.edu
 * Assignment: Assign 4
 * Program Name: Person.java
 * Program Description: Represents an applicant or employee (current or past).
 * Stores name, degree, and a list of skills. Includes constructor, getters, setters, 
 * and toString() method.
 */

//  Represent an applicant, or an employee

package assign4_template;

import java.util.ArrayList;

public class Person { // new applicants, current employees, past employees

    // Item 3. in Assign 4 Document.

    // define data fields: name, degree, skill list ("Java, C#, C++", etc.)
    private String name;
    private String degree;
    // skill list: must be array list or linked list
    private ArrayList<String> skills;

    // define the constructor with given name, degree, and skill list
    public Person(String name, String degree, ArrayList<String> skills) {
        this.name = name;
        this.degree = degree;
        this.skills = skills;

    }

    // define getters
    public String getName() {
        return name;
    }

    public String getDegree() {
        return degree;
    }

    public ArrayList<String> getSkills() {
        return new ArrayList<>(skills); // returns the copy of the list so they can't change it
    }

    // define setters
    public void setName(String newName) {
        if (newName != null && !newName.isEmpty()) {
            name = newName;
        }
    }

    public void setDegree(String newDegree) {
        degree = newDegree;
    }

    public void setSkills(ArrayList<String> newSkills) {
        skills = new ArrayList<>(newSkills);
    }

    // define toString()

    @Override
    public String toString() {
        return "Name: " + name + "\nDegree: " + degree + "\nSkills: " + skills.toString();
    }

}
