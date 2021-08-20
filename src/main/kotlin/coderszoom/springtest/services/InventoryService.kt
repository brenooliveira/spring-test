package coderszoom.springtest.services

import coderszoom.springtest.model.Product
import coderszoom.springtest.model.ProductAlreadyExistsException
import coderszoom.springtest.model.ProductNotFoundException
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Service

@Service
@Scope("singleton")
class InventoryService {

    private val products = mutableMapOf<Long, Product>()

    fun addProduct(product: Product): Product {
        val exists = products.containsKey(product.sku)
        if (exists) throw ProductAlreadyExistsException()
        products[product.sku] = product
        return product
    }

    fun editProduct(sku: Long, newProduct: Product): Product {
        return when (products[sku]) {
            null -> throw ProductNotFoundException()
            else ->  {
                newProduct.sku = sku
                products[sku] = newProduct

                newProduct
            }
        }
    }

    fun deleteProduct(sku: Long) {
        val exists = products.containsKey(sku)
        if (!exists) throw ProductNotFoundException()

        products.remove(sku)
    }

    fun getProduct(sku: Long): Product? {
        return when (val product = products[sku]) {
           null -> throw ProductNotFoundException()
           else -> product
        }
    }
}