
package sdbms;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		System.out.println("Welcome to Student  Database Management System");
		System.out.println("--------------------------------");

		Scanner scan=new Scanner(System.in);
		//upcasting to acheive abstraction
		StudentManagementSystem sms=new StudentManagementSystemImpl();

		while(true)//infinite loop
		{
			System.out.println("1.addStudent\n2:displayStudent");
			System.out.println("3.displayAllStudent\n4:removeStudent");
			System.out.println("5.removeAllStudent\n6:updateStudent");
			System.out.println("7.countStudent\n8:getStudentWithHighestMarks");
			System.out.println("9.getStudentWithLowestMarks\n10:sortStudent");
			System.out.println("11.:Exit\nEnter choice");

			int choice=scan.nextInt();
			switch(choice)
			{
			case 1:
				sms.addStudent();
				break;
			case 2:
				sms.displayStudent();
				break;
			case 3:
				sms.displayAllStudent();
				break;
			case 4:
				sms.removeStudent();
				break;
			case 5:
				sms.removeAllStudent();
				break;
			case 6:
				sms.updateStudent();
				break;
			case 7:
				sms.countStudent();
				break;
			case 8:
				sms.getStudentWithHighestMarks();
				break;
			case 9:
				sms.getStudentWithLowestMarks();
				break;
			case 10:
				sms.sortStudent();
			case 11:
				System.out.println("THANK YOU!!!!!");
				break;

			default:
				try {
					String message="invalid choice,kindly enter the valid choice";
					throw new InvalidChoiceException(message);
				}catch(Exception e)
				{
					System.out.println(e.getMessage());
				}
			}
			System.out.println("==================");

		}

	}

}//addStudent();
//void displayStudent();
//void displayAllStudent();
//void removeStudent();
//void removeAllStudent();
//void updateStudent();
//void countStudent();
//void getStudentWithHighestMarks();
//void getStudentWithLowestMarks();


