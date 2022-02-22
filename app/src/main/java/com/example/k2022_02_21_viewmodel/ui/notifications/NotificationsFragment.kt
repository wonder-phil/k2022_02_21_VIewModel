package com.example.k2022_02_21_viewmodel.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.k2022_02_21_viewmodel.databinding.FragmentNotificationsBinding
import com.example.k2022_02_21_viewmodel.ui.home.HomeViewModel

class NotificationsFragment : Fragment() {

    private var _binding: FragmentNotificationsBinding? = null

    private lateinit var homeViewModel: HomeViewModel

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val notificationsViewModel =
            ViewModelProvider(this).get(NotificationsViewModel::class.java)

        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        homeViewModel = ViewModelProvider(requireActivity()).get(HomeViewModel::class.java)

        val textView: TextView = binding.textNotifications
        notificationsViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        val updateTextView: EditText = binding.updateEditView as EditText

        homeViewModel.getText().observe(viewLifecycleOwner) {
            updateTextView.setText(it)
        }
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeViewModel = ViewModelProvider(requireActivity()).get(HomeViewModel::class.java)
        val updateTextView: EditText = binding.updateEditView as EditText

        binding.updateButton.setOnClickListener {
            homeViewModel.changeText(updateTextView.text.toString())
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}