package coderszoom.springtest.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Test

class ProductTest {

    @Test
    fun shouldBeMarketableTrueWhenHasItemInInventory() {
        assertTrue(productMarketable().marketable())
    }

    @Test
    fun shouldBeMarketableFalseWhenHasNotItemInInventory() {
        assertFalse(productNotMarketable().marketable())
    }

    @Test
    fun countTotalItemInWarehouses() {
        val product = productMarketable()
        assertEquals(23, product.inventory.quantity())
    }

    private fun productMarketable(): Product {
        return Product(
            sku = 12345,
            name = "Um item qualquer",
            inventory = Inventory(
                warehouses = listOf(
                    Warehouse(
                        locality = "SP",
                        quantity = 11,
                        type = ProductType.ECOMMERCE
                    ),
                    Warehouse(
                        locality = "SP",
                        quantity = 12,
                        type = ProductType.ECOMMERCE
                    )
                )
            )
        )
    }

    private fun productNotMarketable(): Product {
        return Product(
            sku = 12345,
            name = "Um item qualquer",
            inventory = Inventory(
                warehouses = listOf(
                    Warehouse(
                        locality = "SP",
                        quantity = 0,
                        type = ProductType.ECOMMERCE
                    ),
                    Warehouse(
                        locality = "SP",
                        quantity = 0,
                        type = ProductType.ECOMMERCE
                    )
                )
            )
        )
    }
}