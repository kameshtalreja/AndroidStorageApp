package com.kamesh.composesetup.patterns

import android.util.Log

interface Observer {
    fun update(title: String)
    fun subscribeChannel(channel: Channel)
}

interface Subject {
    fun subscribe(subscriber: Subscriber)
    fun unsubscribe(subscriber: Subscriber)
    fun notify(title: String)
    fun uploaded(title : String)
}


class Subscriber(val name : String) : Observer {

    private  val TAG = "ObserverDesign"

    var channel : Channel? = null

    override fun update(title: String) {
        Log.d(TAG, title)
    }

    override fun subscribeChannel(channel: Channel){
        this.channel = channel
    }
}



class Channel() : Subject {

    private var list = mutableListOf<Subscriber>()


    override fun subscribe(subscriber: Subscriber){

        list.add(subscriber)
    }

    override fun unsubscribe(subscriber: Subscriber){

        list.remove(subscriber)
    }

    override fun notify(title: String) {

        for(s in list){

            s.update("Hello ${s.name}, new video uploaded - $title")
        }
    }

    override fun uploaded(title : String){
        notify(title)
    }

}


fun runObserverPattern(){

    val channel = Channel()

    var sub1 = Subscriber("s1")
    var sub2 = Subscriber("s2")
    var sub3 = Subscriber("s3")
    var sub4 = Subscriber("s4")
    var sub5 = Subscriber("s5")

    channel.subscribe(sub1)
    channel.subscribe(sub2)
    channel.subscribe(sub3)
    channel.subscribe(sub4)
    channel.subscribe(sub5)

    sub1.subscribeChannel(channel)
    sub2.subscribeChannel(channel)
    sub3.subscribeChannel(channel)
    sub4.subscribeChannel(channel)
    sub5.subscribeChannel(channel)

    channel.notify("kotlin video has been uploaded ?")

}