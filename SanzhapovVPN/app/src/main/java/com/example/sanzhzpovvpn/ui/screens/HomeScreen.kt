package com.example.sanzhzpovvpn.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.sanzhzpovvpn.R
import androidx.compose.ui.unit.size
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import org.w3c.dom.Text
import androidx.compose.material3.Text


@Composable
fun HomeScreen(
    vpnUiState: VPNUiState,
    modifier: Modifier,
    retryAction: () -> Unit,
) {
    when (vpnUiState) {
        is VPNUiState.Success -> SuccessScreen(modifier = modifier)
        is VPNUiState.Loading -> LoadingScreen(modifier = modifier)
        is VPNUiState.Error -> ErrorScreen(
            retryAction = retryAction,
            modifier = modifier,
        )
    }
}

@Composable
fun SuccessScreen(
//    stopAction: () -> Unit,
    modifier: Modifier
) {
    Image(
        modifier = modifier,
        painter = painterResource(R.drawable.glow_circle),
        contentDescription = stringResource(R.string.placeholder_result),
    )
}

@Composable
fun LoadingScreen(
    modifier: Modifier
) {
    Image(
        modifier = modifier,
        painter = painterResource(R.drawable.loading_img),
        contentDescription = stringResource(R.string.loading),
    )
}

@Composable
fun ErrorScreen(
    retryAction: () -> Unit,
    modifier: Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            modifier = modifier,
            painter = painterResource(R.drawable.ic_broken_image),
            contentDescription = stringResource(R.string.loading_failed),
        )
        Text(text = stringResource(R.string.loading_failed), modifier = modifier)
        Button(onClick = retryAction) {
            Text(stringResource(R.string.retry))
        }
    }
}