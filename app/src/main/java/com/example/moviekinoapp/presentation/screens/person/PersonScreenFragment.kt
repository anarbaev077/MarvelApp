package com.example.moviekinoapp.presentation.screens.person

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.moviekinoapp.databinding.FragmentPersonScreenBinding
import com.example.moviekinoapp.presentation.screens.person.adapter.ActorsAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PersonScreenFragment : Fragment() {

    private val binding: FragmentPersonScreenBinding by lazy {
        FragmentPersonScreenBinding.inflate(layoutInflater)
    }

    private val adapter: ActorsAdapter by lazy {
        ActorsAdapter()
    }

    private val viewModel: PersonScreenViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupDataListeners()
        sendUiEvents()
    }

    private fun setupDataListeners() {
        lifecycleScope.launch {
            viewModel.uiAction.collectLatest { action ->
                when (action) {
                    is PersonAction.FetchPopularPerson -> fetchDetailMovie(action)
                }
            }
        }
    }

    private fun sendUiEvents() {
        viewModel.onEvent(
            event = PersonEvent.OnFetchPopularPerson,
        )
    }

    private fun fetchDetailMovie(action: PersonAction.FetchPopularPerson) {
        adapter.submitList(action.popularPersons)
        binding.popularActorsRv.adapter = adapter
    }

}