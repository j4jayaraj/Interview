package com.example.a20241116_jayarajr_nycschools

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import com.example.a20241116_jayarajr_nycschools.viewModel.SchoolsViewModel


class MainActivity : ComponentActivity() {
    private lateinit var viewModel: SchoolsViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[SchoolsViewModel::class.java]
        setContent {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainComposeContent()
                }
            }
    }


    @Composable
    fun MainComposeContent(modifier: Modifier = Modifier) {
        val schoolDataList = viewModel.schoolsMutableState
        LazyColumn(modifier = modifier) {
            itemsIndexed(schoolDataList) { _, item ->
                SchoolListItem(item)
            }
        }
    }

    @Composable
    fun SchoolListItem(schoolListItem: SchoolListResponseItem) {
        Text(text = schoolListItem.requirement1_2, modifier = Modifier.padding(horizontal = 10.dp, vertical = 10.dp))
    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
            MainComposeContent()
    }
}