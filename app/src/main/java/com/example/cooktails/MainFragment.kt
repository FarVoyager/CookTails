package com.example.cooktails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.cooktails.databinding.FragmentMainBinding
import com.example.cooktails.di.AbsFragment


class MainFragment : AbsFragment() {

    private val binding: FragmentMainBinding by viewBinding()

//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        return inflater.inflate(R.layout.fragment_main, container, false)
//    }

    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()
    }
}