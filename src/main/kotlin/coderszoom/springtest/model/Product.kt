package coderszoom.springtest.model

import com.fasterxml.jackson.annotation.JsonAlias
import com.fasterxml.jackson.annotation.JsonGetter
import com.fasterxml.jackson.annotation.JsonInclude
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@JsonInclude(JsonInclude.Include.NON_NULL)
data class Product(
    var sku: Long,
    val name: String,
    val inventory: Inventory
) {
    @JsonGetter
    @JsonAlias("isMarketable")
    fun marketable(): Boolean {
        return inventory.quantity() > 0
    }
}

@JsonInclude(JsonInclude.Include.NON_NULL)
data class Inventory(
    val warehouses: List<Warehouse> = listOf()
) {
    @JsonGetter
    @JsonAlias("quantity")
    fun quantity(): Long {
        return warehouses.sumOf { it.quantity }
    }
}

@JsonInclude(JsonInclude.Include.NON_NULL)
data class Warehouse(
    val locality: String,
    val quantity: Long,
    val type: ProductType
)

enum class ProductType {
    ECOMMERCE,
    PHYSICAL_STORE
}

@ResponseStatus(HttpStatus.BAD_REQUEST, reason = "Produto já cadastrado")
class ProductAlreadyExistsException : RuntimeException ()

@ResponseStatus(HttpStatus.NOT_FOUND, reason = "Produto não encontrado")
class ProductNotFoundException : RuntimeException ()