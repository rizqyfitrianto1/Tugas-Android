package com.example.tugasbesar33

import android.app.Dialog
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

class RecyclerViewAdapter(internal var mContext: Context, internal var mData: List<User>) : RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {
    internal var myDialog: Dialog? = null
    internal var option: RequestOptions

    init {

        option = RequestOptions().centerCrop().placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val v: View
        v = LayoutInflater.from(mContext).inflate(R.layout.item_recycler, parent, false)

        return MyViewHolder(v)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.tv_name.text = mData[position].name
        holder.tv_phone.text = mData[position].nim

        Glide.with(mContext).load(mData[position].images).apply(option).into(holder.img_contact)
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val item_contact: LinearLayout
        private val tv_name: TextView
        private val tv_phone: TextView
        private val img_contact: ImageView


        init {
            item_contact = itemView.findViewById<View>(R.id.contact_item_id) as LinearLayout
            tv_name = itemView.findViewById<View>(R.id.name_contact) as TextView
            tv_phone = itemView.findViewById<View>(R.id.phone_contact) as TextView
            img_contact = itemView.findViewById<View>(R.id.img_contact) as ImageView

        }

    }

    companion object {
        var urlFoto = "http://172.16.10.57/tugasandroid/images/"
    }
}

