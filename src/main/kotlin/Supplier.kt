import jakarta.persistence.*

@Entity
@Table(name = "Proveedor")
data class Supplier(

    @Column(name = "nombre")
    val name: String,

    @OneToMany(mappedBy = "supplier", cascade = [CascadeType.ALL])
    val products: List<Product> = emptyList(),

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?
)
