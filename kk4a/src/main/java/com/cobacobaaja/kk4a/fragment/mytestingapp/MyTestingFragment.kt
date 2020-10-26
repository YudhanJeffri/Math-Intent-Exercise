package com.cobacobaaja.kk4a.fragment.mytestingapp

import android.media.Image
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.cobacobaaja.kk4a.R


class MyTestingFragment : Fragment(), View.OnClickListener{
    private lateinit var btnSetValue: Button
    private lateinit var tvText: TextView
    private lateinit var imgPreview: ImageView
    private var names = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_my_testing, container, false)
        btnSetValue = v.findViewById(R.id.btn_set_value)
        tvText = v.findViewById(R.id.tv_text)
        btnSetValue.setOnClickListener(this)
        names.add("Yudhan")
        names.add("Jeffri")
        names.add("DJuniartha")
        imgPreview = v.findViewById(R.id.img_preview)
        //imgPreview.setImageDrawable(activity?.let { ContextCompat.getDrawable(it, R.drawable.fronalpstock_big) })
        Glide.with(this).load(R.drawable.fronalpstock_big).into(imgPreview)
        return v
    }

    override fun onClick(view: View) {
        if (view.id == R.id.btn_set_value) {
            Log.d("MainActivity", names.toString())
            val name = StringBuilder()
            for (i in 0..2) {
                name.append(names[i]).append("\n")
            }
            tvText.text = name.toString()
        }
    }
}