package com.example.camerax.adapter

import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.camerax.databinding.ListItemAlbumBinding
import com.example.camerax.models.Photo
import com.example.camerax.room.relations.AlbumWithPhotos

class PhotosAdapter(private val photos : MutableList<Photo>) : RecyclerView.Adapter<PhotosAdapter.AlbumViewHolder>()  {
    class AlbumViewHolder(val binding : ListItemAlbumBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(photo: Photo) {
            binding.albumName.text = photo.fileName
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemAlbumBinding.inflate(inflater)
        return AlbumViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        holder.bind(photos[position])
    }

    override fun getItemCount(): Int {
        return photos.size
    }

    fun sumbitList(it: List<Photo>) {
        photos.clear()
        photos.addAll(it)
        notifyDataSetChanged()
    }
}