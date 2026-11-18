package ua.duikt.payments;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import ua.duikt.payments.method.ApplePayPayment;
import ua.duikt.payments.method.CardPayment;
import ua.duikt.payments.method.CryptoPayment;
import ua.duikt.payments.method.PayPalPayment;
import ua.duikt.payments.notify.EmailNotifier;
import ua.duikt.payments.notify.SmsNotifier;

/** Єдина точка збирання (composition root): тут створюються і з'єднуються всі об'єкти. */
public class Main {

    public static void main(String[] args) {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        System.out.println("=== Конфігурація 1: картка + Email ===");
        PaymentService s1 = new PaymentService(new CardPayment(), new EmailNotifier());
        s1.pay(500.00);

        System.out.println();
        System.out.println("=== Конфігурація 2: PayPal + SMS (замінено обидві залежності) ===");
        PaymentService s2 = new PaymentService(new PayPalPayment(), new SmsNotifier());
        s2.pay(250.50);

        System.out.println();
        System.out.println("=== Конфігурація 3: криптовалюта + Email (замінено лише спосіб оплати) ===");
        PaymentService s3 = new PaymentService(new CryptoPayment(), new EmailNotifier());
        s3.pay(1000.00);

        System.out.println();
        System.out.println("=== Додаткова можливість: повернення коштів (лише Refundable) ===");
        new RefundService(new CardPayment(), new EmailNotifier()).refund(100.00);
        new RefundService(new PayPalPayment(), new SmsNotifier()).refund(50.00);
        // new RefundService(new CryptoPayment(), ...);   // помилка компіляції: CryptoPayment не є Refundable

        System.out.println();
        System.out.println("=== Нова реалізація ApplePayPayment (сервіси не змінювались) ===");
        new PaymentService(new ApplePayPayment(), new SmsNotifier()).pay(75.00);
        new RefundService(new ApplePayPayment(), new EmailNotifier()).refund(25.00);
    }
}
