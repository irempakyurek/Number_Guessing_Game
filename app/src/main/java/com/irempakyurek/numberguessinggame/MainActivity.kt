package com.irempakyurek.numberguessinggame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    var score = 0
    var randomSayi = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        score = 100
        randomSayi = Random.nextInt(1, 500)

        btn_guess.setOnClickListener {
            tahmin()
        }
    }

    fun tahmin() {

        val tahminSayiStr = et_guess.text.toString()

        if (!tahminSayiStr.equals("")) {

            val tahminSayi = tahminSayiStr.toInt()

            if (tahminSayi > randomSayi) {
                guess_status.setText(getString(R.string.try_smaller_number))
                score--
                txt_score.setText(score.toString())
            } else if (tahminSayi < randomSayi) {
                guess_status.setText(getString(R.string.try_bigger_number))
                score--
                txt_score.setText(score.toString())
            } else {
                guess_status.setText(getString(R.string.congrats))
                score--
                txt_score.setText(score.toString())
                et_guess.isFocusable = false
                btn_guess.isClickable = false
            }
        }else {
            Toast.makeText(this, "Lütfen bir sayı giriniz", Toast.LENGTH_SHORT).show()
        }


    }
}