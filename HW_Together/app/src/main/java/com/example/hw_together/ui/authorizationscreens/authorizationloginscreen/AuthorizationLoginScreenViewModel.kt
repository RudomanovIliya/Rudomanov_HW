package com.example.hw_together.ui.authorizationscreens.authorizationloginscreen

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.hw_together.domain.usecases.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

private const val TOKEN_KEY = "token_key"
private const val PREFS_KEY = "prefs_key"

@HiltViewModel
class AuthorizationLoginScreenViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
) : ViewModel(), ContainerHost<AuthorizationLoginState, Nothing> {
    override val container = container<AuthorizationLoginState, Nothing>(
        AuthorizationLoginState()
    )

    fun phoneChange(phone: String) = intent {
        reduce {
            state.copy(authorizationLoginUser = state.authorizationLoginUser.copy(phone = phone))
        }
    }

    fun passwordChange(password: String) = intent {
        reduce {
            state.copy(
                authorizationLoginUser = state.authorizationLoginUser.copy(
                    passwordHashed = password
                )
            )
        }
    }

    fun login(context: Context) = intent {
        reduce {
            state.copy(isLoading = true)
        }
        val token =
            loginUseCase.invoke(authorizationLoginUser = state.authorizationLoginUser)
        reduce {
            state.copy(isLoading = false)
        }
        when {
            token.isSuccessful -> {
                reduce {
                    state.copy(isRegister = true)
                }
                val myPrefs: SharedPreferences =
                    context.getSharedPreferences(PREFS_KEY, Context.MODE_PRIVATE)
                val editor: SharedPreferences.Editor = myPrefs.edit()
                editor.putString(TOKEN_KEY, token.body()?.data?.token)
                editor.apply()
                Log.e("e", token.body()?.data?.token + "")
            }

            (token.code() == 401) -> {
                Log.e("e", token.message() + "401")
            }

            else -> {
                Log.e("e", token.code().toString())
            }
        }
    }

}
