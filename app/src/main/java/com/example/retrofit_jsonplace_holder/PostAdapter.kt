package com.example.retrofit_jsonplace_holder

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit_jsonplace_holder.model.UsersItem

class PostAdapter(
    val context: Context,
    val arrayList: ArrayList<UsersItem>?
):RecyclerView.Adapter<PostAdapter.PostViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
      val view = LayoutInflater.from(context).inflate(R.layout.reccyclear_item, parent, false)
         return PostViewHolder(view)
    }

    override fun getItemCount(): Int = arrayList!!.size

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.textView.text="company: ${arrayList?.get(position)?.company.toString()}\nemail: ${arrayList?.get(position)?.email.toString()}\nphone: ${arrayList?.get(position)?.phone.toString()}\nwebsite: ${arrayList?.get(position)?.website.toString()}"
    }
    class PostViewHolder(itemview:View):RecyclerView.ViewHolder(itemview){
        val textView:TextView = itemview.findViewById(R.id.textviewrecyclerrespons)
    }
}