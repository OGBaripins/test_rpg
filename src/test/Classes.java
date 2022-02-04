package test;

public class Classes {
	
	double health;
	double baseAttack;
	double critDamage;
	String name;
	double dodge;

	Classes(String[] cells) {
		this.health = parseStringToDouble(cells[1]);
		this.baseAttack = parseStringToDouble(cells[2]);
		this.critDamage = parseStringToDouble(cells[3]);
		this.name = cells[0];
		this.dodge = parseStringToDouble(cells[4]);

		test1.classes.add(this);

	}
	public double getHealth() {
		return health;
	}

	public void setHealth(double health) {
		this.health = health;
	}

	public double getBaseAttack() {
		return baseAttack;
	}

	public void setBaseAttack(double baseAttack) {
		this.baseAttack = baseAttack;
	}

	public double getCritDamage() {
		return critDamage;
	}

	public void setCritDamage(double critDamage) {
		this.critDamage = critDamage;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getDodge() {
		return dodge;
	}

	public void setDodge(double dodge) {
		this.dodge = dodge;
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
	
	static int parseStringToInt(String text) {

		try {
			int value = Integer.parseInt(text);
			return value;
		} catch (NumberFormatException e) {

			return 0;
		}

	}
	
	public String toString() {

	return "Name: " + this.name+ "\nHealth: " +ConsoleColors.GREEN+ this.health +ConsoleColors.RESET+ "\nBase attack: " +ConsoleColors.RED+ this.baseAttack +ConsoleColors.RESET+ "\nCrit dammage: " +ConsoleColors.RED+ this.critDamage+ConsoleColors.RESET+"\ndoge chance "+ConsoleColors.PURPLE+this.dodge+ConsoleColors.RESET;
	}
}
