package com.jiocoders.paymentapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import com.jiocoders.paymentsdk.PaymentCallback
import com.jiocoders.paymentsdk.PaymentSDK

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        PaymentSDK.initialize(this)

        findViewById<Button>(R.id.payButton).setOnClickListener {
            PaymentSDK.startPayment(this, 20.0, object : PaymentCallback {
                override fun onSuccess(transactionId: String) {
                    Toast.makeText(this@MainActivity, "Success: $transactionId", Toast.LENGTH_LONG)
                        .show()
                }

                override fun onFailure(error: String) {
                    Toast.makeText(this@MainActivity, "Failed: $error", Toast.LENGTH_LONG).show()
                }
            })
        }
    }

    @Deprecated("This method has been deprecated in favor of using the Activity Result API\n      which brings increased type safety via an {@link ActivityResultContract} and the prebuilt\n      contracts for common intents available in\n      {@link androidx.activity.result.contract.ActivityResultContracts}, provides hooks for\n      testing, and allow receiving results in separate, testable classes independent from your\n      activity. Use\n      {@link #registerForActivityResult(ActivityResultContract, ActivityResultCallback)}\n      with the appropriate {@link ActivityResultContract} and handling the result in the\n      {@link ActivityResultCallback#onActivityResult(Object) callback}.")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        PaymentSDK.handleActivityResult(requestCode, resultCode, data)
    }
}