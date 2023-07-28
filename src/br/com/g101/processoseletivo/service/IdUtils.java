package br.com.g101.processoseletivo.service;

import java.util.concurrent.atomic.AtomicReference;

public class IdUtils {

    private static long id = 1;

    public static long nextId() {
        return id++;
    }

}
