package com.nuriulgen.marsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nuriulgen.marsapp.presentation.home.model.RealeStateModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.recycler_row.view.*

class HomeRecyclerAdapter(val postList : ArrayList<RealeStateModel>) : RecyclerView.Adapter<HomeRecyclerAdapter.MarsHolder>() {

    class MarsHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarsHolder {
        val adapterInflater = LayoutInflater.from(parent.context)
        val view = adapterInflater.inflate(R.layout.recycler_row,parent,false)
        return MarsHolder(view)
    }

    override fun onBindViewHolder(holder: MarsHolder, position: Int) {
        holder.itemView.recycler_textView1.text = postList[position].price.toString()
        holder.itemView.recycler_textView2.text = postList[position].id

        Picasso.get().load(postList[position].img_src).into(holder.itemView.recycler_imageView)
    }

    override fun getItemCount(): Int {
        return postList.size
    }

}


