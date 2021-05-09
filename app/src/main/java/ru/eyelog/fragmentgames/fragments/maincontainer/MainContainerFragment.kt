package ru.eyelog.fragmentgames.fragments.maincontainer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_main.*
import ru.eyelog.fragmentgames.R
import ru.eyelog.fragmentgames.fragments.firstfragment.FirstFragment
import ru.eyelog.fragmentgames.fragments.secondfragment.SecondFragment
import ru.eyelog.fragmentgames.fragments.thirdfragment.ThirdFragment

@AndroidEntryPoint
class MainContainerFragment : Fragment() {

    private val bottomNavIds = listOf(
        R.id.firstFragment,
        R.id.secondFragment,
        R.id.thirdFragment
    )

    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycle.addObserver(viewModel)

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                bottomNavIds[0] -> {
                    viewModel.setNumber(0)
                    setFragment(
                        FirstFragment(),
                        FirstFragment::class.java.name
                    )
                    true
                }
                bottomNavIds[1] -> {
                    viewModel.setNumber(1)
                    setFragment(
                        SecondFragment(),
                        SecondFragment::class.java.name
                    )
                    true
                }
                bottomNavIds[2] -> {
                    viewModel.setNumber(2)
                    setFragment(
                        ThirdFragment(),
                        ThirdFragment::class.java.name
                    )
                    true
                }
                else -> false
            }
        }

        viewModel.numberLiveData.observe(viewLifecycleOwner, {
            bottomNavigationView.selectedItemId = bottomNavIds[it]
            bottomNavigationView.performClick()
        })

        setFragment(
            FirstFragment(),
            FirstFragment::class.java.name
        )
    }

    private fun setFragment(fragment: Fragment, tag: String) {
        parentFragmentManager.beginTransaction()
            .replace(
                R.id.mainFragmentSpace,
                fragment,
                tag
            )
            .commit()
    }
}
