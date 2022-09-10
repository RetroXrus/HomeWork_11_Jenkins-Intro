package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.pages.RegistrationFormPage;
import org.junit.jupiter.api.*;

import static io.qameta.allure.Allure.step;

public class RegistrationFormTests extends TestBase {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @Test
    void fillFormTest() {
        step("Open registrations form", () -> {
            registrationFormPage.openPage();
        });
        step("Fill form", () -> {
            //Заполняем данными страницу и отправляем
            registrationFormPage
                    .setFirstName("New")
                    .setLastName("One")
                    .setEmail("newone@example.com")
                    .setGender("Other")
                    .setUserNumber("1234567890")
                    .setBirthDate("17", "June", "1987")
                    .setSubjects()
                    .setHobbies("Sports", "Reading", "Music")
                    .uploadPicture("img/testFile.jpg")
                    .currentAddress("NewOneTown, NewOne st., 22")
                    .state("Uttar Pradesh")
                    .city("Lucknow");
        });
        step("Check form results", () -> {
            //Проверяем результаты построчно
            registrationFormPage
                    .checkResultsTableVisible()
                    .checkResult("Label", "Values")
                    .checkResult("Student Name", "New One")
                    .checkResult("Student Email", "newone@example.com")
                    .checkResult("Gender", "Other")
                    .checkResult("Mobile", "1234567890")
                    .checkResult("Date of Birth", "17 June,1987")
                    .checkResult("Subjects", "Arts, Maths, Accounting, Social Studies, Hindi, English, Computer Science, Commerce, Chemistry, Economics, History, Physics, Biology, Civics")
                    .checkResult("Hobbies", "Sports, Reading, Music")
                    .checkResult("Picture", "testFile.jpg")
                    .checkResult("Address", "NewOneTown, NewOne st., 22")
                    .checkResult("State and City", "Uttar Pradesh Lucknow")
                    .closeResult();
        });
    }
}
