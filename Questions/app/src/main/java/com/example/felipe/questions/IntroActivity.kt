package com.example.felipe.questions

import agency.tango.materialintroscreen.MaterialIntroActivity
import agency.tango.materialintroscreen.MessageButtonBehaviour
import agency.tango.materialintroscreen.SlideFragmentBuilder
import android.Manifest
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.felipe.questions.data.SPInfo
import com.example.felipe.questions.fragment.TermsConditionSlide


class IntroActivity: MaterialIntroActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //botões opcionais que podem ser uteis em alguns casos
        // hideBackButton()
        //setSkipButtonVisible()
        //enableLastSlideAlphaExitTransition(true)

        addSlide(SlideFragmentBuilder()
                .backgroundColor(R.color.slide_1)
                .buttonsColor(R.color.slide_button)
                .title(resources.getString(R.string.slide_1_title))
                .description(resources.getString(R.string.slide_1_description))
                .image(R.drawable.slide_1)
                .build(), MessageButtonBehaviour(object : View.OnClickListener{
            override fun onClick(v: View?) {
                showMessage(resources.getString(R.string.slide_1_button_message))
            }
        },resources.getString(R.string.slide_1_button_label))
        )

        val needPermission = arrayOf(
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION
        )
        addSlide(SlideFragmentBuilder()
            .backgroundColor(R.color.slide_2)
            .buttonsColor(R.color.slide_button)
            .title(resources.getString(R.string.slide_2_title))
            .description(resources.getString(R.string.slide_2_description))
            .image(R.drawable.slide_2)
            .neededPermissions(needPermission)
            .build()
        )

        val acessiblePermission = arrayOf(Manifest.permission.CAMERA)
        addSlide(SlideFragmentBuilder()
            .backgroundColor(R.color.slide_3)
            .buttonsColor(R.color.slide_button)
            .title(resources.getString(R.string.slide_3_title))
            .description(resources.getString(R.string.slide_3_description))
            .image(R.drawable.slide_3)
            .possiblePermissions(acessiblePermission)
            .build()
        )

        addSlide(TermsConditionSlide())
        //ver essa função e classe depois ela não abre o app as vezes
        verifyIntroActicity()
    }

    private fun verifyIntroActicity(){
        if(SPInfo(this).isIntroActivityShown()){
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

    }
}