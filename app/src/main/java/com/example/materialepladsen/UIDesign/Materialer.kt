package com.example.materialepladsen.ui.theme

import androidx.compose.ui.tooling.preview.Preview
import android.os.Bundle
import android.annotation.SuppressLint
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import com.example.materialepladsen.R
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.material.ScrollableTabRow
import androidx.compose.material.Tab
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.debugInspectorInfo
import androidx.compose.ui.unit.Dp
import androidx.navigation.NavController
import com.example.materialepladsen.viewmodel.MaterialList
import com.example.materialepladsen.viewmodel.Material_list



class Materials : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var selectedTabIndex by remember { mutableStateOf(0) }
            val tabs = MaterialList.valueOf(Material_list.toString())

            CustomScrollableTabRow(
                tabs = tabs,
                selectedTabIndex = selectedTabIndex
            ) { tabIndex ->
                selectedTabIndex = tabIndex
            }
        }
    }
}


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Materialer (navController: NavController) {
    Column() {
        Logo2()

        Divider(modifier = Modifier.fillMaxWidth(),
            thickness = 1.dp,
            color = Color.Black)

        Spacer(modifier = Modifier.height(18.dp))

        Text(text = stringResource(id = R.string.Tr??sorter),
            modifier = Modifier.padding(start=15.dp),
            style=MaterialTheme.typography.overline,
        )

        Spacer(modifier = Modifier.height(21.dp))

        //F??rste r??kke
        //M??ske laves til LazyRow?
        Row(modifier=Modifier.padding(start=28.dp)) {

            //CustomScrollableTabRow

            Spacer(modifier = Modifier.width(50.dp))

            Image(
                modifier = Modifier
                    .height(70.dp)
                    .width(70.dp),
                painter = painterResource(id = R.drawable.s_lvplade),
                contentDescription = null
            )

            Spacer(modifier = Modifier.width(13.dp))

            Icon(imageVector=Icons.Default.ArrowForwardIos,
                contentDescription = null,
                modifier= Modifier
                    .height(45.dp)
                    .width(26.dp)
                    .align(CenterVertically)
            )

        }
        Spacer(modifier = Modifier.height(20.dp))
        Divider(modifier = Modifier.fillMaxWidth(),
            thickness = 1.dp,
            color = Color.Black)

        Spacer(modifier = Modifier.height(18.dp))

        Text(text = stringResource(id = R.string.Metaller),
            modifier = Modifier.padding(start=15.dp),
            style=MaterialTheme.typography.overline,
        )

        Spacer(modifier = Modifier.height(21.dp))

        //Anden r??kke
        //M??ske laves til LazyRow?
        Row(modifier=Modifier.padding(start=28.dp)) {

            //CustomScrollableTabRow

            Spacer(modifier = Modifier.width(50.dp))

            Image(
                modifier = Modifier
                    .height(70.dp)
                    .width(70.dp),
                painter = painterResource(id = R.drawable.woodpile_6364896_960_720_3),
                contentDescription = null
            )

            Spacer(modifier = Modifier.width(13.dp))

            Icon(imageVector=Icons.Default.ArrowForwardIos,
                contentDescription = null,
                modifier= Modifier
                    .height(45.dp)
                    .width(26.dp)
                    .align(CenterVertically)
            )

        }

        Spacer(modifier = Modifier.height(20.dp))
        Divider(modifier = Modifier.fillMaxWidth(),
            thickness = 1.dp,
            color = Color.Black)

        Spacer(modifier = Modifier.height(18.dp))

        Text(text = stringResource(id = R.string.Sten),
            modifier = Modifier.padding(start=15.dp),
            style=MaterialTheme.typography.overline,
        )

        Spacer(modifier = Modifier.height(21.dp))

        //Tredje r??kke
        //M??ske laves til LazyRow?
        Row(modifier=Modifier.padding(start=28.dp)) {
            //CustomScrollableTabRow

            Spacer(modifier = Modifier.width(50.dp))

            //CustomScrollableTabRow
            Image(
                modifier = Modifier
                    .height(70.dp)
                    .width(70.dp),
                painter = painterResource(id = R.drawable.woodpile_6364896_960_720_2),
                contentDescription = null
            )

            Spacer(modifier = Modifier.width(13.dp))

            Icon(imageVector=Icons.Default.ArrowForwardIos,
                contentDescription = null,
                modifier= Modifier
                    .height(45.dp)
                    .width(26.dp)
                    .align(CenterVertically)
            )
        }
    }
}

