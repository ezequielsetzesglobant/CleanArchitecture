package com.example.cleanarchitecture.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cleanarchitecture.adapter.CharacterAdapter
import com.example.cleanarchitecture.databinding.ActivityMainBinding
import com.example.cleanarchitecture.fragment.CharacterInformationFragment
import com.example.cleanarchitecture.utils.Event
import com.example.cleanarchitecture.utils.toast
import com.example.cleanarchitecture.viewmodel.CharacterViewModel
import com.example.cleanarchitecture.viewmodel.Data
import com.example.cleanarchitecture.viewmodel.Status
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(), CharacterAdapter.OnCharacterListener {

    private lateinit var adapter: CharacterAdapter
    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModel<CharacterViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.getLiveDataState().observe(this, updateUIObserver)

        viewModel.fetchCharacters()

        initializeRecyclerView()

        binding.floatingActionButtonMainActivityRefresh.setOnClickListener{ viewModel.fetchCharacters() }
    }

    private fun initializeRecyclerView() {
        binding.recyclerViewCharactersRecyclerActivityList.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        adapter = CharacterAdapter(emptyList(), this)
        binding.recyclerViewCharactersRecyclerActivityList.adapter = adapter
    }

    private val updateUIObserver = Observer<Event<Data>> { event ->
        val eventContent = event.getContentIfNotHandled()
        when (eventContent?.responseType) {
            Status.SUCCESSFUL -> {
                binding.progressBarMainActivityDataLoad.visibility = View.GONE
                eventContent.data.data.results.let {
                    adapter.setCharacters(it)
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

    override fun onCharacterClick(position: Int) {
        CharacterInformationFragment.newInstance(adapter.getCharacter(position)).show(supportFragmentManager, TAG)
    }

    companion object {
        private const val TAG: String = "CHARACTER_INFORMATION_FRAGMENT"
    }
}
