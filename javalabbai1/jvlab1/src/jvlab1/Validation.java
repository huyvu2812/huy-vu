package jvlab1;


import java.util.ArrayList;
import java.util.Scanner;

public class Validation {

    private final static Scanner in = new Scanner(System.in);

    //Ktra gioi han so luong ng dung
    public static int checkInputIntLimit(int min, int max) {
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();

                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number in rage [" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }
        }
    }

    //Ktra chuoi dau vao
    public static String checkInputString() {
        while (true) {
            String result = in.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }

    //Ktra user input yes/ no
    public static boolean checkInputYN() {
        while (true) {
            String result = checkInputString();
            if (result.equalsIgnoreCase("Y")) {
                return true;
            }
            if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.err.println("Please input y/Y or n/N.");
            System.out.print("Enter again: ");
        }
    }

    //Ktra user input u / d
    public static boolean checkInputUD() {
        while (true) {
            String result = checkInputString();
            if (result.equalsIgnoreCase("U")) {
                return true;
            }
            if (result.equalsIgnoreCase("D")) {
                return false;
            }
            System.err.println("Please input u/U or d/D.");
            System.out.print("Enter again: ");
        }
    }

    //ktr khoa hoc cua user
    public static String checkInputCourse() {
        while (true) {
            String result = checkInputString();
            //ktr dau vao khoa hc java/ .net/ c/c++
            if (result.equalsIgnoreCase("java")
                    || result.equalsIgnoreCase(".net")
                    || result.equalsIgnoreCase("c")) {
                return result;
            }
            System.err.println("chi co 3 mon: Java, .Net, C"); // neu sai in cau nay
            System.out.print("Enter again: ");
        }
    }

    //Kiem tra student exist
    public static boolean checkStudentExist(ArrayList<SV> ls, String id,
            String studentName, String semester, String courseName) {
        int size = ls.size();
        for (SV student : ls) {
            if (id.equalsIgnoreCase(student.getId())
                    && studentName.equalsIgnoreCase(student.getStudentName())
                    && semester.equalsIgnoreCase(student.getSemester())
                    && courseName.equalsIgnoreCase(student.getCourseName())) {
                return false;
            }
        }
        return true;
    }

    //Kiem tra report exist
    public static boolean checkReportExist(ArrayList<Report> lr, String name,
            String course, int total) {
        for (Report report : lr) {
            if (name.equalsIgnoreCase(report.getStudentName())
                    && course.equalsIgnoreCase(report.getCourseName())
                    && total == report.getTotalCourse()) {
                return false;
            }
        }
        return true;
    }

    //Kiem tra ID va exit
    public static boolean checkIdExist(ArrayList<SV> ls, String id, String name) {
        for (SV student : ls) {
            if (id.equalsIgnoreCase(student.getId())
                    && !name.equalsIgnoreCase(student.getStudentName())) {
                return false;
            }
        }
        return true;
    }
}
