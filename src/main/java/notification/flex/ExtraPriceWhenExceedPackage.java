package notification.flex;

import notification.NotificationCalculator;
import notification.NotificationPackage;

public class ExtraPriceWhenExceedPackage extends NotificationPackage implements NotificationCalculator {

    private Double extraPricePerNotification;

    public Double getExtraPricePerNotification() {
        return extraPricePerNotification;
    }

    public void setExtraPricePerNotification(Double extraPricePerNotification) {
        this.extraPricePerNotification = extraPricePerNotification;
    }

    @Override
    public Double calculate(int count) {
        return getMonthlyPrice() + ((count - getLimit() )* getExtraPricePerNotification());

    }
}
