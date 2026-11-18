package ua.duikt.payments.notify;

public class EmailNotifier implements Notifier {

    @Override
    public void notifyClient(String message) {
        System.out.println("Email: клієнта сповіщено про " + message);
    }
}
