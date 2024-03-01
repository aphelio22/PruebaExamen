package com.example.pruebaexamen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Adapter
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pruebaexamen.adapter.AdapterPais
import com.example.pruebaexamen.adapter.ProviderPais
import com.example.pruebaexamen.databinding.ActivityMainBinding
import com.example.pruebaexamen.domain.PaisDAO
import com.example.pruebaexamen.maps.MapsActivity
import com.example.pruebaexamen.model.Pais

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: AdapterPais
    //Importante con lo de MutableList
    private lateinit var listaPais: MutableList<Pais>
    private var paisDAO = PaisDAO()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        this.onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                finish()
            }
        })

        listaPais = paisDAO.cargarLista(this)
        //Propio del RecyclerView:
        binding.rvPais.layoutManager = LinearLayoutManager(this)
        adapter = AdapterPais(listaPais) {
            pais -> onItemSelected(pais)
        }

        //Es importante establecer esta línea.
        /*
        * Así le dices al adaptador del RecyclerView de Pais que es igual a la
        * variable adapter que has establecido antes. */
        binding.rvPais.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.paisesUE -> {
                listaPais = paisDAO.cargarUE(this)
                adapter.updateList(listaPais)
                return true
            }

            R.id.paisesNoUE -> {
                listaPais = paisDAO.cargarNOUE(this)
                adapter.updateList(listaPais)
                return true
            }

            R.id.todosPaises -> {
                listaPais = paisDAO.cargarLista(this)
                adapter.updateList(listaPais)
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun onItemSelected(pais: Pais) {
        var miIntent = Intent(this, MapsActivity::class.java)
        miIntent.putExtra("latitud", pais.latitud)
        miIntent.putExtra("longitud", pais.longitud)
        startActivity(miIntent)
    }
}