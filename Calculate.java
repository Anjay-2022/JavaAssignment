package assignment;

public class Calculate {
	private String name;
	private int wagePerHour;
	private int dayInMonth;
	private int maxhours;
	private int fullDayHour = 8;
	private int partTimeHour = 4;
	private int employeeWagePerDay = 0;
	private int sallary = 0;
	private int totalhours = 0;
	private int countday = 0;
	private int fullday = 0;
	private int parttime = 0;
	private int absent = 0;
	private int pos = 0;
	private int totalhoursleft=0;
	private int[] dailywage = new int[32];

	public void setName(String name) {
		this.name = name;
	}

	public void setWagePerHour(int wagePerHour) {
		this.wagePerHour = wagePerHour;
	}

	public void setDayInMonth(int dayInMonth) {
		this.dayInMonth = dayInMonth;
	}

	public void setMaxhours(int maxhours) {
		this.maxhours = maxhours;
	}

	public void calculatewage() {

		while (totalhours < maxhours && countday < dayInMonth) {
			int ran = (int) (Math.random() * (3));
			
			if (totalhours == (maxhours - 4)) {
				ran = 2;
			} else if (totalhours > (maxhours - 4)) {
				ran = -1;
			}
			switch (ran) {
			case 0:
				absent++;
				countday++;
				employeeWagePerDay = 0;
				break;
			case 1:
				fullday++;
				countday++;
				employeeWagePerDay = wagePerHour * fullDayHour;
				totalhours = totalhours + 8;
				break;
			case 2:
				parttime++;
				countday++;
				employeeWagePerDay = wagePerHour * partTimeHour;
				totalhours = totalhours + 4;
				break;
			default:
				 totalhoursleft = maxhours - totalhours;
			   // System.out.println(totalhoursleft + " totalhoursleft ");
				totalhours = totalhours + totalhoursleft;
				employeeWagePerDay = 0;
				
			}
			dailywage[pos] = employeeWagePerDay;
			pos++;
			sallary = sallary + employeeWagePerDay;
		}
	}

	public String getname() {
		return name;
	}

	@Override
	public String toString() {
		return "Calculate [name=" + name + ", sallary=" + sallary + ", totalhours=" + (totalhours-totalhoursleft) + ", countday="
				+ countday + ", fullday=" + fullday + ", parttime=" + parttime + ", absent=" + absent + "]";
	}

	public void dailywage() {
		System.out.println("Daily wage of employee :-" + name);
		for (int i = 0; i < pos; i++) {
			System.out.print(dailywage[i]+",");
		}
		System.out.println();

	}

}
