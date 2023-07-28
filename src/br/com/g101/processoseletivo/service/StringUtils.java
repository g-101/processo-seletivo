package br.com.g101.processoseletivo.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
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

    public static boolean isWordValid(String s)
    {
        if (s.isEmpty() || s.isBlank() || s.trim().length() < 2
                || s.trim().length() > 80 || !s.matches("^[\\p{L}\\s]+$"))
        {
            throw new IllegalArgumentException("Caracteres inválidos");

        }

        return true;
    }



}
