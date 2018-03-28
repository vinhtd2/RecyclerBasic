package org.o7planning.recyclerview2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Contact> contacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Lookup the recyclerview in activity layout
        RecyclerView rvContacts = (RecyclerView) findViewById(R.id.rvContacts);

        // Initialize contacts
        contacts = Contact.createContactsList(20);

        ContactsAdapter adapter = new ContactsAdapter(contacts);

        rvContacts.setAdapter(adapter);

        rvContacts.setLayoutManager(new LinearLayoutManager(this));
    }
}
