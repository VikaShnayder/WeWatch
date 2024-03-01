package com.shnayder.android.wewatch

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class SearchActivity : AppCompatActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.search_film)
        val addFilm = findViewById<Button>(R.id.add_film)
        addFilm.setOnClickListener{

        }
    }
}