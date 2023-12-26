package com.kamesh.composesetup.solid

interface VersionController {
    fun passOSVersion() : Int
}
class IOS() : VersionController{

    override fun passOSVersion() : Int{
        return 16
    }
}

class Android() : VersionController{

    override fun passOSVersion() : Int{
        return 34
    }
}

class OSDetail {

    fun OSDetailPrint(versionController: VersionController){
        println("new OS Version is  ${versionController.passOSVersion()}")
    }

//    fun OSDetailPrint(android: Android){
//        print("Google is launching android ${android.passOSVersion()}")
//    }
//
//    fun OSDetailPrint(ios: IOS){
//        print("Apple is launching ios ${ios.passOSVersion()}")
//    }
}

//fun main(){
fun main2(){

    var osDetail = OSDetail()

    var mobile1 = IOS()
    var mobile2 = Android()

    osDetail.OSDetailPrint(mobile1)
    osDetail.OSDetailPrint(mobile2)

}