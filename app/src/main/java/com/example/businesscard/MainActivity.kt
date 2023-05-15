package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = Color(0xFF185F5F)
                ) {
                    BusinessCardApp()
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp() {
    Column {
        ProfileCard(
            name = stringResource(R.string.full_name),
            motto = stringResource(R.string.life_motto),
            modifier = Modifier.weight(0.65f)
        )
        TitleCard(
            title = stringResource(R.string.coder_title),
            handle = stringResource(R.string.coder_handle),
            iconId = R.drawable.round_computer_24,
            iconDescription = stringResource(R.string.coder_icon_description),
            alignment = Alignment.End,
            modifier = Modifier.weight(0.175f)
        )
        TitleCard(
            title = stringResource(R.string.gamer_title),
            handle = stringResource(R.string.gamer_handle),
            iconId = R.drawable.round_videogame_asset_24,
            iconDescription = stringResource(R.string.gamer_icon_description),
            alignment = Alignment.Start,
            modifier = Modifier.weight(0.175f)
        )
    }
}

@Composable
fun ProfileCard(name: String, motto: String, modifier: Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.snow_panda_profile_pic),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(0.4f)
        )
        Text(text = name, fontSize = 60.sp, color = Color.White, fontWeight = FontWeight.Bold)
        Text(
            text = motto,
            fontSize = 16.sp,
            modifier = Modifier
                .align(Alignment.End)
                .padding(end = 14.dp),
            fontStyle = FontStyle.Italic,
            color = Color.White
        )
    }
}

@Composable
fun TitleCard(
    title: String,
    handle: String,
    iconId: Int,
    iconDescription: String,
    alignment: Alignment.Horizontal,
    modifier: Modifier
) {
    Column(
        horizontalAlignment = alignment, modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 14.dp)
    ) {
        Image(painter = painterResource(id = R.drawable.style_line), contentDescription = null, modifier = Modifier.fillMaxSize(0.6f))
        Column(modifier = Modifier.padding(horizontal = 12.dp)) {
            Text(
                text = title,
                fontSize = 26.sp,
                color = Color.White,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.align(alignment)
            )
            Handle(handle = handle, iconId, iconDescription)
        }
    }
}

@Composable
fun Handle(handle: String, iconId: Int, iconDescription: String) {
    Row {
        Icon(
            imageVector = ImageVector.vectorResource(id = iconId),
            contentDescription = iconDescription,
            modifier = Modifier.padding(end = 12.dp),
            tint = colorResource(id = R.color.orange)
        )
        Text(text = handle, fontSize = 14.sp, color = colorResource(id = R.color.orange))
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BusinessCardTheme {
        Surface(color = Color(0xFF185F5F)) {
//            ProfileCard(name = "Tony Guo", motto = "- \"Fail to the top\"")
//            TitleCard("Coder", "@devsTony", R.drawable.round_computer_24, "Coder handle:", Alignment.End)
            BusinessCardApp()
        }
    }
}