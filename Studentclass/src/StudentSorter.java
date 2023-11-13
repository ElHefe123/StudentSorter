import java.util.ArrayList;
import java.util.Comparator;

class Student {
    int rollno;
    String name;
    String address;

    public Student(int rollno, String name, String address) {
        this.rollno = rollno;
        this.name = name;
        this.address = address;
    }
}

class NameComparator implements Comparator<Student> {
    public int compare(Student s1, Student s2) {
        return s1.name.compareTo(s2.name);
    }
}

class RollNoComparator implements Comparator<Student> {
    public int compare(Student s1, Student s2) {
        return s1.rollno - s2.rollno;
    }
}

public class StudentSorter {
    public static void selectionSort(ArrayList<Student> students, Comparator<Student> comparator) {
        int n = students.size();

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (comparator.compare(students.get(j), students.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }
            Student temp = students.get(i);
            students.set(i, students.get(minIndex));
            students.set(minIndex, temp);
        }
    }

    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();

        students.add(new Student(1, "John", "123 Main Street"));
        students.add(new Student(2, "Alice", "456 Elm Street"));
        // Add more student objects here...

        System.out.println("Before sorting:");
        for (Student student : students) {
            System.out.println(student.name + " - " + student.rollno);
        }

        selectionSort(students, new NameComparator());
        System.out.println("\nAfter sorting by name:");
        for (Student student : students) {
            System.out.println(student.name + " - " + student.rollno);
        }

        selectionSort(students, new RollNoComparator());
        System.out.println("\nAfter sorting by roll number:");
        for (Student student : students) {
            System.out.println(student.name + " - " + student.rollno);
        }
    }
}