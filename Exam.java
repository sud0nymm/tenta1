package practicetentaex1;
import java.util.ArrayList;

public class Exam {

	private String name;
	private int code, minpoints, maxpoints;
	private ArrayList<MarkingSheet> markedStudents;

	public Exam(String arg1, int arg2, int arg3, int arg4) {
		name = arg1;
		code = arg2;
		minpoints = arg3;
		maxpoints = arg4;
		markedStudents = new ArrayList<MarkingSheet>();
	}

	public int getMaxPoints() {
		return maxpoints;
	}
	
	public int getMinPoints() {
		return minpoints;
		
	}
	
	public int getCode() {
		return code;
	}
	
	public String getName() {
		return name;
	}
	
	public void addMarkedStudents(MarkingSheet arg) {
		markedStudents.add(arg);
	}
	
	public String toString() {
		String s = String.format("%12s, Code: %d, Maximum points: %2d, Minimum points: %2d", name, code , maxpoints, minpoints);
		s += "\n";
		for (MarkingSheet ms : markedStudents) {
			s += ms + "\n";;
		}
		return s;
	}

	
}
