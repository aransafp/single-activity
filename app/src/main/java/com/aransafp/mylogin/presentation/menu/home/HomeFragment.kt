package com.aransafp.mylogin.presentation.menu.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.aransafp.mylogin.data.UserRepository
import com.aransafp.mylogin.data.sharedpreference.SessionManager
import com.aransafp.mylogin.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sesi = SessionManager(requireContext())
        val userRepository = UserRepository.getInstance(sesi)

        binding.tvUsername.text = userRepository.getUser()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}