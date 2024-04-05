package com.prokopenko.littlelemon.ui.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.prokopenko.littlelemon.viewmodel.ProfileVM
import com.prokopenko.littlelemon.data.model.User


@Composable
fun ProfileScreen(profileVm: ProfileVM = viewModel()) {
    val user by profileVm.user.collectAsStateWithLifecycle()
    ProfileUI(user = user)
}

@Composable
fun ProfileUI(user: User?) {
    Text(
        text = user?.toString() ?: "",
        modifier = Modifier
            .padding(24.dp))
}

@Composable
@Preview(showBackground = true)
fun ProfileScreenPreview() {
    ProfileUI(User("Pavlo", "Prokopenko", "pavlo@example.com"))
}