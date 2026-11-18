package ua.duikt.payments.method;

import java.util.Locale;

/**
 * Абстрактний клас із СПІЛЬНОЮ частиною поведінки (перевірка суми, форматування), щоб не дублювати її
 * в кожній реалізації. Конкретна дія оплати — в абстрактному методі doPay (шаблонний метод).
 */
public abstract class AbstractPaymentMethod implements PaymentMethod {

    @Override
    public final void pay(double amount) {
        requirePositive(amount);       // спільна перевірка — в одному місці
        doPay(amount);
    }

    protected abstract void doPay(double amount);

    protected static void requirePositive(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Сума має бути додатною: " + format(amount));
        }
    }

    public static String format(double amount) {
        return String.format(Locale.US, "%.2f", amount);
    }
}
