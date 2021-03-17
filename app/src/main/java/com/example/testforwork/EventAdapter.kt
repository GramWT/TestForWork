package com.example.testforwork

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.testforwork.Model.Event
import com.example.testforwork.databinding.EventRowBinding
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.event_row.view.*

class EventAdapter(private val mContext:Context, private val eventList: MutableList<Event>):RecyclerView.Adapter<EventAdapter.ViewHolder>() {

    private lateinit var binding:EventRowBinding

    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = EventRowBinding.inflate(LayoutInflater.from(parent.context))

        var itemView = LayoutInflater.from(mContext).inflate(R.layout.event_row, parent, false)

        return ViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = eventList[position]
        holder.itemView.eventName.text = currentItem.name
        holder.itemView.discountTag.text = currentItem.price
        Picasso.get().load(currentItem.image_url).into(holder.itemView.imageEvent)

        holder.itemView.eventItem.setOnClickListener {
            val action = MainPageDirections.actionMainPageToDetailsPage(currentItem)
            holder.itemView.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return eventList.size
    }
}