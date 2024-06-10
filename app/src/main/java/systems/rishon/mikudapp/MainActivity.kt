package systems.rishon.mikudapp

import android.graphics.Typeface
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import systems.rishon.mikudapp.components.InputText

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HeaderText() // Header
            TextFields() // TextFields
        }
    }

    @Composable
    private fun HeaderText() {
        // Header
        Box(modifier = Modifier.fillMaxSize()) {
            Text(
                text = "איתור מיקוד", style = TextStyle(
                    fontFamily = FontFamily(
                        Typeface.createFromAsset(
                            assets, "ibm_plex_sans_bold.ttf"
                        )
                    ),
                    fontWeight = FontWeight.Bold,
                    fontSize = TextStyle(fontSize = TextUnit(64f, TextUnitType.Sp)).fontSize,
                    color = Color(android.graphics.Color.parseColor("#101057"))
                ), modifier = Modifier
                    .align(Alignment.TopCenter)
                    .offset(y = (50).dp)
            )
            Text(
                text = ".הזינו כתובת בכדי לקבל מיקוד",
                style = TextStyle(
                    fontFamily = FontFamily(
                        Typeface.createFromAsset(
                            assets, "ibm_plex_sans_regular.ttf"
                        )
                    ),
                    fontWeight = FontWeight.Bold,
                    fontSize = TextStyle(fontSize = TextUnit(24f, TextUnitType.Sp)).fontSize,
                    color = Color(android.graphics.Color.parseColor("#101057"))
                ),
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .offset(x = (20).dp, y = (135).dp),
            )
        }
    }

    @Composable
    private fun TextFields() {
        // TextFields
        CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
            Box(modifier = Modifier.fillMaxSize()) {
                Column(modifier = Modifier.padding(16.dp)) {
                    val city = remember { mutableStateOf("") }
                    val address = remember { mutableStateOf("") }
                    val houseNumber = remember { mutableStateOf("") }
                    val entranceNumber = remember { mutableStateOf("") }

                    InputText.render(
                        value = city.value,
                        onValueChange = { city.value = it },
                        label = "ישוב / עיר",
                        modifier = Modifier.offset(y = 190.dp),
                        assets = assets
                    )

                    InputText.render(
                        value = address.value,
                        onValueChange = { address.value = it },
                        label = "רחוב",
                        modifier = Modifier.offset(y = 210.dp),
                        assets = assets
                    )

                    InputText.render(
                        value = houseNumber.value,
                        onValueChange = { houseNumber.value = it },
                        label = "מס' בית",
                        modifier = Modifier.offset(y = 230.dp),
                        assets = assets
                    )

                    InputText.render(
                        value = entranceNumber.value,
                        onValueChange = { entranceNumber.value = it },
                        label = "כניסה (אם יש)",
                        modifier = Modifier.offset(y = 250.dp),
                        assets = assets
                    )
                }
            }
        }
    }
}