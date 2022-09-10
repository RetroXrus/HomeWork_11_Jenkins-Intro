package com.demoqa.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

    private SelenideElement
            birthDateInput = $("#dateOfBirthInput"),
            yearInput = $(".react-datepicker__year-select"),
            monthInput = $(".react-datepicker__month-select");
    public CalendarComponent setDate(String day, String month, String year) {
        birthDateInput.click();
        monthInput.selectOption(month);
        yearInput.selectOption(year);
        $(".react-datepicker__day--0" + day + ":not(.react-datepicker__day--outside-month)").click();
        return this;
    }
}
