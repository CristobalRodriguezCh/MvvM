package com.ipsmedigroup.appmvvm.data.Model

import com.google.gson.annotations.SerializedName


//se implementa una serializacion con su respectivo nombre
data class QuoteModel (@SerializedName("quote") val quote:String,@SerializedName("author") val author:String){
    //se le coloca el data por lo que es modelo de datos
}