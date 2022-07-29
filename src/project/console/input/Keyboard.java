/**
 * Class that has static methods to take input from the user on console through keyboard.
 */
package project.console.input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Aqib Chattha
 * @version 0.1, 2022-27-07
 * @since JDK17.0.4
 */
public class Keyboard {
	/**
	 * Ask the user to input one integer and return it as a return value. Repeat
	 * until correct input is obtained.
	 * 
	 * @return Read integer.
	 */
	public static int inputNumber() {
		int number;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String line = br.readLine();
			number = Integer.parseInt(line);
		} catch (NumberFormatException e) {
			System.err.println("Format exception. Again.");
			number = inputNumber(); // Recall
		} catch (IOException e) {
			System.err.println("I / O exception. Again.");
			number = inputNumber(); // Recall
		}

		return number;
	}

	/**
	 * Read one line from the keyboard. If there is an error, re-enter it.
	 * 
	 * @return Read string
	 */
	public static String inputString() {
		String line;

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			line = br.readLine();
		} catch (IOException e) {
			System.err.println("Error: I / O exception. Enter again.");
			line = inputString();
		}

		return line;

	}
}
