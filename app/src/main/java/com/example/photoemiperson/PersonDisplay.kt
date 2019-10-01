package com.example.photoemiperson

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_person_display.*

class PersonDisplay : AppCompatActivity(), View.OnClickListener {
    val personList = mutableListOf<Person>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_person_display)
        btnCreatePerson.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btnCreatePerson -> {
                val intent = Intent(this, CreatePerson::class.java)
                startActivityForResult(intent, 1)
            }
        }
    }

    private fun populateDisplay(){
        tvDisplayPersons.text = ""
        for(person in personList){
            tvDisplayPersons.append("NAME: ${person.name} AGE: ${person.age} " +
                    "DOB: ${person.dob} COUNTRY: ${person.country}\n")
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val passedPerson = data?.getParcelableExtra<Person>("person")

        if (passedPerson != null ) {
            personList.add(passedPerson)
            populateDisplay()

        }

    }
}
