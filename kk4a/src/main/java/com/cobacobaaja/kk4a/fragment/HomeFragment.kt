package com.cobacobaaja.kk4a.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.cobacobaaja.kk4a.R
import com.cobacobaaja.kk4a.fragment.listview.HeroFragment
import com.cobacobaaja.kk4a.fragment.mytestingapp.MyTestingFragment

class HomeFragment : Fragment(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_home, container, false)
        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btn_mytest: Button = view.findViewById(R.id.btn_mytesting)
        btn_mytest.setOnClickListener {
            val mmm = MyTestingFragment()
            val mFragmentManager = fragmentManager
            mFragmentManager?.beginTransaction()?.apply {
                replace(R.id.frame_container, mmm, MyTestingFragment::class.java.simpleName)
                addToBackStack(null)
                commit()
            }
        }

        val btn: Button = view.findViewById(R.id.btn_listview)
        btn.setOnClickListener {
            val mCategoryFragment = HeroFragment()
            val mFragmentManager = fragmentManager
            mFragmentManager?.beginTransaction()?.apply {
                replace(R.id.frame_container, mCategoryFragment, HeroFragment::class.java.simpleName)
                addToBackStack(null)
                commit()
            }
        }
        val btnCategory: Button = view.findViewById(R.id.btn_category)
        btnCategory.setOnClickListener(this)
    }
    override fun onClick(v: View) {
        val mCategoryFragment = CategoryFragment()
        val mFragmentManager = fragmentManager
        mFragmentManager?.beginTransaction()?.apply {
            replace(R.id.frame_container, mCategoryFragment, CategoryFragment::class.java.simpleName)
            addToBackStack(null)
            commit()
        }
    }


}