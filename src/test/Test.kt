package test

import react.*
import react.dom.h1

interface TestProps: RProps{
    var text: String
}

val test = functionalComponent<TestProps> {props ->
    h1{+props.text}
}

fun RBuilder.test(text: String) = child(test){
        attrs.text = text
}