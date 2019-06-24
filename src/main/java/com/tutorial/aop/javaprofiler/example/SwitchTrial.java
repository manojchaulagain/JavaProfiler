package com.tutorial.aop.javaprofiler.example;

public class SwitchTrial {

    enum Day {
        SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
    }

    public static void main( String[] args ) {
        testSwitch( Day.WEDNESDAY );
        testSwitch( Day.MONDAY );
    }

    private static void testSwitch( Day day ) {
        switch ( day ) {
            case SUNDAY, MONDAY, TUESDAY -> System.out.println( "Testing Switch " + day.name() );
            case WEDNESDAY, THURSDAY, FRIDAY, SATURDAY -> System.out.println( "Testing Switch Again " + day.name() );
        }
    }
}
