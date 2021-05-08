package ru.eyelog.fragmentgames.fragments.firstfragment

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.commit
import dagger.hilt.android.AndroidEntryPoint
import ru.eyelog.fragmentgames.R
import ru.eyelog.fragmentgames.fragments.firstfragment.subfragment.SubFragment00
import ru.eyelog.fragmentgames.fragments.firstfragment.subfragment.SubFragment01
import ru.eyelog.fragmentgames.fragments.firstfragment.subfragment.SubFragment02
import ru.eyelog.fragmentgames.fragments.firstfragment.subfragment.SubFragment03

@AndroidEntryPoint
class FirstFragment : Fragment() {

    private val viewModel: FirstViewModel by activityViewModels()

    private lateinit var button: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            inflater.inflate(R.layout.first_fragment_portrait, container, false)
        } else {
            inflater.inflate(R.layout.first_fragment_landscape, container, false)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycle.addObserver(viewModel)

        button = view.findViewById(R.id.tvButton)

        setFragment(
            R.id.fragmentContainer00,
            SubFragment00(),
            SubFragment00::javaClass.name
        )

        setFragment(
            R.id.fragmentContainer01,
            SubFragment01(),
            SubFragment01::javaClass.name
        )

        setFragment(
            R.id.fragmentContainer02,
            SubFragment02(),
            SubFragment02::javaClass.name
        )

        setFragment(
            R.id.fragmentContainer03,
            SubFragment03(),
            SubFragment03::javaClass.name
        )

        viewModel.buttonStatusLiveData.observe(viewLifecycleOwner, {
            button.text = it
        })

        button.setOnClickListener {
            viewModel.handleCounting()
        }
    }

    private fun setFragment(
        res: Int,
        fragment: Fragment,
        tag: String
    ) {
        parentFragmentManager.commit {
            add(res, fragment, tag)
        }
    }
}
