package method;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class test {

    private static final String UPPER_CASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER_CASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()_+";
    private static final SecureRandom random = new SecureRandom();

    public static String generatePassword(int length) {
        if (length < 4) {
            throw new IllegalArgumentException("密码的最小长度为4");
        }

        List<Character> passwordChars = new ArrayList<>();
        passwordChars.add(randomUpperCaseChar());
        passwordChars.add(randomLowerCaseChar());
        passwordChars.add(randomDigitChar());
        passwordChars.add(randomSpecialChar());

        for (int i = passwordChars.size(); i < length; i++) {
            passwordChars.add(randomChar());
        }

        Collections.shuffle(passwordChars);

        return passwordChars.stream().map(String::valueOf).collect(Collectors.joining());
    }

    private static char randomChar() {
        String allChars = UPPER_CASE + LOWER_CASE + DIGITS + SPECIAL_CHARACTERS;
        return allChars.charAt(random.nextInt(allChars.length()));
    }

    private static char randomUpperCaseChar() {
        return UPPER_CASE.charAt(random.nextInt(UPPER_CASE.length()));
    }

    private static char randomLowerCaseChar() {
        return LOWER_CASE.charAt(random.nextInt(LOWER_CASE.length()));
    }

    private static char randomDigitChar() {
        return DIGITS.charAt(random.nextInt(DIGITS.length()));
    }

    private static char randomSpecialChar() {
        return SPECIAL_CHARACTERS.charAt(random.nextInt(SPECIAL_CHARACTERS.length()));
    }
}
