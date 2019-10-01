package com.example.photoemiperson

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_photo.*
import java.util.jar.Manifest

class Photo : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo)
        btnTakePhoto.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when(view.id){
            R.id.btnTakePhoto -> {
                var intent =  Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE)
                startActivityForResult(intent, 0)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val bitmap = data?.extras?.get("data") as Bitmap
        ivPic.setImageBitmap(bitmap)
    }

}
