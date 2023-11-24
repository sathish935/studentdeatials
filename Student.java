 package sdbms;

 public class Student  {
	private String sid;
	private int age;
	private String name;
	private int marks;
	
	private static int count=101;
	
	Student(int age, String name, int marks){
		this.sid="JSP"+count;
		count++;
		this.age=age;
		this.name=name;
		this.marks=marks;
		}


	public String getSid() {
		return sid;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}
	@Override
public String toString() {
	return "Id :"+sid+"  Age :"+age+" Name :"+name+"  Marks :"+marks;
}
//	public static void main(String[] args) {
//		Student s1=new Student(10,"Iron Man",75);
//		Student s2=new Student(12,"Captian",90);
//		Student s3=new Student(13,"Hulk ",70);
//		System.out.println(s1);
//		System.out.println(s2);
//		System.out.println(s3);
//	}

}
