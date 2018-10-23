package com.example.felipe.carrosvenda.domain

import android.os.Parcel
import android.os.Parcelable

data class Acessorio(
    val nome: String,
    val preco: Float
) : Parcelable {
    constructor(source: Parcel) : this(
        source.readString(),
        source.readFloat()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(nome)
        writeFloat(preco)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Acessorio> = object : Parcelable.Creator<Acessorio> {
            override fun createFromParcel(source: Parcel): Acessorio = Acessorio(source)
            override fun newArray(size: Int): Array<Acessorio?> = arrayOfNulls(size)
        }
    }
}