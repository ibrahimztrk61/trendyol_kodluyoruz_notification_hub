package notification.flex;

public class SmsFlexPackage extends ExtraPriceWhenExceedPackage {

    public SmsFlexPackage() {
        setLimit(2000);
        setMonthlyPrice(30D);
        setExtraPricePerNotification(0.1D);
    }
}
