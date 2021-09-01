package com.example.cleanarchitecture.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.cleanarchitecture.R
import com.example.cleanarchitecture.databinding.ActivityMainBinding
import com.example.cleanarchitecture.utils.Event
import com.example.cleanarchitecture.utils.toast
import com.example.cleanarchitecture.viewmodel.CharacterViewModel
import com.example.cleanarchitecture.viewmodel.Data
import com.example.cleanarchitecture.viewmodel.Status
import com.example.domain.entity.CharacterDataWrapperEntity
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModel<CharacterViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.liveDataState.observe(this, { updateUI(it) })

        binding.buttonMainActivityIdFetch.setOnClickListener { viewModel.onFetchCharactersClicked() }
    }

    private fun updateUI(characterData: Event<Data<CharacterDataWrapperEntity>>?) {
        when (characterData?.peekContent()?.responseType) {
            Status.SUCCESSFUL -> {
                binding.progressBarMainActivityDataLoad.visibility = View.GONE
                toast(getString(R.string.toast_main_activity_characters, characterData.peekContent().data?.data?.total))
            }
            Status.ERROR -> {
                binding.progressBarMainActivityDataLoad.visibility = View.GONE
                toast(characterData.peekContent().error.toString())
            }
            Status.LOADING -> {
                binding.progressBarMainActivityDataLoad.visibility = View.VISIBLE
            }
        }
    }
}
