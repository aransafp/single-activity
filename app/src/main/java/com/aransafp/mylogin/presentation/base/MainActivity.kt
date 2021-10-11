package com.aransafp.mylogin.presentation.base

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.aransafp.mylogin.R
import com.aransafp.mylogin.data.UserRepository
import com.aransafp.mylogin.data.sharedpreference.SessionManager
import com.aransafp.mylogin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val mainNavController: NavController? by lazy { findNavController(R.id.nav_host_fragment_main) }
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sesi = SessionManager(this)
        val userRepository = UserRepository(sesi)

        if (userRepository.isUserLogin()) {
            try {
                Log.d("Login", "onViewCreated: Berhasil")
                moveToHome()
            } catch (e: Exception) {
                Log.d("Login", "onViewCreated: $e")
            }
        }

    }

    // Move to home screen
    private fun moveToHome() {
        val direction = R.id.action_containerAuthFragment_to_containerMenuFragment
        mainNavController?.navigate(direction)
    }

}