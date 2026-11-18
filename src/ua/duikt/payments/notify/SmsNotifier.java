package ua.duikt.payments.notify;

public class SmsNotifier implements Notifier {

    @Override
    public void notifyClient(String message) {
        System.out.println("SMS: клієнта сповіщено про " + message);
    }
}
