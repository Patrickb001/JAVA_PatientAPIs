package com.patrick.PatientAPIMGDB;

public class Counter {
    private static Integer id = 0;

    public Counter(){}

    public static Integer getId() {
        increment();
        return id;
    }

    public static void increment(){
        id++;
    }
}
