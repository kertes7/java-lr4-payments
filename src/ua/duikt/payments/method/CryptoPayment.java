package ua.duikt.payments.method;

/**
 * Оплата криптовалютою: повернення коштів НЕ підтримує, тому Refundable не реалізує
 * і не містить жодного порожнього або «заглушкового» методу refund().
 */
public class CryptoPayment extends AbstractPaymentMethod {

    @Override
    protected void doPay(double amount) {
        System.out.println("Оплата " + format(amount) + " криптовалютою");
    }
}
