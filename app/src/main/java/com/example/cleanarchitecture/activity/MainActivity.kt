package com.example.cleanarchitecture.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cleanarchitecture.adapter.CharacterAdapter
import com.example.cleanarchitecture.databinding.ActivityMainBinding
import com.example.cleanarchitecture.utils.Event
import com.example.cleanarchitecture.utils.toast
import com.example.cleanarchitecture.viewmodel.CharacterViewModel
import com.example.cleanarchitecture.viewmodel.Data
import com.example.cleanarchitecture.viewmodel.Status
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModel<CharacterViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.liveDataState.observe(this, { updateUI(it) })

        viewModel.fetchCharacters()
    }

    private fun updateUI(characterData: Event<Data>) {
        val eventContent = characterData.getContentIfNotHandled()
        when (eventContent?.responseType) {
            Status.SUCCESSFUL -> {
                binding.progressBarMainActivityDataLoad.visibility = View.GONE
                binding.recyclerViewCharactersRecyclerActivityList.layoutManager =
                    LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
                binding.recyclerViewCharactersRecyclerActivityList.adapter = eventContent.data.data.results.let {
                    CharacterAdapter(
                        it
                    )
                }
            }
            Status.ERROR -> {
                binding.progressBarMainActivityDataLoad.visibility = View.GONE
                toast(eventContent.error)
            }
            Status.LOADING -> {
                binding.progressBarMainActivityDataLoad.visibility = View.VISIBLE
            }
            Status.EMPTY_LIST -> {
                binding.progressBarMainActivityDataLoad.visibility = View.GONE
                toast(eventContent.error)
            }
        }
    }
}
