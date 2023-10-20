package com.example.rickandmorty

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmorty.databinding.ActivityMainBinding
import com.example.rickandmorty.fragments.CharactersFragmentMain
import com.example.rickandmorty.fragments.EpisodesFragment
import com.example.rickandmorty.fragments.LocationsFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setCurrentFragment(CharactersFragmentMain())

        binding.bottomNavBar.setOnItemSelectedListener {
            when(it.itemId){
                R.id.characters_iconButton -> setCurrentFragment(CharactersFragmentMain())
                R.id.locations_iconButton -> setCurrentFragment(LocationsFragment())
                R.id.episodes_iconButton -> setCurrentFragment(EpisodesFragment())
            }
            true
        }






    }
    private fun setCurrentFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
              replace(R.id.constraint_layout_parent, fragment)
                commit()
            }
    }


}

