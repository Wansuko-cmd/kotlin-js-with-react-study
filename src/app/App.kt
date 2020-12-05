package app

import kotlinx.css.*
import react.*
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

class App(props: Props) : RComponent<Props, State>(props) {
    override fun State.init(props: Props) {
        text = props.text
        size = 300
    }

    override fun RBuilder.render() {
        styledDiv(){
            css{
                +ComponentStyles.wrapper
            }
            styledButton() {
                css{
                    classes = mutableListOf("btn", "btn-info")
                }
                +state.text
            }
            test()
        }
    }
}

fun RBuilder.app(text: String) = child(App::class) {
    attrs.text = text
}
