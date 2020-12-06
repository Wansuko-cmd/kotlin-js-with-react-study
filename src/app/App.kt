package app

import kotlinx.css.*
import kotlinx.html.js.onChangeFunction
import org.w3c.dom.HTMLInputElement
import react.*
import react.dom.*
import styled.*
import test.test

interface State : RState{
    var text: String
    var size: Int
}

interface Props: RProps{
    var text: String
}

object ComponentStyles : StyleSheet("ComponentStyles", isStatic = true) {
    val wrapper by css {
        //backgroundColor = Color.red
        children("h1") {
            backgroundColor = Color.darkBlue
        }
        children("button") {
            backgroundColor = Color.aqua
        }
        children("test"){
            backgroundColor = Color.darkBlue
        }
    }
}

val app = functionalComponent<Props>{props ->
    val (text, setText) = useState("")
    input{
        attrs.onChangeFunction = {
            val target = it.target as HTMLInputElement
            setText(target.value)
        }
    }
    test(text)
}

fun RBuilder.app(handler: Props.() -> Unit) = child(app){
    attrs{
        handler()
    }
}