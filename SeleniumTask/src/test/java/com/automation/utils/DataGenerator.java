package com.automation.utils;

import com.github.javafaker.Faker;

public class DataGenerator {
    private static final Faker faker = new Faker();

    // Generating the name with capital letter
    public static String generateValidFirstName() {
        String firstName = faker.name().firstName();
        return firstName.substring(0, 1).toUpperCase() + firstName.substring(1);
    }

    // Generating the name with capital letter and doesn't equal first name
    public static String generateValidLastName(String firstName) {
        String lastName;
        do {
            lastName = faker.name().lastName();
        } while (lastName.equalsIgnoreCase(firstName));  // Ensure Last Name is not equal to First Name

        return lastName.substring(0, 1).toUpperCase() + lastName.substring(1);
    }

    // Generating a valid phone number
    public static String generateValidPhoneNumber() {
        StringBuilder phoneNumber = new StringBuilder("01");

        // Generate 9 more digits (totaling 11)
        for (int i = 0; i < 9; i++) {
            phoneNumber.append(faker.random().nextInt(0, 10));
        }

        return phoneNumber.toString();
    }

    // Generating a unique valid Email
    public static String generateUniqueEmail() {
        return faker.internet().emailAddress();
    }
}
