package com.example.photoemiperson

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    val REQUEST_IMAGE = 1;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnPhoto.setOnClickListener(this)
    }

    override fun onClick(view: View){
        when(view.id){
            R.id.btnPhoto -> openPhoto()
        }
    }

    private fun openPhoto(){
        val intent = Intent(this, Photo::class.java)
        startActivity(intent)
    }
}
