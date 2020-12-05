package app

import kotlinx.css.*
import kotlinx.html.js.onChangeFunction
import org.w3c.dom.HTMLInputElement
import react.*
import react.dom.input
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
            test(state.text)
        }
        input{
            attrs{
                onChangeFunction = {
                    val target = it.target as HTMLInputElement
                    setState{
                        text = target.value
                    }
                }
            }
        }
    }
}

fun RBuilder.app(text: String) = child(App::class) {
    attrs.text = text
}
