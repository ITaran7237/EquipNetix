package com.equipnetix.screen.main.presentation.ui

import android.view.View
import com.equipnetix.base.BaseActivity
import com.equipnetix.databinding.ActivityMainBinding
import com.equipnetix.util.ResultState
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    @Inject
    lateinit var viewModel: MainViewModelContract

    override fun getViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun initViews() {
        binding.btnGetData.setOnClickListener {
            viewModel.fetchData()
        }
    }

    override fun observeViewModel() {
        viewModel.resultState.observe(this) { resultState ->
            if (resultState != ResultState.Loading) binding.progressBar.visibility = View.GONE
            when (resultState) {
                is ResultState.Success -> {
                    binding.twDataText.text = resultState.data.punchline
                }

                is ResultState.Error -> {
                    binding.twDataText.text = resultState.errorMessage
                }

                ResultState.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
            }
        }
    }
}