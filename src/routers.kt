import react.RBuilder
import react.dom.h1
import react.router.dom.browserRouter
import react.router.dom.route
import react.router.dom.switch

fun RBuilder.routing() = browserRouter {
    browserRouter {
        switch {
            route("/", exact = true) {
                h1{
                    +"MAIN"
                }
            }
            route("/test", exact = true){
                h1{
                    +"SUB"
                }
            }
        }
    }
}