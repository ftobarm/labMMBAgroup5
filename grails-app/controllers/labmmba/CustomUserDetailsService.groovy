package labmmba

import grails.plugin.springsecurity.SpringSecurityUtils
import grails.plugin.springsecurity.userdetails.GrailsUser
import grails.plugin.springsecurity.userdetails.GrailsUserDetailsService
import org.springframework.security.core.authority.GrantedAuthorityImpl
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UsernameNotFoundException

class CustomUserDetailsService implements GrailsUserDetailsService {
    static final List NO_ROLES = [new GrantedAuthorityImpl(SpringSecurityUtils.NO_ROLE)]

    UserDetails loadUserByUsername(String username, boolean loadRoles) throws UsernameNotFoundException {
        return loadUserByUsername(username)
    }

    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario.withTransaction { status ->
            Usuario user = Usuario.findByEmail(username)

            if (!user)
                throw new UsernameNotFoundException('User not found', username)

            def authorities = user.authorities.collect {new GrantedAuthorityImpl(it.authority)}

            return new GrailsUser(user.email, user.password, user.enabled, !user.accountExpired,
                    !user.passwordExpired, !user.accountLocked,
                    authorities ?: NO_ROLES, user.id)
        }
    }
}

