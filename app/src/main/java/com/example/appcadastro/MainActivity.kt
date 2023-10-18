
package com.example.appcadastro

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.appcadastro.db.DBHandler
import com.example.appcadastro.ui.theme.AppCadastroTheme

class MainActivity : ComponentActivity() {

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppCadastroTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(
                        topBar = {
                            TopAppBar(colors = TopAppBarDefaults.centerAlignedTopAppBarColors(),

                                title = {
                                    Text(
                                        text = "GFG",

                                        modifier = Modifier.fillMaxWidth(),

                                        textAlign = TextAlign.Center,

                                        color = Color.White
                                    )
                                }
                                )
                        }) {
                            addDataToDatabase(LocalContext.current)
                    }
                    }
                }
            }
        }
    }



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun addDataToDatabase(
    context: Context
) {
    // var text by rememberSaveable { mutableStateOf("") }
    val Tnome = remember { mutableStateOf(TextFieldValue()) }

    val Tende = remember { mutableStateOf(TextFieldValue()) }

    val Tbairro = remember { mutableStateOf(TextFieldValue()) }

    val Tcep = remember { mutableStateOf(TextFieldValue()) }

    val Tcidad = remember { mutableStateOf(TextFieldValue()) }

    val Testad = remember { mutableStateOf(TextFieldValue()) }

    val Ttel = remember { mutableStateOf(TextFieldValue()) }

    val Tcell = remember { mutableStateOf(TextFieldValue()) }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){

        var dbHandler: DBHandler = DBHandler(context)

        TextField(
            value = Tnome.value,
            onValueChange = { Tnome.value = it },
            label = { Text("Nome") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
            // placeholder = { Text("Digite seu nome) }
        )


        Spacer(modifier = Modifier.height(20.dp))


        TextField(
            value = Tende.value,
            onValueChange = { Tende.value = it },
            label = { Text("Endereço") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
            //placeholder = { Text("Digite seu endereço") }
        )


        Spacer(modifier = Modifier.height(20.dp))


        TextField(
            value = Tbairro.value,
            onValueChange = { Tbairro.value = it },
            label = { Text("Bairro") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
            //placeholder = { Text("Digite o nome do seu bairro") }
        )


        Spacer(modifier = Modifier.height(20.dp))


        TextField(
            value = Tcep.value,
            onValueChange = { Tcep.value = it },
            label = { Text("CEP") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )


        Spacer(modifier = Modifier.height(20.dp))


        TextField(
            value = Tcidad.value,
            onValueChange = { Tcidad.value = it },
            label = { Text("Cidade") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )


        Spacer(modifier = Modifier.height(20.dp))


        TextField(
            value = Testad.value,
            onValueChange = { Testad.value = it },
            label = { Text("Estado") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )


        Spacer(modifier = Modifier.height(20.dp))


        TextField(
            value = Ttel.value,
            onValueChange = { Ttel.value = it },
            label = { Text("Telefone") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )


        Spacer(modifier = Modifier.height(20.dp))


        TextField(
            value = Tcell.value,
            onValueChange = { Tcell.value = it },
            label = { Text("Celular") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )


        Spacer(modifier = Modifier.height(20.dp))


        Button(
            onClick = {
                dbHandler.addNewData(
                    Tnome.value.text,
                    Tende.value.text,
                    Tbairro.value.text,
                    Tcep.value.text,
                    Tcidad.value.text,
                    Testad.value.text,
                    Ttel.value.text,
                    Tcell.value.text
                )
                Toast.makeText(context, "Dados adicionados ao banco", Toast.LENGTH_SHORT).show()
            } )
        { Text(text = "Adicionar os dados ao banco" ,color = Color.White ) }

    }


    Spacer(modifier = Modifier.height(15.dp))


    Button(onClick = {
        val i = Intent(context, ViewCourses::class.java)
        context.startActivity(i)
    }) { Text(text = "Verificar dados no banco" ,color = Color.White ) }

}

/*
@Preview(showBackground = true, widthDp = 300, heightDp = 350)
@Composable
fun TFsamplePreview() {
    TFsample()
}
*/


/*
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TFsample3() {
    val Tobs = remember {
        mutableStateOf("")
    }

    TextField(
        value = Tobs.value,
        onValueChange = { Tobs.value = it },
        label = { Text("Observações")}
        // modifier = Modifier.fillMaxWidth()
    )

}


@Preview (showBackground = true, widthDp = 300, heightDp = 150)
@Composable
fun TFsample3Preview() {
    TFsample3()
}
*/


