package org.o7planning.recyclerview2;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

/**
 * Created by jake on 27/03/2018.
 */

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ViewHolder> {
    private List<Contact> mContact;

    public ContactsAdapter(List<Contact> contacts) {
        mContact = contacts;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView nameTextView;
        public Button messageButton;

        public ViewHolder(View itemView) {
            super(itemView);
            nameTextView = (TextView) itemView.findViewById(R.id.contact_name);
            messageButton = (Button) itemView.findViewById(R.id.message_button);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View contactView = inflater.inflate(R.layout.item_contact, parent, false);
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Contact contact = mContact.get(position);

        TextView textView = holder.nameTextView;
        textView.setText(contact.getName());

        Button button = holder.messageButton;

        if(contact.isOnline()) {
            button.setText("Message");
            button.setEnabled(true);
        } else {
            button.setText("Offline");
            button.setEnabled(false);
        }
    }

    @Override
    public int getItemCount() {
        return mContact.size();
    }
}