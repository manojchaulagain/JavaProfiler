package com.tutorial.aop.javaprofiler.example;

import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.summingDouble;
import static java.util.stream.Collectors.summingInt;
import static java.util.stream.Collectors.teeing;

public class StreamTeeing {

    public static void main( String[] args ) {
        calculateAverage();
    }

    private static void calculateAverage() {

        double average = Stream.of( 1, 4, 2, 7, 5, 5, 3 ).collect( teeing( summingDouble( i -> i ), counting(), ( sum, n ) -> sum / n ) );
        System.out.println( average );

        long a = Stream.of( "String 1", "asdf", "asdf" ).collect( teeing( summingInt( String::length ), counting(), ( sum, i ) -> sum / i ) );
        System.out.println( a );

        String test = " asdfasdf";

        System.out.println(test.transform( x -> x.substring( 3 ) ) + "");
    }
}
