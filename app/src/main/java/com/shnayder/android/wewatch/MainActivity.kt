package com.shnayder.android.wewatch

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton


class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val openSearchFilm = findViewById<FloatingActionButton>(R.id.open_search_film)

        openSearchFilm.setOnClickListener{
            val intent = Intent(this@MainActivity, AddActivity::class.java)
            startActivity(intent)
        }


    }
}