package ru.eyelog.fragmentgames.fragments.secondfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_sub.*
import ru.eyelog.fragmentgames.R

class SecondFragment00: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sub, container, false)
    }

    fun setNumber(number: String){
        tvNumber.text = number
    }
}
