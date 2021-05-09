package ru.eyelog.fragmentgames.fragments.secondfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.second_fragment_base.*
import ru.eyelog.fragmentgames.R

@AndroidEntryPoint
class SecondFragment: Fragment() {

    private val viewModel: SecondViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.second_fragment_base, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val childFragment = childFragmentManager.findFragmentById(R.id.secondFragment00) as SecondFragment00

        viewModel.sampleLiveData.observe(viewLifecycleOwner, {
            childFragment.setNumber(it)
        })

        tvButtonMinus.setOnClickListener {
            viewModel.dataMinus()
        }

        tvButtonPlus.setOnClickListener {
            viewModel.dataPlus()
        }
    }
}
