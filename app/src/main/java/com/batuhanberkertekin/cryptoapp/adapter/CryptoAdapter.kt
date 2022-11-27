package com.batuhanberkertekin.cryptoapp.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.batuhanberkertekin.cryptoapp.R
import com.batuhanberkertekin.cryptoapp.data.Crypto
import com.batuhanberkertekin.cryptoapp.view.DetailsActivity
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.recyler_row.view.*

class CryptoAdapter(private val mcontext : Context , private val myList : List<Crypto>)  : RecyclerView.Adapter<CryptoAdapter.CryptoObject>()
{


 inner   class  CryptoObject(view : View) : RecyclerView.ViewHolder(view){

 }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CryptoObject {
        val layout = LayoutInflater.from(mcontext).inflate(R.layout.recyler_row,parent,false)
        return CryptoObject(layout)
    }

    override fun onBindViewHolder(holder: CryptoObject, position: Int) {
       val getList = myList.get(position)

        holder.itemView.currencyText.text = getList.currency
        holder.itemView.priceText.text = getList.price
        holder.itemView.setOnClickListener {
            val intent = Intent(mcontext,DetailsActivity::class.java)
            intent.putExtra("key",getList)
            holder.itemView.context.startActivity(intent)

        }
    }

    override fun getItemCount(): Int {
        return myList.size
    }
}
