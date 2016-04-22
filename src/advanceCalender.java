import java.util.Scanner;

public class advanceCalender {
	public static void main(String[]args) {
		Scanner scan = new Scanner(System.in);
		String[][] arr = new String [7][24];
		String command = "";
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				arr [i][j] = null;
			}
		}

		do {
			System.out.print("Input command: ");
			command = scan.nextLine();
			
			if (command.equals("add")) {
				count++;
				System.out.print("Date (1-7): ");
				int date = Integer.parseInt(scan.nextLine());
				if (date > 7 || date == 0) {
					System.out.println("Invalid date!"); 
				} else {
					System.out.print("Hour (1-24): ");
					int hour = Integer.parseInt(scan.nextLine());
					if (hour > 24 || hour <= 0) {
						System.out.println("Invalid hour!");
					}
				}
			}

		} while (!command.equals("exit"));
		System.out.print("Thank you for using my calendar.");

	}
}
