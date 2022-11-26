package com.batuhanberkertekin.cryptoapp.data

import com.google.firebase.database.IgnoreExtraProperties
import com.google.firebase.database.ServerValue

@IgnoreExtraProperties
data class Crypto( var id :Int? = null , var currency :String? = null , var price : String? = null ): java.io.Serializable
