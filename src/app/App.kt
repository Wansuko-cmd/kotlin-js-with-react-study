package app

import react.*
import react.dom.*

interface State : RState{
    var text: String
}

interface Props: RProps{
    var text: String
}

class App(props: Props) : RComponent<Props, State>(props) {
    override fun State.init(props: Props) {
        text = props.text
    }

    override fun RBuilder.render() {
        h1 {
            +state.text
        }
    }
}

fun RBuilder.app(text: String) = child(App::class) {
    attrs.text = text
}
