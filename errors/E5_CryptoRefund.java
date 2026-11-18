import ua.duikt.payments.RefundService;
import ua.duikt.payments.method.CryptoPayment;
import ua.duikt.payments.notify.EmailNotifier;

public class E5_CryptoRefund {
    public static void main(String[] args) {
        // Криптовалюта не підтримує повернення коштів і не реалізує Refundable:
        new RefundService(new CryptoPayment(), new EmailNotifier()).refund(10);
    }
}
