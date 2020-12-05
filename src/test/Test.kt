package test

import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import styled.styledH1

interface TestProps: RProps{
    var text: String
}

class Test(props: TestProps) : RComponent<TestProps, RState>(props) {
    override fun RBuilder.render() {
        styledH1{
            +props.text
        }
    }
}

fun RBuilder.test(text: String) = child(Test::class){
    attrs.text = text
}