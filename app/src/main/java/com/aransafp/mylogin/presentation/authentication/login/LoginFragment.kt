package com.aransafp.mylogin.presentation.authentication.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.aransafp.mylogin.R
import com.aransafp.mylogin.data.UserRepository
import com.aransafp.mylogin.data.sharedpreference.SessionManager
import com.aransafp.mylogin.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {

    private val mainNavController: NavController? by lazy { activity?.findNavController(R.id.nav_host_fragment_main) }

    private lateinit var userRepository: UserRepository

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sesi = SessionManager(requireContext())
        userRepository = UserRepository.getInstance(sesi)

        binding.btnLogin.setOnClickListener {
            saveUser()
        }
    }

    // Save user to preference
    private fun saveUser() {
        val username = binding.edtUsername.text.toString()
        userRepository.loginUser(username)
        moveToHome()
    }

    // Move to home screen
    private fun moveToHome() {
        val direction = R.id.action_containerAuthFragment_to_containerMenuFragment
        mainNavController?.navigate(direction)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}