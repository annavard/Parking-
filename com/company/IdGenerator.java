package com.company;

/**
 * Created by anhaytananun on 12.05.15.
 */
public class IdGenerator {
    private long counter = 0;
    private String prefix;

    public IdGenerator(String prefix) {
        this.prefix = prefix;
    }

    public String generateId() {
        counter++;
        return prefix + "_" + counter;
    }
}
