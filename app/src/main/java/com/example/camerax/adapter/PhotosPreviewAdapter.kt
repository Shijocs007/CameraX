package com.example.camerax.adapter

import android.R
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.camerax.databinding.ListPhotoPreviewItemBinding
import com.example.camerax.listeners.IAdapterClickListener
import com.example.camerax.models.Photo
import java.io.File


class PhotosPreviewAdapter(private var photos : MutableList<Photo>,
     val listener : IAdapterClickListener): RecyclerView.Adapter<PhotosPreviewAdapter.PhotoViewHolder>() {


    class PhotoViewHolder(val binding: ListPhotoPreviewItemBinding, val listener : IAdapterClickListener) : RecyclerView.ViewHolder(binding.root){

        fun bind(photo: Photo){
            val file = File(photo.filePath)
            if(file.exists()) {
                Glide
                    .with(binding.root.context)
                    .load(file)
                    .centerCrop()
                    .placeholder(R.drawable.progress_horizontal)
                    .into(binding.image)
            }

            binding.imageClose.setOnClickListener {
                listener.onRemovePhoto(photo)
            }

            binding.image.setOnClickListener {
                listener.onPhotoClcicked(photo.filePath)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PhotosPreviewAdapter.PhotoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListPhotoPreviewItemBinding.inflate(inflater)
        return PhotoViewHolder(binding, listener)
    }

    override fun onBindViewHolder(holder: PhotosPreviewAdapter.PhotoViewHolder, position: Int) {
        holder.bind(photos[position])
    }

    override fun getItemCount(): Int {
        return photos.size
    }

    fun submitList(it: List<Photo>) {
        photos.clear()
        photos.addAll(it)
        notifyDataSetChanged()
    }
}

