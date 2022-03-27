package com.example.camerax.adapter

import android.R
import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.camerax.databinding.ListItemAlbumBinding
import com.example.camerax.listeners.IAdapterClickListener
import com.example.camerax.models.Photo
import com.example.camerax.room.relations.AlbumWithPhotos
import java.io.File

class PhotosAdapter(private val photos : MutableList<Photo>,
                    val listener : IAdapterClickListener
) : RecyclerView.Adapter<PhotosAdapter.AlbumViewHolder>()  {
    class AlbumViewHolder(val binding : ListItemAlbumBinding, val listener : IAdapterClickListener) : RecyclerView.ViewHolder(binding.root) {

        fun bind(photo: Photo) {

            val file = File(photo.filePath)
            if(file.exists()) {
                Glide
                    .with(binding.root.context)
                    .load(file)
                    .centerCrop()
                    .placeholder(R.drawable.progress_horizontal)
                    .into(binding.imageView)
            }
            binding.albumName.text = photo.fileName
            binding.imageView.setOnClickListener {
                listener.onPhotoClcicked(photo.filePath)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemAlbumBinding.inflate(inflater)
        return AlbumViewHolder(binding, listener)
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