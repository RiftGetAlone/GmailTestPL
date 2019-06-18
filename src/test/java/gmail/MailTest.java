package gmail;

import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import pages.LoginPage;
import pages.MailPage;


public class MailTest extends WebDriverSettings {

    @Test
    public void SendLetter(){
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        MailPage mailPage = PageFactory.initElements(driver, MailPage.class);

        String emailSender = "emailSender";
        String passwordSender = "passwordSender";

        String emailRecipient = "emailRecipient";
        String letterSubject = "letterSubject";
        String letterText = "letterText";

        loginPage.open();
        loginPage.writeLogin(emailSender);
        loginPage.inputLogin();
        loginPage.writePassword(passwordSender);
        loginPage.inputPassword();

        mailPage.open();
        mailPage.createNewLetter();
        mailPage.writeRecipientEmail(emailRecipient);
        mailPage.writeLetterSubject(letterSubject);
        mailPage.writeLetterText(letterText);
        mailPage.sendLetter();
    }
}
