package com.prokopenko.littlelemon.ui.screen

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.prokopenko.littlelemon.R
import com.prokopenko.littlelemon.ui.theme.AppTheme

@Composable
fun Onboarding(navHostController: NavHostController) {
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    val context = LocalContext.current

    Column (
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
    ) {
        Image(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .height(80.dp)
                .fillMaxWidth()
                .padding(vertical = 16.dp, horizontal = 32.dp),
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Little Lemon Logo"
        )
        Box(
            modifier = Modifier
                .background(AppTheme.color.primary1)
                .padding(0.dp, 48.dp, 0.dp, 48.dp)
                .fillMaxWidth()
        ) {
            Text(modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center),
                color = AppTheme.color.highlight1,
                text = stringResource(id = R.string.on_boarding_title),
                textAlign = TextAlign.Center,
                style = AppTheme.typography.subTitle
            )
        }
        Text(
            text = stringResource(id = R.string.on_boarding_sub_title),
            style = AppTheme.typography.sectionTitle,
            modifier = Modifier.padding(16.dp, 40.dp)
        )
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp, 0.dp, 16.dp, 16.dp),
            value = firstName,
            maxLines = 1,
            onValueChange = {firstName = it},
            label = { Text(stringResource(id = R.string.on_boarding_form_first_name_label))},
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next)
        )
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp, 16.dp),
            value = lastName,
            maxLines = 1,
            onValueChange = {lastName = it},
            label = { Text(stringResource(id = R.string.on_boarding_form_last_name_label))},
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next)
        )
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp, 16.dp),
            value = email,
            maxLines = 1,
            onValueChange = {email = it},
            label = { Text(stringResource(id = R.string.on_boarding_form_email_label))},
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done,
                keyboardType = KeyboardType.Email
            )
        )
        Button(
            onClick = {
                      if (
                          firstName.isNotBlank() &&
                          lastName.isNotBlank() &&
                          email.isNotBlank()
                      ) {
                          Toast.makeText(
                              context,
                              context.getString(R.string.registration_successful_msg),
                              Toast.LENGTH_SHORT
                          ).show()
                      } else Toast.makeText(
                          context,
                          context.getString(R.string.registration_unsuccessful_msg),
                          Toast.LENGTH_SHORT
                      ).show()
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            colors = ButtonDefaults.filledTonalButtonColors(AppTheme.color.primary2)
        ) {
            Text(stringResource(id = R.string.on_boarding_form_register_btn_txt))
        }
    }
}

@Preview
@Composable
fun OnboardingPreview() {
    Onboarding(navHostController = rememberNavController())
}