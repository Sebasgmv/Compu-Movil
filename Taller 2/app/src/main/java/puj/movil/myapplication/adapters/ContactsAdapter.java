package puj.movil.myapplication.adapters;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CursorAdapter;


import lombok.Getter;
import puj.movil.myapplication.databinding.ContactsAdapterBinding;

public class ContactsAdapter extends CursorAdapter {

    public static final String[] PROYECTION = new String[]{
            ContactsContract.Profile._ID,
            ContactsContract.Contacts.PHOTO_URI,
            ContactsContract.Contacts.DISPLAY_NAME,
            ContactsContract.Contacts.CONTACT_STATUS,
            ContactsContract.Contacts.STARRED
    };

    public ContactsAdapter(Context context, Cursor c, boolean autoRequery) {
        super(context, c, autoRequery);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return ContactsAdapterBinding.inflate(LayoutInflater.from(context), viewGroup, false).getRoot();
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        ContactsAdapterBinding binding =  ContactsAdapterBinding.bind(view);

        if(cursor.getString(1) != null) binding.contactPhoto.setImageURI(Uri.parse(cursor.getString(1)));
        binding.contactFullName.setText(cursor.getString(2));
        binding.contactPhone.setText(String.valueOf(cursor.getInt(3)));
        binding.contactFavorite.setChecked(cursor.getInt(4) == 1);
    }
}