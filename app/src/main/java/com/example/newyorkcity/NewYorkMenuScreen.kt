package com.example.newyorkcity

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
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
import androidx.compose.ui.unit.dp
import com.example.newyorkcity.model.LocationModel

@Composable
fun CompactMenuScreen(
    boroughs: List<LocationModel>,
    onClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    BoroughList(
        boroughs = boroughs,
        onClick = onClick

    )
}

@Composable
fun BoroughList(
    boroughs: List<LocationModel>,
    onClick: (String) -> Unit,
    modifier: Modifier = Modifier
){
    LazyColumn {
        items(boroughs) {  borough ->
            BoroughLayout(location = borough, onClick = onClick)
        }
    }
}

@Composable
fun BoroughLayout(
    location: LocationModel,
    onClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        elevation = CardDefaults.cardElevation(dimensionResource(R.dimen.small_padding)),
        modifier = modifier.padding(dimensionResource(R.dimen.medium_padding))
            .clickable { onClick(location.navigation) }
    ){
        Column(
        ) {
            Image(
                painter = painterResource(location.locationImage),
                contentDescription = null,
                modifier.fillMaxHeight()
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