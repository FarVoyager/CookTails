package com.example.cooktails.mainFragment

import android.annotation.SuppressLint

import android.content.res.ColorStateList
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.SearchView
import android.widget.Toast
import androidx.annotation.RequiresApi

import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.cooktails.R
import com.example.cooktails.databinding.FragmentMainBinding
import com.example.cooktails.di.AbsFragment
import com.example.cooktails.mainActivity.BackButtonListener
import com.example.cooktails.view.glide.GlideImageLoader
import com.example.cooktails.mainFragment.rv.MainRecyclerViewAdapter
import com.example.cooktails.model.room.RetrofitCocktailsRepo

import com.google.android.material.button.MaterialButton
import moxy.ktx.moxyPresenter
import javax.inject.Inject


class MainFragment : AbsFragment(R.layout.fragment_main), MainView, BackButtonListener {

    @Inject
    lateinit var cocktailsRepo: RetrofitCocktailsRepo

    private val binding: FragmentMainBinding? by viewBinding()
    companion object { @JvmStatic fun newInstance() = MainFragment() }
    private val presenter by moxyPresenter {
        MainPresenter(router, cocktailsRepo, scheduler, androidScreens)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.btnAll?.setOnClickListener { presenter.loadCocktailDatabase() }
        binding?.btnRandom?.setOnClickListener { presenter.loadRandomCocktails() }
        binding?.btnBrowse?.setOnClickListener { presenter.loadBrowsed() }

        SearchView(requireContext())
        binding?.btnSearch?.setOnClickListener {
            val searchQuery = binding?.searchView?.query.toString()
            if (searchQuery.isNotEmpty()) {
                presenter.onSearchClicked(presenter.getSearchQuery(searchQuery))
            } else {
                showToast("Search field is empty")
            }
        }

    }

    private var adapter: MainRecyclerViewAdapter? = null

    override fun init() {
        binding?.mainRecyclerView?.layoutManager = LinearLayoutManager(context)
        adapter = MainRecyclerViewAdapter(presenter.mainListPresenter, GlideImageLoader())
        binding?.mainRecyclerView?.adapter = adapter
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun updateList() {
        adapter?.notifyDataSetChanged()
    }

    override fun updateRvListHeader(text: String) {
        binding?.rvListHeader?.text = text
    }

    override fun updateRvListUnitsCount(text: String) {
        binding?.textViewCocktailsCount?.text = text
    }

    override fun showToast(text: String) {
        Toast.makeText(requireContext(), text, Toast.LENGTH_LONG).show()
    }


    @RequiresApi(Build.VERSION_CODES.M)
    override fun setSearchLayoutVisibility() {
        val searchLayout = binding?.searchLayout
        if (searchLayout?.visibility == View.GONE) {
            searchLayout.visibility = View.VISIBLE
            setBtnColor(binding?.btnBrowse, R.color.white, R.color.white, R.color.black)
        } else {
            searchLayout?.visibility = View.GONE
            setBtnColor(binding?.btnBrowse, R.color.colorPrimary, R.color.white, R.color.white)
        }
    }

    override fun isNonAlcoholicChecked() {
        binding?.nonAlcoholicCheckBox?.isChecked?.let { presenter.getNonAlcoholicCheck(it) }
    }

    override fun updateRvVisibility(isListEmpty: Boolean) {
        if (isListEmpty) {
            binding?.mainRecyclerView?.visibility = View.GONE
            binding?.textViewNotFound?.visibility = View.VISIBLE
        } else {
            binding?.mainRecyclerView?.visibility = View.VISIBLE
            binding?.textViewNotFound?.visibility = View.GONE
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun setBtnColor(button: MaterialButton?, backgroundColor: Int, strokeColor: Int, textColor: Int) {
        button?.apply {
            setBackgroundColor(resources.getColor(backgroundColor, null))
            setStrokeColor(ColorStateList.valueOf(resources.getColor(strokeColor, null)))
            setTextColor(resources.getColor(textColor, null))
        }
    }


    override fun backPressed(): Boolean = presenter.backPressed()

}