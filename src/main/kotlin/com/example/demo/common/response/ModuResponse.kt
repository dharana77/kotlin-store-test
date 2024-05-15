package com.example.demo.common.response

class ModuResponse<T> (
    private var statusCode: Int? = 0,
    private var data: Any? = null,
    private var message: String = ""
){
    fun success(data: Any, message: String) {
        this.statusCode = 200
        this.data = data
        this.message = message
    }
}