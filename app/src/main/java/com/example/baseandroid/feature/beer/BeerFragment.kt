package com.example.baseandroid.feature.beer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.baseandroid.R
import com.example.baseandroid.databinding.FragmentBeerBinding
import com.example.baseandroid.feature.beer.adapter.BeerAdapter
import com.example.common.R.dimen.bottom_item_decoration
import com.example.common.adapter.MyItemDecoration
import com.example.common.base.BaseFragment
import com.example.common.commom.hide
import com.example.common.commom.show
import com.example.domain.entities.BeersViewState
import org.koin.androidx.viewmodel.ext.android.viewModel

class BeerFragment : BaseFragment<BeerViewModel, FragmentBeerBinding>(R.layout.fragment_beer) {

    override val viewModel: BeerViewModel by viewModel()

    private var _binding: FragmentBeerBinding? = null
    override val binding: FragmentBeerBinding
        get() = _binding!!

    private var layoutManagerBeer: LinearLayoutManager? = null
    private val beerAdapter: BeerAdapter by lazy {
        BeerAdapter(viewModel.listBeer)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBeerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun initControl() {
        binding.swipeRefreshLayout.setOnRefreshListener {
            viewModel.getBeers()
        }
    }

    override fun initUI() {
        layoutManagerBeer = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.recycleViewBeer.apply {
            layoutManager = layoutManagerBeer
            addItemDecoration(
                MyItemDecoration(
                    resources.getDimension(bottom_item_decoration).toInt()
                )
            )
            adapter = beerAdapter
        }
    }

    override fun initEvent() {
        viewModel.listBeerLiveData.observe(viewLifecycleOwner) {
            it.getContentIfNotHandled()?.let { beers ->
                beerAdapter.addAll(beers)
            }
        }
    }

    override fun initConfig() {
        viewModel.getBeers()
    }

    private fun handleBeersLoading(state: BeersViewState) {
        if (state.isLoading) {
            binding.progressBar.show()
        } else {
            binding.progressBar.hide()
        }
    }
}