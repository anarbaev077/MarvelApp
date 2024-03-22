package com.example.moviekinoapp.presentation.screens.detail.pager.cast

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.moviekinoapp.databinding.FragmentCastDetailBinding
import com.example.moviekinoapp.presentation.screens.detail.pager.adapter.CastAdapter
import com.example.moviekinoapp.presentation.screens.home.HomeScreenFragment.Companion.DETAIL_ID_ARG
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CastFragment : Fragment() {

    private val binding: FragmentCastDetailBinding by lazy {
        FragmentCastDetailBinding.inflate(layoutInflater)
    }

    private val viewModel: CastFragmentViewModel by viewModels()

    private val adapter: CastAdapter by lazy {
        CastAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val movieId = arguments?.getInt(DETAIL_ID_ARG)
        sendUiEvents(movieId)
        setupDataListeners()
        Log.d("Eerme","$movieId")
    }

    private fun setupDataListeners() {
        lifecycleScope.launch {
            viewModel.uiAction.collectLatest { action ->
                when (action) {
                    is CastAction.FetchCastDetail -> fetchCastDetail(action)
                }
            }
        }
    }

    private fun sendUiEvents(movieId: Int?){
        if (movieId != null){
            viewModel.onEvent(
                event = CastEvent.OnFetchCastDetails,
                movieId = movieId
            )
        }
    }

    private fun fetchCastDetail(action: CastAction.FetchCastDetail){
        adapter.submitList(action.castDetail.cast)
        binding.castBlockDetail.castRv.adapter = adapter
    }

}