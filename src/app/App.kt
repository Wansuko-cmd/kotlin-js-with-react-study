package app

import react.*
import react.dom.*

interface State : RState{
    var text: String
}

class App : RComponent<RProps, State>() {
    override fun State.init() {
        text = "INIT"
    }

    override fun RBuilder.render() {
        h1 {
            +state.text
        }
    }
}

fun RBuilder.app() = child(App::class) {}
