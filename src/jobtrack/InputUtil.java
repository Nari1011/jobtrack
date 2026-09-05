package jobtrack;

import java.time.LocalDate;
import java.util.Scanner;

public class InputUtil {
	private static final Scanner scanner = new Scanner(System.in);

	public static String readText(String prompt) {
		while (true) {
			System.out.print(prompt);
			String input = scanner.nextLine().trim();
			if (!input.isEmpty()) {
				return input;
			}
			System.out.println("入力されていません。もう一度入力してください。");
		}
	}

	public static int readInt(String prompt) {
		while (true) {
			System.out.print(prompt);
			if (scanner.hasNextInt()) {
				int value = scanner.nextInt();
				return value;
			}
			scanner.nextLine();
			System.out.println("整数で入力してください。");
		}
	}

	public static int readIntInRange(String prompt, int min, int max) {
		while (true) {
			int value = readInt(prompt);
			if (value >= min && value <= max) {
				return value;
			}
			System.out.println(min + "~" + max + "の範囲で入力してください。");
		}
	}

	public static LocalDate readDate(String prompt) {
		System.out.println(prompt);
		int year = readIntInRange("年: ", 2000, 2100);
		int month = readIntInRange("月: ", 1, 12);
		int maxDay = LocalDate.of(year, month, 1).lengthOfMonth();
		int day = readIntInRange("日: ", 1, maxDay);
		return LocalDate.of(year, month, day);
	}

	public static void close() {
		scanner.close();
	}
}
