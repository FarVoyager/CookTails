package com.example.cooktails.detailsFragment

import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.widget.AppCompatTextView
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.core.view.marginStart
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.cooktails.R
import com.example.cooktails.databinding.FragmentDetailsBinding
import com.example.cooktails.di.AbsFragment
import com.example.cooktails.mainActivity.BackButtonListener
import com.example.cooktails.model.Cocktail
import com.example.cooktails.view.glide.GlideImageLoader
import moxy.ktx.moxyPresenter

const val COCKTAIL_KEY = "COCKTAIL_KEY"

class DetailsFragment : AbsFragment(R.layout.fragment_details), DetailsView, BackButtonListener {

    private val presenter by moxyPresenter {
        DetailsPresenter(
            router,
            arguments?.get(COCKTAIL_KEY) as Cocktail
        )
    }

    companion object {
        @JvmStatic
        fun newInstance(cocktail: Cocktail): Fragment {
            val bundle = Bundle()
            bundle.putParcelable(COCKTAIL_KEY, cocktail)
            return DetailsFragment().apply { arguments = bundle }
        }
    }

    private val binding: FragmentDetailsBinding by viewBinding()

    override fun showName(text: String?) {
        binding.textViewDetailsName.text = text
    }

    override fun showImage(url: String?) {
        if (url != null) { glideImageLoader.loadInto(url, binding.detailsImageView) }
    }

    override fun showCategory(text: String?) {
        binding.textViewDetailsCategory.text = text
    }

    override fun showAlcoholic(text: String?) {
        binding.textViewDetailsAlcoholic.text = text
    }

    override fun showGlass(text: String?) {
        binding.textViewDetailsGlass.text = text
    }

    override fun showRecipe(text: String?) {
        binding.textViewRecipe.text = text
    }

    override fun showIngredients(ingredients: List<String>) {
        initIngredientsData(ingredients, binding.linearLayoutIngredients)
    }

    override fun showMeasures(measures: List<String>) {
        initIngredientsData(measures, binding.linearLayoutMeasures)
    }

    private fun initIngredientsData(data: List<String>, layout: LinearLayout) {
        for (i in data.indices) {
            layout.addView(
                AppCompatTextView(requireContext()).apply {
                    text = data[i]
                    gravity = Gravity.CENTER_VERTICAL
                    height = 80
                    textSize = 14f
                }
            )
        }
    }

    override fun backPressed(): Boolean {
        return presenter.backPressed()
    }
}