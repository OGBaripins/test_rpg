package test;

import java.util.Random;

public class Enemies {
	static Random rnd = new Random();

	double health;
	double baseAttack;
	double critDamage;
	double dodge;
	double points;
	String name;
	String lastWords;
	
	Enemies(String [] cells){
		this.health = parseStringToDouble(cells[1]);
		this.baseAttack = parseStringToDouble(cells[2]);
		this.name = cells[0];
		this.lastWords = cells[3];
		this.critDamage = parseStringToDouble(cells[4]);
		this.dodge = parseStringToDouble(cells[5]);
		this.points = parseStringToDouble(cells[6]);
		test1.enemies.add(this);
		
	}
	
	double enemyDamage() {
		int a = rnd.nextInt(3 - 1) + 1;
		if (a == 3) {
			return this.baseAttack;
		} else {
			return this.baseAttack+this.critDamage;
		}	
	}
	
	
	static double parseStringToDouble(String text) {
		

		try {
			double value = Double.parseDouble(text.replace(",", "."));
			
			return value;
		} catch (NumberFormatException e) {

			return 0;
		}

	}
	
	static int parseStringToInt(String text) {

		try {
			int value = Integer.parseInt(text.replace(",", "."));
			return value;
		} catch (NumberFormatException e) {

			return 0;
		}

	}
	
	public String toString() {
		return "Name: "+this.name+"\nHealth: "+ConsoleColors.GREEN+this.health+ConsoleColors.RESET+"\nDodge chance: "+ConsoleColors.PURPLE+this.dodge+ConsoleColors.RESET+" %";
	}

}
