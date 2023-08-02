package br.com.g101.processoseletivo.service;


public class IdUtils {

    private static int id = 1;

    public static int nextId() {
        return id++;
    }

}
