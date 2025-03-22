package com.jiocoders.paymentsdk

// Callback interface for payment result
interface PaymentCallback {
    fun onSuccess(transactionId: String)

    fun onFailure(error: String)
}