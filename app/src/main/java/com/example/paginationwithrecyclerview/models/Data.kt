package com.example.paginationwithrecyclerview.models

import com.google.gson.annotations.SerializedName

class Data {

    @SerializedName("id")
    var id: Int? = null

    @SerializedName("email")
    var email: String? = null

    @SerializedName("first_name")
    var firstName: String? = null

    @SerializedName("last_name")
    var lastName: String? = null

    @SerializedName("avatar")
    var avatar: String? = null

    constructor(avatar: String?, email: String?, firstName: String?, id: Int?, lastName: String?) {
        this.avatar = avatar
        this.email = email
        this.firstName = firstName
        this.id = id
        this.lastName = lastName
    }

    constructor()
}