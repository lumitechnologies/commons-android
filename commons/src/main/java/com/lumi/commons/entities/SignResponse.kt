package com.lumi.commons.entities

import android.os.Parcel
import android.os.Parcelable

class SignResponse : Parcelable {

    val message: Message<*>?
    val signInfo: SignInfo?
    val walletInfo: WalletInfo?

    constructor(message: Message<*>?, signInfo: SignInfo, walletInfo: WalletInfo) {
        this.message = message
        this.signInfo = signInfo
        this.walletInfo = walletInfo
    }

    private constructor(parcel: Parcel) {
        message = parcel.readParcelable(Message::class.java.classLoader) as Message<*>?
        signInfo = parcel.readParcelable(SignInfo::class.java.classLoader) as SignInfo?
        walletInfo = parcel.readParcelable(WalletInfo::class.java.classLoader) as WalletInfo?
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeParcelable(message, flags)
        parcel.writeParcelable(signInfo, flags)
        parcel.writeParcelable(walletInfo, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<SignResponse> {
        override fun createFromParcel(parcel: Parcel): SignResponse {
            return SignResponse(parcel)
        }

        override fun newArray(size: Int): Array<SignResponse?> {
            return arrayOfNulls(size)
        }
    }
}