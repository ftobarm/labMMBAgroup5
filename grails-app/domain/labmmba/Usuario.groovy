package labmmba

class Usuario implements Serializable {

	private static final long serialVersionUID = 1

	transient springSecurityService

	String email
	String password
	String nombre
	String apellido
	boolean enabled = true
	boolean accountLocked
	boolean accountExpired
	boolean passwordExpired

	Usuario(String email, String password, String nombre,String apellido) {
		this()
		this.email = email
		this.password = password
		this.nombre = nombre
		this.apellido = apellido
	}

	@Override
	int hashCode() {
		email?.hashCode() ?: 0
	}

	@Override
	boolean equals(other) {
		is(other) || (other instanceof Usuario && other.email == email)
	}

	@Override
	String toString() {
		email
	}

	Set<Rol> getAuthorities() {
		UsuarioRol.findAllByUsuario(this)*.rol
	}

	def beforeInsert() {
		encodePassword()
	}

	def beforeUpdate() {
		if (isDirty('password')) {
			encodePassword()
		}
	}

	protected void encodePassword() {
		password = springSecurityService?.passwordEncoder ? springSecurityService.encodePassword(password) : password
	}

	static transients = ['springSecurityService']

	static constraints = {
		email blank: false, unique: true
		password blank: false
	}

	static mapping = {
		password column: '`password`'
	}
}
