package com.orderfood.OrderFood.exception;

public class PaymentNotCompletedException extends Throwable {
    public PaymentNotCompletedException(String pleaseMakeThePaymentFirst) {
        super(pleaseMakeThePaymentFirst);
    }
}
