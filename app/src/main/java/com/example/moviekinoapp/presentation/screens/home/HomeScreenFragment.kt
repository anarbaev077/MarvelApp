package com.example.moviekinoapp.presentation.screens.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.domain.models.movie_list_domain.MovieDomainModel
import com.example.moviekinoapp.R
import com.example.moviekinoapp.databinding.FragmentHomeScreenBinding
import com.example.moviekinoapp.presentation.screens.home.adapter.ItemOnClickListeners
import com.example.moviekinoapp.presentation.screens.home.adapter.MovieItemTypes
import com.example.moviekinoapp.presentation.screens.home.adapter.MoviesItemAdapter
import com.example.netfilxcloneapp.presentation.utils.PeekingLinearLayoutManager
import com.example.moviekinoapp.presentation.links.gone
import com.example.moviekinoapp.presentation.links.hideBottomNavigation
import com.example.moviekinoapp.presentation.links.show
import com.example.moviekinoapp.presentation.links.showBottomNavigation
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeScreenFragment : Fragment(), ItemOnClickListeners {

    private val binding: FragmentHomeScreenBinding by lazy {
        FragmentHomeScreenBinding.inflate(layoutInflater)
    }
    private val viewModel: HomeScreenViewModel by viewModels()

    private val latestAdapter: MoviesItemAdapter by lazy {
        MoviesItemAdapter(MovieItemTypes.LATEST, this)
    }
    private val trendingTodayAdapter: MoviesItemAdapter by lazy {
        MoviesItemAdapter(MovieItemTypes.TRENDING, this)
    }
    private val topRatedAdapter: MoviesItemAdapter by lazy {
        MoviesItemAdapter(MovieItemTypes.TOP_RATED, this)
    }
    private val upcomingAdapter: MoviesItemAdapter by lazy {
        MoviesItemAdapter(MovieItemTypes.UPCOMING, this)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupLatestMoviesUi()
        setupTrendingTodayMoviesUi()
        sendUiEvents()
        setupDataListeners()
    }

    private fun setupDataListeners() {
        lifecycleScope.launch {
            viewModel.uiAction.collectLatest { action ->
                when (action) {
                    is HomeScreenAction.UpdateScreenHideShimmer -> setupUiWhenUpdateScreenAction()
                    is HomeScreenAction.FetchAllMovies -> submitListAdapters(action)
                    is HomeScreenAction.NavigateToDetailsScreen -> navigateToDetailScreen(action)
                    is HomeScreenAction.ShowSuccessSnackBar -> showSuccessSnackBar("Ваше кино сохранено")
                }
            }
        }
    }

    private fun showSuccessSnackBar(message: String) {
        Snackbar.make(
            binding.root,
            message,
            Snackbar.LENGTH_SHORT
        ).show()
    }

    private fun navigateToDetailScreen(action: HomeScreenAction.NavigateToDetailsScreen) {
        findNavController().navigate(
            R.id.action_home_destination_to_detail_destination,
            bundleOf(DETAIL_ID_ARG to action.movieId)
        )
    }

    private fun sendUiEvents() {
        requireActivity().hideBottomNavigation()
        viewModel.onEvent(HomeScreenEvent.OnFetchAllMovies)
    }

    private fun setupLatestMoviesUi() = with(binding.latestMoviesBlock) {
        moviesRv.layoutManager = PeekingLinearLayoutManager(requireContext())
        moviesRv.adapter = latestAdapter
    }

    private fun setupTrendingTodayMoviesUi() = with(binding) {
        trendingTodayMoviesBlock.moviesTrendingTodayRv.adapter = trendingTodayAdapter
        topRatedMoviesBlock.moviesTrendingTodayRv.adapter = topRatedAdapter
        topRatedMoviesBlock.listHeader.text = "Топовые"
        upcomingMoviesBlock.moviesTrendingTodayRv.adapter = upcomingAdapter
        upcomingMoviesBlock.listHeader.text = "Скоро Выйдут"
    }

    private fun submitListAdapters(action: HomeScreenAction.FetchAllMovies) {
        latestAdapter.submitList(action.popularMovies)
        trendingTodayAdapter.submitList(action.nowPlayingMovies)
        topRatedAdapter.submitList(action.topRatedMovies)
        upcomingAdapter.submitList(action.upcomingMovies)
    }

    private fun setupUiWhenUpdateScreenAction() = with(binding) {
        shimmer.hideShimmer()
        shimmer.gone()
        homeMainLL.show()
        requireActivity().showBottomNavigation()
    }

    override fun onMovieItemClick(movieId: Int) {
        viewModel.onEvent(HomeScreenEvent.OnNavigateToDetails(movieId))
    }

    override fun onMovieLongClick(movieDomainModel: MovieDomainModel) {
        viewModel.onEvent(HomeScreenEvent.OnSaveMovieToCache(movieDomainModel))
    }

    companion object {
        const val DETAIL_ID_ARG = "DETAIL_ID_ARG"
    }
}