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
        btnEMI.setOnClickListener(this)
        btnPerson.setOnClickListener(this)
    }

    override fun onClick(view: View){
        when(view.id){
            R.id.btnPhoto -> openPhoto()
            R.id.btnEMI -> openEMICal()
            R.id.btnPerson -> openPersonDisplay()
        }
    }

    private fun openPhoto(){
        val intent = Intent(this, Photo::class.java)
        startActivity(intent)
    }

    private fun openEMICal(){
        val intent = Intent(this, EMICalculator::class.java)
        startActivity(intent)
    }

    private fun openPersonDisplay(){
        val intent = Intent(this, PersonDisplay::class.java)
        startActivity(intent)
    }
}
