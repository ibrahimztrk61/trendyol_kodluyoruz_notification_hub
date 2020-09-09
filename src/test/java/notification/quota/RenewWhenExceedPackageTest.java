package notification.quota;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


public class RenewWhenExceedPackageTest {

    @Test
    public void it_should_calculate() {
        //given
        RenewWhenExceedPackage emailConstantQuotaPackage = new EmailConstantQuotaPackage();
        //when

        Double calculatedPrice = emailConstantQuotaPackage.calculate(100);
        //then

        assertThat(calculatedPrice).isEqualTo(10D);
    }
}