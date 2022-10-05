package com.example.laboratorio2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {

    private lateinit var etnNombre: EditText
    private lateinit var etnEdad: EditText
    private lateinit var etnDepartamento: EditText
    private var tv_Registro: TextView? = null
    private lateinit var lv_registros: ListView

    private var Nombres = ArrayList<String>()
    private var Edades = ArrayList<Int>()
    private var Departamentos = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etnNombre = findViewById(R.id.etn_Nombre)
        etnEdad = findViewById(R.id.etn_Edad)
        etnDepartamento = findViewById(R.id.etn_Departamento)
        tv_Registro = findViewById(R.id.tv_Registro)
        lv_registros = findViewById(R.id.lv_Registros)

    }

    fun Guardar(v: View) {
        var nombre = etnNombre.text.toString()
        var edad = etnEdad.text.toString().toInt()
        var departamento = etnDepartamento.text.toString()

        Nombres.add(nombre)
        Edades.add(edad)
        Departamentos.add(departamento)

        Clean()
        nombre = ""
        edad = 0
        departamento = ""

        val adaptador:ArrayAdapter<String> = ArrayAdapter<String>(this, R.layout.lv_registros, Nombres)
        lv_registros.adapter = adaptador

        lv_registros.onItemClickListener = object: AdapterView.OnItemClickListener{
            override fun onItemClick(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
                tv_Registro?.setText("Información de ${Nombres[position]}: ${Edades[position]} años, de ${Departamentos[position]}")
            }
        }
    }
    private fun Clean(){
        etnNombre.text.clear()
        etnEdad.text.clear()
        etnDepartamento.text.clear()
        tv_Registro?.setText("")

    }
}