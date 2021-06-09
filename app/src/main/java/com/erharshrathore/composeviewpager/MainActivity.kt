package com.erharshrathore.composeviewpager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.erharshrathore.composeviewpager.ui.theme.ComposeViewpagerExampleTheme
import com.erharshrathore.viewpager_compose.ViewPager

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeViewpagerExampleTheme {
                ViewPagerScreenExample(Modifier)
            }
        }
    }
}

@Composable
fun ViewPagerScreenExample(
    modifier: Modifier = Modifier
) {
    val imageIdList = remember{
        listOf(
            R.drawable.image_01,
            R.drawable.image_02,
            R.drawable.image_03,
            R.drawable.image_04,
            R.drawable.image_05,
            R.drawable.image_06,
            R.drawable.image_07,
            R.drawable.image_08,
            R.drawable.image_09,
            R.drawable.image_10,
            R.drawable.image_11,
            R.drawable.image_12,
        )
    }
    ViewPager(modifier = modifier) {
        repeat(imageIdList.size) { index ->
            //Will add 12 Screens in ViewPager
            ViewPagerChild {
                MyContent(imageId = imageIdList[index])
            }
        }

        //Adding 13th child(screen) to viewpager without looping.
        ViewPagerChild { Greeting(modifier) }


        // ---------------- OPTIONAL THINGS ----------------
        //You can use a ViewPager2 object to be able to receive callbacks by adding some listeners
        //or can attach it with some TabLayout like things.
        //For very own custom ViewPager in Composable scope user can override its adapter and other
        //properties as well.
        //TODO("Do something view ViewPager2 Object")
        //androidViewPager2.setCurrentItem(10, true)
        //...
        //...
    }
}

@Composable
fun MyContent(
    modifier: Modifier = Modifier,
    imageId: Int
) {
    Image(
        modifier = modifier,
        painter = painterResource(id = imageId),
        contentDescription = null,
        contentScale = ContentScale.FillBounds
    )
}

@Composable
fun Greeting(
    modifier: Modifier = Modifier,
    to: String = "World"
) {
    Box(
        modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text("Hello $to", style = MaterialTheme.typography.h2)
    }
}

