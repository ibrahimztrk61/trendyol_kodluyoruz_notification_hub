import exception.Language;
import notification.NotificationPackage;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Company {

    private Long id;
    private String name;
    private HashMap<NotificationPackage, Agreement> agreementMap = new HashMap();
    private List<User> users = new ArrayList<>();
    private Language language;

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void makeAgreement(Agreement agreement) {
        agreement.setStartDate(new Date());
        agreementMap.put(agreement.getNotificationPackage(), agreement);
    }

    public HashMap<NotificationPackage, Agreement> getAgreements() {
        return agreementMap;
    }


    public List<User> getUsers() {
        return users;
    }

    public void addUsers(User user) {
        this.users.add(user);
    }

    public void sendNotification(String message, NotificationPackage notificationPackage) {

        if (this.users.isEmpty()) {
            throw new IllegalArgumentException(getLanguage().message());
        }
        System.out.println("Message is sent: " + message);

        this.agreementMap.get(notificationPackage).incrementNotificationCount();
    }
}
