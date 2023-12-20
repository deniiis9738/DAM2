package com.example.reservebites.ui.viewmodels

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.reservebites.R

class LoginViewModel: ViewModel() {
    fun getFontFamily(googleFontName: String): FontFamily {
        val provider = GoogleFont.Provider(
            providerAuthority = "com.google.android.gms.fonts",
            providerPackage = "com.google.android.gms",
            certificates = R.array.com_google_android_gms_fonts_certs
        )
        val fontName = GoogleFont(googleFontName)

        return FontFamily(
            Font(googleFont = fontName, fontProvider = provider)
        )
    }

    private var _username = MutableLiveData("")
    val username: LiveData<String> = _username

    fun onUsernameChanged(newUsername: String) {
        _username.value = newUsername
    }

    private var _password = MutableLiveData("")
    val password: LiveData<String> = _password

    fun onPasswordChanged(newPassword: String) {
        _password.value = newPassword
    }

    private var _passwordVisibility = MutableLiveData(false)
    val passwordVisibility: LiveData<Boolean> = _passwordVisibility

    fun togglePasswordVisibility() {
        _passwordVisibility.value = !_passwordVisibility.value!!
    }

    fun viewIcon(): ImageVector {
        return if (_passwordVisibility.value == true) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
    }
}