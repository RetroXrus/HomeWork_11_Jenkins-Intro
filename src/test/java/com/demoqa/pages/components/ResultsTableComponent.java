package com.demoqa.pages.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selectors.*;

public class ResultsTableComponent {
    //Elements
    private final static String TITLE_TEXT = "Thanks for submitting the form";
    private SelenideElement
            tableOutput = $(".table-responsive table"),
            closeOutput = $("#closeLargeModal");

    // Actions
    public ResultsTableComponent checkVisible() {
        $(".modal-dialog").should(Condition.appear);
        $("#example-modal-sizes-title-lg").shouldHave(text(TITLE_TEXT));

        return this;
    }

    public ResultsTableComponent checkResult(String key, String value) {
        tableOutput.$(byText(key)).parent().shouldHave(text(value));

        return this;
    }
    public ResultsTableComponent closeResult() {
        closeOutput.click();

        return this;
    }


}
