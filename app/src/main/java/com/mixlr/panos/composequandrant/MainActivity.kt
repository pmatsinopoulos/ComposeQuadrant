package com.mixlr.panos.composequandrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mixlr.panos.composequandrant.ui.theme.ComposeQuandrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeQuandrantTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Quadrant()
                }
            }
        }
    }
}

@Composable
fun Quadrant(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .weight(1F)
        ) {
            ComposableInfo(
                infoTitle = stringResource(R.string.info_title_text),
                infoParagraph = stringResource(R.string.info_paragraph_text),
                backgroundColor = colorResource(R.color.top_left),
                modifier = Modifier.weight(1F)
            )
            ComposableInfo(
                infoTitle = stringResource(R.string.info_title_image),
                infoParagraph = stringResource(R.string.info_paragraph_image),
                backgroundColor = colorResource(R.color.top_right),
                modifier = Modifier.weight(1F)
            )
        }
        Row(
            modifier = Modifier
                .weight(1F)
        ) {
            ComposableInfo(
                infoTitle = stringResource(R.string.info_title_row),
                infoParagraph = stringResource(R.string.info_paragraph_row),
                backgroundColor = colorResource(R.color.bottom_left),
                modifier = Modifier.weight(1F)
            )
            ComposableInfo(
                infoTitle = stringResource(R.string.info_title_column),
                infoParagraph = stringResource(R.string.info_paragraph_column),
                backgroundColor = colorResource(R.color.bottom_right),
                modifier = Modifier.weight(1F)
            )
        }
    }
}

@Composable
fun ComposableInfo(
    infoTitle: String,
    infoParagraph: String,
    backgroundColor: Color,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = backgroundColor)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp),
            text = infoTitle
        )
        Text(
            text = infoParagraph,
            textAlign = TextAlign.Justify
        )
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun QuadrantPreview() {
    ComposeQuandrantTheme {
        Quadrant()
    }
}
