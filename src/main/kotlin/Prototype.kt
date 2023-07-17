class Prototype {
    // In real application this would be a database of users
    val allUsers = mutableListOf<User>()

    enum class Role {
        ADMIN,
        SUPER_ADMIN,
        REGULAR_USER
    }
    data class User(
        val name: String,
        val role: Role,
        val permissions: Set<String>,
    ) {
        fun hasPermission(permission: String) = permission in
                permissions
    }

    //  Data classes have  a copy() method, which takes an existing data class, and creates a new copy of it,
    //  optionally changing some of its attributes in the process
    fun createUser(_name: String, role: Role) {
        for (u in allUsers) {
            if (u.role == role) {
                allUsers += u.copy(name = _name)
                return
            }
        }
// Handle case that no other user with such a role exists
    }

}