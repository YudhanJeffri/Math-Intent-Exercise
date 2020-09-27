package com.cobacobaaja.barvolume.ui

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.cobacobaaja.barvolume.R
import com.cobacobaaja.barvolume.ui.data.DataMTK
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun intent_volume(view: View) {
        val intent = Intent(this@MainActivity, VolumeActivity::class.java)
        startActivityForResult(intent, 1)
    }
    fun pindah_data(view: View) {
        val intent = Intent(this@MainActivity, VolumeActivity2::class.java)
        intent.putExtra(VolumeActivity2.EXTRA_panjang, "10")
        intent.putExtra(VolumeActivity2.EXTRA_lebar,"20")
        intent.putExtra(VolumeActivity2.EXTRA_tinggi,"30")
        startActivityForResult(intent, 1)
    }
    fun pindah_object(view: View) {
        val person = DataMTK("40","50","60")
        val intent = Intent(this@MainActivity, VolumeActivity::class.java)
        intent.putExtra(VolumeActivity.EXTRS_object, person)
        startActivityForResult(intent, 1)
    }
    fun dial(view: View) {
        val phoneNumber = "0895346060631"
        val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
        startActivity(dialPhoneIntent)
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