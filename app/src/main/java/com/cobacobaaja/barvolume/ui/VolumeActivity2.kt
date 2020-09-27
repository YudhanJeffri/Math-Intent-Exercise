package com.cobacobaaja.barvolume.ui

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import com.cobacobaaja.barvolume.R
import kotlinx.android.synthetic.main.activity_volume.*

class VolumeActivity2 : AppCompatActivity() {
    companion object {
        private const val STATE_RESULT = "state_result"
        const val EXTRA_panjang = "extra_panjang"
        const val EXTRA_lebar = "extra_lebar"
        const val EXTRA_tinggi = "extra_tinggi"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_volume2)
        intentData()
        if (savedInstanceState != null) {
            val result = savedInstanceState.getString(STATE_RESULT) as String
            textHasil.text = result
        }
    }

    private fun intentData() {
        val panjang = intent.getStringExtra(EXTRA_panjang)
        val lebar = intent.getStringExtra(EXTRA_lebar)
        val tinggi = intent.getStringExtra(EXTRA_tinggi)
        editTinggi.setText(tinggi)
        editLebar.setText(lebar)
        editPanjang.setText(panjang)
    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT, textHasil.text.toString())
    }
    fun count(view: View) {
        try {
            when {
                editPanjang.text?.isEmpty()!! -> {
                    editPanjang.error = "The Field Cannot be Empty"
                }
                editLebar.text?.isEmpty()!! -> {
                    editLebar.error = "The Field Cannot be Empty"
                }
                editTinggi.text?.isEmpty()!! -> {
                    editTinggi.error = "The Field Cannot be Empty"
                }
            }
            val volume = editPanjang.text.toString().toDouble() * editLebar.text.toString().toDouble() * editTinggi.text.toString().toDouble()
            textHasil.text = volume.toString()
        }
        catch (e: Exception){
            Toast.makeText(this,"Something Went Wrong!", Toast.LENGTH_SHORT).show()
        }
    }

    fun again(view: View) {
        editPanjang.setText("")
        editLebar.setText("")
        editTinggi.setText("")
        editPanjang.requestFocus()
        val imm: InputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(editPanjang, InputMethodManager.SHOW_IMPLICIT)
    }
    fun exit(view: View) {
        exit.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    fun result(view: View) {
        if (textHasil.text.toString() == "0"){
            Toast.makeText(this,"Hasil Ga boleh kosong ya :)", Toast.LENGTH_SHORT).show()
        } else {
            val msg = textHasil.text.toString()
            val resultIntent = Intent()
            resultIntent.putExtra("msg",msg)
            setResult(Activity.RESULT_OK,resultIntent)
            finish()
        }
    }
}