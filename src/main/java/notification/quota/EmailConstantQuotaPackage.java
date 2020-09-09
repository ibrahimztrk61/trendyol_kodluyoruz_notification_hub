package notification.quota;

public class EmailConstantQuotaPackage extends RenewWhenExceedPackage {

    public EmailConstantQuotaPackage() {
        setLimit(1000);
        setMonthlyPrice(10.0D);
    }

}
