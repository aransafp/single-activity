package com.aransafp.mylogin.presentation.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.aransafp.mylogin.R
import com.aransafp.mylogin.databinding.FragmentContainerMenuBinding

class ContainerMenuFragment : Fragment() {

    private var _binding: FragmentContainerMenuBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentContainerMenuBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val nav =
            childFragmentManager.findFragmentById(R.id.nav_host_fragment_menu) as NavHostFragment
        NavigationUI.setupWithNavController(binding.bnMenu, nav.navController)
        nav.navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.homeFragment, R.id.prefFragment, R.id.settingsFragment -> {

                }
            }
        }
    }

}