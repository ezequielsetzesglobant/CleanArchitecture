package com.example.cleanarchitecture.fragment

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.cleanarchitecture.R
import com.example.cleanarchitecture.adapter.ComicAdapter
import com.example.cleanarchitecture.databinding.FragmentCharacterInformationBinding
import com.example.cleanarchitecture.utils.Event
import com.example.cleanarchitecture.viewmodel.CharacterInformationViewModel
import com.example.cleanarchitecture.viewmodel.Data
import com.example.cleanarchitecture.viewmodel.FragmentData
import com.example.cleanarchitecture.viewmodel.FragmentStatus
import com.example.domain.entity.CharacterData
import java.io.Serializable
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharacterInformationFragment : DialogFragment() {

    private lateinit var adapter: ComicAdapter
    private lateinit var binding: FragmentCharacterInformationBinding
    private val viewModel by viewModel<CharacterInformationViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentCharacterInformationBinding.inflate(inflater, container, false)
        viewModel.getLiveDataState().observe(this, updateUIObserver)
        initializeRecyclerView()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            viewModel.showCharacterInformation(it.getSerializable(CHARACTER_DATA_KEY) as CharacterData)
        }
    }

    private val updateUIObserver = Observer<Event<FragmentData>> { event ->
        with(binding) {
            buttonFragmentClose.setOnClickListener { dismiss() }
            val eventContent = event.getContentIfNotHandled()
            when (eventContent?.responseType) {
                FragmentStatus.INITIALIZATION -> {
                    eventContent.data.let {
                        setDataUI(it)
                        textViewFragmentDescription.text =
                            context?.getString(R.string.text_view_description_message_fragment, it.description)
                        textViewFragmentDescription.movementMethod = ScrollingMovementMethod()

                    }
                }
                FragmentStatus.INITIALIZATION_EMPTY_DESCRIPTION -> {
                    eventContent.data.let {
                        setDataUI(it)
                        textViewFragmentDescription.text = context?.getString(R.string.text_view_default_description_message_fragment)
                    }
                }
            }
        }
    }

    private fun setDataUI(characterData: CharacterData) {
        with(binding) {
            textViewFragmentTitle.text = context?.getString(R.string.text_view_title_message_fragment, characterData.name)
            Glide.with(root)
                .load("${characterData.thumbnail.path}.${characterData.thumbnail.extension}")
                .into(imageViewFragmentIcon)
            adapter.setComics(characterData.comics.items)
        }
    }

    private fun initializeRecyclerView() {
        binding.recyclerViewFragmentComics.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        adapter = ComicAdapter(emptyList())
        binding.recyclerViewFragmentComics.adapter = adapter
    }

    companion object {
        private const val CHARACTER_DATA_KEY = "CHARACTER_DATA_KEY"

        fun newInstance(characterData: CharacterData) =
            CharacterInformationFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(CHARACTER_DATA_KEY, characterData as? Serializable)
                }
            }
    }
}
