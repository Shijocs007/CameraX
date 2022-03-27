package com.example.camerax.adapter

import android.R
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.camerax.databinding.ListPhotoPreviewItemBinding
import com.example.camerax.models.Photo
import java.io.File


class PhotosPreviewAdapter(private var photos : MutableList<Photo>): RecyclerView.Adapter<PhotosPreviewAdapter.PhotoViewHolder>() {


    class PhotoViewHolder(val binding: ListPhotoPreviewItemBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(photo: Photo){
            val file = File(photo.filePath)
            if (file.exists()) {
                val myBitmap = BitmapFactory.decodeFile(file.absolutePath)
              //  binding.image.setImageBitmap(myBitmap)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PhotosPreviewAdapter.PhotoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListPhotoPreviewItemBinding.inflate(inflater)
        return PhotoViewHolder(binding)
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

