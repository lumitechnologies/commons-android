package com.lumi.commons.entities;

import android.os.Parcel;
import android.os.Parcelable;

import com.lumi.commons.enumerations.SignType;

public class Message<V> implements Parcelable {

    public final V value;
    public final long id;
    public final SignType type;

    public Message(V value, long id, SignType messageType) {
        this.value = value;
        this.id = id;
        this.type = messageType;
    }

    protected Message(Parcel in) {
        Class<?> type = (Class<?>) in.readSerializable();
        this.value = (V) in.readValue(type.getClassLoader());
        this.id = in.readLong();
        this.type = SignType.fromIdentifier(in.readString());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeSerializable(value.getClass());
        dest.writeValue(value);
        dest.writeLong(id);
        dest.writeString(type.getIdentifier());
    }

    public static final Creator<Message> CREATOR = new Creator<Message>() {
        @Override
        public Message createFromParcel(Parcel in) {
            return new Message(in);
        }

        @Override
        public Message[] newArray(int size) {
            return new Message[size];
        }
    };
}