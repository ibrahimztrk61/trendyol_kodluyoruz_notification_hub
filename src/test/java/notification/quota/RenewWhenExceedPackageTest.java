package notification.quota;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


public class RenewWhenExceedPackageTest {

    @Test
    public void it_should_calculate_email() {
        //given
        RenewWhenExceedPackage emailConstantQuotaPackage = new EmailConstantQuotaPackage();
        //when

        Double calculatedPrice = emailConstantQuotaPackage.calculate(100);
        //then

        assertThat(calculatedPrice).isEqualTo(10D);
    } @Test

    public void it_should_calculate_sms() {
        //given
        RenewWhenExceedPackage smsConstantQuotaPackage = new SmsConstantQuotaPackage();
        //when

        Double calculatedPrice = smsConstantQuotaPackage.calculate(100);
        //then

        assertThat(calculatedPrice).isEqualTo(20D);
    }  @Test
    public void it_should_calculate_email_exceed() {
        //given
        RenewWhenExceedPackage emailConstantQuotaPackage = new EmailConstantQuotaPackage();
        //when

        Double calculatedPrice = emailConstantQuotaPackage.calculate(1200);
        //then

        assertThat(calculatedPrice).isEqualTo(20D);
    } @Test

    public void it_should_calculate_sms_exceed() {
        //given
        RenewWhenExceedPackage smsConstantQuotaPackage = new SmsConstantQuotaPackage();
        //when

        Double calculatedPrice = smsConstantQuotaPackage.calculate(1200);
        //then

        assertThat(calculatedPrice).isEqualTo(40D);
    }
}