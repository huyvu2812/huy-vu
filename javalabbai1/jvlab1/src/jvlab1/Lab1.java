package jvlab1;

import java.util.ArrayList;

public class Lab1 {

    public static void main(String[] args) {
        ArrayList<SV> ls = new ArrayList<>();
        Validation validation = new Validation();
        int count = 3;
        while (true) {
            
        	Qly.menu();
            int choice = Validation.checkInputIntLimit(1, 5);
            switch (choice) {
                case 1:
                    Qly.createStudent(count, ls);
                    break;
                case 2:
                	Qly.findAndSort(ls);
                    break;
                case 3:
                	Qly.updateOrDelete(count, ls);
                    break;
                case 4:
                	Qly.report(ls);
                    break;
                case 5:
                    return;
            }

        }
    }
}
