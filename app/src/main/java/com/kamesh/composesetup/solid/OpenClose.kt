package com.kamesh.composesetup.solid

/**
 * here because of abstraction (interface or abstract class) we can create new extension of version control
 * but don't require to change the OSDetail functionality because it's depend on abstraction not the extension of functionality
 * */
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