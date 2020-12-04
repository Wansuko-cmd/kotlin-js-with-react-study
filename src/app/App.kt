package app

import react.*
import react.dom.*

class App : RComponent<RProps, RState>() {
    override fun RBuilder.render() {
        for(i in 0..5){
            h1{
                +"${square(i)}"
            }
        }
    }

    fun square(num: Int): Int{
        return num*num
    }
}

fun RBuilder.app() = child(App::class) {}
