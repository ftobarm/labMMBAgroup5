package labmmba

import grails.plugin.springsecurity.SpringSecurityUtils
import grails.plugin.springsecurity.annotation.Secured

@Secured(['IS_AUTHENTICATED_FULLY'])
//Solo accesible por usuarios creados
class SuccesLoginController {
    def springSecurityService
    //dependiendo del tipo usuario que se logea le envia a una vista distinta.
    def index() {
        if (SpringSecurityUtils.ifAllGranted("ROLE_ADMIN")) {
            return redirect(controller: 'usuario', action: "admin")
        } else if (SpringSecurityUtils.ifAllGranted("ROLE_USUARIO")) {
            return redirect(controller: 'usuario', action:"userView", params:[id:springSecurityService.currentUserId])
        }
    }
}