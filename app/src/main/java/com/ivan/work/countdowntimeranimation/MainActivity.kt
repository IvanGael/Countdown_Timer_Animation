package com.ivan.work.countdowntimeranimation

import android.animation.ValueAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var countDownTextView : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        countDownTextView = findViewById<TextView>(R.id.countdown_text_view)
    }

    override fun onStart() {
        super.onStart()

        // set the duration of the countdown in milliseconds
        val countDownDuration = 60000L

        // create a value animator to animate the countdown
        val valueAnimator = ValueAnimator.ofInt(countDownDuration.toInt(), 0)
        valueAnimator.duration = countDownDuration

        // update the text view with the current countdown value
        valueAnimator.addUpdateListener {
            val currentValue = it.animatedValue as Int
            val remainingTime = (currentValue / 1000).toString()
            countDownTextView.text = remainingTime
        }

        // start the countdown animation
        valueAnimator.start()
    }
}