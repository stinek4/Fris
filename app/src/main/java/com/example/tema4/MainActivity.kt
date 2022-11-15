package com.example.tema4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.example.tema4.database.OrderObject
import com.example.tema4.ui.main.MainFragment


class MainActivity : AppCompatActivity() {

    val mainFragment = MainFragment.newInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        //Forsikrer meg om at Theme er riktig
        setTheme(R.style.Theme)

        //Setter MainFragment inn i FragmentView
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

    }

}