@Composable
fun Logo2(){
    Row(modifier= Modifier
        .height(41.dp)
        .width(360.dp),
    horizontalArrangement = Arrangement.Start)
    {
        Image(
            painter = painterResource(id = R.drawable.unknown_1),
            contentDescription =null,
            modifier= Modifier
                .width(118.dp)
                .height(35.dp)
                .padding(start = 18.dp, top = 5.dp)
        )
        Spacer(modifier = Modifier.width(200.dp))

        Icon(modifier= Modifier
            .height(25.dp)
            .width(25.dp)
            .align(CenterVertically),
            imageVector = Icons.Default.ShoppingCart,
            contentDescription = null)
    }
}

@Composable
fun CustomScrollableTabRow(
    tabs: List<String>,
    selectedTabIndex: Int,
    onTabClick: (Int) -> Unit
) {
    val density = LocalDensity.current
    val tabWidths = remember {
        val tabWidthStateList = mutableStateListOf<Dp>()
        repeat(tabs.size) {
            tabWidthStateList.add(0.dp)
        }
        tabWidthStateList
    }
    ScrollableTabRow(
        selectedTabIndex = selectedTabIndex,
        contentColor = Color.White,
        edgePadding = 0.dp,
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                modifier = Modifier.customTabIndicatorOffset(
                    currentTabPosition = tabPositions[selectedTabIndex],
                    tabWidth = tabWidths[selectedTabIndex]
                )
            )
        }
    ) {
        tabs.forEachIndexed { tabIndex, tab ->
            Tab(
                selected = selectedTabIndex == tabIndex,
                onClick = { onTabClick(tabIndex) },
                text = {
                    Text(
                        text = tab,
                        onTextLayout = { textLayoutResult ->
                            tabWidths[tabIndex] =
                                with(density) { textLayoutResult.size.width.toDp() }
                        }
                    )
                }
            )
        }
    }
}

@Composable
fun Modifier.customTabIndicatorOffset(
    currentTabPosition: TabPosition,
    tabWidth: Dp
): Modifier = composed(
    inspectorInfo = debugInspectorInfo {
        name = "customTabIndicatorOffset"
        value = currentTabPosition
    }
) {
    val currentTabWidth by animateDpAsState(
        targetValue = tabWidth,
        animationSpec = tween(durationMillis = 250, easing = FastOutSlowInEasing)
    )
    val indicatorOffset by animateDpAsState(
        targetValue = ((currentTabPosition.left + currentTabPosition.right - tabWidth) / 2),
        animationSpec = tween(durationMillis = 250, easing = FastOutSlowInEasing)
    )
    fillMaxWidth()
        .wrapContentSize(Alignment.BottomStart)
        .offset(x = indicatorOffset)
        .width(currentTabWidth)
}

//@Composable
//fun Materialeitem(
//    //Strings for product - Product/
//    @StringRes id_et: Int,
//    @StringRes id_to: Int,
//    @StringRes id_tre: Int,
//    @DrawableRes billede: Int,
//) {
//
//    Column(modifier = Modifier.width(140.dp)) {
//        Image(
//            modifier = Modifier
//                .height(81.dp)
//                .width(98.dp)
//                .align(CenterHorizontally),
//            painter = painterResource(id = billede),
//            contentDescription = null
//        )
//        Text(text = stringResource(id = id_et),
//            style=MaterialTheme.typography.subtitle1,
//            textAlign = TextAlign.Center,
//            modifier = Modifier.fillMaxWidth(),
//            lineHeight = 14.sp
//        )
//
//        Text(text = stringResource(id = id_to),
//            style=MaterialTheme.typography.subtitle2,
//            textAlign = TextAlign.Center,
//            modifier = Modifier.fillMaxWidth(),
//            lineHeight = 14.sp
//        )
//
//        Text(text ="DKK "+ stringResource(id = id_tre),
//            style=MaterialTheme.typography.h3,
//            textAlign = TextAlign.Center,
//            modifier = Modifier.fillMaxWidth(),
//            lineHeight = 14.sp,
//            color = MaterialTheme.colors.secondaryVariant
//        )
//    }
//}

