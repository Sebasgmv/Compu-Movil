package puj.movil.myapplication.activities;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.service.controls.ControlsProviderService;
import android.util.Log;

import javax.inject.Inject;

import puj.movil.myapplication.App;
import puj.movil.myapplication.R;
import puj.movil.myapplication.adapters.ContactsAdapter;
import puj.movil.myapplication.databinding.ActivityContactsBinding;
import puj.movil.myapplication.utils.PermissionHelper;

public class ContactsActivity extends AppCompatActivity {
    ActivityContactsBinding binding;

    @Inject
    PermissionHelper permissionHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ((App) getApplicationContext()).getAppComponent().inject(this);
        super.onCreate(savedInstanceState);
        binding = ActivityContactsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        permissionHelper.getContactsPermission(this);
        if (permissionHelper.isMContactsPermissionGranted()){
            fillcontacts();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == PermissionHelper.PERMISSIONS_REQUEST_READ_CONTACTS){
            permissionHelper.getContactsPermission(this);
            if(permissionHelper.isMContactsPermissionGranted()){
                fillcontacts();
            }
        }
    }

    private void fillcontacts(){
        Cursor cursor = getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, ContactsAdapter.PROYECTION, null, null, null);
        ContactsAdapter adapter = new ContactsAdapter(this, cursor, false);
        binding.listaContactos.setAdapter(adapter);
    }
}