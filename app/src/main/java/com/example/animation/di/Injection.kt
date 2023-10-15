package com.example.animation.di

import android.content.Context
import com.example.animation.data.UserRepository
import com.example.animation.data.pref.UserPreference
import com.example.animation.data.pref.dataStore

object Injection {
    fun provideRepository(context: Context): UserRepository {
        val pref = UserPreference.getInstance(context.dataStore)
        return UserRepository.getInstance(pref)
    }
}