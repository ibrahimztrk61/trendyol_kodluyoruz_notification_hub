import notification.NotificationPackage;

import java.util.Date;

public class Invoice {

    private Company company;
    private NotificationPackage notificationPackage;
    private Double price;
    private Date createdDate;
    private Boolean paid;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public NotificationPackage getNotificationPackage() {
        return notificationPackage;
    }

    public void setNotificationPackage(NotificationPackage notificationPackage) {
        this.notificationPackage = notificationPackage;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }
}
