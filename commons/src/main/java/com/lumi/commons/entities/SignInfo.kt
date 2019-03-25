package com.lumi.commons.entities

import android.os.Parcel
import android.os.Parcelable
import com.lumi.commons.enumerations.SignStatus

class SignInfo : Parcelable {

    var status: SignStatus?
    var description: String?

    constructor(status: SignStatus, description: String) {
        this.status = status
        this.description = description
    }

    private constructor(parcel: Parcel) {
        status = SignStatus.fromIdentifier(parcel.readString())
        description = parcel.readString()

    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(status?.getIdentifier())
        parcel.writeString(description)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<SignInfo> {
        override fun createFromParcel(parcel: Parcel): SignInfo {
            return SignInfo(parcel)
        }

        override fun newArray(size: Int): Array<SignInfo?> {
            return arrayOfNulls(size)
        }
    }
}