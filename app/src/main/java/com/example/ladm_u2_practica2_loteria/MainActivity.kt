package com.example.ladm_u2_practica2_loteria

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ladm_u2_practica2_loteria.databinding.ActivityMainBinding
import kotlinx.coroutines.*
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var mazo = ArrayList<Carta>()
    var vector = ArrayList<Carta>()
    val scope = CoroutineScope(Job()+ Dispatchers.Main)
    var contador = 0
    var pausar = false
    val coroutineCartas = scope.launch(EmptyCoroutineContext,CoroutineStart.LAZY){
        while(contador <= mazo.size){
            runOnUiThread {
                if(pausar != true) {
                    binding.panel.setImageResource(mazo[contador].imagen)
                    mazo -=mazo[contador]
                    contador++
                }
            }
            delay(3000L)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnJugar.setOnClickListener {
            if (coroutineCartas.isActive) {
                binding.texto.text = ""
                vector.clear()
                binding.recyclerView.isVisible = false
                binding.btnVerificar.isEnabled = false
                binding.btnDetener.isEnabled = true
                llenarMazo()
                barajar()
                pausar = false
            } else {
                llenarMazo()
                barajar()
                binding.btnDetener.isEnabled = true
                coroutineCartas.start()
            }
        }

        binding.btnDetener.setOnClickListener {
            binding.btnVerificar.isEnabled = true
            binding.texto.text = "TENEMOS UN GANADOR!"
            pausar=true
        }

        binding.btnVerificar.setOnClickListener {
            binding.btnDetener.isEnabled = false
            binding.recyclerView.isVisible = true
            mostrarCartasRest(mazo.size)
        }

        if(coroutineCartas.isCompleted){
            binding.texto.text = "FIN DEL MAZO"
        }
    }

    fun llenarMazo() {
        mazo.add(Carta(R.drawable.carta1,R.raw.carta1))
        mazo.add(Carta(R.drawable.carta2,R.raw.carta1))
        mazo.add(Carta(R.drawable.carta3,R.raw.carta1))
        mazo.add(Carta(R.drawable.carta4,R.raw.carta1))
        mazo.add(Carta(R.drawable.carta5,R.raw.carta1))
        mazo.add(Carta(R.drawable.carta6,R.raw.carta1))
        mazo.add(Carta(R.drawable.carta7,R.raw.carta1))
        mazo.add(Carta(R.drawable.carta8,R.raw.carta1))
        mazo.add(Carta(R.drawable.carta9,R.raw.carta1))
        mazo.add(Carta(R.drawable.carta10,R.raw.carta1))
        mazo.add(Carta(R.drawable.carta11,R.raw.carta1))
        mazo.add(Carta(R.drawable.carta12,R.raw.carta1))
        mazo.add(Carta(R.drawable.carta13,R.raw.carta1))
        mazo.add(Carta(R.drawable.carta14,R.raw.carta1))
        mazo.add(Carta(R.drawable.carta15,R.raw.carta1))
        mazo.add(Carta(R.drawable.carta16,R.raw.carta1))
        mazo.add(Carta(R.drawable.carta17,R.raw.carta1))
        mazo.add(Carta(R.drawable.carta18,R.raw.carta1))
        mazo.add(Carta(R.drawable.carta19,R.raw.carta1))
        mazo.add(Carta(R.drawable.carta23,R.raw.carta1))
        mazo.add(Carta(R.drawable.carta24,R.raw.carta1))
        mazo.add(Carta(R.drawable.carta21,R.raw.carta1))
        mazo.add(Carta(R.drawable.carta22,R.raw.carta1))
        mazo.add(Carta(R.drawable.carta20,R.raw.carta1))
        mazo.add(Carta(R.drawable.carta25,R.raw.carta1))
        mazo.add(Carta(R.drawable.carta26,R.raw.carta1))
        mazo.add(Carta(R.drawable.carta27,R.raw.carta1))
        mazo.add(Carta(R.drawable.carta28,R.raw.carta1))
        mazo.add(Carta(R.drawable.carta29,R.raw.carta1))
        mazo.add(Carta(R.drawable.carta30,R.raw.carta1))
        mazo.add(Carta(R.drawable.carta31,R.raw.carta1))
        mazo.add(Carta(R.drawable.carta32,R.raw.carta1))
        mazo.add(Carta(R.drawable.carta33,R.raw.carta1))
        mazo.add(Carta(R.drawable.carta34,R.raw.carta1))
        mazo.add(Carta(R.drawable.carta35,R.raw.carta1))
        mazo.add(Carta(R.drawable.carta36,R.raw.carta1))
        mazo.add(Carta(R.drawable.carta37,R.raw.carta1))
        mazo.add(Carta(R.drawable.carta38,R.raw.carta1))
        mazo.add(Carta(R.drawable.carta39,R.raw.carta1))
        mazo.add(Carta(R.drawable.carta40,R.raw.carta1))
        mazo.add(Carta(R.drawable.carta41,R.raw.carta1))
        mazo.add(Carta(R.drawable.carta42,R.raw.carta1))
        mazo.add(Carta(R.drawable.carta43,R.raw.carta1))
        mazo.add(Carta(R.drawable.carta44,R.raw.carta1))
        mazo.add(Carta(R.drawable.carta45,R.raw.carta1))
        mazo.add(Carta(R.drawable.carta46,R.raw.carta1))
        mazo.add(Carta(R.drawable.carta47,R.raw.carta1))
        mazo.add(Carta(R.drawable.carta48,R.raw.carta1))
        mazo.add(Carta(R.drawable.carta49,R.raw.carta1))
        mazo.add(Carta(R.drawable.carta50,R.raw.carta1))
        mazo.add(Carta(R.drawable.carta51,R.raw.carta1))
        mazo.add(Carta(R.drawable.carta52,R.raw.carta1))
        mazo.add(Carta(R.drawable.carta53,R.raw.carta1))
        mazo.add(Carta(R.drawable.carta54,R.raw.carta1))
    }

    fun barajar(){
        mazo.shuffle()
    }
    /*fun Barajar() = GlobalScope.launch{
             var i=0
             while(i <= mazo.size){
             runOnUiThread {
                 binding.panel.setImageResource(carta)
             }
                 i++
                 index = rand(mazo.size)
                 carta = mazo[index]
                 delay(3000L)
             }
     }*/

   fun mostrarCartasRest(tam:Int) = GlobalScope.launch{
        (0..tam-1).forEach {
            vector.add(mazo[it])
        }
        runOnUiThread {
            val adapter = CustomAdapter(vector)
            binding.recyclerView.layoutManager = LinearLayoutManager(this@MainActivity,LinearLayoutManager.HORIZONTAL,false)
            binding.recyclerView.scrollToPosition(tam-1)
            binding.recyclerView.adapter = adapter
        }
    }


    private fun rand(hasta:Int) : Int{
        return Random.nextInt(hasta)
    }


}