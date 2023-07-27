package com.company.oop.agency.utils;

import java.util.List;

public class ValidationHelper {

    public static final String INVALID_NUMBER_OF_ARGUMENTS = "Invalid number of arguments. Expected: %d, Received: %d";

    public static void validateValueInRange(double value, double min, double max, String errorMessage) {
        // Needs to check if value > min and if value < max
        //    passengerCap, MIN_PASSENGER_CAP, MAX_PASSENGER_CAP, ERROR_MESSAGE_PASSENGER_CAP);
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public static void validateStringLength(String stringToValidate, int minLength, int maxLength, String errorMessage) {
        validateValueInRange(stringToValidate.length(), minLength, maxLength, errorMessage);
    }

    public static void validateArgumentsCount(List<String> list, int expectedArgumentsCount) {
        if (list.size() < expectedArgumentsCount || list.size() > expectedArgumentsCount) {
            throw new IllegalArgumentException(String.format(INVALID_NUMBER_OF_ARGUMENTS, expectedArgumentsCount, list.size()));
        }
    }

}