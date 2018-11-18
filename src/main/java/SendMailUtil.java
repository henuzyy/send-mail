import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

/**
 * Created by Administrator on 2018/11/18.
 */
public class SendMailUtil {

    private final static String EMAIL_HOSTNAME = "smtp.sina.com";
    private final static int EMAIL_PORT = 25;
    private final static String EMAIL_FROM = "quote_file@sina.com";
    private final static String EMAIL_USERNAME = "quote_file@sina.com";
    private final static String EMAIL_PASSWORD = "quote_file";
    private final static String EMAIL_TITLE = "行情落地告警";


    public static boolean sendEmail(String emailMsg, String toEmail) {
        Email email = new SimpleEmail();
        email.setHostName(EMAIL_HOSTNAME);
        email.setSmtpPort(EMAIL_PORT);
        email.setAuthenticator(new DefaultAuthenticator(EMAIL_USERNAME, EMAIL_PASSWORD));
        email.setSSLOnConnect(true);
        email.setSubject(EMAIL_TITLE);
        try {
            email.setFrom(EMAIL_FROM);
            email.setMsg(emailMsg);
            email.addTo(toEmail);
            email.send();
        } catch (EmailException e) {
            e.printStackTrace();
        }

        return true;
    }

    public static void main(String[] args) {
        String warnMsg = "这是一个测试邮件，请忽略";
        String toMail = "897080264@qq.com";
        SendMailUtil.sendEmail(warnMsg,toMail);
    }
}
