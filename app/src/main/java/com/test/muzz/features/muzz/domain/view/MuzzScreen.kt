package com.test.muzz.features.muzz.domain.view

import ImageMuzzItem
import SliderMuzzItem
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.test.muzz.R
import com.test.muzz.features.muzz.domain.model.MuzzModel
import com.test.muzz.features.muzz.domain.repository.MuzzResult
import com.test.muzz.features.muzz.domain.viewmodel.MuzzViewModel

@Composable
fun MuzzScreen(viewModel: MuzzViewModel = hiltViewModel()) {
    val muzzResult by viewModel.muzzState.collectAsState()

    when (muzzResult) {
        is MuzzResult.Loading -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }

        is MuzzResult.Error -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(text = stringResource(R.string.muzz_failed_to_load_message))
            }
        }

        is MuzzResult.Muzz -> {
            val muzzList = (muzzResult as MuzzResult.Muzz).muzz
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(muzzList) { muzzModel ->
                    when (muzzModel) {
                        is MuzzModel.Image -> ImageMuzzItem(muzzModel)
                        is MuzzModel.Slider -> SliderMuzzItem(muzzModel)
                        is MuzzModel.Empty -> {}
                    }
                }
            }
        }
    }
}
