package assignment;

import java.util.Scanner;

public class EmpwageClass {
	int wagePerHour ;
	int fullDayHour = 8;
	int partTimeHour = 4;
	int employeeWagePerDay = 0;
	int dayInMonth = 20, day = 0;
	int sallary = 0;
	int present = 0, parttime = 0, absent = 0;
	int totalhours;
	int hours = 0;

	public EmpwageClass(int wph,int hpw) {
		wagePerHour = wph;
		totalhours = hpw;
	}

	public void calculatewage() {

		while (hours < totalhours && day < dayInMonth) {
			int ran = (int) (Math.random() * (3));
			if (hours == (totalhours-4)) {
				ran = 2;
			} else if(hours > (totalhours-4)) {
				ran = -1;
			}
			switch (ran) {
			case 0:
				absent++;
				employeeWagePerDay = 0;
				break;
			case 1:
				present++;
				employeeWagePerDay = wagePerHour * fullDayHour;
				hours = hours + 8;
				break;
			case 2:
				parttime++;
				employeeWagePerDay = wagePerHour * partTimeHour;
				hours = hours + 4;
				break;
			default:
				int hoursleft = totalhours - hours;
				System.out.println(hoursleft+" hoursleft ");
				hours=hours+hoursleft;
			}
			sallary = sallary + employeeWagePerDay;
		}
	}

	public void display() {
		System.out.println("total Present is :" + present);
		System.out.println("total Present part time is :" + parttime);
		System.out.println("total absent is :" + absent);
		System.out.println("EmployeeWage for a month is : " + sallary);

	}

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		System.out.println("Give employee_wage_per_hour and totalhours for a week");
		int wageph = sc.nextInt();
		int hourpw = sc.nextInt();
		
		
		EmpwageClass company1 = new EmpwageClass(wageph,hourpw);
		company1.calculatewage();
		company1.display();
	}
}
