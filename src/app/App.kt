package app

import react.*
import react.dom.*

class App : RComponent<RProps, RState>() {
    override fun RBuilder.render() {
        h1{
            +"Hello World"
        }
    }
}

fun RBuilder.app() = child(App::class) {}
