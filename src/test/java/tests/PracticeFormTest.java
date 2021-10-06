package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.StudentRegistrationForm;

import java.util.Locale;


public class PracticeFormTest extends config.TestBase {

    StudentRegistrationForm studentRegistrationForm = new StudentRegistrationForm();

    Faker fake = new Faker(new Locale("en-US"));

    String  url = "https://demoqa.com/automation-practice-form",
            firstName = fake.name().firstName(),
            lastName = fake.name().lastName(),
            email = fake.internet().emailAddress(),
            gender = fake.demographic().sex(),
            mobileNumber = fake.number().digits(10),
            year = String.valueOf(fake.number().numberBetween(1950, 2000)),
            month = fake.options().option("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"),
            day = String.valueOf(fake.number().numberBetween(10, 20)),
            subject = fake.options().option("English", "Maths", "Physics"),
            address = fake.address().fullAddress(),
            hobbies = fake.options().option("Sports", "Reading", "Music"),
            picture = fake.options().option("gif.jpg", "jpg.jpg", "png.jpg"),
            state = "NCR",
            city = "Delhi";

    @Test
    void successfulSubmitFormTest() {

        studentRegistrationForm.openPage(url);

        studentRegistrationForm.fillFirstName(firstName);
        studentRegistrationForm.fillLastName(lastName);
        studentRegistrationForm.fillEmail(email);
        studentRegistrationForm.selectGender(gender);
        studentRegistrationForm.fillMobileNumber(mobileNumber);
        studentRegistrationForm.fillDateOfBirth(year, month, day);
        studentRegistrationForm.selectSubject(subject);
        studentRegistrationForm.selectHobbies(hobbies);
        studentRegistrationForm.uploadPicture(picture);
        studentRegistrationForm.fillAddress(address);
        studentRegistrationForm.selectState(state);
        studentRegistrationForm.selectCity(city);

        studentRegistrationForm.clickSubmit();

        studentRegistrationForm.testRegistrationForm(
                firstName,
                lastName,
                email,
                gender,
                mobileNumber,
                day,
                month,
                year,
                subject,
                hobbies,
                picture,
                address,
                state,
                city
        );
    }

}
