package common;

import java.util.Scanner;

/**
 *
 * @author GoldCandy
 */
public class Validation {

    public String inputString(String title) {
        String s = "";
        while (s.isBlank() || s.isEmpty()) {
            Scanner sc = new Scanner(System.in);
            System.out.print(title + ": ");
            s = sc.nextLine();
        }
        return s;
    }

    public int inputInt(String title) {
        int a = 0;
        while (a < 1) {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println(title + ": ");
                a = sc.nextInt();
            } catch (Exception e) {
                System.err.println("Please input integer");
                a = 0;
            }
        }
        return a;
    }

    public String phoneMatch(String title) {
        String phone;
        while (true) {
            phone = inputString(title);
            if (checkPhoneMatch(phone)) {
                return phone;
            }
            System.err.println("""
                               Please input Phone flow
                               . 1234567890
                               . 123-456-7890 
                               . 123-456-7890 x1234
                               . 123-456-7890 ext1234
                               . (123)-456-7890
                               . 123.456.7890
                               . 123 456 7890""");
        }
    }

    private boolean checkPhoneMatch(String phone) {
        String[] match = {"[0-9]{10}",
            "[0-9]{3}\\-[0-9]{3}\\-[0-9]{4}",
            "[0-9]{3}\\-[0-9]{3}\\-[0-9]{4}\\s[x][0-9]{4}",
            "[0-9]{3}\\-[0-9]{3}\\-[0-9]{4}\\sext[0-9]{4}",
            "\\([0-9]{3}\\)\\-[0-9]{3}\\-[0-9]{4}",
            "[0-9]{3}\\.[0-9]{3}\\.[0-9]{4}",
            "[0-9]{3}\\s[0-9]{3}\\s[0-9]{4}"};
        for (String match1 : match) {
            if (phone.matches(match1)) {
                return true;
            }
        }
        return false;
    }

    public String checkName(String title) {
        String name;
        while (true) {
            name = inputString(title);
            name = name.trim();
            name = name.replaceAll("\\s+", " ");
            String[] list = name.split(" ");
            if (list.length >= 2) {
                return name;
            }
            System.err.println("Wrong name format (FirstName LastName)");
        }
    }
}
