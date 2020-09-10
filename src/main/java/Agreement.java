import exception.Language;
import notification.NotificationPackage;

import java.util.Date;

public class Agreement {

    private NotificationPackage notificationPackage;
    private Date startDate;
    private int agreementTimeInMonth;
    private int notificationCount;


    public Agreement() {
        this.agreementTimeInMonth = 1;
        this.notificationCount = 0;
    }

    public NotificationPackage getNotificationPackage() {
        return notificationPackage;
    }

    public void setNotificationPackage(NotificationPackage notificationPackage) {
        this.notificationPackage = notificationPackage;
    }

    public void incrementNotificationCount() {
        this.notificationCount++;
    }

    public Double calculatePrice() {
        this.agreementTimeInMonth++;
        this.notificationCount = 0;

        return notificationPackage.calculate(this.notificationCount);
    }

    public Date getStartDate() {
        return startDate;
    }

    public int getAgreementTimeInMonth() {
        return agreementTimeInMonth;
    }

    public int getNotificationCount() {
        return notificationCount;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

}
