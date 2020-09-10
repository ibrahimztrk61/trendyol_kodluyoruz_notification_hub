package exception;

public class TurkishMessage implements Language {
    @Override
    public String message() {
        String turkishMessage = "Kullanıcı grup listesi boş olduğu için mesaj gönderilmedi.";
        return turkishMessage;
    }
}
