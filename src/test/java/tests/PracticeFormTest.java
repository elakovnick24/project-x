package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import tests.pages.RegistrationPage;

import java.io.File;

import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTest extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    String firstName = "Student";
    String lastName = "Guru";
    String userEmail = "qaguru@guru.com";
    String userNumber = "9111117777";
    String userGender = "Male";
    String monthBirth = "September";
    String yearBirth = "1993";
    String dayBirth = "2";
    String subject = "Computer Science";
    String currentAddress = "196084 SPB";
    String state = "Haryana";
    String city = "Panipat";
    File image = new File("src/test/resources/img/1.png");
    String textHeaderModalWindow = "Thanks for submitting the form";

    String fieldStName = "Student Name";
    String fieldStEmail = "Student Email";
    String fieldGender = "Gender";
    String fieldMobile = "Mobile";
    String fieldDBirth = "Date of Birth";
    String resultBirth = dayBirth + " " + " " + monthBirth + "," + yearBirth;
    String fieldSubjects = "Subjects";
    String fieldHobbies = "Hobbies";
    String resultHobbies = "Music, Reading, Sports";
    String fieldPictute = "Picture";
    String resultPicture = "1.png";
    String fieldAddress = "Address";
    String fieldStateCity = "State and City";
    String resultStateCity = state + " " + city;

    @Test
    public void happyPathTest() throws InterruptedException {
        SelenideLogger.addListener("allure", new AllureSelenide());
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setUserGender()
                .setUserNumber(userNumber)
                .setBirthDate(dayBirth, monthBirth, yearBirth)
                .setUserNumber(userNumber)
                .setSubjects(subject)
                .setHobbies()
                //.uploadImage(image)
                .setCurrentAddress(currentAddress)
                .chooseState(state)
                .chooseCity(city)
                .clickSubmit()
                .checkTextModalWindow(textHeaderModalWindow)
                .checkForm(fieldStName, firstName)
                .checkForm(fieldStEmail, userEmail)
                .checkForm(fieldGender, userGender)
                .checkForm(fieldMobile, userNumber)
                .checkForm(fieldDBirth, resultBirth)
                .checkForm(fieldSubjects, subject)
                .checkForm(fieldHobbies, resultHobbies)
                //.checkForm(fieldPictute, resultPicture)
                .checkForm(fieldAddress, currentAddress)
                .checkForm(fieldStateCity, resultStateCity)
                .clickClose()
                .checkModalWindowNotVisible();
    }
}
