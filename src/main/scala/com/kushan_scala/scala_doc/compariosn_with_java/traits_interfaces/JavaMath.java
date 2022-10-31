package com.kushan_scala.scala_doc.compariosn_with_java.traits_interfaces;


interface Adder_J {
    int add(int a, int b);
}

interface Multiplier_J {
    default int multiply (
            int a,
            int b)
    {
        return a * b;
    }
}

public class JavaMath implements Adder_J, Multiplier_J {
    @Override
    public int add(int a, int b) {
        return a+b;
    }
}
