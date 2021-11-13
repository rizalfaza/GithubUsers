package com.coba.submision1

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.graphics.drawable.ColorDrawable
import android.view.MenuItem


class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val avatarImage = findViewById<ImageView>(R.id.imageView2)
        val tvUsername = findViewById<TextView>(R.id.textView2)
        val tvName = findViewById<TextView>(R.id.tv_name_d)
        val tvCompany = findViewById<TextView>(R.id.textView3)
        val tvLocation = findViewById<TextView>(R.id.textView4)
        val tvFollowing = findViewById<TextView>(R.id.tv_following)
        val tvFollower = findViewById<TextView>(R.id.tv_follower)
        val tvRepository = findViewById<TextView>(R.id.tv_repository)

        val data = intent.getParcelableExtra<User>(KEY_DATA)

        data?.let {

            supportActionBar?.apply {
                setDisplayHomeAsUpEnabled(true)
                title = data.name
            }

            avatarImage.setImageResource(data.avatar)
            tvUsername.text = data.username
            tvName.text = data.name
            tvCompany.text = data.company
            tvLocation.text = data.location
            tvFollower.text = data.followers.toString()
            tvFollowing.text = data.following.toString()
            tvRepository.text = data.repository.toString()

        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home){
            super.onBackPressed()
        }
        return true
    }

    companion object {
        val KEY_DATA = "key_data"
    }

}

