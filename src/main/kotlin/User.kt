import jakarta.persistence.*

@Entity
@Table(name = "Usuario")
data class User(

    @Column(name = "contraseña", nullable = false, length = 20)
    var password: String,

    @Id
    val username: String
)