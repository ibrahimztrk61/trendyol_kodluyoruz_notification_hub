import notification.NotificationPackage;
import notification.quota.EmailConstantQuotaPackage;
import notification.quota.SmsConstantQuotaPackage;
import org.junit.Test;

import java.util.Date;
import java.util.stream.IntStream;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class CompanyTest {


    @Test
    public void company_should_make_an_agreement_with_notification_package(){
        //given
        Company company = new Company();
        company.setId(1L);
        company.setName("A");

        NotificationPackage smsConstantQuotaPackage = new SmsConstantQuotaPackage();

        Agreement agreement = new Agreement();
        agreement.setNotificationPackage(smsConstantQuotaPackage);

        //when
        company.makeAgreement(agreement);

        //then
        assertThat(company.getAgreements()).hasSize(1);
        assertThat(company.getAgreements().get(smsConstantQuotaPackage).getNotificationPackage()).isExactlyInstanceOf(SmsConstantQuotaPackage.class);
        assertThat(company.getAgreements().get(smsConstantQuotaPackage).getNotificationPackage().getLimit()).isEqualTo(1000);
        assertThat(company.getAgreements().get(smsConstantQuotaPackage).getNotificationPackage().getMonthlyPrice()).isEqualTo(20D);
        assertThat(company.getAgreements().get(smsConstantQuotaPackage).getStartDate()).isEqualToIgnoringMillis(new Date());
        assertThat(company.getAgreements().get(smsConstantQuotaPackage).getAgreementTimeInMonth()).isEqualTo(1);
        assertThat(company.getAgreements().get(smsConstantQuotaPackage).getNotificationCount()).isEqualTo(0);

        company.getAgreements().get(smsConstantQuotaPackage).incrementNotificationCount();

        assertThat(company.getAgreements().get(smsConstantQuotaPackage).getNotificationCount()).isEqualTo(1);
    }

    @Test
    public void it_should_calculate_price_of_email_constant_quota_package_when_not_exceed(){
        //given
        Company company = new Company();
        company.setId(1L);
        company.setName("A");

        NotificationPackage smsConstantQuotaPackage = new SmsConstantQuotaPackage();
        NotificationPackage emailConstantQuotaPackage = new EmailConstantQuotaPackage();

        Agreement smsConstantAgreement = new Agreement();
        smsConstantAgreement.setNotificationPackage(smsConstantQuotaPackage);

        Agreement emailConsatantAgreement = new Agreement();
        emailConsatantAgreement.setNotificationPackage(emailConstantQuotaPackage);

        //when
        company.makeAgreement(smsConstantAgreement);
        company.makeAgreement(emailConsatantAgreement);

        //then

        IntStream.range(0 , 800).forEach(
                i -> company.getAgreements().get(emailConstantQuotaPackage).incrementNotificationCount()
        );

        Agreement invoicedAgreement = company.getAgreements().get(emailConstantQuotaPackage);

        Double price = invoicedAgreement.calculatePrice();

        assertThat(price).isEqualTo(10D);
    }

    @Test
    public void it_should_calculate_price_of_email_constant_quota_package_when_exceed(){
        //given
        Company company = new Company();
        company.setId(1L);
        company.setName("A");

        NotificationPackage smsConstantQuotaPackage = new SmsConstantQuotaPackage();
        NotificationPackage emailConstantQuotaPackage = new EmailConstantQuotaPackage();

        Agreement smsConstantAgreement = new Agreement();
        smsConstantAgreement.setNotificationPackage(smsConstantQuotaPackage);

        Agreement emailConstantAgreement = new Agreement();
        emailConstantAgreement.setNotificationPackage(emailConstantQuotaPackage);

        //when
        company.makeAgreement(smsConstantAgreement);
        company.makeAgreement(emailConstantAgreement);

        User user = new User();
        user.setEmail("ibrahimztrk@gmail.com");
        user.setName("ibrahim");
        user.setTelNo("5461234567");
        company.addUsers(user);
        //then

        IntStream.range(0 , 1200).forEach(
                //i -> company.getAgreements().get(emailConstantQuotaPackage).incrementNotificationCount()
                i -> company.sendNotification("Hello", emailConstantQuotaPackage)
        );

        Double price = company.getAgreements().get(emailConstantQuotaPackage).calculatePrice();

        assertThat(price).isEqualTo(20D);
    }
}
