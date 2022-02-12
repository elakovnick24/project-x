import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "3840x2160";
    }

    @Test
    public void happyPathTest() throws InterruptedException {
        String firstName = "Student";
        String lastName = "Guru";
        String userEmail = "qaguru@guru.com";
        String userNumber = "9111117777";
        String monthBirth = "September";
        String yearBirth = "1993";
        String dayBirth = "2";
        String currentAddress = "196084 SPB";
        String state = "Haryana";
        String city = "Panipat";

        open("/automation-practice-form");
        $(".main-header").shouldHave(Condition.textCaseSensitive("Practice Form"));

        $("#firstName").click();
        $("#firstName").setValue(firstName);

        $("#lastName").click();
        $("#lastName").setValue(lastName);

        $("#userEmail").click();
        $("#userEmail").setValue(userEmail);

        $(".custom-radio:nth-child(1) > .custom-control-label").click();
        $("#userNumber").click();
        $("#userNumber").val(userNumber);

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(monthBirth);
        $(".react-datepicker__year-select").selectOption(yearBirth);
        $(".react-datepicker__day--002").click();

        $("#subjectsInput").click();
        $("#subjectsInput").sendKeys("Co");
        $("#react-select-2-option-0").click();

        $(".custom-checkbox:nth-child(1) > .custom-control-label").click();
        $(".custom-checkbox:nth-child(2) > .custom-control-label").click();
        $(".custom-checkbox:nth-child(3) > .custom-control-label").click();

        $("#uploadPicture").uploadFile(new File("src/test/resources/mini_yoda.jpeg"));
        $("#currentAddress").click();

        $("#currentAddress").sendKeys(currentAddress);
        $("#react-select-3-input").setValue(state).pressEnter();
        $("#react-select-4-input").setValue(city).pressEnter();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(Condition.text("Thanks for submitting the form"));
        $(".table-responsive tr:nth-child(1) > td:nth-child(1)").shouldHave(Condition.textCaseSensitive("Student Name"));
        $(".table-responsive tr:nth-child(1) > td:nth-child(2)").shouldHave(Condition.textCaseSensitive("Student Guru"));
        $(".table-responsive tr:nth-child(2) > td:nth-child(1)").shouldHave(Condition.textCaseSensitive("Student Email"));
        $(".table-responsive tr:nth-child(2) > td:nth-child(2)").shouldHave(Condition.textCaseSensitive(userEmail));
        $(".table-responsive tr:nth-child(3) > td:nth-child(1)").shouldHave(Condition.textCaseSensitive("Gender"));
        $(".table-responsive tr:nth-child(3) > td:nth-child(2)").shouldHave(Condition.textCaseSensitive("Male"));
        $(".table-responsive tr:nth-child(4) > td:nth-child(1)").shouldHave(Condition.textCaseSensitive("Mobile"));
        $(".table-responsive tr:nth-child(4) > td:nth-child(2)").shouldHave(Condition.textCaseSensitive(userNumber));
        $(".table-responsive tr:nth-child(5) > td:nth-child(1)").shouldHave(Condition.textCaseSensitive("Date of Birth"));
        $(".table-responsive tr:nth-child(5) > td:nth-child(2)").shouldHave(Condition.textCaseSensitive("02 September,1993"));
        $(".table-responsive tr:nth-child(6) > td:nth-child(1)").shouldHave(Condition.textCaseSensitive("Subjects"));
        $(".table-responsive tr:nth-child(6) > td:nth-child(2)").shouldHave(Condition.textCaseSensitive("Computer Science"));
        $(".table-responsive tr:nth-child(7) > td:nth-child(1)").shouldHave(Condition.textCaseSensitive("Hobbies"));
        $(".table-responsive tr:nth-child(7) > td:nth-child(2)").shouldHave(Condition.textCaseSensitive("Sports, Reading, Music"));
        $(".table-responsive tr:nth-child(8) > td:nth-child(1)").shouldHave(Condition.textCaseSensitive("Picture"));
        $(".table-responsive tr:nth-child(8) > td:nth-child(2)").shouldHave(Condition.textCaseSensitive("mini_yoda.jpeg"));
        $(".table-responsive tr:nth-child(9) > td:nth-child(1)").shouldHave(Condition.textCaseSensitive("Address"));
        $(".table-responsive tr:nth-child(9) > td:nth-child(2)").shouldHave(Condition.textCaseSensitive(currentAddress));
        $(".table-responsive tr:nth-child(10) > td:nth-child(1)").shouldHave(Condition.textCaseSensitive("State and City"));
        $(".table-responsive tr:nth-child(10) > td:nth-child(2)").shouldHave(Condition.textCaseSensitive("Haryana Panipat"));

        $("#closeLargeModal").click();
    }
}
