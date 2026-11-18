package ua.duikt.payments;

import ua.duikt.payments.method.AbstractPaymentMethod;
import ua.duikt.payments.method.Refundable;
import ua.duikt.payments.notify.Notifier;

/**
 * Сервіс повернення коштів приймає лише Refundable: передати сюди CryptoPayment неможливо
 * вже на етапі компіляції — без перевірок instanceof і без винятків «не підтримується».
 */
public class RefundService {

    private final Refundable method;
    private final Notifier notifier;

    public RefundService(Refundable method, Notifier notifier) {
        this.method = method;
        this.notifier = notifier;
    }

    public void refund(double amount) {
        method.refund(amount);
        notifier.notifyClient("повернення " + AbstractPaymentMethod.format(amount));
    }
}
