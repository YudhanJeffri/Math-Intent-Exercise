package com.cobacobaaja.barvolume.ui.fragment

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.cobacobaaja.barvolume.R
import com.google.android.material.button.MaterialButton
import kotlinx.android.synthetic.main.activity_volume.*

class VolumeFragment : Fragment() {
    lateinit var editPanjang_fragment : com.google.android.material.textfield.TextInputEditText
    lateinit var editLebar_fragment : com.google.android.material.textfield.TextInputEditText
    lateinit var editTinggi_fragment : com.google.android.material.textfield.TextInputEditText
    companion object {
        private const val STATE_RESULT = "state_result"
        const val EXTRA_PANJANG = "extra_panjang"
        const val EXTRA_LEBAR = "extra_lebar"
        const val EXTRA_TINGGI = "extra_tinggi"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_volume, container, false)
        val texthasil = view.findViewById<TextView>(R.id.textHasil_fragment)
        if (savedInstanceState != null) {
            val result = savedInstanceState.getString(STATE_RESULT) as String
            texthasil?.text = result
        }
        editPanjang_fragment = view.findViewById(R.id.editPanjang_fragment)
        editLebar_fragment = view.findViewById(R.id.editLebar_fragment)
        editTinggi_fragment = view.findViewById(R.id.editTinggi_fragment)

        val panjang = arguments?.getString(EXTRA_PANJANG)
        val lebar = arguments?.getString(EXTRA_LEBAR)
        val tinggi = arguments?.getString(EXTRA_TINGGI)

        editPanjang_fragment.setText(panjang)
        editLebar_fragment.setText(lebar)
        editTinggi_fragment.setText(tinggi)

        val button_count = view.findViewById<MaterialButton>(R.id.button_count_fragment)
        button_count.setOnClickListener {
            try {
                when {
                    editPanjang_fragment.text?.isEmpty()!! -> {
                        editPanjang_fragment.error = "The Field Cannot be Empty"
                    }
                    editLebar_fragment.text?.isEmpty()!! -> {
                        editLebar_fragment.error = "The Field Cannot be Empty"
                    }
                    editTinggi_fragment.text?.isEmpty()!! -> {
                        editTinggi_fragment.error = "The Field Cannot be Empty"
                    }
                }
                val volume = editPanjang_fragment.text.toString().toDouble() * editLebar_fragment.text.toString().toDouble() * editTinggi_fragment.text.toString().toDouble()
                texthasil.text = volume.toString()
            }
            catch (e: Exception){
                Toast.makeText(context,"Something Went Wrong!", Toast.LENGTH_SHORT).show()
            }
        }
        val button_again_fragment = view.findViewById<MaterialButton>(R.id.button_again_fragment)
        button_again_fragment.setOnClickListener {
            editPanjang_fragment.setText("")
            editLebar_fragment.setText("")
            editTinggi_fragment.setText("")
            editPanjang_fragment.requestFocus()
            val imm: InputMethodManager = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.showSoftInput(editPanjang_fragment, InputMethodManager.SHOW_IMPLICIT)
        }
        val button_exit_fragment = view.findViewById<MaterialButton>(R.id.button_exit_fragment)
        button_exit_fragment.setOnClickListener {
            val transaction = this.fragmentManager?.beginTransaction()
            val fragment = HomeFragment()
            transaction?.replace(R.id.main, fragment)
            transaction?.commit()
        }
        val button_pindah_fragment = view.findViewById<MaterialButton>(R.id.button_pindah_fragment)
        button_pindah_fragment.setOnClickListener {
            if (texthasil.text.toString() == "0"){
                Toast.makeText(context,"Hasil Ga boleh kosong ya :)", Toast.LENGTH_SHORT).show()
            } else {
                val bundle = Bundle()
                bundle.putString("msg",texthasil.text.toString())
                val fragment = HomeFragment()
                fragment.arguments = bundle
                val transaction = this.fragmentManager?.beginTransaction()
                transaction?.replace(R.id.main, fragment)
                transaction?.addToBackStack(null)
                transaction?.commit()

                /*
                val msg = texthasil.text.toString()
                val resultIntent = Intent()
                resultIntent.putExtra("msg",msg)
                activity?.setResult(Activity.RESULT_OK,resultIntent)
                val transaction = this.fragmentManager?.beginTransaction()
                val fragment = HomeFragment()
                transaction?.replace(R.id.main, fragment)
                transaction?.addToBackStack(null)
                transaction?.commit()*/
            }
        }
        return view
    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val texthasil = view?.findViewById<TextView>(R.id.textHasil_fragment)
        outState.putString(STATE_RESULT, texthasil?.text.toString())
    }
}