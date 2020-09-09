package notification.quota;

import notification.quota.RenewWhenExceedPackage;

public class SmsConstantQuotaPackage extends RenewWhenExceedPackage {

    public SmsConstantQuotaPackage() {
        setLimit(1000);
        setMonthlyPrice(20.0D);
    }
}
