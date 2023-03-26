package com.nikasov.musiclyrics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.nikasov.data.repository.MusixmatchRepository
import com.nikasov.musiclyrics.navigation.RootNavigationGraph
import com.nikasov.theme.MusiclyricsTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var musixmatchRepository: MusixmatchRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MusiclyricsTheme {
                val navController = rememberNavController()
                RootNavigationGraph(navController)
            }
        }
    }
}