package com.example.felipefrazao.animationface

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.ConstraintSet
import android.transition.TransitionManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addAnimation()
    }

    private fun addAnimation() {

        var set = false

        val constraintSet1 = ConstraintSet()
        constraintSet1.clone(main_layout)

        val constraintSet2 = ConstraintSet()
        constraintSet2.clone(this, R.layout.activity_main_alt)

        imgFace.setOnClickListener {
            TransitionManager.beginDelayedTransition(main_layout)

            val constraint = if (set) constraintSet1 else constraintSet2
            constraint.applyTo(main_layout)
            set = !set
        }
    }

}

