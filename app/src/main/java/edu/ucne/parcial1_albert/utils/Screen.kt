package edu.ucne.parcial1_albert.utils

sealed class Screen(Route: String) {
    object RegistroArticuloScreen: Screen("RegistroArticuloScreen")
    object ConsultaArticuloScreen: Screen("ConsultaArticulosScreen")
}