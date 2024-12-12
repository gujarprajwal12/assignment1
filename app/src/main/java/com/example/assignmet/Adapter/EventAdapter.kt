package com.example.assignmet.Adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.assignmet.Data.Event
import com.example.assignmet.R



class EventAdapter(private val events: List<Event>) : RecyclerView.Adapter<EventAdapter.EventViewHolder>() {

    class EventViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvCompany: TextView = itemView.findViewById(R.id.tvCompany)
        val tvStartDate: TextView = itemView.findViewById(R.id.tvStartDate)
        val tvEndDate: TextView = itemView.findViewById(R.id.tvEndDate)
        val ivEventImage: ImageView = itemView.findViewById(R.id.ivEventImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_event, parent, false)
        return EventViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        val event = events[position]

        holder.tvCompany.text = event.company
        holder.tvStartDate.text = event.startDate
        holder.tvEndDate.text = event.endDate

        // Log the image URL for debugging
        Log.d("EventImage", "Loading image: ${event.image}")

        // Load image with placeholder and error image
        holder.ivEventImage.load(event.image) {
            crossfade(true)
            placeholder(R.drawable.placeholder)  // Placeholder image
            error(R.drawable.error) // Error image
            listener(
                onError = { _, _ ->
                    Log.e("ImageLoadingError", "Failed to load image: ${event.image}")
                }
            )
        }
    }

    override fun getItemCount(): Int {
        return events.size
    }
}
