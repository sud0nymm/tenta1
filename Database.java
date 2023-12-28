package practicetentaex1;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Database {

	private ArrayList<Student> allStudents;
	private ArrayList<Exam> allExams = new ArrayList<Exam>();;
	private Scanner consoleReader;
	
	public Database() {
		allStudents = new ArrayList<Student> ();
		consoleReader = new Scanner(System.in); 
	}
	
	public void addStudent(String arg1, String arg2) {
		allStudents.add(new Student(arg1, arg2));
	}
	
	public String loadStudents(String arg1, int arg2) {
		
		String s = String.format("Loaded %2d Students", arg2);
		
		BufferedReader reader;
		try {
		reader = new BufferedReader(new FileReader(arg1));
		String line = reader.readLine();
		do {
			line.trim();
			String[] d = line.split(" ");
			addStudent(d[0], d[1]);
			line = reader.readLine();
			
		} while(line != null);
		
		reader.close();
		} catch(IOException ie) {
			s = "Something went wrong";
		}

		return s;		
	}
	
	public String addExam(String arg1, int arg2) {
		int max = 0, min = 0;
		
		System.out.println("Maximum points? ");
		while (max == 0){
		try { max = Integer.parseInt(consoleReader.nextLine()); }
		catch (NumberFormatException ne){  
			return "ne Exception";
		} }
		
		System.out.println("Minimum points? ");
		while (min == 0){
		try { min = Integer.parseInt(consoleReader.nextLine()); }
		catch (NumberFormatException ne){  
			return "ne Exception";
		} }
		
		allExams.add(new Exam(arg1, arg2, min, max));
		return "Course: " + arg1 + " added";
	}
	
	public String checkStudent(int arg) {
		
		if (arg > allStudents.size() + 1) {
			return "Student does not exist";
		} else {
			return allStudents.get(arg).toString();
		}
	}
	
	public String checkExam(int arg) {
		if (arg > allExams.size()) {
			return "Exam does not exist";
		}
		return allExams.get(arg).toString();
	}
	
	public String markStudent(String arg1, int arg2, int arg3) {
		String s = "Could not create marking sheet";
		Student stud = new Student(" ", " ");
		
		String test = "";
		for (int i = 0; i < allStudents.size(); i++) {
			if (arg1.equals(allStudents.get(i).getName())) {
				stud = allStudents.get(i);
				test = " ";
				break;
			}
			else {
				test = "Student does not exist";
			}
		}
		
		Exam daExam = new Exam("", 0, 0, 0);
		
		for (int i = 0; i < allExams.size(); i++) {
			if(arg2 == allExams.get(i).getCode()) {
				daExam = allExams.get(i);
				break;
			}
		}
		
		if (test.equals("Student does not exist") || arg3 > daExam.getMaxPoints()) {
			return "Could not create marking sheet";
		}else {
			String grade = "U";
			MarkingSheet ms =new MarkingSheet(arg2, daExam, stud);
			stud.addMarkingSheet(ms);
			
			if (daExam.getMinPoints()<=arg3) {
				grade = "G";
			}
			ms.setGrade(grade);
			
			s = String.format("Student: %10s got the grade %s", stud.getName(), grade);
		}
		
		return s;
	}
	
	public String toString() {
		String st = "Students\n";
		for (int i = 0; i < allStudents.size(); i++) {
			st += allStudents.get(i).getName() + "\n";
		}
		st += "\n";
		String dt = "Exams\n";
		for (int i = 0; i < allExams.size(); i++) {
			dt += allExams.get(i).getName() + "\n";
		}
				
		return st + dt;
	}
	
}



