import jakarta.persistence.EntityManager
import jakarta.persistence.EntityManagerFactory
import jakarta.persistence.Persistence
import java.time.Instant
import java.util.*

fun main() {

    // Cargar la configuración que queremos del persistence.xml
    val emf: EntityManagerFactory = Persistence.createEntityManagerFactory("unidadMySQL")
    // Abre la conexión con la base de datos -> em contiene la conexión
    val em: EntityManager = emf.createEntityManager()

    // Abre la transacción
    em.transaction.begin()

    val fecha = Date.from(Instant.now())

    // Usuario
    val user1 = User("12345abcde", "Juan Eustaquio")

    // Productos
    val prod1 = Product("Alcachofa", "Ricas alcachofas", 3.30, fecha, null, null)
    val prod2 = Product("Garbanzo", "Ricos garbanzos", 1.75, fecha, null, null)
    val prod3 = Product("Lechuga", "Rica lechuga", 1.10, fecha, null, null)
    // Lista de productos
    val verduras = listOf(prod1, prod2, prod3)

    val sup1 = Supplier("Verdulería Juana", verduras, null)

    // Asigna el proveedor a los productos
    prod1.supplier = sup1
    prod2.supplier = sup1
    prod3.supplier = sup1

    // Persiste los elementos
    em.persist(user1)
    // Gracias al campo Cascade.ALL al persistir el supplier tambien persisten los productos
    em.persist(sup1)

    // Empuja los cambios a la BD
    em.transaction.commit()
    // Cierra la conexión con la BD
    em.close()
    emf.close()
}