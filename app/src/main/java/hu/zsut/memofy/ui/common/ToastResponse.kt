package hu.zsut.memofy.ui.common

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import hu.zsut.memofy.core.events.EventEmitter

@Composable
fun <TViewModel> ShowToastMessage(
    message: String,
    duration: Int,
    viewModel: TViewModel
) where TViewModel : EventEmitter {

    val context = LocalContext.current

    LaunchedEffect(Unit) {
        viewModel.toastEvent.collect {
            Toast.makeText(context, message, duration).show()
        }
    }
}