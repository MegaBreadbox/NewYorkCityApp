package com.example.newyorkcity

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp

@Composable
fun DetailScreen(
    image: Int,
    textBody: String,
    modifier: Modifier = Modifier
){
    Column(
        modifier
            .verticalScroll(rememberScrollState())
            .fillMaxWidth()
    ){
        Image(
            painter = painterResource(image),
            contentDescription = null,
        )
        Spacer(modifier = modifier.padding(dimensionResource(R.dimen.medium_padding)))
        Text(
            text = textBody,
            lineHeight = 25.sp,
            style = MaterialTheme.typography.bodyLarge,
            modifier = modifier.padding(dimensionResource(R.dimen.medium_padding))
        )
    }
}