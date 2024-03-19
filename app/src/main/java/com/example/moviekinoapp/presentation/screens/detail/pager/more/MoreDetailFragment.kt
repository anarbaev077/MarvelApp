package com.example.moviekinoapp.presentation.screens.detail.pager.more

import android.os.Bundle
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
import com.example.moviekinoapp.databinding.FragmentMoreDetailBinding
import com.example.moviekinoapp.presentation.screens.detail.pager.more.adapter.MoreMoviesItemAdapter
import com.example.moviekinoapp.presentation.screens.home.HomeScreenFragment
import com.example.moviekinoapp.presentation.screens.home.adapter.ItemOnClickListeners
import com.example.moviekinoapp.presentation.screens.home.adapter.MoreMovieItemTypes
import com.example.moviekinoapp.presentation.screens.home.adapter.MovieItemTypes
import com.example.moviekinoapp.presentation.screens.home.adapter.MoviesItemAdapter
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

//Хотел в more Добавить top rated но выходила ошибка и я пошел спать

class MoreDetailFragment : Fragment(), ItemOnClickListeners {

    private val binding: FragmentMoreDetailBinding by lazy {
        FragmentMoreDetailBinding.inflate(layoutInflater)
    }
    private val topRatedAdapter: MoreMoviesItemAdapter by lazy {
        MoreMoviesItemAdapter(MoreMovieItemTypes.TOP_RATED, this)
    }
//
//    private val viewModel: MoreDetailViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        setupTrendingTodayMoviesUi()
//        setupDataListeners()
    }


//    private fun setupDataListeners() {
//        lifecycleScope.launch {
//            viewModel.uiAction.collectLatest { action ->
//                when (action) {
//                    is MoreDetailAction.FetchAllMovies -> submitListAdapters(action)
//                    is MoreDetailAction.NavigateToDetailsScreen -> navigateToDetailScreen(action)
//                    is MoreDetailAction.ShowSuccessSnackBar -> showSuccessSnackBar("Ваше кино сохранено")
//                }
//            }
//        }
//    }

    override fun onMovieItemClick(movieId: Int) {

    }
//
//    override fun onMovieItemClick(movieId: Int) {
//        viewModel.onEvent(MoreDetailEvent.OnNavigateToDetails(movieId))
//    }

    override fun onMovieLongClick(movieDomainModel: MovieDomainModel) {

    }
//
//    private fun setupTrendingTodayMoviesUi() = with(binding) {
//        latestMoviesBlock.moviesRv.adapter = topRatedAdapter
//    }

    private fun navigateToDetailScreen(action: MoreDetailAction.NavigateToDetailsScreen) {
        findNavController().navigate(
            R.id.action_detail_destination_self,
            bundleOf(HomeScreenFragment.DETAIL_ID_ARG to action.movieId)
        )
    }

    private fun submitListAdapters(action: MoreDetailAction.FetchAllMovies) {
        topRatedAdapter.submitList(action.topRatedMovies)
    }

    private fun showSuccessSnackBar(
        message: String
    ) {
        Snackbar.make(
            binding.root,
            message,
            Snackbar.LENGTH_SHORT
        ).show()
    }

}