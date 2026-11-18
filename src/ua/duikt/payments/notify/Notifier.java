package ua.duikt.payments.notify;

/** Друга, незалежна залежність сервісів — сповіщення клієнта. */
public interface Notifier {

    void notifyClient(String message);
}
