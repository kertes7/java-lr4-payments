package ua.duikt.payments.method;

/**
 * НОВА реалізація, додана після першого коміту. Успадковує спільну поведінку від AbstractPaymentMethod
 * і підтримує повернення коштів. Жоден рядок PaymentService / RefundService не змінено.
 */
public class ApplePayPayment extends AbstractPaymentMethod implements Refundable {

    @Override
    protected void doPay(double amount) {
        System.out.println("Оплата " + format(amount) + " через Apple Pay");
    }

    @Override
    public void refund(double amount) {
        System.out.println("Повернення " + format(amount) + " на рахунок Apple Pay");
    }
}
