package com.cobacobaaja.layout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ConstraintActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constraint)
        supportActionBar?.title = "MyConstraintView"
    }
}