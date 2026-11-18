package ua.duikt.payments.method;

/** Оплата через PayPal: підтримує повернення коштів. */
public class PayPalPayment extends AbstractPaymentMethod implements Refundable {

    @Override
    protected void doPay(double amount) {
        System.out.println("Оплата " + format(amount) + " через PayPal");
    }

    @Override
    public void refund(double amount) {
        System.out.println("Повернення " + format(amount) + " на рахунок PayPal");
    }
}
