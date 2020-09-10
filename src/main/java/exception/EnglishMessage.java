package exception;

public class EnglishMessage implements Language {

    @Override
    public String message() {
        String englishMessage = "Notification is not send! Because user group list is empty";
        return englishMessage;
    }
}
