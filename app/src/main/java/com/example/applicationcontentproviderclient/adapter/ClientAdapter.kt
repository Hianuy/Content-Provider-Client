package com.example.applicationcontentproviderclient.adapter

import android.database.Cursor
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.applicationcontentproviderclient.R

class ClientAdapter(private val mCursor: Cursor) : RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.client_item, parent, false))


    override fun getItemCount(): Int = mCursor.count


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        mCursor.moveToPosition(position)
        holder.clientTitle.text = mCursor.getString(mCursor.getColumnIndex("title"))
        holder.clientDescription.text = mCursor.getString(mCursor.getColumnIndex("description"))




    }



}


class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val clientTitle: TextView = itemView.findViewById(R.id.client_item_title)
    val clientDescription: TextView = itemView.findViewById(R.id.client_item_description)

}
