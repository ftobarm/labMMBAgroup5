package labmmba

import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured

@Secured(["IS_AUTHENTICATED_ANONYMOUSLY"])
//controlador del pag principal, accesible por todos
class InicioController {
    def fileSystemService
    def index() {
    }
}
