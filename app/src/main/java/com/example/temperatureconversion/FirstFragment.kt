package com.example.temperatureconversion

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.widget.addTextChangedListener
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_first.*
import java.lang.Exception
import kotlin.math.roundToLong

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        temp_input.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

                val input = s.toString()

                try {
                    val f = input.toDouble()

                    val c = ((f-32) * (5.0/9.0))
                    val cRounded = (c*100).roundToLong()/100.0
                    celsius_update.text = cRounded.toString()

                    val k = c + 273.15
                    val kRounded = (k*100).roundToLong()/100.0
                    kelvin_update.text = kRounded.toString()

                }
                catch(e: Exception) {
                    celsius_update.text = ""
                    kelvin_update.text = ""
                }

            }

            override fun afterTextChanged(s: Editable) {

            }
        })

    }
}