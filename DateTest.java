import java.util.Scanner;

//this program assumes the user will enter at least 10 characters to the scanner it will take the first 10 as the date
//this program requires the user to re-enter the whole date if there is an invalid value.  
public class DateTest {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);

		boolean runDate = true;

		while (runDate) {

			System.out.println("Enter a date in this format: mm/dd/yyyy");
			String inputDate = new String(keyboard.nextLine());
			try {
				Integer.parseInt(inputDate.substring(0, 2));

			} catch (NumberFormatException e) {
				System.out.println("The month value"/* + inputMonth + */ + " is invalid. Please try again.");
				continue;
			}
			int inputMonth = Integer.parseInt(inputDate.substring(0, 2));
			try {
				// String strInputMonth = inputDate.substring(0, 2);
				if ((inputMonth < 1) || (inputMonth > 12))
					throw new MonthException();

				// System.out.println("The month value: " + inputMonth + " is
				// valid.");
			} catch (MonthException e) {
				System.out.println("The month value"/* + inputMonth + */ + " is invalid. Please try again.");
				continue;
			}
			try {
				Integer.parseInt(inputDate.substring(6, 10));

			} catch (NumberFormatException e) {
				System.out.println("The year value"/* + inputYear + */ + " is invalid. Please try again.");
				continue;
			}

			int inputYear = Integer.parseInt(inputDate.substring(6, 10));
			try {
				// String strInputYear = inputDate.substring(6, 10);
				if ((inputYear < 1000) || (inputYear > 3000))
					throw new YearException();

				// System.out.println("The year value: " + inputYear + " is
				// valid.");
			} catch (YearException e) {
				System.out.println("The year value"/* + inputYear + */ + " is invalid. Please try again.");
				continue;
			}

			int dayMaxNumber = 0;
			switch (inputMonth) { // switch to see the amount of days in the
									// month and leap year check
			case 1:
				dayMaxNumber += 31;
				break;
			case 2:
				if ((inputYear % 4) == 0) {
					dayMaxNumber += 29;
				} else {
					dayMaxNumber += 28;
				}
				break;
			case 3:
				dayMaxNumber += 31;
				break;
			case 4:
				dayMaxNumber += 30;
				break;
			case 5:
				dayMaxNumber += 31;
				break;
			case 6:
				dayMaxNumber += 30;
				break;
			case 7:
				dayMaxNumber += 31;
				break;
			case 8:
				dayMaxNumber += 31;
				break;
			case 9:
				dayMaxNumber += 30;
				break;
			case 10:
				dayMaxNumber += 31;
				break;
			case 11:
				dayMaxNumber += 30;
				break;
			case 12:
				dayMaxNumber += 31;
				break;
			default:
				dayMaxNumber = 28;// defaults to lowest possible # of days in a
									// month
				break;
			}
			// check if day can be turned into an int
			try {
				Integer.parseInt(inputDate.substring(3, 5));

			} catch (NumberFormatException e) {
				System.out.println("The day value"/* + inputDay + */ + " is invalid. Please try again.");
				continue;
			}
			int inputDay = Integer.parseInt(inputDate.substring(3, 5)); // turns
																		// day
																		// into
																		// an
																		// int
			try { // checks if the day value is between the accepted values
					// String strInputDay = inputDate.substring(3, 5);
				if ((inputDay < 1) || (inputDay > dayMaxNumber))
					throw new DayException();
				// System.out.println("The day value: " + inputDay + " is
				// valid.");
				runDate = false;
			} catch (DayException e) {
				System.out.println("The day value"/* + inputDay + */ + " is invalid. Please try again.");
				continue;
			}

			String daySuffix; // finds the appropriate suffix for the day of the
								// month
			switch (inputDay) {
			case 1:
				daySuffix = "st";
				break;
			case 2:
				daySuffix = "nd";
				break;
			case 3:
				daySuffix = "rd";
				break;
			case 21:
				daySuffix = "st";
				break;
			case 22:
				daySuffix = "nd";
				break;
			case 31:
				daySuffix = "st";
				break;
			default:
				daySuffix = "th";
				break;
			}

			String monthString; // takes the month and changes it to its full
								// name
			switch (inputMonth) {
			case 1:
				monthString = "January";
				break;
			case 2:
				monthString = "February";
				break;
			case 3:
				monthString = "March";
				break;
			case 4:
				monthString = "April";
				break;
			case 5:
				monthString = "May";
				break;
			case 6:
				monthString = "June";
				break;
			case 7:
				monthString = "July";
				break;
			case 8:
				monthString = "August";
				break;
			case 9:
				monthString = "September";
				break;
			case 10:
				monthString = "October";
				break;
			case 11:
				monthString = "November";
				break;
			case 12:
				monthString = "December";
				break; // should not need a default since it has already checked
						// for invalid months
			default:
				monthString = "BROKEN";
				break; // only needed to see if the switch is working
			}

			String fullString = monthString + " " + inputDay + "" + daySuffix + ", " + inputYear;
			System.out.println(fullString); // prints the whole date in the new
											// format
		}

		keyboard.close();
	}
}
