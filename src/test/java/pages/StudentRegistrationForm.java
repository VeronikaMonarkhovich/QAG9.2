package pages;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class StudentRegistrationForm {

    public void openPage(String url) {
        open(url);
    }

    public void fillFirstName(String firstName) {
        $("#firstName").setValue(firstName);
    }

    public void fillLastName(String lastName) {
        $("#lastName").setValue(lastName);
    }

    public void fillEmail(String email) {
        $("#userEmail").setValue(email);
    }

    public void selectGender(String gender) {
        $(byText(gender)).click();
    }

    public void fillMobileNumber(String mobileNumber) {
        $("#userNumber").setValue(mobileNumber);
    }

    public void fillDateOfBirth(String year,
                                String month,
                                String day) {
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__month-select").selectOption(month);
        $x(String.format("//*[contains(@aria-label,'%s %sth, %s')]", month, day, year)).click();
    }

    public void selectSubject(String subject) {
        $("#subjectsInput").setValue(subject).pressEnter();
    }

    public void selectHobbies(String hobbies) {
        $("#hobbiesWrapper").$(byText(hobbies)).click();
    }

    public void uploadPicture(String picture) {
        $("input#uploadPicture").uploadFile(new File("src/test/resources/" + picture));
    }

    public void fillAddress(String address) {
        $("#currentAddress").setValue(address);
    }

    public void selectState(String state) {
        $("#state").click();
        $("#state").$(byText(state)).click();
    }

    public void selectCity(String city) {
        $("#city").click();
        $("#city").$(byText(city)).click();
    }

    public void clickSubmit() {
        $("#submit").click();
    }

    public void testRegistrationForm(
            String firstName,
            String lastName,
            String email,
            String gender,
            String mobileNumber,
            String day,
            String month,
            String year,
            String subject,
            String hobbies,
            String picture,
            String address,
            String state,
            String city) {
        $("tbody").shouldHave(text(firstName + " " + lastName),
                text(email),
                text(gender),
                text(mobileNumber),
                text(day + " " + month + "," + year),
                text(subject),
                text(hobbies),
                text(picture),
                text(address),
                text(state),
                text(city)
        );
    }
}
