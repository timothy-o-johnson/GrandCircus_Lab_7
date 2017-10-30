import java.util.Scanner;

/**
 * 
 * @author Tim Johnson 10/29/17 Grand Circus Lab 7: Class Info
 */

public class Lab7 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String[] studentInfo = ClassData.studentInfo;
		String[] names = ClassData.names;
		String[] nicknames = ClassData.nicknames;
		String[] homeTown = ClassData.homeTown;
		String[] favoriteFood = ClassData.favoriteFood;

		int max = names.length;

		boolean repeat = true;

		System.out.println("Welcome to our Java Class, yo!");

		// printClassRoster();
		while (repeat) {
			System.out.println("\n" + "There are " + names.length + " students in our class.");
			printStudentRoster(names);
			System.out.println();

			String rosterPrompt = "\nWhich student would you like to learn more about? " + "(enter a number 1-"
					+ names.length + ") ";
			int studentChoice = Validator.getInt(sc, rosterPrompt, 1, max) - 1; // subtract 1 to convert to array

			System.out.println("\nWhat would you like to know about " + names[studentChoice] + "? Choose one.");
			printStudentRoster(studentInfo);

			int infoChoice = Validator.getInt(sc, "", 1, max);
			getStudentInfo(names, nicknames, homeTown, favoriteFood, studentChoice, infoChoice);

			if (!Validator.getString(sc, "\nWould you like to learn about another student? ").equalsIgnoreCase("y")) {
				repeat = false;
			}
		}
		
		System.out.println("\n Ok. Well thanks for stopping by! :-)");
		sc.close();
	}

	/**
	 * @param studentInfo
	 */
	private static void printStudentRoster(String[] studentInfo) {
		for (int i = 0; i < studentInfo.length; i++) {
			System.out.println((i + 1) + ": " + studentInfo[i]);
		}
	}

	/**
	 * @param names
	 * @param nicknames
	 * @param homeTown
	 * @param favoriteFood
	 * @param firstChoice
	 * @param choice
	 */
	private static void getStudentInfo(String[] names, String[] nicknames, String[] homeTown, String[] favoriteFood,
			int firstChoice, int choice) {
		switch (choice) {
		case 1: // nick name
			System.out.println("\n" + names[firstChoice] + "'s nick name is " + nicknames[firstChoice]);
			break;
		case 2: // home town
			System.out.println("\n" + names[firstChoice] + "'s home town is " + homeTown[firstChoice]);
			break;
		case 3: // favorite food
			System.out.println("\n" + names[firstChoice] + "'s favorite food is " + favoriteFood[firstChoice]);
			break;
		default:
			break;
		}
	}
}