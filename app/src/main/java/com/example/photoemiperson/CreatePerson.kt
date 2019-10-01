package com.example.photoemiperson

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_add_person.*

class CreatePerson : AppCompatActivity(), View.OnClickListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_person)
        btnAddPerson.setOnClickListener(this)

    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.btnAddPerson -> created()
        }
    }

    private fun created() {
        val name = etName.text.toString()
        val age = etAge.text.toString()
        val dob = etDob.text.toString()
        val country = etCountry.text.toString()

        var person = Person(name, age, dob, country)

        val intent = Intent()
        intent.putExtra("person", person)
        setResult(1, intent)
        finish()
    }
}
