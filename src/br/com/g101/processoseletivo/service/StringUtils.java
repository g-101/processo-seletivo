package br.com.g101.processoseletivo.service;


public class StringUtils
{
    private StringUtils() {}
    public static String capitalize(String s)
    {

        s = s.toLowerCase();
        char[] cArr = s.trim().toCharArray();
        cArr[0] = Character.toUpperCase(cArr[0]);

        for (int i = 0; i < cArr.length; i++)
        {

            if (cArr[i] == ' ' && (i + 1) < cArr.length)
            {
                cArr[i + 1] = Character.toUpperCase(cArr[i + 1]);
            }

            if (cArr[i] == '-' && (i + 1) < cArr.length)
            {
                cArr[i + 1] = Character.toUpperCase(cArr[i + 1]);
            }

            if (cArr[i] == '\'' && (i + 1) < cArr.length)
            {
                cArr[i + 1] = Character.toUpperCase(cArr[i + 1]);
            }
        }

        return new String(cArr);

    }

    public static boolean isStringValid(String s)
    {
        if (s.isEmpty() || s.isBlank() || s.trim().length() < 3
                || s.trim().length() > 150 || !s.matches("^[\\p{L}\\s]+$"))
        {
            throw new IllegalArgumentException("Caracteres inválidos");

        }

        return true;
    }

}
