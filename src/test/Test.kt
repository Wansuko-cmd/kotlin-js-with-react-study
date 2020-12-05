package test

import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import styled.styledH1

class Test : RComponent<RProps, RState>() {
    override fun RBuilder.render() {
        styledH1{
            +"TEST"
        }
    }
}

fun RBuilder.test() = child(Test::class){}