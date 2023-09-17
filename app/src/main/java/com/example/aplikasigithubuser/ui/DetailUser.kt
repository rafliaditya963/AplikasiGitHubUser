package com.example.aplikasigithubuser.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.StringRes
import com.example.aplikasigithubuser.R
import com.example.aplikasigithubuser.databinding.ActivityDetailUserBinding
import com.google.android.material.tabs.TabLayoutMediator

class DetailUser : AppCompatActivity() {

    private lateinit var binding: ActivityDetailUserBinding

    companion object {
        @StringRes
        private val TAB_TITLES = intArrayOf(
            R.string.tab_text_1,
            R.string.tab_text_2
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_user)

        binding = ActivityDetailUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sectionsPagerAdapter = SectionsPagerAdapter(this)
        val viewPager = binding.viewPager
        viewPager.adapter = sectionsPagerAdapter
        val tabs = binding.tabs
        TabLayoutMediator(tabs, viewPager) { tab, position ->
            tab.text = resources.getString(TAB_TITLES[position])
        }.attach()

    }
}