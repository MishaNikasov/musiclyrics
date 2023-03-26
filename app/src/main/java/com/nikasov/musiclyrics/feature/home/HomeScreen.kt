package com.nikasov.musiclyrics.feature.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.nikasov.musiclyrics.widget.EditField
import kotlinx.coroutines.delay

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel()
) {

    var searchText by remember { mutableStateOf("") }
    val list = viewModel.list.collectAsState()

    Column {
        EditField(label = "Search") { searchText = it}
        LazyColumn(content = {
            items(list.value.size) {
                val track = list.value[it]
                Column(modifier = Modifier.padding(8.dp)) {
                    Text(text = track.name, fontSize = 21.sp, color = Color.Black)
                    Text(text = track.artistName, fontSize = 14.sp)
                }
            }
        })
    }

    LaunchedEffect(key1 = searchText, block = {
        delay(500)
        viewModel.getCharts(searchText)
    })
}