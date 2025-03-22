package com.jiocoders.paymentsdk

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.util.Log

// Payment SDK class
object PaymentSDK {
    private var callback: PaymentCallback? = null

    fun initialize(context: Context) {
        Log.d("PaymentSDK", "SDK Initialized ${context.cacheDir}")
    }

    fun startPayment(activity: Activity, amount: Double, callback: PaymentCallback) {
        this.callback = callback
        val intent = Intent(activity, PaymentActivity::class.java)
        intent.putExtra("amount", amount)
        activity.startActivityForResult(intent, PAYMENT_REQUEST_CODE)
    }

    fun handleActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == PAYMENT_REQUEST_CODE) {
            when (resultCode) {
                Activity.RESULT_OK -> {
                    val transactionId = data?.getStringExtra("transactionId") ?: "Unknown"
                    callback?.onSuccess(transactionId)
                }

                Activity.RESULT_CANCELED -> {
                    val error = data?.getStringExtra("error") ?: "Payment Canceled"
                    callback?.onFailure(error)
                }
            }
        }
    }

    private const val PAYMENT_REQUEST_CODE = 1001
}
