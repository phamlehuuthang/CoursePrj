/**
 * @ (#) CourseList.java       1.0     26/08/2024
 * <p>
 * Copuright (c) 2024 IUH, All rights reserved
 */
package edu.iuh.fit;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: This class represents a list of courses
 * @auther: Pham Le Huu Thang
 * @date: 26/08/2024
 * @version: 1.0
 */
public class CourseList {
    private Course[] courses;
    private static int count = 0;

    /**
     * Description: Constructor with a parameter to initialize the array of courses with a specific length n
     *
     * @param n The length of the array
     * @throws IllegalArgumentException if n is less than or equal to 0
     */
    public CourseList(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Length of the array must be greater than 0");
        }
        courses = new Course[n];// create an array of n elements
    }

    /**
     * Description: Add a course to the list
     *
     * @param course The course to be added
     * @return true if the course is added successfully, false otherwise
     */
    public boolean addCourse(Course course) {
        // check if course is null
        if (course == null)
            return false;
        //  check if course already exists
        if (exists(course))//Check if id of course duplicate
            return false;
        // check if the array is full
        if (count == courses.length)
            return false;
        courses[count++] = course;
        return true;
    }

    /**
     * Description: Check if a course exists in the list
     *
     * @param course The course to be checked
     * @return true if the course exists, false otherwise
     */
    public boolean exists(Course course) {
        for (int i = 0; i < count; i++) {
            if (courses[i] != null && courses[i].getID().equalsIgnoreCase(course.getID()))
                return true;
        }
        return false;
    }

    public Course[] getCourses() {
        Course[] result = new Course[count];
        System.arraycopy(courses, 0, result, 0, count);
        return courses;
    }

    /**
     * Description: delete a course from the list
     *
     * @return The array contains the courses in the list
     */
    public boolean removeCourse(String id) {
        int info = findLocation(id);
        if (info == -1) {
            return false;
        }
        System.arraycopy(courses, info + 1, courses, info, count - info - 1);
        return true;
    }

    /**
     * Description: Find the location of the Course
     *
     * @return The array contains the courses in the list
     */
    private int findLocation(String id) {
        for (int i = 0; i < count; i++) {
            if (courses[i].getID().equalsIgnoreCase(id)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Description: serach a course by department
     * @param department The department of the course
     * @return The array contains the courses in the list with the department
     */
    public Course[] searchByDepartment(String department) {
        int cnt = 0,index = 0;
        for (int i = 0; i < count; i++) {
            if (courses[i].getDepartment().equalsIgnoreCase(department)) {
                cnt++;
            }
        }
        Course[] result = new Course[cnt];
        for (int i = 0; i < count; i++) {
            if (courses[i].getDepartment().equalsIgnoreCase(department)) {
                result[index++] = courses[i];
            }
        }
        if (cnt == 0) {
            return null;
        }
        return result;
    }

    /**
     * Description: serach a course by credit
     * @param id The credit of the course
     * @return The array contains the courses in the list with the credit
     */
    public Course searchByID(String id) {
        for (int i = 0; i < count; i++) {
            if (courses[i].getID().equalsIgnoreCase(id)) {
                return courses[i];
            }
        }
        return null;
    }

    /**
     * Description: serach a course by title
     * @param title The title of the course
     * @return The array contains the courses in the list with the title
     */
    public Course[] searchByTitle(String title) {
        int cnt = 0,index = 0;
        for (int i = 0; i < count; i++) {
            if (courses[i].getTitle().equalsIgnoreCase(title)) {
                cnt++;
            }
        }
        Course[] result = new Course[cnt];
        for (int i = 0; i < count; i++) {
            if (courses[i].getTitle().equalsIgnoreCase(title)) {
                result[index++] = courses[i];
            }
        }
        if (cnt == 0) {
            return null;
        }
        return result;
    }

    /**
     * Description: sort the courses by Title
     * @return The array contains the courses in the list sorted by title
     */
    public Course[] sortCourseByTitle() {
        Course temp;
        for(int i = 0;i < count;i++){
            for(int j = i + 1;j < count;j++){
                if(courses[i].getTitle().compareTo(courses[j].getTitle()) > 0){
                    temp = courses[i];
                    courses[i] = courses[j];
                    courses[j] = temp;
                }
            }
        }
        return courses;
    }

    /**
     * Description: Find the list of Courses with the most credit
     * @return The array contains the courses in the list with the most credit
     */
    public Course[] findMaxCredit(){
        int max = 0,index = 0;
        Course[] temp = new Course[count];
        for(int i = 0;i < count;i++){
            if(courses[i].getCredit() > max){
                max = courses[i].getCredit();
            }
        }
        for(int i = 0; i<count;i++){
            if(courses[i].getCredit() == max){
                temp[index++] = courses[i];
            }
        }
        return temp;
    }

    /**
     * Description: Find the department with the most courses
     * @return The department with the most courses
     */
    public String findDepartmentWithMostCourses(){
        String[] departments = new String[courses.length];
        int[] countDepartment = new int[courses.length];
        int uniqueDepartments = 0;
        for(Course cs : courses) {
            if(cs != null){
                String dep = cs.getDepartment();
                int index = findDepartmentIndex(departments,uniqueDepartments,dep);
                if(index == -1){
                    departments[uniqueDepartments] = dep;
                    countDepartment[uniqueDepartments] = 1;
                    uniqueDepartments++;
                }else{
                    countDepartment[index]++;
                }
            }
        }
        int maxIndex = 0;
        for(int i = 0; i < count;i++){
            if(countDepartment[i] > countDepartment[maxIndex]){
                maxIndex = i;
            }
        }
        return departments[maxIndex];
    }

    /**
     * Description: Find the index of the department
     * @return The index of the department
     */
    private int findDepartmentIndex(String[] departments, int uniqueDepartments, String dep) {
        for (int i = 0; i < count; i++) {
            if(departments[i].equalsIgnoreCase(dep)){
                return i;
            }
        }
        return -1;
    }
}