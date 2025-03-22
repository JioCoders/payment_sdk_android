package com.jiocoders.paymentsdk

import android.app.Activity
import android.content.Intent
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

// PaymentActivity to simulate a payment process
class PaymentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)
        val amount = intent.getDoubleExtra("amount", 0.0)
        Log.d("PaymentActivity", "SDK amount $amount")

        // Simulating payment process
        val isSuccess = (0..1).random() == 1
        val resultIntent = Intent()
        if (isSuccess) {
            resultIntent.putExtra("transactionId", "TXN123456")
            setResult(Activity.RESULT_OK, resultIntent)
        } else {
            resultIntent.putExtra("error", "Transaction Failed")
            setResult(Activity.RESULT_CANCELED, resultIntent)
        }
        finish()
    }
}
