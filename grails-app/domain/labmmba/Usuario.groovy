package labmmba

class Usuario implements Serializable {
	static hasMany = [
	        study: Study,
			tesis: Usuario_tesis,
			book: Usuario_publicacion_libro,
			proyect: Usuario_proyecto,
			congress: Usuario_congreso,
			multi: Multimedia
	]
	static belongsTo = [
	        area: InvestigationArea,
			charge: Charge
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

	Usuario(String email, String password, String nombre, String apellido, boolean enabled, InvestigationArea area, Charge charge) {
		this()
		this.email = email
		this.password = password
		this.nombre = nombre
		this.apellido = apellido
		this.enabled = enabled
		this.area = area
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
	}

	static mapping = {
		password column: '`password`'
	}
}
