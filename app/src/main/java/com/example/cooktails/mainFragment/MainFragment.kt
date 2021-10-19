package com.example.cooktails.mainFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cooktails.databinding.FragmentMainBinding
import com.example.cooktails.di.AbsFragment
import com.example.cooktails.model.CocktailsRepo
import com.example.cooktails.mainActivity.BackButtonListener
import com.example.cooktails.view.glide.GlideImageLoader
import com.example.cooktails.view.rv.MainRecyclerViewAdapter
import moxy.ktx.moxyPresenter
import javax.inject.Inject


class MainFragment : AbsFragment(), MainView, BackButtonListener {

    @Inject
    lateinit var cocktailsRepo: CocktailsRepo

    private var binding: FragmentMainBinding? = null
    companion object { @JvmStatic fun newInstance() = MainFragment() }
    private val presenter by moxyPresenter {
        MainPresenter(router, cocktailsRepo, scheduler)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentMainBinding.inflate(inflater, container, false)
        .also{ binding = it }.root

    private var adapter: MainRecyclerViewAdapter? = null

    override fun init() {
        binding?.mainRecyclerView?.layoutManager = LinearLayoutManager(context)
        adapter = MainRecyclerViewAdapter(presenter.mainListPresenter, GlideImageLoader())
        binding?.mainRecyclerView?.adapter = adapter
    }

    override fun updateList() {
        adapter?.notifyDataSetChanged()
    }

    override fun backPressed(): Boolean = presenter.backPressed()

}