package com.example.camerax.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.camerax.R
import java.io.File

class PhotoPreviewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo_preview)

        try {
            val file = File(intent.getStringExtra("file"))
            if(file.exists()) {
                Glide
                    .with(this)
                    .load(file)
                    .centerCrop()
                    .placeholder(android.R.drawable.progress_horizontal)
                    .into(findViewById(R.id.image_view))
            }
        } catch (e : Exception) {

        }
    }
}