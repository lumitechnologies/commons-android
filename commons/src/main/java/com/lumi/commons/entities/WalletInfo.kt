package com.lumi.commons.entities

import android.os.Parcel
import android.os.Parcelable

class WalletInfo : Parcelable {

    val address: String?
    val balance: String?
    val network: String?

    constructor(address: String, balance: String, network: String) {
        this.address = address
        this.balance = balance
        this.network = network
    }

    private constructor(parcel: Parcel) {
        address = parcel.readString()
        balance = parcel.readString()
        network = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(address)
        parcel.writeString(balance)
        parcel.writeString(network)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<WalletInfo> {
        override fun createFromParcel(parcel: Parcel): WalletInfo {
            return WalletInfo(parcel)
        }

        override fun newArray(size: Int): Array<WalletInfo?> {
            return arrayOfNulls(size)
        }
    }
}