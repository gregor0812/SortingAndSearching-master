package ClassroomAssingment;

import java.util.ArrayList;

import static ClassroomAssingment.Merge.merge;
import static ClassroomAssingment.Merge.sort;
import static ClassroomAssingment.Schudder.schud;

public class Main {
	private static final int STUDENTS = 20;
	
	private int ree = 1232333342;
	static BST bst = new BST();

	
	public static void main(String[] args) {
		// write your code here
		

		
		long before = System.currentTimeMillis();
		Student[] students = new Student[STUDENTS];
		ArrayList<Student> st = new ArrayList();
		for(int i=0; i<STUDENTS; i++){
			int studentnummer = 50080001;
			studentnummer = (studentnummer+i);
			students[i] = new Student(studentnummer);
			st.add(students[i]);

		}

		schud(students);
		sort(students);
		for(int i=0; i<STUDENTS; i++){
			System.out.println(students[i].getCijfer()+"  "+students[i].getStudentNummer());
			bst.put(students[i].getCijfer(),students[i].getStudentNummer());
		}
		Long after = System.currentTimeMillis();
		System.out.println(after-before);

		System.out.println(bst.get(5));





		
	}
	
}

