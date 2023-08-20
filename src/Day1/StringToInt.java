package Day1;

public class StringToInt {
    public static void main(String[] args) {
        String s = "words and 987";
        int i = cutString(s);
        System.out.println(i);
    }
    private static int cutString(String string) {
        int index = findIndex(string);

        if (index == -1) {
            return 0; // No valid numeric characters found
        }

        StringBuilder sb = new StringBuilder();

        // Include the first character (digit or '-' sign)
        sb.append(string.charAt(index));

        // Continue adding digits until a non-digit character is encountered
        index++;
        while (index < string.length() && Character.isDigit(string.charAt(index))) {
            sb.append(string.charAt(index));
            index++;
        }

        String numericString = sb.toString();

        if (numericString.equals("-") || numericString.equals("")) {
            return 0; // Only a minus sign or empty string
        }

        try {
            return Integer.parseInt(numericString);
        } catch (NumberFormatException e) {
            return 0; // Handle invalid integer format
        }
    }

    private static int findIndex(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i)) || s.charAt(i) == '-') {
                return i;
            }
        }
        return -1;
    }
}
