package com.example.identifyimage.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.identifyimage.R
import com.example.identifyimage.ui.theme.IdentifyImageTheme

@Composable
fun IdentifyImageScreen(
    modifier: Modifier = Modifier,
    viewModel: IdentifyImageScreenVM = androidx.lifecycle.viewmodel.compose.viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    Column(modifier = modifier) {
        GameStatus(uiState.imageCount, uiState.score)
        GameLayout(
            uiState.image,
            viewModel.userGuess,
            onGuessChanged = { viewModel.updateUserGuess(it) }
        )
        GameNavigation(
            onSkipClicked = {
                viewModel.skipCurrentImage()
            },
            onSubmitClicked = {
                viewModel.submitAnswer()
            }
        )
    }
}

@Composable
fun GameStatus(imageCount: Int, score: Int, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Text(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            text = stringResource(R.string.image_count, imageCount),
            fontSize = 18.sp,
        )
        Text(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .wrapContentWidth(Alignment.End),
            text = stringResource(R.string.score, score)
        )
    }
}

@Composable
fun GameLayout(
    image: Int,
    guess: String,
    onGuessChanged: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(verticalArrangement = Arrangement.spacedBy(24.dp)) {
        Image(
            modifier = Modifier
                .size(80.dp)
                .align(Alignment.CenterHorizontally),
            painter = painterResource(id = image),
            contentDescription = null
        )
        Text(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            text = stringResource(id = R.string.identify_image)
        )
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = guess,
            onValueChange = onGuessChanged,
            label = {
                Text(text = "Enter a Noun")
            }
        )
    }
}

@Composable
fun GameNavigation(
    onSubmitClicked: () -> Unit,
    onSkipClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        OutlinedButton(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(end = 8.dp),
            onClick = onSkipClicked
        ) {
            Text(text = "skip")
        }
        Button(
            modifier = modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(start = 8.dp),
            onClick = onSubmitClicked
        ) {
            Text(text = "submit")
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun DefaultPreview() {
    IdentifyImageTheme {
        IdentifyImageScreen(modifier = Modifier.padding(16.dp))
    }
}
