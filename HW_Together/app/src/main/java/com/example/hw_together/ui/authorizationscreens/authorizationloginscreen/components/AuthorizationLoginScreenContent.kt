package com.example.hw_together.ui.authorizationscreens.authorizationloginscreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.hw_together.R
import com.example.hw_together.ui.authorizationscreens.authorizationloginscreen.AuthorizationLoginScreenViewModel
import com.example.hw_together.ui.authorizationscreens.components.CustomBasicTextFieldAuthorization
import com.example.hw_together.ui.authorizationscreens.components.CustomBasicTextFieldPassword
import com.example.hw_together.ui.components.CustomButton
import com.example.hw_together.ui.theme.HW_TogetherTheme
import com.example.hw_together.ui.theme.LocalColors
import com.example.hw_together.ui.theme.LocalTypography
import org.orbitmvi.orbit.compose.collectAsState

@Composable
fun AuthorizationLoginScreenContent(
    onClickRegister: () -> Unit,
) {
    val context = LocalContext.current
    val viewModel: AuthorizationLoginScreenViewModel = hiltViewModel()
    val state = viewModel.collectAsState().value
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = LocalColors.current.yellow)
            .safeDrawingPadding()
    ) {
        Image(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 70.dp),
            painter = painterResource(id = R.drawable.image_logo),
            contentDescription = ""
        )

        Column(
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(horizontal = 16.dp)
        ) {
            Text(text = "Вход", style = LocalTypography.current.headerAuthorization)
            Text(
                modifier = Modifier.padding(top = 6.dp),
                text = "Пожалуйста, войдите для продолжения",
                style = LocalTypography.current.subHeaderAuthorization
            )
            CustomBasicTextFieldAuthorization(
                value = state.authorizationLoginUser.phone,
                defaultValue = "Номер телефона",
                onValueChange = remember { { viewModel.phoneChange(it) } }
            )
            CustomBasicTextFieldPassword(
                value = state.authorizationLoginUser.passwordHashed,
                defaultValue = "Пароль",
                onValueChange = remember { { viewModel.passwordChange(it) } }
            )
        }
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(horizontal = 16.dp),
        ) {
            CustomButton(
                modifier = Modifier
                    .padding(bottom = 12.dp)
                    .background(
                        shape = RoundedCornerShape(8.dp),
                        color = LocalColors.current.lightBlack
                    ),
                onClick = { viewModel.login(context = context) },
                text = "Войти",
                textColor = Color.White,
                isLoading = state.isLoading
            )
            CustomButton(
                modifier = Modifier
                    .padding(bottom = 16.dp)
                    .background(
                        shape = RoundedCornerShape(8.dp),
                        color = LocalColors.current.yellow
                    ),
                onClick = onClickRegister,
                text = "Регистрация",
                textColor = Color.Black
            )

        }
    }
}

@Preview
@Composable
fun AuthorizationLoginScreenPreview() {
    HW_TogetherTheme {
        AuthorizationLoginScreenContent(onClickRegister = {})
    }
}