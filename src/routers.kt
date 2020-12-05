import app.App
import react.RBuilder
import react.dom.h1
import react.dom.h3
import react.router.dom.browserRouter
import react.router.dom.route
import react.router.dom.switch
import test.Test
import test.test

fun RBuilder.routing() = browserRouter {
    browserRouter {
        switch {
            route("/", exact = true) {
                h1{
                    +"MAIN"
                }
            }
            route("/test", exact = true){
                child(Test::class){attrs.text = "Ok"}
            }
        }
    }
}