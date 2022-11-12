package assignment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class EmpwageClass {
	ArrayList<Calculate> employeedetails = new ArrayList<Calculate>();
	HashMap<String, ArrayList<Calculate>> company = new HashMap<String, ArrayList<Calculate>>();

	public void getemployeedetails() {
		Calculate calculate = new Calculate();
		Scanner read = new Scanner(System.in);

		System.out.println("Enter the name of employee");
		calculate.setName(read.next());

		System.out.println("Enter the wage per hours for employeedetails");
		calculate.setWagePerHour(read.nextInt());
		System.out.println("Enter the total number of Day in a month");
		calculate.setDayInMonth(read.nextInt());
		System.out.println("Enter the Maximum  working hours in a month");
		calculate.setMaxhours(read.nextInt());

		employeedetails.add(calculate);
		calculate.calculatewage();
		System.out.println("Enter the Company name in which you want to add this employee");
		String companyname = read.next();
		if (company.containsKey(companyname)) {
			ArrayList<Calculate> employeedetails = company.get(companyname);
			company.put(companyname, employeedetails);
			System.out.println("New employeedetails added to existing company '" + companyname + "'");
		} else {
			ArrayList<Calculate> employeedetails = company.get(companyname);
			company.put(companyname, employeedetails);
			System.out.println(" New Company '" + companyname + "' Created");
			System.out.println("New employee details added to '" + companyname + "'");
		}
	}

	public void display() {
		if (employeedetails.size() > 0) {
			for (Calculate i : employeedetails)
				System.out.println(i);
		} else
			System.out.println("Employee details is empty");

	}

	public void dailywage() {
		Scanner scanner = new Scanner(System.in);
		if (employeedetails.size() > 0) {
			System.out.println("Enter the first name of that contact you want to delete");
			String delname = scanner.next();
			boolean check = false;
			for (int i = 0; i < employeedetails.size(); i++) {
				if (employeedetails.get(i).getname().equals(delname)) {
					check = true;
					Calculate calculate = employeedetails.get(i);
					employeedetails.get(i).dailywage();
					break;
				}
			}
			if (check == false)
				System.out.println("Employee not found in Directory");

		} else
			System.out.println("Directory of employee is empty");
	}

	public void deletedetails() {
		Scanner scanner = new Scanner(System.in);
		if (employeedetails.size() > 0) {
			System.out.println("Enter the first name of that contact you want to delete");
			String delname = scanner.next();
			boolean check = false;
			for (int i = 0; i < employeedetails.size(); i++) {
				if (employeedetails.get(i).getname().equals(delname)) {
					check = true;
					Calculate calculate = employeedetails.get(i); // object in i th postion Contacts in contactlist
					employeedetails.remove(calculate);
					System.out.println("Employee details deleted...");
					break; // used to terminate when employee found and deleted
				}
			}
			if (check == false)
				System.out.println("Employee not found in Directory");

		} else
			System.out.println("Directory of employee is empty");
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to the employee wage program using class and arraylist");
		EmpwageClass emp = new EmpwageClass();
		boolean run = true;

		while (run) {
			System.out.println(
					"Choose the option \n1.Add employee\n2.Display details \n3.Delete details of employee\n4.Display dialywage\n5.Exit");
			int option = sc.nextInt();
			switch (option) {
			case 1:
				emp.getemployeedetails();
				break;
			case 2:
				emp.display();
				break;
			case 3:
				emp.deletedetails();
				break;
			case 4:
				emp.dailywage();
				break;
			case 5:
				run = false;
				break;
			default:
				System.out.println("choose correct option");
			}
		}
	}
}
