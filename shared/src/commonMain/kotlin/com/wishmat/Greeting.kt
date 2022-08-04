package com.wishmat

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}