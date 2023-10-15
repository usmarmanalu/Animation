package com.example.animation.view.signup

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import android.view.WindowManager
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.animation.databinding.ActivitySignUpBinding

class SignupActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupView()
        setupAction()
        playAnimation()
    }

    private fun setupView() {
        @Suppress("DEPRECATION")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }
        supportActionBar?.hide()
    }

    private fun setupAction() {
        binding.signupButton.setOnClickListener {
            val email = binding.emailEditText.text.toString()

            AlertDialog.Builder(this).apply {
                setTitle("Yeah!")
                setMessage("Akun dengan $email sudah jadi nih. Yuk, login dan belajar coding.")
                setPositiveButton("Lanjut") { _, _ ->
                    finish()
                }
                create()
                show()
            }
        }
    }
    //  Animation
    @SuppressLint("Recycle")
    private fun playAnimation() {
        ObjectAnimator.ofFloat(binding.imageView, View.TRANSLATION_X, -30F, 30F).apply {
            duration = 6000
            repeatCount = ObjectAnimator.INFINITE
            repeatMode = ObjectAnimator.REVERSE
        }.start()

        val title = ObjectAnimator.ofFloat(binding.titleTextView, View.ALPHA, 1f).setDuration(500)

        val name = ObjectAnimator.ofFloat(binding.nameTextView, View.ALPHA, 1f).setDuration(500)
        val nameEdit = ObjectAnimator.ofFloat(binding.nameEditText, View.ALPHA, 1f).setDuration(500)
        val nameLyt = ObjectAnimator.ofFloat(binding.nameEditTextLayout, View.ALPHA, 1f).setDuration(500)


        val email = ObjectAnimator.ofFloat(binding.emailTextView, View.ALPHA, 1f).setDuration(500)
        val emailEdit = ObjectAnimator.ofFloat(binding.emailEditText, View.ALPHA, 1f).setDuration(500)
        val emailLyt = ObjectAnimator.ofFloat(binding.emailEditTextLayout, View.ALPHA, 1f).setDuration(500)


        val password = ObjectAnimator.ofFloat(binding.passwordTextView, View.ALPHA, 1f).setDuration(500)
        val passwordEdit = ObjectAnimator.ofFloat(binding.passwordEditText, View.ALPHA, 1f).setDuration(500)
        val passwordLyt = ObjectAnimator.ofFloat(binding.passwordEditTextLayout, View.ALPHA, 1f).setDuration(500)


        val signup = ObjectAnimator.ofFloat(binding.signupButton, View.ALPHA, 1f).setDuration(500)

        AnimatorSet().apply {
            playSequentially(title, name, nameEdit,nameLyt,
                email, emailEdit, emailLyt,
                password, passwordEdit, passwordLyt,
                signup)
            start()
        }
    }
}