package ru.eyelog.fragmentgames.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dagger.hilt.android.AndroidEntryPoint
import ru.eyelog.fragmentgames.R
import ru.eyelog.fragmentgames.fragments.maincontainer.MainContainer

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .add(R.id.mainSpace, MainContainer())
            .commit()
    }
}
