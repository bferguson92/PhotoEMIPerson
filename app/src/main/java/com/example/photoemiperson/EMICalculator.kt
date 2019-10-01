package com.example.photoemiperson

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_emicalulator.*
import java.math.BigDecimal
import java.math.RoundingMode

class EMICalculator : AppCompatActivity(), View.OnClickListener, SeekBar.OnSeekBarChangeListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_emicalulator)
        btnCalculate.setOnClickListener(this)
        sbLoanAmount.setOnSeekBarChangeListener(this)
        sbInterestRate.setOnSeekBarChangeListener(this)
        sbTenure.setOnSeekBarChangeListener(this)

    }

    override fun onClick(view: View) {
        when(view.id){
            R.id.btnCalculate -> calulateEMI()
        }
    }

    override fun onStartTrackingTouch(seekBar: SeekBar) {

    }

    override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
        when(seekBar.id){
            R.id.sbLoanAmount -> tvLoanAmount.text = progress.toString()
            R.id.sbInterestRate -> tvInterestRate.text = progress.toString()
            R.id.sbTenure -> tvTenure.text = progress.toString()

        }
    }

    override fun onStopTrackingTouch(seekBar: SeekBar) {

    }

    private fun calulateEMI(){
        val loanAmount = tvLoanAmount.text.toString().toDouble()
        val intersetRate = (tvInterestRate.text.toString().toDouble() / 12) / 100
        val tenure = tvTenure.text.toString().toDouble()

        val emi = BigDecimal((loanAmount) * (intersetRate) * ((Math.pow((1 + intersetRate), tenure)) /
                ((Math.pow(1 + intersetRate, tenure)) - 1))).setScale(2, RoundingMode.CEILING)

        tvEMI.text = emi.toString()
    }
}
