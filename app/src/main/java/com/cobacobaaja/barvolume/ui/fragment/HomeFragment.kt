package com.cobacobaaja.barvolume.ui.fragment

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import com.cobacobaaja.barvolume.R
import com.cobacobaaja.barvolume.ui.VolumeActivity
import com.cobacobaaja.barvolume.ui.data.DataMTK
import com.cobacobaaja.barvolume.ui.fragment.VolumeFragment.Companion.EXTRA_LEBAR
import com.cobacobaaja.barvolume.ui.fragment.VolumeFragment.Companion.EXTRA_PANJANG
import com.cobacobaaja.barvolume.ui.fragment.VolumeFragment.Companion.EXTRA_TINGGI
import com.google.android.material.button.MaterialButton
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {
    lateinit var button_pindah_activity : MaterialButton
    lateinit var button_pindah_data : MaterialButton
    lateinit var button_pindah_object : MaterialButton
    lateinit var button_pindah_dial : MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_home, container, false)
        val text = v.findViewById<TextView>(R.id.hasil_result)
        val bundle: Bundle? = this.arguments
        val data:String? = bundle?.getString("msg")
        text.text = data
        button_pindah_activity = v.findViewById(R.id.button_pindah_activity_home)
        button_pindah_activity.setOnClickListener {
            val intent = Intent(context, VolumeActivity::class.java)
            startActivityForResult(intent, 1)
        }
        button_pindah_data = v.findViewById(R.id.button_pindah_data)
        button_pindah_data.setOnClickListener {

            val bundle = Bundle()
            bundle.putString(EXTRA_PANJANG,"10")
            bundle.putString(EXTRA_LEBAR,"20")
            bundle.putString(EXTRA_TINGGI,"30")
            val transaction = this.fragmentManager?.beginTransaction()
            val fragment = VolumeFragment()
            fragment.arguments = bundle
            transaction?.replace(R.id.main, fragment)
            transaction?.addToBackStack(null)
            transaction?.commit()
            fragment.setTargetFragment(this,1)
        }
        button_pindah_object = v.findViewById(R.id.button_pindah_object)
        button_pindah_object.setOnClickListener {
            val person = DataMTK("40","50","60")
            val intent = Intent(context, VolumeActivity::class.java)
            intent.putExtra(VolumeActivity.EXTRS_object, person)
            startActivityForResult(intent, 1)
        }
        button_pindah_dial = v.findViewById(R.id.button_pindah_dial)
        button_pindah_dial.setOnClickListener {
            val phoneNumber = "0895346060631"
            val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
            startActivity(dialPhoneIntent)
        }
        return v
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                val msg = data?.getStringExtra("msg")
                hasil_result.text = msg
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                hasil_result.text = "Result Null"
            }
        }
    }
}