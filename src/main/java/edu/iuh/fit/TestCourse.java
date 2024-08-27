/**
 * @ (#) TestCourse.java       1.0     26/08/2024
 * <p>
 * Copuright (c) 2024 IUH, All rights reserved
 */
package edu.iuh.fit;

import java.util.Scanner;

/**
 * @description:
 * @auther: Pham Le Huu Thang
 * @date: 26/08/2024
 * @version: 1.0
 */
public class TestCourse {
    /**
     * The main method of the program.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        CourseList courseList = new CourseList(10);
        Course course1 = new Course("FIT101", "Java Programming", 3, "FIT");
        Course course2 = new Course("FIT102", "Web Programming", 3, "FIT");
        Course course3 = new Course("FIT103", "Database Programming", 3, "FIT");
        Course course4 = new Course("FIT104", "Mobile Programming", 3, "FIT");
        Course course5 = new Course("FIT105", "Software Engineering", 3, "FIT");
        Course course6 = new Course("FIT106", "Data Science", 3, "FIT");
        Course course7 = new Course("FIT107", "Machine Learning", 3, "FIT");
        Course course8 = new Course("FIT108", "Artificial Intelligence", 3, "FIT");
//        Course course9 = new Course("FIT109", "Computer Vision", 3, "FIT");
//        Course course10 = new Course("FIT110", "Natural Language Processing", 3, "FIT");

        courseList.addCourse(course1);
        courseList.addCourse(course2);
        courseList.addCourse(course3);
        courseList.addCourse(course4);
        courseList.addCourse(course5);
        courseList.addCourse(course6);
        courseList.addCourse(course7);
        courseList.addCourse(course8);
        Course[] courses;

        int choice;

        do{
            System.out.println("1. Add courses");
            System.out.println("2. Print course list");
            System.out.println("3. Delete course");
            System.out.println("4. Find science by title");
            System.out.println("5. Find courses by department");
            System.out.println("6. Find courses by id");
            System.out.println("7. Course arrangement");
            System.out.println("8. Find the course with the highest credit rating");
            System.out.println("9. Find the department with the most courses");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            choice=sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1:
                    System.out.println("Enter the ID of the course: ");
                    String id = sc.nextLine();
                    System.out.println("Enter the title of the course: ");
                    String title = sc.nextLine();
                    System.out.println("Enter the credit of the course: ");
                    int credit = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter the department of the course: ");
                    String department = sc.nextLine();
                    Course course = new Course(id, title, credit, department);
                    courseList.addCourse(course);
                    break;
                case 2:
                    System.out.println("Course List");
                    System.out.println("-------------------------------------------------------------");
                    System.out.println(String.format("%-10s%-30s%2s %-10s", "ID", "Title", "Credit", "Department"));
                    System.out.println("-------------------------------------------------------------");
                    for (Course c : courseList.getCourses()) {
                        if (c != null)
                            System.out.println(c);
                    }
                    System.out.println("-------------------------------------------------------------");
                    break;
                case 3:
                    System.out.println("Enter the ID of the course you want to delete: ");
                    String idDelete = sc.nextLine();
                    if(courseList.removeCourse(idDelete)){
                        System.out.println("Delete successfully");
                    }else{
                        System.out.println("Delete failed");
                    }
                    break;
                case 4:
                    System.out.println("Enter the title of the course you want to find: ");
                    String titleFind = sc.nextLine();
                    courses = courseList.searchByTitle(titleFind);
                    System.out.println("||-----------------------------------------------------||");
                    for(Course cs : courses) {
                        System.out.println("|"+cs.toString()+"|");
                    }
                    System.out.println("||-----------------------------------------------------||");
                    break;
                case 5:
                    System.out.println("Enter the department of the course you want to find: ");
                    String departmentFind = sc.nextLine();
                    courses = courseList.searchByDepartment(departmentFind);
                    System.out.println("||-----------------------------------------------------||");
                    for(Course cs : courses) {
                        System.out.println("|"+cs.toString()+"|");
                    }
                    System.out.println("||-----------------------------------------------------||");
                    break;
                case 6:
                    System.out.println("Enter the ID of the course you want to find: ");
                    String idFind = sc.nextLine();
                    Course courseFind = courseList.searchByID(idFind);
                    System.out.println("||-----------------------------------------------------||");
                    System.out.println("|"+courseFind.toString()+"|");
                    System.out.println("||-----------------------------------------------------||");
                    break;
                case 7:
                    courses =courseList.sortCourseByTitle();
                    System.out.println("||-----------------------------------------------------||");
                    for(Course cs : courses) {
                        if(cs != null)
                            System.out.println("|"+cs.toString()+"|");
                    }
                    System.out.println("||-----------------------------------------------------||");
                    break;
                case 8:
                    courses = courseList.findMaxCredit();
                    System.out.println("||-----------------------------------------------------||");
                    System.out.println("|"+courses.toString()+"|");
                    System.out.println("||-----------------------------------------------------||");
                    break;
                case 9:
                    department = courseList.findDepartmentWithMostCourses();
                    System.out.println("The department with the most courses is : " + department);
                    break;
                default:
            }
        }while (choice != 0);
        sc.close();
    }
}
