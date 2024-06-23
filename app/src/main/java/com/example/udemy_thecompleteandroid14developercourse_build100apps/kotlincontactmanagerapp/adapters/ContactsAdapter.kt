package com.example.udemy_thecompleteandroid14developercourse_build100apps.kotlincontactmanagerapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.udemy_thecompleteandroid14developercourse_build100apps.R
import com.example.udemy_thecompleteandroid14developercourse_build100apps.databinding.ContactListItemBinding
import com.example.udemy_thecompleteandroid14developercourse_build100apps.kotlincontactmanagerapp.models.Contact

class ContactsAdapter(private val contactsList: List<Contact>, private val clickListener:(Contact)-> Unit): RecyclerView.Adapter<ContactsAdapter.ContactsViewHolder>() {
    
    class ContactsViewHolder(val binding: ContactListItemBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(contact:Contact, clickListener: (Contact) -> Unit){
            binding.contactNameTextView.text = contact.contactName
            binding.contactEmailTextView.text = contact.contactEmail
            
            binding.listItemLayout.setOnClickListener{
                clickListener(contact)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding :ContactListItemBinding = DataBindingUtil.inflate(layoutInflater, R.layout.contact_list_item, parent, false)
        return ContactsViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return contactsList.size
    }

    override fun onBindViewHolder(holder: ContactsViewHolder, position: Int) {
        holder.bind(contactsList[position], clickListener)
    }
}