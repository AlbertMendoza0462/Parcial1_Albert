package edu.ucne.parcial1_albert.utils

sealed class Screen(val Route: String) {
    object RegistroArticuloScreen: Screen("RegistroArticuloScreen")
    object ConsultaArticuloScreen: Screen("ConsultaArticulosScreen")
}