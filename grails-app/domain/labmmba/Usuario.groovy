package labmmba

class Usuario implements Serializable {
	static hasMany = [
	        study: Study,
			tesis: UserTesis,
			proyect: Proyect,
			book: UserBook
	]
	static belongsTo = [
	        area: InvestigationArea,
			charge: Charge,
	]
	private static final long serialVersionUID = 1

	transient springSecurityService

	String email
	String password
	String nombre
	String apellido
	boolean enabled = false
	boolean accountLocked
	boolean accountExpired
	boolean passwordExpired

	Usuario(String email, String password, String nombre, String apellido, boolean enabled, Charge charge) {
		this()
		this.email = email
		this.password = password
		this.nombre = nombre
		this.apellido = apellido
		this.enabled = enabled
		this.charge = charge
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
		tesis nullable: true
		area nullable: true
		charge nullable: true
	}

	static mapping = {
		password column: '`password`'
	}
}
