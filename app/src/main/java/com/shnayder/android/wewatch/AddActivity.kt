package com.shnayder.android.wewatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class AddActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
    }
}
/*
package com.shnayder.android.wewatch

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast

class FindActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find)

        val searchFilm = findViewById<Button>(R.id.search_film)
        val miniSearchFilm = findViewById<ImageView>(R.id.mini_search_film)
        val enterTitleFilm = findViewById<EditText>(R.id.enter_title_film)
        val enterYearFilm = findViewById<EditText>(R.id.enter_year_film)

        fun goSearchActivity(){
            val intent = Intent(this@FindActivity, SearchActivity::class.java)
            startActivity(intent)
        }

        searchFilm.setOnClickListener{
            val title = enterTitleFilm.text.toString()
            val year = enterYearFilm.text.toString()

            if(title != "" && year!=""){
                goSearchActivity()
            } else if(title != ""){
                goSearchActivity()
            } else
                Toast.makeText(this@FindActivity, "Для поиска введите название фильма.", Toast.LENGTH_SHORT).show()
        }

        miniSearchFilm.setOnClickListener{
            val title = enterTitleFilm.text.toString()
            if(title != ""){
                goSearchActivity()
            } else
                Toast.makeText(this@FindActivity, "Для поиска введите название фильма.", Toast.LENGTH_SHORT).show()
        }

        //при нажатии (выборе) фильма->
        /*
            val intent = Intent(this@AllFilmActivity, AddActivity::class.java)
            startActivity(intent)
        */

    }
}
* */