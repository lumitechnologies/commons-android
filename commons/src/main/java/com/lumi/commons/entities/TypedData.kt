package com.lumi.commons.entities

import android.os.Parcel
import android.os.Parcelable

class TypedData : Parcelable {
    val name: String?
    val type: String?
    val data: Any?

    constructor(name: String, type: String, data: Any) {
        this.name = name
        this.type = type
        this.data = data
    }

    private constructor(parcel: Parcel) {
        name = parcel.readString()
        type = parcel.readString()
        val type = parcel.readSerializable() as Class<*>
        data = parcel.readValue(type.classLoader)
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(name)
        dest.writeString(type)
        dest.writeSerializable(data?.javaClass)
        dest.writeValue(data)
    }

    companion object CREATOR : Parcelable.Creator<TypedData> {

        override fun createFromParcel(parcel: Parcel): TypedData {
            return TypedData(parcel)
        }

        override fun newArray(size: Int): Array<TypedData?> {
            return arrayOfNulls(size)
        }
    }
}