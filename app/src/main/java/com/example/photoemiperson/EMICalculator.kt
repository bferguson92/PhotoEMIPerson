package com.example.photoemiperson

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_emicalulator.*
import kotlinx.android.synthetic.main.activity_main.*
import java.math.BigDecimal
import java.math.RoundingMode

class EMICalculator : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_emicalulator)
        btnCalculate.setOnClickListener(this)

    }

    override fun onClick(view: View) {
        when(view.id){
            R.id.btnCalculate -> calulateEMI()
        }
    }

    private fun calulateEMI(){
        val loanAmount = etLoanAmount.text.toString().toDouble()
        val intersetRate = (etIntersetRate.text.toString().toDouble() / 12) / 100
        val tenure = etTenure.text.toString().toDouble()

        val emi = BigDecimal((loanAmount) * (intersetRate) * ((Math.pow((1 + intersetRate), tenure)) /
                ((Math.pow(1 + intersetRate, tenure)) - 1))).setScale(2, RoundingMode.CEILING)

        tvEMI.text = emi.toString()
    }
}
