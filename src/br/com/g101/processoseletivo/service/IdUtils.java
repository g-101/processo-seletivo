package br.com.g101.processoseletivo.service;

import java.util.concurrent.atomic.AtomicReference;

public class IdUtils {
    private static AtomicReference<Long> currentTime =
            new AtomicReference<>(System.currentTimeMillis());

    public static Long nextId() {
        return currentTime.accumulateAndGet(System.currentTimeMillis(),
                (prev, next) -> next > prev ? next : prev + 1);
    }
}
