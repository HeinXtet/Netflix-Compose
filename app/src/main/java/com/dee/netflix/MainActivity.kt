package com.dee.netflix

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.dee.common.base.BaseActivity
import com.dee.common.theme.NetflixTheme
import com.dee.netflix.navigation.Navigation
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    @Composable
    override fun MainContent() {
        val navController = rememberNavController()
        Navigation.AppNavigationGraph(navController = navController)
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NetflixTheme {
        Greeting("Android")
    }
}