package ru.eyelog.fragmentgames.fragments.firstfragment.subfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_sub.*
import ru.eyelog.fragmentgames.R
import ru.eyelog.fragmentgames.fragments.firstfragment.FirstViewModel

@AndroidEntryPoint
class SubFragment03: Fragment() {

    private val viewModel: FirstViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sub, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvNumber.text = "X"

        viewModel.sample03LiveData.observe(viewLifecycleOwner, {
            tvNumber.text = it
        })
    }
}
