package ru.eyelog.fragmentgames.fragments.maincontainer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_main.*
import ru.eyelog.fragmentgames.R
import ru.eyelog.fragmentgames.fragments.firstfragment.FirstFragment
import ru.eyelog.fragmentgames.fragments.secondfragment.SecondFragment
import ru.eyelog.fragmentgames.fragments.thirdfragment.ThirdFragment

@AndroidEntryPoint
class MainContainer : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.firstFragment -> {
                    setFragment(
                        FirstFragment(),
                        FirstFragment::class.java.name
                    )
                    true
                }
                R.id.secondFragment -> {
                    setFragment(
                        SecondFragment(),
                        SecondFragment::class.java.name
                    )
                    true
                }
                R.id.thirdFragment -> {
                    setFragment(
                        ThirdFragment(),
                        ThirdFragment::class.java.name
                    )
                    true
                }
                else -> false
            }
        }

        setFragment(
            FirstFragment(),
            FirstFragment::class.java.name
        )
    }

    private fun setFragment(fragment: Fragment, tag: String){
        parentFragmentManager.beginTransaction()
            .replace(
                R.id.mainFragmentSpace,
                fragment,
                tag
            )
            .commit()
    }
}
