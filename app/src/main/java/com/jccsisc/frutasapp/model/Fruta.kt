package com.jccsisc.frutasapp.model

import android.os.Parcel
import android.os.Parcelable
import androidx.versionedparcelable.VersionedParcelize

@VersionedParcelize
data class Fruta(
        val nombreFruta: String? = "",
        val colorFruta: String? = "",
        val precioFruta: String? = "",
        val pesoFruta: String? = "",
        val image: String? = ""
) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nombreFruta)
        parcel.writeString(colorFruta)
        parcel.writeString(precioFruta)
        parcel.writeString(pesoFruta)
        parcel.writeString(image)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Fruta> {
        override fun createFromParcel(parcel: Parcel): Fruta {
            return Fruta(parcel)
        }

        override fun newArray(size: Int): Array<Fruta?> {
            return arrayOfNulls(size)
        }
    }
}