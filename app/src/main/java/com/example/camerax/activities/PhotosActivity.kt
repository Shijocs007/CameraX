package com.example.camerax.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.camerax.R
import com.example.camerax.adapter.AlbumAdapter
import com.example.camerax.adapter.PhotosAdapter
import com.example.camerax.databinding.ActivityAlbumBinding
import com.example.camerax.databinding.ActivityPhotosBinding
import com.example.camerax.listeners.IAdapterClickListener
import com.example.camerax.viewmodels.AlbumViewmodel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PhotosActivity : AppCompatActivity(), IAdapterClickListener {

    private lateinit var mBinding: ActivityPhotosBinding
    private val viewModel: AlbumViewmodel by viewModels()
    private  var mAdapter =  PhotosAdapter(mutableListOf(), this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photos)

        mBinding = ActivityPhotosBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        mBinding.recyclerView.apply {
            layoutManager = GridLayoutManager(this@PhotosActivity, 3)
            adapter = mAdapter
        }

        initObservers()
    }

    private fun initObservers() {
        lifecycleScope.launch {
            viewModel.getPhotsos(intent.getStringExtra("album")!!).collect {
                mAdapter.sumbitList(it)
            }
        }
    }

    override fun onPhotoClcicked(filePath: String) {
        startActivity(Intent(this@PhotosActivity, PhotoPreviewActivity::class.java).apply {
            putExtra("file", filePath)
        })
    }
}