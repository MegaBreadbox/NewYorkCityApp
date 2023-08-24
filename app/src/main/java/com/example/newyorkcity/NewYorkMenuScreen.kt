package com.example.newyorkcity

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
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
    viewModel: NewYorkViewModel,
    modifier: Modifier = Modifier
) {
    BoroughList(
        boroughs = boroughs,
        onClick = onClick,
        viewModel = viewModel
    )
}
@Composable
fun MediumMenuScreen(
    boroughs: List<LocationModel>,
    image: Int,
    textBody: Int,
    onClick: (String) -> Unit,
    viewModel: NewYorkViewModel,

    modifier: Modifier = Modifier
) {
    Row {
        BoroughList(
            boroughs = boroughs,
            onClick = onClick,
            viewModel = viewModel,
            modifier = modifier.weight(1F)
        )
        Spacer(modifier.padding(dimensionResource(R.dimen.medium_padding)))
        DetailScreen(
            image = image,
            textBody = stringResource(textBody),
            modifier = modifier.weight(3F)
        )
    }
}

@Composable
fun BoroughList(
    boroughs: List<LocationModel>,
    onClick: (String) -> Unit,
    viewModel: NewYorkViewModel,
    modifier: Modifier = Modifier
){
    LazyColumn(modifier = modifier.testTag("List")) {
        items(boroughs) {  borough ->
            BoroughLayout(location = borough, onClick = onClick, viewModel = viewModel)

        }
    }
}

@Composable
fun BoroughLayout(
    location: LocationModel,
    onClick: (String) -> Unit,
    viewModel: NewYorkViewModel,
    modifier: Modifier = Modifier
) {
    Card(
        elevation = CardDefaults.cardElevation(dimensionResource(R.dimen.small_padding)),
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.secondaryContainer),
        modifier = modifier
            .padding(dimensionResource(R.dimen.medium_padding))
            .clickable {
                onClick(location.navigation)
                viewModel.currentlySelected(location)
            }

    ){
        Column(
        ) {
            Image(
                painter = painterResource(location.locationImage),
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
                modifier = modifier.heightIn(min = 100.dp, max = 500.dp)
            )
            //Spacer(modifier.weight(1F))
            Text(
                text = stringResource(location.locationName),
                color = MaterialTheme.colorScheme.onSecondaryContainer,
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