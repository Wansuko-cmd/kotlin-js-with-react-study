package index

import app.*
import react.dom.*
import kotlinx.browser.*
import kotlinx.css.CSSBuilder
import kotlinx.css.*
import styled.StyledComponents
import styled.injectGlobal

fun main(args: Array<String>) {
    StyledComponents.injectGlobal(CSSBuilder().apply {
        body{
            backgroundColor = Color.azure
        }
    }.toString())

    render(document.getElementById("root")) {
        app("Props")
    }
}
