import jakarta.persistence.*

@Entity
@Table(name = "Usuario")
data class User(

    @Column(name = "contraseña", nullable = false, length = 20)
    val password: String,

    @Id
    val username: String
)