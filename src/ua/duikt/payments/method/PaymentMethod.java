package ua.duikt.payments.method;

/** Абстракція «спосіб оплати» — єдине, що знає PaymentService. Містить лише спільну можливість. */
public interface PaymentMethod {

    void pay(double amount);
}
