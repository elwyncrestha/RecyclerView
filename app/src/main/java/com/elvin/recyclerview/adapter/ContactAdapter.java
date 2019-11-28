package com.elvin.recyclerview.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.elvin.recyclerview.R;
import com.elvin.recyclerview.activity.DetailActivity;
import com.elvin.recyclerview.model.Contact;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * @author Elvin Shrestha on 25/11/19
 */
public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {

    Context context;
    List<Contact> contacts;

    public ContactAdapter(Context context, List<Contact> contacts) {
        this.context = context;
        this.contacts = contacts;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_contact, parent, false);
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        final Contact contact = this.contacts.get(position);
        holder.civContactImage.setImageResource(contact.getImageId());
        holder.tvName.setText(contact.getName());
        holder.tvContact.setText(contact.getPhoneNumber());

        holder.civContactImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("image", contact.getImageId());
                intent.putExtra("name", contact.getName());
                intent.putExtra("contact", contact.getPhoneNumber());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.contacts.size();
    }

    public class ContactViewHolder extends RecyclerView.ViewHolder {

        CircleImageView civContactImage;
        TextView tvName, tvContact;

        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);
            civContactImage = itemView.findViewById(R.id.civContactImage);
            tvName = itemView.findViewById(R.id.tvName);
            tvContact = itemView.findViewById(R.id.tvContact);
        }
    }

}
