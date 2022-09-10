package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.CalendarComponent;
import com.demoqa.pages.components.ResultsTableComponent;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;

public class RegistrationFormPage {
    //Elements
    private final static String TITLE_TEXT = "Student Registration Form";
    private CalendarComponent calendarComponent = new CalendarComponent();
    private ResultsTableComponent resultsModal = new ResultsTableComponent();
    private SelenideElement
            pageNameInput = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderInput = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            birthDateInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesInput = $("#hobbiesWrapper"),
            pictureInput = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            stateInput = $("#react-select-3-input"),
            cityInput = $("#react-select-4-input"),
            submitInput = $("#submit");

    // Actions
    public RegistrationFormPage openPage() {
        open("/automation-practice-form");
        pageNameInput.shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }
    public RegistrationFormPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }
    public RegistrationFormPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }
    public RegistrationFormPage setEmail(String value) {
        emailInput.setValue(value);
        return this;
    }
    public RegistrationFormPage setGender(String value) {
        genderInput.$(byText(value)).click();
        return this;
    }
    public RegistrationFormPage setUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }
    public RegistrationFormPage setBirthDate(String day, String month, String year) {
        birthDateInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }
    public RegistrationFormPage setSubjects() {
        subjectsInput.setValue("Arts").pressEnter();
        subjectsInput.setValue("Maths").pressEnter();
        subjectsInput.setValue("Accounting").pressEnter();
        subjectsInput.setValue("Social Studies").pressEnter();
        subjectsInput.setValue("Hindi").pressEnter();
        subjectsInput.setValue("English").pressEnter();
        subjectsInput.setValue("Computer Science").pressEnter();
        subjectsInput.setValue("Commerce").pressEnter();
        subjectsInput.setValue("Chemistry").pressEnter();
        subjectsInput.setValue("Economics").pressEnter();
        subjectsInput.setValue("History").pressEnter();
        subjectsInput.setValue("Physics").pressEnter();
        subjectsInput.setValue("Biology").pressEnter();
        subjectsInput.setValue("Civics").pressEnter();
        return this;
    }
    public RegistrationFormPage setHobbies(String one, String two, String three) {
        hobbiesInput.$(byText(one)).click();
        hobbiesInput.$(byText(two)).click();
        hobbiesInput.$(byText(three)).click();
        return this;
    }

    public RegistrationFormPage uploadPicture(String value) {
        pictureInput.uploadFromClasspath(value);
        return this;
    }

    public RegistrationFormPage currentAddress(String value) {
        addressInput.setValue(value);
        return this;
    }

    public RegistrationFormPage state(String value) {
        stateInput.setValue(value).pressEnter();
        return this;
    }
    public RegistrationFormPage city(String value) {
        cityInput.setValue(value).pressEnter();
        return this;
    }
    public RegistrationFormPage submit() {
        submitInput.click();
        return this;
    }

    public RegistrationFormPage checkResultsTableVisible() {
        resultsModal.checkVisible();
        return this;
    }

    public ResultsTableComponent checkResult(String key, String value) {
        resultsModal.checkResult(key, value);
        return resultsModal;
    }
}
