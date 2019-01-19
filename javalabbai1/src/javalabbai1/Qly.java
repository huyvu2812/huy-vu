package javalabbai1;
import java.util.ArrayList;
import java.util.Collections;



public class Qly {

    //menu
    public static void menu() {
        System.out.println(" 1.	Create");
        System.out.println(" 2.	Find and Sort");
        System.out.println(" 3.	Update/Delete");
        System.out.println(" 4.	Report");
        System.out.println(" 5.	Exit");
        System.out.print(" Enter your choice: ");
    }

    // Tao SV moi
    public static void createStudent(int count, ArrayList<SV> ls) {
        if (count > 10) {
            System.out.print("Do you want to continue (Y/N): ");
            if (!Validation.checkInputYN()) {
                return;
            }
        }
        //chay vong lap cho den khi dau vao ko trung lap
        while (true) {
            System.out.print("Enter id: ");
            String id = Validation.checkInputString();
            System.out.print("Enter name student: ");
            String name = Validation.checkInputString();
            if (!Validation.checkIdExist(ls, id, name)) {
                System.err.println("Id has exist student. Pleas re-input.");
                continue;
            }
            System.out.print("Enter semester: ");
            String semester = Validation.checkInputString();
            System.out.print("Enter name course: ");
            String course = Validation.checkInputCourse();
            //Kiem Tra
            if (Validation.checkStudentExist(ls, id, name, semester, course)) {
                ls.add(new SV(id, name, semester, course));
                count++;
                System.out.println("Add student success.");
                return;
            }
            System.err.println("Duplicate.");

        }
    }
    //TIM KIEM VA SAP XEP
    public static void findAndSort(ArrayList<SV> ls) {
        //Kiem Tra DS Trong
        if (ls.isEmpty()) {
            System.err.println("List empty.");
            return;
        }
        ArrayList<SV> listStudentFindByName = listStudentFindByName(ls);
        if (listStudentFindByName.isEmpty()) {
            System.err.println("Not exist.");
        } else {
            Collections.sort(listStudentFindByName);
            System.out.printf("%-15s%-15s%-15s\n", "Student name", "semester", "Course Name");
            //vong lap
            for (SV student : listStudentFindByName) {
                student.print();
            }
        }
    }
    //DS sinh vien duoc tim thay theo ten da nhap
    public static ArrayList<SV> listStudentFindByName(ArrayList<SV> ls) {
        ArrayList<SV> listStudentFindByName = new ArrayList<>();
        System.out.print("Enter name to search: ");
        String name = Validation.checkInputString();
        for (SV student : ls) {
            //Ktr Ten SV
            if (student.getStudentName().contains(name)) {
                listStudentFindByName.add(student);
            }
        }
        return listStudentFindByName;
    }
    //update and delete   
    public static void updateOrDelete(int count, ArrayList<SV> ls) {
        //neu list nay trong thi in ra  " ds nay trong
        if (ls.isEmpty()) {
            System.err.println("List nay trong !!!!.");
            return;
        }
        System.out.print("Enter id: ");
        String id = Validation.checkInputString();
        ArrayList<SV> listStudentFindByName = getListStudentById(ls, id);
        //kiem tra ds trong
        if (listStudentFindByName.isEmpty()) {
            System.err.println("khong tim thay sinh vien nay.");
            return;
        } else {
            SV student = getStudentByListFound(listStudentFindByName);
            System.out.print("Do you want to update (U) or delete (D) student: ");
            //kiem tra user ban muon update or delete
            if (Validation.checkInputUD()) {
                System.out.print("Enter name student: ");
                String name = Validation.checkInputString();
                System.out.print("Enter semester: ");
                String semester = Validation.checkInputString();
                System.out.print("Enter name course: ");
                String course = Validation.checkInputCourse();
                //kiem tra chuc nang
                if (Validation.checkStudentExist(ls, id, name, course, semester)) {
                    student.setStudentName(name);
                    student.setCourseName(course);
                    student.setSemester(semester);
                    
                    System.err.println("Update thanh cong!!!.");
                }
                return;
            } else {
                ls.remove(student);
                count--;
                System.err.println("xoa thanh cong!!!!.");
                return;
            }
        }
    }

    //nhap sv ban muon update/delete trong ds dc tiem thay
    public static SV getStudentByListFound(ArrayList<SV> listStudentFindByName) {
        System.out.println("List student found: ");
        int count = 1;
        System.out.printf("%-10s%-15s%-15s%-15s\n", "Number", "Student name",
                "semester", "Course Name");
        //ds sv duoc tim thay
        for (SV student : listStudentFindByName) {
            System.out.printf("%-10d%-15s%-15s%-15s\n", count,
                    student.getStudentName(), student.getSemester(),
                    student.getCourseName());
            count++;
        }
        System.out.print("Enter student: ");
        int choice = Validation.checkInputIntLimit(1, listStudentFindByName.size());
        return listStudentFindByName.get(choice - 1);
    }

    //danh sach sv tiem theo ID
    public static ArrayList<SV> getListStudentById(ArrayList<SV> ls, String id) {
        ArrayList<SV> getListStudentById = new ArrayList<>();
        for (SV student : ls) {
            if (id.equalsIgnoreCase(student.getId())) {
                getListStudentById.add(student);
            }
        }
        return getListStudentById;
    }

    //In report
    public static void report(ArrayList<SV> ls) {
        if (ls.isEmpty()) {
            System.err.println("List empty.");
            return;
        }
        ArrayList<Report> lr = new ArrayList<>();
        int size = ls.size();
        for (int i = 0; i < size; i++) {
            int total = 0;
            for (SV student1 : ls) {
                for (SV student2 : ls) {
                    if (student1.getId().equalsIgnoreCase(student2.getId())
                            && student1.getCourseName().equalsIgnoreCase(student2.getCourseName())) {
                        total++;
                    }
                }
                if (Validation.checkReportExist(lr, student1.getStudentName(),
                        student1.getCourseName(), total)) {
                    lr.add(new Report(student1.getStudentName(),
                            student1.getCourseName(), total));
                }
            }
        }
        //print report
        for (int i = 0; i < lr.size(); i++) {
            System.out.printf("%-15s|%-10s|%-5d\n", lr.get(i).getStudentName(),
                    lr.get(i).getCourseName(), lr.get(i).getTotalCourse());
        }
    }
}

