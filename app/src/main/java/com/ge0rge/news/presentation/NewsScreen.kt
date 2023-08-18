package com.ge0rge.news.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import java.util.Date
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ge0rge.news.model.NewsItemDomain
import java.time.format.TextStyle

@Composable
fun ViewNewsScreen(viewModel : NewsViewModel = hiltViewModel())
{
    val news = viewModel.newsList
    Card(modifier = Modifier.fillMaxSize())
    {
        LazyColumn(modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(8.dp))
        {
            items(news)
            {
                NewView(it)
            }
        }
    }

}



@Composable
fun NewView(new : NewsItemDomain)
{
    Card(modifier = Modifier
        .wrapContentHeight()
        .fillMaxWidth()) {
        
        
        Row(modifier = Modifier.wrapContentSize()) {
            Text(text = new.url, modifier = Modifier.weight(0.2f))
            Column(modifier = Modifier.weight(0.6f)) {
                
                Text(text = new.title, fontSize = 25.sp, fontWeight = FontWeight.Bold)
                Text(text = new.date.toString(), fontWeight = FontWeight.Thin, fontSize = 10.sp)
                Text(text = new.description,fontWeight = FontWeight.SemiBold, fontSize = 10.sp)
            }
            Button(onClick = {new.isFavorete = !new.isFavorete}) {
                if (new.isFavorete)
                {
                    Text(text = "Favorete", color = Color.Yellow)
                }
                else
                {
                    Text(text = "Favorete")
                }
            }

        }
        
        
    }
}
