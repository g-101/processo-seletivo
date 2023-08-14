package br.com.g101.processoseletivo.util;

public class InputUtils
{
    private InputUtils() {}
    public static String capitalize(String s) {

        s = s.toLowerCase();
        char[] cArr = s.trim().toCharArray();
        cArr[0] = Character.toUpperCase(cArr[0]);

        for (int i = 0; i < cArr.length; i++) {

            if (cArr[i] == ' ' && (i + 1) < cArr.length) {
                cArr[i + 1] = Character.toUpperCase(cArr[i + 1]);
            }

            if (cArr[i] == '-' && (i + 1) < cArr.length) {
                cArr[i + 1] = Character.toUpperCase(cArr[i + 1]);
            }

            if (cArr[i] == '\'' && (i + 1) < cArr.length) {
                cArr[i + 1] = Character.toUpperCase(cArr[i + 1]);
            }
        }
        return new String(cArr);
    }

    public static boolean isUnknown(String str) {
        return str.isEmpty() || str.trim().isEmpty() || str.isBlank();
    }

    public static boolean isWordValid(String s) {
        if (isUnknown(s) || s.trim().length() < 2 || s.trim().length() > 80 || !s.matches("^[\\p{L}\\s]+$")) {
           return false;
        }
        return true;
    }



    public static <T> Integer isOnlyDigit(T input)  {
        if (input == null) {
            throw new IllegalArgumentException("Entrada inválida");
        }
        String str = input.toString();
        if (isUnknown(str) || !str.matches("\\d+")) {
            throw new IllegalArgumentException("Entrada inválida, apenas números");
        }
        return Integer.parseInt(str);

    }

}
