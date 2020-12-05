package index

import app.*
import kotlinext.js.*
import react.dom.*
import kotlinx.browser.*

fun main(args: Array<String>) {
    render(document.getElementById("root")) {
        app("Props")
    }
}
