package br.senai.sp.jandira.simpsonsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.simpsonsapp.ui.theme.SimpsonsAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpsonsAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting() {
    Image(
        painter = painterResource(id = R.drawable.background),
        contentDescription = "Background da aplicação android",
        contentScale = ContentScale.Crop
    )
    Surface(
        color = Color(0x88F0CC5E)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            OutlinedTextField(
                value = "",
                onValueChange = {},
                modifier = Modifier.fillMaxWidth(),
                placeholder = {
                    Text(text = "Buscar Personagem...", color = Color.Black)
                },
                shape = RoundedCornerShape(16.dp),
                trailingIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Botão buscar",
                            tint = Color(0xFFECB100)
                        )

                    }
                }
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "Personagens:",
                color = Color.Black,
                fontSize = 18.sp
            )
            Spacer(modifier = Modifier.height(12.dp))
            LazyColumn {
                items(20) {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(180.dp)
                            .width(120.dp)
                            .padding(bottom = 8.dp),
                        colors = CardDefaults.cardColors(containerColor = Color(0xaaFCD017)),
                        border = BorderStroke(
                            width = 2.dp, brush = Brush.horizontalGradient(
                                listOf
                                    (
                                    Color.Yellow, Color.White
                                )
                            )
                        )
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(8.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Card(
                                shape = CircleShape,
                                modifier = Modifier.size(width = 100.dp, height = 100.dp)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.homer),
                                    contentDescription = "",
                                    contentScale = ContentScale.Crop
                                )
                            }
                            Column(
                                modifier = Modifier
                                    .padding(12.dp)
                            ) {
                                Text(
                                    text = "Homer Simpson",
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Black,
                                    letterSpacing = 3.sp
                                )
                                Spacer(
                                    modifier = Modifier.height(
                                        8.dp
                                    )
                                )
                                Text(
                                    text = "Como o sustentador da família, ele trabalha na Usina Nuclear de Springfield. É rude, acima do peso, incompetente, grosseiro, preguiçoso, ignorante, mas" +
                                            " bastante dedicado à sua família.",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Black,
                                    lineHeight = 16.sp
                                )
                            }
                        }

                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    SimpsonsAppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Greeting()
        }
    }
}