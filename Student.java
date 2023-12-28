package practicetentaex1;
import java.util.ArrayList;

public class Student {

	private ArrayList<MarkingSheet> theExams;
	private String firstName, secondName;
	
	public Student(String arg1, String arg2) {
		
		firstName = arg1;
		secondName = arg2;
		theExams = new ArrayList<MarkingSheet>();
	}
	
	public String getName() {
		return secondName;
	}
	
	public void addMarkingSheet(MarkingSheet arg) {
		theExams.add(arg);
	}
	
	public String toString() {
		String s = "";
		for (int i = 0; i < theExams.size(); i++) {
			s += theExams.get(i).getExamName() + ", Grade: " + theExams.get(i).getGrade() + "\n";
		}
		return "Student: " + firstName + " " + secondName + "\n" + s + "\n";
	}
}
