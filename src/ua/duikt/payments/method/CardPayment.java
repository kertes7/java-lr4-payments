package ua.duikt.payments.method;

/** Оплата карткою: підтримує повернення коштів. */
public class CardPayment extends AbstractPaymentMethod implements Refundable {

    @Override
    protected void doPay(double amount) {
        System.out.println("Оплата " + format(amount) + " карткою");
    }

    @Override
    public void refund(double amount) {
        System.out.println("Повернення " + format(amount) + " на картку");
    }
}
