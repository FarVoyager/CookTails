package com.example.cooktails.detailsFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.cooktails.databinding.FragmentDetailsBinding
import com.example.cooktails.databinding.FragmentMainBinding
import com.example.cooktails.di.AbsFragment
import com.example.cooktails.model.Cocktail

const val COCKTAIL_KEY = "COCKTAIL_KEY"

class DetailsFragment : AbsFragment() {

    private val binding: FragmentDetailsBinding by viewBinding()

    companion object {
        @JvmStatic
        fun newInstance(cocktail: Cocktail): Fragment =
            DetailsFragment().apply { arguments?.putParcelable(COCKTAIL_KEY, cocktail) }
    }
}