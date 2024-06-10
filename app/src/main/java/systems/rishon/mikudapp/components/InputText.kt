package systems.rishon.mikudapp.components

import android.graphics.Typeface
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp

object InputText {

    @JvmStatic
    @Composable
    fun render(
        value: String,
        onValueChange: (String) -> Unit,
        label: String,
        modifier: Modifier = Modifier,
        assets: android.content.res.AssetManager
    ) {
        TextField(
            value = value,
            onValueChange = onValueChange,
            label = {
                Text(
                    text = label,
                    fontFamily = FontFamily(
                        Typeface.createFromAsset(assets, "ibm_plex_sans_regular.ttf")
                    ),
                )
            },
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 50.dp)
                .background(Color.White, shape = RoundedCornerShape(8.dp))
                .border(
                    width = 1.dp, color = Color.Gray, shape = RoundedCornerShape(8.dp)
                ),
            singleLine = true,
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                disabledContainerColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
            ),
        )
    }
}