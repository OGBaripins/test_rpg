package test;

public class Items {
	String name;
	double bonusHealth;
	double bonusDamage;
	double bonusCritDamage;
	double dodgeBonus;
	
	Items (String [] cells){
		this.name =cells[0];
		this.bonusHealth =parseStringToDouble(cells[1]);
		this.bonusDamage =parseStringToDouble(cells[2]);
		this.bonusCritDamage =parseStringToDouble(cells[3]);
		this.dodgeBonus =parseStringToDouble(cells[4]);
		test1.items.add(this);
				
	}
	
	static int parseStringToInt(String text) {

		try {
			int value = Integer.parseInt(text.replace(",", "."));
			return value;
		} catch (NumberFormatException e) {

			return 0;
		}

	}
	
	static double parseStringToDouble(String text) {
		//System.out.println(text);
		try {
			double value = Double.parseDouble(text.replace(",", "."));

			return value;
		} catch (NumberFormatException e) {

			return 0;
		}

	}
	
	public String toString() {
		return "Name: "+this.name+"\nBonus Health: "+ConsoleColors.GREEN+this.bonusHealth+ConsoleColors.RESET+"\nBonus Critical Damage: "+ConsoleColors.RED+this.bonusCritDamage+ConsoleColors.RESET+"\nDodge Bonus: "+ConsoleColors.PURPLE+this.dodgeBonus+ConsoleColors.RESET;
	}

}
