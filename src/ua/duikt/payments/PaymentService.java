package ua.duikt.payments;

import ua.duikt.payments.method.AbstractPaymentMethod;
import ua.duikt.payments.method.PaymentMethod;
import ua.duikt.payments.notify.Notifier;

/**
 * Центральний сервіс. Залежить ЛИШЕ від абстракцій (PaymentMethod, Notifier) і нічого не створює сам:
 * обидві залежності передаються через конструктор і замінюються незалежно одна від одної.
 */
public class PaymentService {

    private final PaymentMethod method;
    private final Notifier notifier;

    public PaymentService(PaymentMethod method, Notifier notifier) {
        this.method = method;
        this.notifier = notifier;
    }

    public void pay(double amount) {
        method.pay(amount);
        notifier.notifyClient("оплату " + AbstractPaymentMethod.format(amount));
    }
}
