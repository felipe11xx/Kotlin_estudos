package com.example.felipe.questions.fragment

import agency.tango.materialintroscreen.SlideFragment
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.felipe.questions.MainActivity
import com.example.felipe.questions.R
import com.example.felipe.questions.data.SPInfo
import kotlinx.android.synthetic.main.fragment_terms_condition_slide.*

class TermsConditionSlide : SlideFragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_terms_condition_slide, container, false)
    }

    override fun canMoveFurther(): Boolean {

        if(cb_concordo.isChecked){
            SPInfo(activity!!).updateIntroStatus(true)

            val intent = Intent(activity!!, MainActivity::class.java)
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            activity!!.finish()
        }

        return cb_concordo.isChecked
    }

    override fun cantMoveFurtherErrorMessage(): String {
        return activity!!.resources.getString(R.string.slide_4_checkbox_error)
    }

    override fun backgroundColor(): Int {
        return R.color.slide_4
    }

    override fun buttonsColor(): Int {
        return R.color.slide_button
    }
}