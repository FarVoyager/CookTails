package com.example.cooktails.mainFragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.cooktails.R
import com.example.cooktails.databinding.FragmentMainBinding
import com.example.cooktails.di.AbsFragment
import com.example.cooktails.mainActivity.BackButtonListener
import com.example.cooktails.view.glide.GlideImageLoader
import com.example.cooktails.mainFragment.rv.MainRecyclerViewAdapter
import com.example.cooktails.model.room.RetrofitCocktailsRepo
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

    override fun backPressed(): Boolean = presenter.backPressed()

}