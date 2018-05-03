package com.notifellow.su.notifellow;

import android.os.Parcel;
import android.os.Parcelable;

public class Note implements Comparable<Note>, Parcelable {

    public static final Creator CREATOR = new Creator() {
        public Note createFromParcel(Parcel in) {
            return new Note(in);
        }

        public Note[] newArray(int size) {
            return new Note[size];
        }
    };

    String id;
    String title;
    String note;
    String imagePath;
    String email;

    public Note(String id, String title, String note, String imagePath, String email) {
        this.id = id;
        this.title = title;
        this.note = note;
        this.imagePath = imagePath;
        this.email = email;
    }

    public Note(Note other) {
        this.id = id;
        this.title = other.title;
        this.note = other.note;
        this.imagePath = other.imagePath;
        this.email = email;
    }

    public Note(Parcel in) {
        this.id = in.readString();
        this.title = in.readString();
        this.note = in.readString();
        this.imagePath = in.readString(); // TODO fix this readString
        this.email = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(title);
        dest.writeString(note);
        dest.writeString(imagePath);
        dest.writeString(email);
    }

    @Override
    public int compareTo(Note another) { // i know.. this makes no sense but compiler cries otherwise
        return id.compareTo(another.id);
    }

    @Override
    public int describeContents() {
        return 0;
    }
}
