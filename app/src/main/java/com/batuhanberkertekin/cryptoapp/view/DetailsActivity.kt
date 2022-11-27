package com.batuhanberkertekin.cryptoapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.batuhanberkertekin.cryptoapp.R
import com.batuhanberkertekin.cryptoapp.data.Crypto
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)




        val intent = intent.getSerializableExtra("key") as Crypto

        cryptoName.text = intent.currency
        cryptoPrice.text = intent.price





    }
}