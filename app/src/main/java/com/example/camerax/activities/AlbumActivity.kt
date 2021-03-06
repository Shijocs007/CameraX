package com.example.camerax.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.camerax.R
import com.example.camerax.TakePhotoActivity
import com.example.camerax.adapter.AlbumAdapter
import com.example.camerax.adapter.PhotosPreviewAdapter
import com.example.camerax.databinding.ActivityAlbumBinding
import com.example.camerax.databinding.ActivityMainBinding
import com.example.camerax.listeners.IAdapterClickListener
import com.example.camerax.models.Photo
import com.example.camerax.viewmodels.AlbumViewmodel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AlbumActivity : AppCompatActivity(), IAdapterClickListener {
    private lateinit var mBinding: ActivityAlbumBinding
    private val viewModel: AlbumViewmodel by viewModels()

    private lateinit  var mAdapter : AlbumAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityAlbumBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        mAdapter = AlbumAdapter(mutableListOf(), this)


        mBinding.cameraFab.setOnClickListener {
            startActivity(Intent(this@AlbumActivity, TakePhotoActivity::class.java))
        }

        mBinding.recyclerView.apply {
            layoutManager = GridLayoutManager(this@AlbumActivity, 3)
            adapter = mAdapter
        }

    }

    override fun onStart() {
        super.onStart()
        initObservers()
    }

    private fun initObservers() {
        lifecycleScope.launch {
            viewModel.getAllAlbums().collect {
                mAdapter.sumbitList(it)
            }
        }
    }

    override fun onAlbumClicked(albumName: String) {
        startActivity(Intent(this@AlbumActivity, PhotosActivity::class.java).apply {
            putExtra("album", albumName)
        })
    }
}