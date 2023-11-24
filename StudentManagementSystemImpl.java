package sdbms;

import java.util.Map;
import java.util.Scanner;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import customsorting.SortStudentById;
import customsorting.SortingStudentByName;
import customsorting.SortingStudentByAge;
import customsorting.SortingStudentByMarks;

import customexception.StudentNotFoundException;
import java.util.Set;

//implementation class
public class StudentManagementSystemImpl implements StudentManagementSystem  {

	Scanner scan=new Scanner(System.in);

	/**we are using Collection as our Database.
	 * key is<String>-->Student id & value is<Student>-->student object,
	 * 
	 */
	Map<String,Student> db=new LinkedHashMap<String,Student>();


	@Override
	public void addStudent() {

		//Accepting Age
		System.out.println("enter Age :");
		int age=scan.nextInt();

		//Accepting name
		System.out.println("enter Name :");
		String name=scan.next();

		//accepting marks
		System.out.println("enter Marks :");
		int marks=scan.nextInt();


		//add student instance or object
		Student std=new Student(age,name,marks);

		//adding Student id & key & Student object of values in db(map)
		db.put(std.getSid(), std);

		System.out.println("Student Record insert Successfully");
		System.out.println("your Sid is :"+std.getSid());
 
	}

	@Override
	public void displayStudent() {
		//accepting student id & converting into uppercase because 
		//all id's should be considered as valid--->Jsp101,jsp101,JSP101
		System.out.println("Enter the student id");
		String id=scan.next();

		id=id.toUpperCase();//String id=scan.next().toUppercase();

		//if checking the student object or not
		if(db.containsKey(id)) {
			System.out.println("Student record found!!!");

			Student std=db.get(id); //geting student object

			System.out.println("ID: "+std.getSid());
			System.out.println("Age: "+std.getAge());
			System.out.println("Name: "+std.getName());
			System.out.println("Marks: "+std.getMarks());	
		}
		else
		{
			try {
				String message="Student with Id "+id+" is not found!!1";
				throw new StudentNotFoundException(message);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public void displayAllStudent() {
		if(!db.isEmpty())
		{
			System.out.println("Sturdent Records are as follows : ");
			System.out.println("----------------------");

			//converting map(Db) into set
			Set<String> keys=db.keySet(); //JSP101 JSP102 JSP 103

			for(String key:keys) {
				//printing reference variable as toString() is overridden
				System.out.println(db.get(key));
			}
		}
		else {
			try {
				String message="no Student Recordss to Display";
				throw new StudentNotFoundException(message);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}

	}

	@Override
	public void removeStudent() {
		System.out.println("Enter Student Id");
		String id=scan.next();
		id=id.toUpperCase();

		if(db.containsKey(id)) {
			System.out.println("Student record found");

			System.out.println("No of Student record before deleted: "+db.size());
			db.remove(id);
			System.out.println("no of Student Record after Deleted :"+db.size());
			System.out.println(" Student Record Delete SuccessFully");	
		}
		else {
			try {
				String message="Student with Id"+id+ "is not found";
				throw new StudentNotFoundException(message);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}

	}

	@Override
	public void removeAllStudent() {

		if(!db.isEmpty()) {
			System.out.println("No of Student Records before Deleting :"+db.size());
			db.clear();

			System.out.println("No of Student Records after Deleting :"+db.size());
			System.out.println(" Student Record Delete SuccessFully");
		}
		else {
			try {
				String message="no Student Records to Delete";
				throw new StudentNotFoundException(message);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}

	}

	@Override
	public void updateStudent() {
		//accepting Student Id
		System.out.println("enter the Student Id");
		String id=scan.next();
		int choice=scan.nextInt();
		id=id.toUpperCase();

		//if student record present or not
		if(db.containsKey(id)) {
			System.out.println("Student Record Found");

			Student std=db.get(id); //geting student object
			System.out.println("1:Update Age\n2:Update Name");
			System.out.println("3:Update Marks\n4:Update choice");

			switch(choice) {

			case 1:System.out.println("enter the age");
			int age=scan.nextInt();
			std.setAge(age);
			System.out.println("Age Update SuccessFully");
			break;
			case 2:System.out.println("enter the name");
			String name=scan.next();
			std.setName(name);
			System.out.println("Name update Successfully");

			break;
			case 3:System.out.println("enter the Marks");
			int marks=scan.nextInt();
			System.out.println("Marks update SuccessFully");
			break;
			default:
				try {
					String message="Invalid Choice,Kindly enter valid Choice";
					throw new StudentNotFoundException(message);
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}}
		else
		{
			try {
				String message="Student with record is not found!!1";
				throw new StudentNotFoundException(message);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}

	@Override
	public void countStudent() {
		System.out.println("No of Student Records :"+db.size());
	}
	@Override
	public void getStudentWithHighestMarks() {
		if(db.size()>=2) {
		
		List<Student> list=new ArrayList<Student>();
		Set<String> keys=db.keySet();
		for(String key:keys)
		{
			list.add(db.get(key));
		}
		Collections.sort(list,new SortingStudentByMarks());
		System.out.println("Student with Highest marks");
		System.out.println(list.get(list.size()-1));
	}
		else {
			try {
				String message="No Sufficient student record find Hight Marks";
				throw new StudentNotFoundException(message);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public void getStudentWithLowestMarks() {
		if(db.size()>=2) {
			
			List<Student> list=new ArrayList<Student>();
			Set<String> keys=db.keySet();
			for(String key:keys)
			{
				list.add(db.get(key));
			}
			Collections.sort(list,new SortingStudentByMarks());
			System.out.println("Student with lowest marks");
			System.out.println(list.get(0));
		}
			else {
				try {
					String message="No Sufficient student record find Lowest Marks";
					throw new StudentNotFoundException(message);
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}


	}
	public void sortStudent() {
		if(db.size()>=2) {
			//reference of list &object of arraylist storing student object
			List<Student> list=new ArrayList<Student>();
			//convertibg DB(map) into set into keyset
			Set<String> keys=db.keySet();//JSP101.Jsp101,jsp101

			for(String key:keys) {
				Student std=db.get(key);//getting the student object
				list.add(std);//adding student object into the list 
			}
			System.out.println("1:sorting student by ID\n2:sorting student by Sname");
			System.out.println("3:sorting student by Age\n4:sorting student by Marks");
			System.out.println("Enter the choice");

			int choice=scan.nextInt();

			switch(choice) {

			case 1:
				Collections.sort(list,new SortStudentById());
				for(Student s:list) {
					System.out.println(s);
					break;
				}
			case 2:
				Collections.sort(list,new SortingStudentByName());
				for(Student s:list) {
					System.out.println(s);
					break;
				}
			case 3:
				Collections.sort(list,new SortingStudentByAge());
				for(Student s:list) {
					System.out.println(s);
					break;
				}
			case 4:
				Collections.sort(list,new SortingStudentByMarks());
				for(Student s:list) {
					System.out.println(s);
					break;			
				}
			default:
				try {
					String message="invalid choice.please enter valid choice";
					throw new StudentNotFoundException(message);
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}}
		else {
			try {
				String message="no suffient student record to sort";
				throw new StudentNotFoundException(message);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}

		}
	}
}
