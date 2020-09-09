package notification.flex;

public class EmailFlexPackage extends ExtraPriceWhenExceedPackage {

    public EmailFlexPackage() {
        setMonthlyPrice(7.5D);
        setLimit(2000);
        setExtraPricePerNotification(0.03D);
    }
}
