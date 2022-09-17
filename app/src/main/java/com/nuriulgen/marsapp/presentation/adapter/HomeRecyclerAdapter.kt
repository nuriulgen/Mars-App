package com.nuriulgen.marsapp.presentation.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nuriulgen.marsapp.presentation.home.view.HomeDetailActivity
import com.nuriulgen.marsapp.R
import com.nuriulgen.marsapp.presentation.home.model.RealeStateModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.recycler_card.view.*

class HomeRecyclerAdapter(val postList : ArrayList<RealeStateModel>) : RecyclerView.Adapter<HomeRecyclerAdapter.MarsHolder>() {

    class MarsHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarsHolder {
        val adapterInflater = LayoutInflater.from(parent.context)
        val view = adapterInflater.inflate(R.layout.recycler_card,parent,false)
        return MarsHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MarsHolder, position: Int) {
        holder.itemView.recycler_textView4.text = "\$${postList[position].price}"
        holder.itemView.recycler_textView5.text = postList[position].id

        Picasso.get().load(postList[position].img_src).into(holder.itemView.recycler_imageView1)

        holder.itemView.setOnClickListener {
            val intent =  Intent(holder.itemView.context, HomeDetailActivity :: class.java)
            intent.putExtra("price",postList.get(position).id)
            intent.putExtra("type",postList.get(position).type)
            intent.putExtra("image",postList.get(position).img_src)

            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return postList.size
    }

}


