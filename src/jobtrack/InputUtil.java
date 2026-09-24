package jobtrack;

import java.time.DateTimeException;
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
			String input = scanner.nextLine();
			try {
				int value = Integer.parseInt(input);
				return value;
			} catch (NumberFormatException e) {
				System.out.println("整数で入力してください。");
			}
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
		while (true) {
			int year = readIntInRange("年: ", 2000, 2100);
			int month = readIntInRange("月: ", 1, 12);
			int day = readIntInRange("日: ", 1, 31);
			try {
				return LocalDate.of(year, month, day);
			} catch (DateTimeException e) {
				System.out.println("存在しない日付です。もう一度入力してください。");
			}
		}
	}

	public static void close() {
		scanner.close();
	}
}
