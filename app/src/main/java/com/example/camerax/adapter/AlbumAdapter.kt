package com.example.camerax.adapter

import android.R
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.camerax.databinding.ListItemAlbumBinding
import com.example.camerax.listeners.IAdapterClickListener
import com.example.camerax.models.Album
import com.example.camerax.room.relations.AlbumWithPhotos
import java.io.File

class AlbumAdapter(private val albums : MutableList<AlbumWithPhotos>,
                    val listener : IAdapterClickListener)
    : RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder>() {

    class AlbumViewHolder(val binding: ListItemAlbumBinding, val listener : IAdapterClickListener) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(albumWithPhotos: AlbumWithPhotos) {
            val file = File(albumWithPhotos.photos[albumWithPhotos.photos.size-1].filePath)
            if(file.exists()) {
                Glide
                    .with(binding.root.context)
                    .load(file)
                    .centerCrop()
                    .placeholder(R.drawable.progress_horizontal)
                    .into(binding.imageView);
            }
            binding.albumName.text =
                """${albumWithPhotos.album.albumName}(${albumWithPhotos.photos.size})"""
            binding.imageView.setOnClickListener {
             listener.onAlbumClicked(albumWithPhotos.album.albumName)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemAlbumBinding.inflate(inflater)
        return AlbumViewHolder(binding, listener)
    }

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        holder.bind(albums[position])
    }

    override fun getItemCount(): Int {
        return albums.size
    }

    fun sumbitList(it: List<AlbumWithPhotos>) {
        albums.clear()
        albums.addAll(it)
        notifyDataSetChanged()
    }
}