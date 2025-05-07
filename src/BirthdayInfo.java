import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BirthdayInfo {

    private static final Map<Character, String[]> digits = new HashMap<>();

    static {
        digits.put('0', new String[]{"***", "* *", "* *", "* *", "***"});
        digits.put('1', new String[]{" * ", "** ", " * ", " * ", "***"});
        digits.put('2', new String[]{"***", "  *", "***", "*  ", "***"});
        digits.put('3', new String[]{"***", "  *", "***", "  *", "***"});
        digits.put('4', new String[]{"* *", "* *", "***", "  *", "  *"});
        digits.put('5', new String[]{"***", "*  ", "***", "  *", "***"});
        digits.put('6', new String[]{"***", "*  ", "***", "* *", "***"});
        digits.put('7', new String[]{"***", "  *", "  *", "  *", "  *"});
        digits.put('8', new String[]{"***", "* *", "***", "* *", "***"});
        digits.put('9', new String[]{"***", "* *", "***", "  *", "***"});
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите день рождения: ");
        int day = scanner.nextInt();
        System.out.print("Введите месяц рождения: ");
        int month = scanner.nextInt();
        System.out.print("Введите год рождения: ");
        int year = scanner.nextInt();

        LocalDate birthDate = LocalDate.of(year, month, day);

        System.out.println("\nДень недели: " + getDayOfWeek(birthDate));
        System.out.println("Високосный год: " + (isLeapYear(year) ? "Да" : "Нет"));
        System.out.println("Возраст: " + calculateAge(birthDate) + " лет");

        System.out.println("\nДата рождения:");
        printDate(day, month, year);

        scanner.close();
    }

    private static String getDayOfWeek(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern("EEEE"));
    }

    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    private static long calculateAge(LocalDate birthDate) {
        return ChronoUnit.YEARS.between(birthDate, LocalDate.now());
    }

    private static void printDate(int day, int month, int year) {
        String dateStr = String.format("%02d%02d%04d", day, month, year);
        for (int row = 0; row < 5; row++) {
            StringBuilder line = new StringBuilder();
            for (char digit : dateStr.toCharArray()) {
                line.append(digits.get(digit)[row]).append(" ");
            }
            System.out.println(line);
        }
    }
}
