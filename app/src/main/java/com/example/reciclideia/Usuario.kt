package com.example.reciclideia

class Usuario{
    var id: String? = null
    var nome: String? = null
    var email: String? = null
    //var usuario: String? = null

    constructor(){}
    constructor(id: String?, nome: String?, email: String?) {
        this.nome=nome
        this.email=email
        this.id = id
    }
}
