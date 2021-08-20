package coderszoom.springtest.controllers

import coderszoom.springtest.model.Product
import coderszoom.springtest.services.InventoryService
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.noContent
import org.springframework.http.ResponseEntity.ok
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/v1/inventory")
class InventoryController(
    private val inventoryService: InventoryService
) {

    @PostMapping
    fun create(@RequestBody product: Product): ResponseEntity<Any> {
        return ok(inventoryService.addProduct(product))
    }

    @GetMapping("/{sku}")
    fun get(@PathVariable("sku") sku: Long): ResponseEntity<Any> {
        return ok(inventoryService.getProduct(sku))
    }

    @PutMapping("/{sku}")
    fun edit(
        @PathVariable("sku") sku: Long,
        @RequestBody product: Product
    ): ResponseEntity<Any> {

        return ok(inventoryService.editProduct(sku, product))
    }

    @DeleteMapping("/{sku}")
    fun delete(@PathVariable("sku") sku: Long): ResponseEntity<Any> {
        inventoryService.deleteProduct(sku)
        return noContent().build()
    }
}