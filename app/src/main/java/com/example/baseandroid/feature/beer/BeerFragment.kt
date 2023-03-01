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
       showToast("init Control")
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
            it.getContentIfNotHandled()?.let {
                beerAdapter.addAll(it.listBeer)
            }
        }
    }

    override fun initConfig() {
        viewModel.getBeers()
    }
}