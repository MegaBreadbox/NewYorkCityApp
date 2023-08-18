package com.example.newyorkcity

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.example.newyorkcity.model.LocationModel

@Composable
fun CompactMenuScreen(
    boroughs: List<LocationModel>,
    modifier: Modifier = Modifier
) {
    BoroughList(
        boroughs = boroughs
    )
}

@Composable
fun BoroughList(
    boroughs: List<LocationModel>,
    modifier: Modifier = Modifier
){
    LazyColumn {
        items(boroughs) {
            BoroughLayout(location = it)
        }
    }
}

@Composable
fun BoroughLayout(
    location: LocationModel,
    modifier: Modifier = Modifier
) {
    Card(
        elevation = CardDefaults.cardElevation(dimensionResource(R.dimen.small_padding)),
        modifier = modifier.padding(dimensionResource(R.dimen.medium_padding))
    ){
        Column(
        ) {
            Image(
                painter = painterResource(location.locationImage),
                contentDescription = null,
                //modifier.weight(1F)
            )
            //Spacer(modifier.weight(1F))
            Text(
                text = stringResource(location.locationName),
                style = MaterialTheme.typography.headlineSmall,
                textAlign = TextAlign.Center,
                modifier = modifier.padding(start = dimensionResource(R.dimen.medium_padding),
                    top = dimensionResource(R.dimen.small_padding),
                    bottom = dimensionResource(R.dimen.small_padding)
                )
            )
        }
    }
}