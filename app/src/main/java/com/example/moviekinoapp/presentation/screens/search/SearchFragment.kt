package com.example.moviekinoapp.presentation.screens.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.domain.models.movie_list_domain.MovieDomainModel
import com.example.moviekinoapp.R
import com.example.moviekinoapp.databinding.FragmentSearchScreenBinding
import com.example.moviekinoapp.presentation.screens.home.HomeScreenEvent
import com.example.moviekinoapp.presentation.screens.home.HomeScreenFragment
import com.example.moviekinoapp.presentation.screens.home.HomeScreenViewModel
import com.example.moviekinoapp.presentation.screens.home.adapter.ItemOnClickListeners
import com.example.moviekinoapp.presentation.screens.home.adapter.MovieItemTypes
import com.example.moviekinoapp.presentation.screens.home.adapter.MoviesItemAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SearchFragment : Fragment(), ItemOnClickListeners {

    private val binding: FragmentSearchScreenBinding by lazy {
        FragmentSearchScreenBinding.inflate(layoutInflater)
    }

    private val searchAdapter: MoviesItemAdapter by lazy {
        MoviesItemAdapter(MovieItemTypes.TRENDING, this)
    }

    private val viewModelHome: HomeScreenViewModel by viewModels()

    private val viewModel: SearchViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUi()
        observeActions()
    }

    private fun observeActions() {
        lifecycleScope.launch {
            viewModel.uiAction.collectLatest {
                when (it) {
                    is SearchAction.FilteredMoviesBySearch -> searchAdapter.submitList(it.movies)
                }
            }
        }
    }

    private fun setupUi() = with(binding) {
        searchRv.adapter = searchAdapter
        movieSearch.setOnQueryTextListener(
            object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    return false
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    viewModel.onEvent(SearchEvent.onSearchMovies(newText.orEmpty()))
                    return true
                }
            },
        )
    }

    override fun onMovieItemClick(movieId: Int) {
        findNavController().navigate(
            R.id.action_search_destination_to_detail_destination,
            bundleOf(HomeScreenFragment.DETAIL_ID_ARG to movieId)
        )
    }

    override fun onMovieLongClick(movieDomainModel: MovieDomainModel) {
        viewModelHome.onEvent(HomeScreenEvent.OnSaveMovieToCache(movieDomainModel))
    }
}