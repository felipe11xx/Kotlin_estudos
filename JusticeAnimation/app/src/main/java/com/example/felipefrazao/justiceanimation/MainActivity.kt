package com.example.felipefrazao.justiceanimation

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.constraint.ConstraintSet
import android.support.v7.app.AppCompatActivity
import android.transition.ChangeBounds
import android.transition.TransitionManager
import android.view.View
import android.view.animation.OvershootInterpolator
import com.example.felipefrazao.justiceanimation.R
import kotlinx.android.synthetic.main.activity_main.*

 class MainActivity : AppCompatActivity() {

    private var selectedView: View? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        animateConstraints()
    }

    private fun animateConstraints() {
        main_layout.setOnClickListener { defaultLayout() }

        imgWonderWoman.setOnClickListener {
            if (selectedView != imgWonderWoman) {
                updateLayout(R.layout.activity_wonder_woman)
                selectedView = imgWonderWoman
            }else{
                defaultLayout()
            }
        }

        imgBatman.setOnClickListener {
            if (selectedView != imgBatman) {
                updateLayout(R.layout.activity_batman)
                selectedView = imgBatman
            }else{
                defaultLayout()
            }
        }

        imgSuperman.setOnClickListener {
            if (selectedView != imgSuperman) {
                updateLayout(R.layout.activity_superman)
                selectedView = imgSuperman
            }else{
                defaultLayout()
            }
        }
    }

    private fun defaultLayout() {
        if (selectedView != null) {
            updateLayout(R.layout.activity_main)
            selectedView = null
        }
    }

    private fun updateLayout(@LayoutRes id: Int) {
        val constraintSet = ConstraintSet()
        constraintSet.clone(this, id)
        constraintSet.applyTo(main_layout)

        val transition = ChangeBounds()
        transition.interpolator = OvershootInterpolator()
        TransitionManager.beginDelayedTransition(main_layout, transition)

    }

}