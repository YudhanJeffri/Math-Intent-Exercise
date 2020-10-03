package com.cobacobaaja.barvolume.ui

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.cobacobaaja.barvolume.R
import com.cobacobaaja.barvolume.ui.data.DataMTK
import com.cobacobaaja.barvolume.ui.fragment.HomeFragment
import com.cobacobaaja.barvolume.ui.fragment.VolumeFragment
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fragment = HomeFragment()
        if (savedInstanceState == null){
            val fragmentManager = supportFragmentManager
            fragmentManager.beginTransaction().add(R.id.main, fragment).commit()
        } else {
            fragment.isVisible
        }
    }
}