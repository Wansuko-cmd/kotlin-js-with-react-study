package app

import kotlinx.css.*
import react.*
import react.dom.*
import styled.css
import styled.styledH1

interface State : RState{
    var text: String
    var size: Int
}

interface Props: RProps{
    var text: String
}

class App(props: Props) : RComponent<Props, State>(props) {
    override fun State.init(props: Props) {
        text = props.text
        size = 300
    }

    override fun RBuilder.render() {
        styledH1 {
            css{
                width = state.size.px
                backgroundColor = Color.red
            }
            +state.text
        }
    }
}

fun RBuilder.app(text: String) = child(App::class) {
    attrs.text = text
}
