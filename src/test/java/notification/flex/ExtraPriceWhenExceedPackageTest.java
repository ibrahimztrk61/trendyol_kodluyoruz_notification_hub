package notification.flex;

import notification.quota.EmailConstantQuotaPackage;
import notification.quota.RenewWhenExceedPackage;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.*;

public class ExtraPriceWhenExceedPackageTest {
    @Test
    public void it_should_calculate_email() {
        //given
        ExtraPriceWhenExceedPackage emailFlexPackage = new EmailFlexPackage();
        //when

        Double calculatedPrice = emailFlexPackage.calculate(1500);
        //then

        assertThat(calculatedPrice).isEqualTo(7.5D);
    }
    @Test
    public void it_should_calculate_sms() {
        //given
        ExtraPriceWhenExceedPackage smsFlexPackage = new SmsFlexPackage();
        //when

        Double calculatedPrice = smsFlexPackage.calculate(1500);
        //then

        assertThat(calculatedPrice).isEqualTo(30D);
    }
@Test
    public void it_should_calculate_email_exceed() {
        //given
        ExtraPriceWhenExceedPackage emailFlexPackage = new EmailFlexPackage();
        //when

        Double calculatedPrice = emailFlexPackage.calculate(2100);
        //then

        assertThat(calculatedPrice).isEqualTo(10.5D);
    }
    @Test
    public void it_should_calculate_sms_exceed() {
        //given
        ExtraPriceWhenExceedPackage smsFlexPackage = new SmsFlexPackage();
        //when

        Double calculatedPrice = smsFlexPackage.calculate(2100);
        //then

        assertThat(calculatedPrice).isEqualTo(40D);
    }

}