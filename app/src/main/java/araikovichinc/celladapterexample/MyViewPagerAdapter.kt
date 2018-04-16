package araikovichinc.celladapterexample

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

/**
 * Created by Tigran on 16.04.2018.
 */
class MyViewPagerAdapter(val fm: FragmentManager, val fragmentsList: ArrayList<Fragment> = ArrayList(),
                         val titleList: ArrayList<String> = ArrayList()) : FragmentPagerAdapter(fm) {
    override fun getItem(position: Int) = fragmentsList.get(position)

    override fun getCount() = fragmentsList.size

    fun addFragments(fragment : Fragment, title: String ){
        fragmentsList.add(fragment)
        titleList.add(title)
    }

    override fun getPageTitle(position: Int) = titleList.get(position)
}