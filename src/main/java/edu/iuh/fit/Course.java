/**
 * @ (#) Course.java       1.0     26/08/2024
 * <p>
 * Copuright (c) 2024 IUH, All rights reserved
 */
package edu.iuh.fit;

/**
 * @description: This class represents the information of a course
 * @auther: Pham Le Huu Thang
 * @date: 26/08/2024
 * @version: 1.0
 */
public class Course {
    private String ID;
    private String title;
    private int credit;
    private String department;

    /**
     * * Description: Default constructor
     */
    public Course() {
    }

    /**
     * * Description: Constructor with parameters
     * @param ID The ID of the course
     * @param title The title of the course
     * @param credit The credit of the course
     * @param department The department of the course
     */
    public Course(String ID, String title, int credit, String department) {
        this.ID = ID;
        this.title = title;
        this.credit = credit;
        this.department = department;
    }

    /**
     * * Description: Get the title of the course
     * @return The title of the course
     */
    public String getID() {
        return ID;
    }

    /**
     * * Description: Set the ID of the course
     * @param ID The ID of the course
     * @throws IllegalArgumentException if ID is null or has less than 3 characters or contains non-alphanumeric characters
     */
    public void setID(String ID) {
        if(ID == null || ID.length() < 3){
            throw new IllegalArgumentException("ID must be at least 3 characters");
        }
        for(int i = 0; i < ID.length();i++){
            if(!Character.isLetterOrDigit(ID.charAt(i))){
                throw new IllegalArgumentException("ID must be alphanumeric");
            }
        }
        this.ID = ID;
    }

    /**
     * * Description: Get the title of the course
     * @return The title of the course
     */
    public String getTitle() {
        return title;
    }

    /**
     * * Description: Set the title of the course
     * @param title The title of the course
     * @throws IllegalArgumentException if title is null or empty
     */
    public void setTitle(String title) {
        if(title == null || title.isEmpty()){
            throw new IllegalArgumentException("Title must not be empty");
        }
        this.title = title;
    }

    /**
     * * Description: Get the department of the course
     * @return The department of the course
     */
    public int getCredit(){
        return credit;
    }

    /**
     * * Description: Set the credit of the course
     * @param credit The credit of the course
     * @throws IllegalArgumentException if credit is less than 0
     */
    public void setCredit(int credit){
        if(credit < 0){
            throw new IllegalArgumentException("Credit must be greater than 0");
        }
        this.credit = credit;
    }

    /**
     * * Description: Get the department of the course
     * @return The department of the course
     */
    public String getDepartment() {
        return department;
    }

    /**
     * * Description: Set the department of the course
     * @param department The department of the course
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString(){
        return String.format("%-10s%-30s%4d%-10s", ID, title, credit, department);
    }
}
