package com.example.identifyimage.ui

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import com.example.identifyimage.data.SCORE_INCREASE
import com.example.identifyimage.data.images
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class IdentifyImageScreenVM(application: Application) : AndroidViewModel(application) {

    private val _uiState = MutableStateFlow(UiState())
    val uiState = _uiState.asStateFlow()

    var userGuess by mutableStateOf("")
        private set

    init {
        resetGame()
    }

    private fun resetGame() {
        _uiState.value = UiState()
    }

    fun updateUserGuess(guess: String) {
        userGuess = guess
    }

    fun skipCurrentImage() {
        if (_uiState.value.imageCount + 1 != images.size) {
            val updatedImageCount = _uiState.value.imageCount + 1
            _uiState.update {
                it.copy(
                    imageCount = updatedImageCount,
                    image = images[updatedImageCount].imageResourceId,
                    imageName = images[updatedImageCount].imageIdentification,
                    guess = ""
                )
            }
        } else {
            resetGame()
        }
    }

    fun submitAnswer() {
        if (_uiState.value.imageCount + 1 != images.size) {
            val correctGuess = _uiState.value.imageName
            val correctGuessString =
                getApplication<Application>().applicationContext.getString(correctGuess)
            if (userGuess.trim().equals(correctGuessString, ignoreCase = true)) {
                val updatedScore = _uiState.value.score + SCORE_INCREASE
                val updatedImageCount = _uiState.value.imageCount + 1
                _uiState.update {
                    it.copy(
                        imageCount = updatedImageCount,
                        score = updatedScore,
                        image = images[updatedImageCount].imageResourceId,
                        imageName = images[updatedImageCount].imageIdentification,
                        guess = ""
                    )
                }
            }

        } else {
            resetGame()
        }
    }
}