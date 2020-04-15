package com.example.hw1.contacts;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class ContactListContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<Contact> ITEMS = new ArrayList<Contact>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, Contact> ITEM_MAP = new HashMap<String, Contact>();

    private static final int COUNT = 5;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createDummyItem(i));
        }
    }

    public static void addItem(Contact item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static Contact createDummyItem(int position) {
        return new Contact(String.valueOf(position), "Item " + position, makeDetails(position));
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

    public static void removeItem(int position) {
        String itemId = ITEMS.get(position).id;
        ITEMS.remove(position);
        ITEM_MAP.remove(itemId);
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class Contact implements Parcelable {
        public final String id;
        public final String Name;
        public final String Surname;
        public final String Birthday;
        public final String Phone;
        public final int picPath;

        public Contact(String id, String Name, String Surname) {
            int min = 0;
            int max = 7;
            this.id = id;
            this.Name = Name;
            this.Surname = Surname;
            this.Birthday = "";
            this.Phone = "";
            this.picPath = (int)(Math.random()*(max - min +1)+min);
        }
        public Contact(String id, String Name, String Surname,String Birthday, String Phone, int picPath ) {
            this.id = id;
            this.Name = Name;
            this.Surname = Surname;
            this.Birthday = Birthday;
            this.Phone = Phone;
            this.picPath = picPath;
        }

        protected Contact(Parcel in) {
            id = in.readString();
            Name = in.readString();
            Surname = in.readString();
            Birthday = in.readString();
            Phone = in.readString();
            picPath = in.readInt();
        }

        public static final Creator<Contact> CREATOR = new Creator<Contact>() {
            @Override
            public Contact createFromParcel(Parcel in) {
                return new Contact(in);
            }

            @Override
            public Contact[] newArray(int size) {
                return new Contact[size];
            }
        };

        @Override
        public String toString() {
            return Name;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(id);
            dest.writeString(Name);
            dest.writeString(Surname);
            dest.writeString(Birthday);
            dest.writeString(Phone);
            dest.writeInt(picPath);
        }
    }
}
