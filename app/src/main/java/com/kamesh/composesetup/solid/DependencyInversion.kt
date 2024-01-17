package com.kamesh.composesetup.solid

interface Switchable {
    fun turnOn()
    fun turnOff()
}

// Low Level Module
class Light : Switchable {
    override fun turnOn() {
        println("Light On")
    }

    override fun turnOff() {
        println("Light Off")
    }

}

//High Level Module
class Switch(private val device : Switchable) {

    fun operate() {
        device.turnOff()
        device.turnOn()
    }
}

/** the main fun here uses the switch class without knowing the concerte details of light class.
 * this is possible because both high and low level module depend on abstractions */
fun main(){

    var light = Light()
    var switch = Switch(light)
    switch.operate()
}

