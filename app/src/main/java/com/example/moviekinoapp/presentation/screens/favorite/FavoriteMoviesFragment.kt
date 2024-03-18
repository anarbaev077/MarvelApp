package com.example.moviekinoapp.presentation.screens.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.data.locale.data.source.MovieCacheDataSource
import com.example.data.locale.data.source.MovieCacheDataSourceImpl
import com.example.domain.models.movie_list_domain.MovieDomainModel
import com.example.moviekinoapp.R
import com.example.moviekinoapp.databinding.FavoritesItemsBinding
import com.example.moviekinoapp.databinding.FragmentFavoriteMoviesBinding
import com.example.moviekinoapp.presentation.screens.home.HomeScreenFragment
import com.example.moviekinoapp.presentation.screens.home.adapter.ItemOnClickListeners
import com.example.moviekinoapp.presentation.screens.home.adapter.MovieItemTypes
import com.example.moviekinoapp.presentation.screens.home.adapter.MoviesItemAdapter
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FavoriteMoviesFragment : Fragment(), ItemOnClickListeners {

    private val binding: FragmentFavoriteMoviesBinding by lazy {
        FragmentFavoriteMoviesBinding.inflate(layoutInflater)
    }

    private val adapter: MoviesItemAdapter by lazy {
        MoviesItemAdapter(MovieItemTypes.FAVORITES, this)
    }

    private val item by lazy {
        FavoritesItemsBinding.inflate(layoutInflater)
    }

    private val viewModel: FavoriteMoviesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding.root


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.favoriteRv.adapter = adapter
        setupDataListeners()
    }

    private fun setupDataListeners() {
        lifecycleScope.launch {
            viewModel.savedMoviesFlow.collectLatest {
                adapter.submitList(it)
            }
            viewModel.uiAction.collectLatest { action ->
                when (action) {
                    is FavoriteAction.FavoriteMovies -> fetchFavoritesMovies(action)
                }
            }
        }
    }
    
    private fun fetchFavoritesMovies(action: FavoriteAction.FavoriteMovies) {}

    override fun onMovieItemClick(movieId: Int) {
        findNavController().navigate(
            R.id.action_favorite_destination_to_detail_destination,
            bundleOf(HomeScreenFragment.DETAIL_ID_ARG to movieId)
        )
    }

    override fun onMovieLongClick(movieDomainModel: MovieDomainModel) {
        findNavController().navigate(R.id.action_favorite_destination_to_detail_destination)
    }
}