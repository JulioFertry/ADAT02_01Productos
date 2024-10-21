import jakarta.persistence.*
import java.util.Date

@Entity
@Table(name = "Producto")
data class Product(

    @Column(name = "nombre")
    val name: String,

    @Column(name = "descripcion")
    val description: String,

    @Column(name = "precio")
    val price: Double,

    @Column(name = "fecha_alta")
    val registerDate: Date,

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    var supplier: Supplier?,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Columna autoincremental
    val id: Long?
)