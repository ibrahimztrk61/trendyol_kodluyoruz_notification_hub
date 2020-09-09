package notification.quota;

import notification.NotificationCalculator;
import notification.NotificationPackage;

public class RenewWhenExceedPackage extends NotificationPackage implements NotificationCalculator {

    @Override
    public Double calculate(int notificationCount) {
        if (notificationCount < getLimit()) {
            return getMonthlyPrice();
        } else {
            double exceedMultiplier = (double) notificationCount / (double) getLimit();
            double exceedAmount = Math.ceil(exceedMultiplier);
            return exceedAmount * getMonthlyPrice();
        }
    }
}
