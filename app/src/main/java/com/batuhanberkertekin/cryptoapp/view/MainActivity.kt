package com.batuhanberkertekin.cryptoapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.batuhanberkertekin.cryptoapp.R
import com.batuhanberkertekin.cryptoapp.adapter.CryptoAdapter
import com.batuhanberkertekin.cryptoapp.data.Crypto
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var  crypto : DatabaseReference
    private lateinit var  arrayList : ArrayList<Crypto>
    private lateinit var myadapter : CryptoAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


         recylerView.setHasFixedSize(true)
        recylerView.layoutManager = LinearLayoutManager(this)
        arrayList = ArrayList()

        myadapter = CryptoAdapter(this,arrayList)

        val db = FirebaseDatabase.getInstance()
        crypto = db.getReference("Crypto")
        recylerView.adapter = myadapter

     allCrypto()

    }



    fun allCrypto(){
        crypto.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                  arrayList.clear()

                for(i in snapshot.children){

                    val crypto = i.getValue(Crypto::class.java)


                    if(crypto !=null){
                     //arraya ekliyoruz
                       arrayList.add(crypto)

                    }

                }

                myadapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                 error.message
            }
        })

    }
}