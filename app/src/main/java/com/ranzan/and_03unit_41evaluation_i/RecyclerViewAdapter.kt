package com.ranzan.and_03unit_41evaluation_i

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.ranzan.and_03unit_41evaluation_i.Database.DatabaseModel

class RecyclerViewAdapter(private val list: MutableList<DatabaseModel>, val listener: Listener) :
    RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return RecyclerViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.setData(list[position], listener)
    }

    override fun getItemCount(): Int = list.size


    class RecyclerViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val tvEventName = view.findViewById<TextView>(R.id.tvEventName)
        private val tvEventDesc = view.findViewById<TextView>(R.id.tvEventDesc)
        private val tvEventLocation = view.findViewById<TextView>(R.id.tvEventLocation)
        private val tvEventPrice = view.findViewById<TextView>(R.id.tvEventPrice)
        private val tvEventDate = view.findViewById<TextView>(R.id.tvEventDate)
        private val cardView = view.findViewById<CardView>(R.id.cardView)
        fun setData(databaseModel: DatabaseModel, listener: Listener) {
            tvEventName.text = databaseModel.eventName
            tvEventDesc.text = databaseModel.eventDesc
            tvEventLocation.text = databaseModel.eventLocation
            tvEventPrice.text = databaseModel.eventPrice.toString()
            tvEventDate.text = databaseModel.eventDate
            cardView.setOnClickListener {
                listener.getData(databaseModel.id)
            }
        }
    }
}