package com.example.hw_together.ui.authorizationscreens.authorizationregisterscreen

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.hw_together.domain.usecases.RegisterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.annotation.OrbitExperimental

import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

private const val TOKEN_KEY = "token_key"
private const val PREFS_KEY = "prefs_key"

@HiltViewModel
class AuthorizationRegisterScreenViewModel @Inject constructor(
    private val registerUseCase: RegisterUseCase
) : ViewModel(), ContainerHost<AuthorizationRegisterState, Nothing> {

    override val container = container<AuthorizationRegisterState, Nothing>(
        AuthorizationRegisterState()
    )

    fun nameChange(name: String) = blockingIntent {
        reduce {
            state.copy(authorizationRegisterUser = state.authorizationRegisterUser.copy(name = name))
        }
    }

    fun surnameChange(surname: String) = blockingIntent {
        reduce {
            state.copy(authorizationRegisterUser = state.authorizationRegisterUser.copy(surname = surname))
        }
    }

    fun phoneChange(phone: String) = blockingIntent {
        reduce {
            state.copy(authorizationRegisterUser = state.authorizationRegisterUser.copy(phone = phone))
        }
    }

    fun passwordChange(password: String) = blockingIntent {
        reduce {
            state.copy(
                authorizationRegisterUser = state.authorizationRegisterUser.copy(
                    passwordHashed = password
                )
            )
        }
    }

    fun register(context: Context) = intent {
        reduce {
            state.copy(isLoading = true)
        }
        val token =
            registerUseCase.invoke(authorizationRegisterUser = state.authorizationRegisterUser)
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

            (token.code() == 409) -> {
                Log.e("e", token.message() + "409")
            }

            else -> {
                Log.e("e", token.code().toString())
            }
        }
    }
}