package com.example.camerax.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.camerax.databinding.ListItemAlbumBinding
import com.example.camerax.models.Album
import com.example.camerax.room.relations.AlbumWithPhotos

class AlbumAdapter(private val albums : MutableList<AlbumWithPhotos>) : RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder>()  {
    class AlbumViewHolder(val binding : ListItemAlbumBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(albumWithPhotos: AlbumWithPhotos) {
            binding.albumName.text =
                """${albumWithPhotos.album.albumName}(${albumWithPhotos.photos.size})"""
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemAlbumBinding.inflate(inflater)
        return AlbumViewHolder(binding)
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