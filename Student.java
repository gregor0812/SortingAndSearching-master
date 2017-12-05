package ClassroomAssingment;

/**
 * Created by Gregor on 03/12/2017.
 */
import java.util.Random;

/**
 * Created by Gregor on 22/10/2017.
 */
public class Student implements Comparable<Student>
{
	public int getStudentNummer()
	{
		return studentNummer;
	}
	
	private int studentNummer;
	private int cijfer;
	Random generator = new Random();
	int min = 1;
	int max = 10;
	
	public Student(int studentnummer)
	{
		studentNummer = studentnummer;
		cijfer = (int) ((generator.nextInt((max-min)*10+1)+min*10) / 10.0);
	}
	
	public int getCijfer()
	{
		return cijfer;
	}
	
	@Override
	public int compareTo(final Student student)
	{
		return Integer.compare(this.getStudentNummer(),student.getStudentNummer());
	}
}