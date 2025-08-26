import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import coil.compose.rememberAsyncImagePainter
import com.test.muzz.R
import com.test.muzz.features.muzz.domain.model.MuzzModel

@Composable
fun ImageMuzzItem(muzzModel: MuzzModel.Image) {
    val context = LocalContext.current
    Card(
        modifier =
        Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable {
                muzzModel.url?.let {
                    val intent = Intent(Intent.ACTION_VIEW, it.toUri())
                    context.startActivity(intent)
                }
            },
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Image(
                painter = rememberAsyncImagePainter(muzzModel.imageUrlsList.firstOrNull()),
                contentDescription = null,
                modifier =
                Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop,
            )
            muzzModel.title?.let {
                Text(
                    text = it,
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier.padding(top = 8.dp),
                )
            }
            muzzModel.description?.let {
                Text(
                    text = it,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(top = 4.dp),
                )
            }
            muzzModel.author?.let {
                Text(
                    text = stringResource(R.string.muzz_item_author_prefix) + " " + it,
                    style = MaterialTheme.typography.labelSmall,
                    modifier = Modifier.padding(top = 4.dp),
                )
            }
            muzzModel.sourceName?.let {
                Text(
                    text = stringResource(R.string.muzz_item_source_prefix) + " " + it,
                    style = MaterialTheme.typography.labelSmall,
                    modifier = Modifier.padding(top = 4.dp),
                )
            }
        }
    }
}
