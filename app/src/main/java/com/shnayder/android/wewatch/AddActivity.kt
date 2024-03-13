package com.shnayder.android.wewatch

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.shnayder.android.wewatch.retrofit.FilmApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddActivity : AppCompatActivity() {
    private lateinit var title: String
    private lateinit var year: String
    private lateinit var searchFilm: ImageView
    private lateinit var addFilm: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        searchFilm = findViewById(R.id.search_film)
        addFilm = findViewById(R.id.add_film)

        searchFilm.setOnClickListener{
            title = intent.getStringExtra("title").toString()
            year = intent.getStringExtra("year").toString()

            val intent = Intent(this@AddActivity, SearchActivity::class.java)
            intent.putExtra("title",title)
            //intent.putExtra("year",year)
            startActivity(intent)
        }

        addFilm.setOnClickListener{

        }
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