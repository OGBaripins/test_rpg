package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class test1 {
	static DecimalFormat df = new DecimalFormat("0.0");
	static DecimalFormat dl = new DecimalFormat("0");
	static Scanner input = new Scanner(System.in);
	static Random rnd = new Random();
	static ArrayList<Enemies> enemies = new ArrayList<Enemies>();
	static ArrayList<Classes> classes = new ArrayList<Classes>();
	static ArrayList<Items> items = new ArrayList<Items>();
	static ArrayList<String> enemyNames = new ArrayList<String>();
	static ArrayList<Integer> highscores = new ArrayList<Integer>();

	// PLAYER STAT
	public static String playerName;
	public static double health;
	public static double baseHealth;
	public static double damage;
	public static double critDamage;
	public static double dodgeChance;

	static String filePath = "enemies.csv";
	static String filePath1 = "classes.csv";
	static String filePath2 = "items.csv";
	static String encoding = "UTF-8";
	static String delimiter = ",";
	static String text = "";
	static int potion = 50;
	static int enemieCount;
	static int defeatedEnemieCount;
	static int points;
	static int classChoice;
	static int itemChoise;
	static int choiseCount;
	static int itemChoice;
	static double potionCount;
	static double healthNow;
	static boolean endless;
	static boolean append = true;

	public static void main(String args[]) {
		System.out.println(ConsoleColors.RED+ "\n                                                                                                              You are entering the Dungeon! "+ ConsoleColors.RESET);
		readStats_2();
		readStats_1();
		readStats();

		nameChoice();
		endless();
		classChoice();
		itemChoice();
		roadChoiseChooser();
	}

	static void readStats_2() {

		File file1 = new File(filePath2);
		try {
			Scanner reader = new Scanner(file1, encoding);
			reader.nextLine(); // Skipping the header
			while (reader.hasNextLine()) {
				enemieCount++;
				String line = reader.nextLine() + " ";
				String[] parts = line.split(delimiter);
				if (parts.length < 2 || parts[0].isEmpty())
					continue;
				new Items(parts);

			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static void readStats_1() {

		File file1 = new File(filePath1);
		try {
			Scanner reader = new Scanner(file1, encoding);
			reader.nextLine(); // Skipping the header
			while (reader.hasNextLine()) {
				String line = reader.nextLine() + " ";
				String[] parts = line.split(delimiter);
				if (parts.length < 2 || parts[0].isEmpty())
					continue;
				new Classes(parts);

			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static void readStats() {

		File file1 = new File(filePath);
		try {
			Scanner reader = new Scanner(file1, encoding);
			reader.nextLine(); // Skipping the header
			while (reader.hasNextLine()) {
				String line = reader.nextLine() + " ";
				String[] parts = line.split(delimiter);
				if (parts.length < 2 || parts[0].isEmpty())
					continue;
				new Enemies(parts);

			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		enemieCount = enemies.size();
	}

	static void roadChoice() {
		System.out.println("\n*In front of you You can see a road that goes in " + ConsoleColors.GREEN
				+ "three directions" + ConsoleColors.RESET + "*");
		System.out.println("\nWhere would you like to " + ConsoleColors.GREEN + "go" + ConsoleColors.RESET
				+ "?\n 1: Left\n 2: Right\n 3: Straight");
		int i = typing(3);

		if (i == 1) {
			int a = rnd.nextInt(enemieCount - 1) + 1;
			healthNow = enemies.get(a).health;
			battleText(a);
			initialChoice(a);
			return;

		}
		if (i == 2) {
			int a = rnd.nextInt(enemieCount - 1) + 1;
			healthNow = enemies.get(a).health;
			battleText(a);
			initialChoice(a);
			return;

		}
		if (i == 3) {
			int a = rnd.nextInt(enemieCount - 1) + 1;
			healthNow = enemies.get(a).health;
			battleText(a);
			initialChoice(a);
			return;

		}
	}

	static void roadChoice2() {
		System.out.println("\n*In front of you You can see a" + ConsoleColors.RED + " baricated" + ConsoleColors.RESET
				+ " road that only goes in " + ConsoleColors.GREEN + "two directions" + ConsoleColors.RESET + "*");
		System.out.println("\nWhere would you like to" + ConsoleColors.GREEN + " go" + ConsoleColors.RESET
				+ "?\n 1: Left\n 2: Right");
		int i = typing(2);

		if (i == 1) {
			int a = rnd.nextInt(enemieCount - 1) + 1;
			healthNow = enemies.get(a).health;
			battleText(a);
			initialChoice(a);
			return;

		}
		if (i == 2) {
			int a = rnd.nextInt(enemieCount - 1) + 1;
			healthNow = enemies.get(a).health;
			battleText(a);
			initialChoice(a);
			return;

		}

	}

	static void roadChoice3() {
		System.out.println("\n*In front of you You can see a road,*");
		System.out.println("\n*All of the paths before you are " + ConsoleColors.RED + "blocked" + ConsoleColors.RESET
				+ ", except " + ConsoleColors.GREEN + "one" + ConsoleColors.RESET + "*");
		System.out.println(
				"\nWhere would you like to" + ConsoleColors.GREEN + " go" + ConsoleColors.RESET + "?\n 1: Straight");
		int i = typing(1);

		if (i == 1) {
			int a = rnd.nextInt(enemieCount - 1) + 1;
			healthNow = enemies.get(a).health;
			battleText(a);
			initialChoice(a);
			return;

		}

	}

	static void classChoice() {
		int i = 0;
		potionCount = 2;
		System.out.println("Before you procede onwards. Choose a class");
		System.out.println("You have a choice between: ");
		for (Classes a : classes) {
			i++;
			System.out.println("\n" + i + ".");
			System.out.println(a);
		}
		i = typing(4);

		if (i == 1) {
			health = classes.get(0).getHealth();
			baseHealth = health;
			damage = classes.get(0).getBaseAttack();
			critDamage = classes.get(0).getCritDamage();
			dodgeChance = classes.get(0).getDodge();
		}
		if (i == 2) {
			health = classes.get(1).getHealth();
			baseHealth = health;
			damage = classes.get(1).getBaseAttack();
			critDamage = classes.get(1).getCritDamage();
			dodgeChance = classes.get(1).getDodge();
		}
		if (i == 3) {
			health = classes.get(2).getHealth();
			baseHealth = health;
			damage = classes.get(2).getBaseAttack();
			critDamage = classes.get(2).getCritDamage();
			dodgeChance = classes.get(2).getDodge();
		}
		if (i == 4) {
			health = classes.get(3).getHealth();
			baseHealth = health;
			damage = classes.get(3).getBaseAttack();
			critDamage = classes.get(3).getCritDamage();
			dodgeChance = classes.get(3).getDodge();
		}

		itemChoise = Integer.parseInt(text) - 1;

	}

	static void roadChoiseChooser() {
		int a = rnd.nextInt(3) + 1;
		switch (a) {
		case 1:
			roadChoice();

		case 2:
			roadChoice2();

		case 3:
			roadChoice3();

		}
	}

	static void itemChoice() {
		int i = 0;
		System.out.println("Now you can chose an item for your newly found class");
		System.out.println("You have a choice between: ");
		for (Items a : items) {
			i++;
			System.out.println("\n" + i + ".");
			System.out.println(a);
		}

		i = typing(5);
		if (i == 1) {
			health += items.get(0).bonusHealth;
			baseHealth = health;
			damage += items.get(0).bonusDamage;
			critDamage += items.get(0).bonusCritDamage;
			dodgeChance += items.get(0).dodgeBonus;
		}
		if (i == 2) {
			health += items.get(1).bonusHealth;
			baseHealth = health;
			damage += items.get(1).bonusDamage;
			critDamage += items.get(1).bonusCritDamage;
			dodgeChance += items.get(1).dodgeBonus;
		}
		if (i == 3) {
			health += items.get(2).bonusHealth;
			baseHealth = health;
			damage += items.get(2).bonusDamage;
			critDamage += items.get(2).bonusCritDamage;
			dodgeChance += items.get(2).dodgeBonus;
		}
		if (i == 4) {
			health += items.get(3).bonusHealth;
			baseHealth = health;
			damage += items.get(3).bonusDamage;
			critDamage += items.get(3).bonusCritDamage;
			dodgeChance += items.get(3).dodgeBonus;
		}
		if (i == 5) {
			health += items.get(4).bonusHealth;
			baseHealth = health;
			damage += items.get(4).bonusDamage;
			critDamage += items.get(4).bonusCritDamage;
			dodgeChance += items.get(4).dodgeBonus;
		}

		itemChoice = Integer.parseInt(text) - 1;
	}

	static boolean chance() {
		int a = rnd.nextInt(4) + 1;
		if (a == 4) {
			return true;
		} else {
			return false;
		}

	}

	static boolean dodgeChance(double i) {
		int j = (int) i;
		int b;
		b = 100 / j;
		int a = rnd.nextInt(b) + 1;
		if (a == b) {
			return true;
		} else {
			return false;
		}

	}

	static void nameChoice() {
		System.out.println("Hello, how do you want to be called?");
		text = "";
		System.out.print("\nplayer: ");
		text = input.nextLine();
		playerName = text.trim();	
		

	}

	static int initialChoice(int i) {

		@SuppressWarnings("unused")
		Enemies enemy = enemies.get(i);
		int b = 0;

		healthCheck(i);

		System.out
				.println("\nHEALTH  " + ConsoleColors.GREEN + " ---" + df.format(health) + "---" + ConsoleColors.RESET);
		System.out.println(
				"ENEMY HEALTH  " + ConsoleColors.GREEN + " ---" + df.format(healthNow) + "---\n" + ConsoleColors.RESET);
		System.out.println("1. Atack the enemy.\n2. Run away.\n3. Use a health potion.(You have " + ConsoleColors.GREEN
				+ dl.format(potionCount) + ConsoleColors.RESET + " potions left)\n4. Do nothing");
		b = typing(4);

		switch (b) {
		case 1:
			combat_1(i);

		case 2:
			escaping(i);

		case 3:
			useHealth(i);

		case 4:
			doingNothing(i);
		}

		return i;
	}

	static void combat_1(int i) {
		int a = 0;
		@SuppressWarnings("unused")
		Enemies enemy = enemies.get(i);
		System.out.println(
				ConsoleColors.RED + "*You chose to fight" + ConsoleColors.RESET + ", what would you like to do?*");
		System.out.println(
				"\n1. Hit the " + ConsoleColors.RED + "enemy" + ConsoleColors.RESET + " with a " + ConsoleColors.RED
						+ "regular atack" + ConsoleColors.RESET + "." + "\n2. Hit the" + ConsoleColors.RED + " enemy"
						+ ConsoleColors.RESET + " with a " + ConsoleColors.RED + "strong atack." + ConsoleColors.RESET
						+ "\n3. Use your" + ConsoleColors.PURPLE + " special atack." + ConsoleColors.RESET);

		a = typing(3);
		switch (a) {
		case 1:
			regularAttack(i);
			break;
		case 2:
			strongAttack(i);
			break;
		case 3:
			System.out.println("yes");
		}
		enemyAttack(i);

		initialChoice(i);
	}

	static void useHealth(int i) {
		if (potionCount > 0) {
			health += potion;
			if (health >= baseHealth) {
				health = baseHealth;
				System.out.println(ConsoleColors.GREEN + "You have restored your health to a maximum amount of points."
						+ ConsoleColors.RESET);
			} else {
				System.out.println(ConsoleColors.GREEN + "You have restored your health to: " + df.format(health)
						+ " points." + ConsoleColors.RESET);
			}
			potionCount--;
		} else {
			System.out.println(ConsoleColors.WHITE_BOLD + "You dont have any potions left!" + ConsoleColors.RESET);
		}

		initialChoice(i);
	}

	static void battleText(int i) {
		Enemies enemy = enemies.get(i);
		System.out.println(ConsoleColors.RED
				+ "--------------------------------You have encountered an ENEMY--------------------------------"
				+ ConsoleColors.RESET);
		System.out.println(enemy);
		System.out.println(ConsoleColors.RED
				+ "--------------------------------A battle has begun-------------------------------------------"
				+ ConsoleColors.RESET);
	}

	static int typing(int a) {
		int i = 0;
		do {
			try {
				System.out.print("\n" + playerName + ": ");
				text = input.nextLine();
				i = Integer.parseInt(text);
				if (i <= a) {
					break;
				} else {
					System.out.println("Please enter a valid answer (1-" + a + ")");
				}
			} catch (NumberFormatException e) {
				System.out.println("Please enter a valid answer (1-" + a + ")");
			}
		} while (text.equals(text));
		return i;
	}

	static void escaping(int i) {
		int a = rnd.nextInt(5 - 1) + 1;
		if (a == 4) {
			System.out.println(ConsoleColors.GREEN + "*You have sucesesfully escaped to safety*" + ConsoleColors.RESET);
			points += 15;
			roadChoice();
		} else {
			System.out.println(ConsoleColors.RED + "*While trying to escape you fell down and were eaten alive*"
					+ ConsoleColors.RESET);
			health = 0;
			initialChoice(i);
		}
	}

	static void doingNothing(int i) {
		Enemies enemy = enemies.get(i);
		System.out.println(ConsoleColors.RED + "*You chose to do nothing.*\n*" + enemy.name + " ate you alive*\n"
				+ ConsoleColors.RESET);
		health = 0;
		initialChoice(i);
	}

	static void healthCheck(int i) {
		Enemies enemy = enemies.get(i);
		if (healthNow <= 0) {
			System.out.println(ConsoleColors.GREEN + "*You have defeated the enemy!*" + ConsoleColors.RESET);
			System.out.println("\n*In its dying breath you faintly hear: " + ConsoleColors.RED_BOLD_BRIGHT
					+ enemy.lastWords + ConsoleColors.RESET + "*");
			if (chance() == true) {
				potionCount++;
				System.out
						.println(ConsoleColors.GREEN + "\n*You have recieved one health potion*" + ConsoleColors.RESET);
			}
			enemyNames.add(enemy.name);
			defeatedEnemieCount++;
			points += enemy.points;
			ifCompleted();
			roadChoice();
		}
		if (health <= 0) {
			System.out.println(ConsoleColors.RED + "*You are dead*" + ConsoleColors.RESET + ",\n  GAME OVER \n");
			potionCount = 0;
			endGame();
		}
	}

	static void regularAttack(int i) {
		Enemies enemy = enemies.get(i);

		if (dodgeChance(enemies.get(i).dodge) == false) {
			healthNow -= damage;
			System.out.println(ConsoleColors.YELLOW + "*You hit " + enemy.name + " with " + damage
					+ " points of damage.*" + ConsoleColors.RESET);
		} else {
			System.out.println(ConsoleColors.PURPLE + "\n*An enemy has doged your attack!*" + ConsoleColors.RESET);
		}
	}

	static void strongAttack(int i) {
		Enemies enemy = enemies.get(i);

		if (dodgeChance(enemies.get(i).dodge) == false) {
			healthNow -= damage * 2;
			System.out.println(ConsoleColors.YELLOW + "*You hit " + enemy.name + " with " + damage * 2
					+ " points of damage.*" + ConsoleColors.RESET);
			if (chance() == true) {
				healthNow -= critDamage;
				System.out.print(ConsoleColors.YELLOW + "(An adittional damage of " + critDamage
						+ " points has been struck)\n" + ConsoleColors.RESET);
			}
		} else {
			System.out.println(ConsoleColors.PURPLE + "\n*An enemy has doged your attack!*" + ConsoleColors.RESET);
		}
	}

	static void enemyAttack(int i) {
		Enemies enemy = enemies.get(i);
		if (healthNow > 0) {
			if (dodgeChance(classes.get(classChoice).dodge) == false) {
				System.out.println(ConsoleColors.RED + "*You have been hit by " + enemy.name + " with "
						+ enemies.get(i).enemyDamage() + " points of damage.*" + ConsoleColors.RESET);
				health -= enemies.get(i).enemyDamage();
			} else {
				System.out.println(ConsoleColors.GREEN + "\n*You have doged an enemy attack!*" + ConsoleColors.RESET);
			}

		}
	}

	static void endless() {
		int i = 0;
		System.out.println("\nYou can choose a game mode before proceeding.\nYou have a choice between:\n");
		System.out.println(ConsoleColors.CYAN + "1. Regular Mode (You can finish the game)" + ConsoleColors.RESET
				+ ConsoleColors.PURPLE + "\n2. Endless mode (You can try your luck in setting a new highscore)"
				+ ConsoleColors.RESET);
		typing(2);
		switch (i) {
		case 1:
			endless = false;
		case 2:
			endless = true;
		}
	}

	static void ifCompleted() {
		
		if (endless == true)
			return;
		if (points >= 400) {
			System.out.println("\nYou have completed the game\n    " + ConsoleColors.YELLOW + "C" + ConsoleColors.RED + "O"
				+ ConsoleColors.CYAN + "N" + ConsoleColors.GREEN + "G" + ConsoleColors.YELLOW + "R"
				+ ConsoleColors.PURPLE + "A" + ConsoleColors.GREEN + "T" + ConsoleColors.RED + "U" + ConsoleColors.CYAN
				+ "L" + ConsoleColors.YELLOW + "A" + ConsoleColors.WHITE + "T" + ConsoleColors.GREEN + "I"
				+ ConsoleColors.PURPLE + "O" + ConsoleColors.CYAN + "N" + ConsoleColors.RED + "!!!"
				+ ConsoleColors.RESET);
			System.out.println(ConsoleColors.GREEN + "You have earned precisely nothing!!\\n" + ConsoleColors.RESET);
			endGame();
		}
	}

	static void endGame() {
		String text = "You have completed my litle text-based rpg game.\nWhile playing the game you have defeated "
				+ defeatedEnemieCount + " enemies, wich were " + enemyNames + "\nIn the end you recieved " + points
				+ " points.";
		try {
			File gameResult = new File("Game Results.txt");
			if (gameResult.createNewFile()) {
				System.out.println("The game has ended, you can see your score in a file called '"
						+ gameResult.getName() + "'\nyou can find it by this path: " + gameResult.getAbsolutePath());
			} else {
				gameResult.delete();
				gameResult.createNewFile();
				System.out.println("The game has ended, you can see your score in a file called '"
						+ gameResult.getName() + "'\nyou can find it by this path: " + gameResult.getAbsolutePath());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			FileWriter myWriter = new FileWriter("Game Results.txt");
			myWriter.write(text);
			myWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		scoreboard();
		enemyNames.clear();
		System.exit(0);
	}

	static void scoreboard() {
		text = " Player: " + playerName + " Playing: " + classes.get(classChoice).name + " Item: "
				+ items.get(itemChoice).name + "  |SCORE: " + points + "|";
		try {
			FileWriter myWriter = new FileWriter("Scoreboard.txt", append);

			myWriter.write(text + "\n");
			myWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static void highscoreSorter() {
		File file = new File("C:\\Eclipse_Workspace\\Kursa_darbs\\Scoreboard.txt");
		try {
			Scanner reader = new Scanner(file, "UTF-8");
			while (reader.hasNextLine()) {
				String line = reader.nextLine();
				String[] parts = line.split("SCORE: ");
				int num = Integer.parseInt(parts[1].replace("|", ""));
				System.out.println(num);
				highscores.add(num);
				Collections.sort(highscores);
				reader.close();

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(highscores);
	}

}
