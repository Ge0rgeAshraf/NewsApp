package com.ge0rge.newsviewapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ge0rge.newsviewapp.ui.theme.NewsViewAppTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsViewAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val newsViewModel = NewsViewModel()
                    ViewApp(viewModel = newsViewModel)
                }
            }
        }
    }
}







@Composable
fun ViewApp(viewModel: NewsViewModel)
{
    Column(modifier = Modifier.fillMaxSize()) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .weight(0.1f)) {
            Button(onClick = { CoroutineScope(Dispatchers.IO).launch { viewModel.fetchNewsArticles() } }, modifier = Modifier.weight(0.5f)) {
                Text(text = "Reload")
            }
            Button(onClick = { /*TODO*/ }, modifier = Modifier.weight(0.5f)) {
                Text(text = "Cancel")

            }
        }
        LazyColumn(modifier = Modifier
            .fillMaxWidth()
            .weight(0.9f))
        {
            items(items = viewModel.newsResponse.articles)
            {

                NewsUI(article = it)
            }
        }
    }
}

@Composable
fun NewsUI(article: Article)
{

    Column(modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight()) {
        Text(text = "this is a new")
        Text(text = article.author)
        Text(text = article.publishedAt)
        Text(text = article.title)
        Text(text = article.content.toString())

    }
}

