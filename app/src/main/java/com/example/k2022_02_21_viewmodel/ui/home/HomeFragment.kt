package com.example.k2022_02_21_viewmodel.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.k2022_02_21_viewmodel.R
import com.example.k2022_02_21_viewmodel.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    private lateinit var homeViewModel :HomeViewModel

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        homeViewModel = ViewModelProvider(requireActivity()).get(HomeViewModel::class.java)

        val editText: EditText = root.findViewById(R.id.text_home)
        homeViewModel.text.observe(viewLifecycleOwner) {
            editText.setText(it)
        }
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homeViewModel = ViewModelProvider(requireActivity()).get(HomeViewModel::class.java)

        var changeValue: Button = view.findViewById(R.id.home_button)
        changeValue.setOnClickListener {
            var editText: EditText = view.findViewById(R.id.text_home)
            editText.setText("Hello")
        }

        var changeScore: Button = view.findViewById(R.id.score_button)
        changeScore.setOnClickListener {
            homeViewModel.setScore(binding.scoreTextView.text.toString().toInt())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()

        var myText: EditText = binding.textHome.findViewById(R.id.text_home)
        homeViewModel.getText().setValue(myText?.getText().toString())

        _binding = null
    }
}