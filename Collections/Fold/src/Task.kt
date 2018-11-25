// Return the set of products that were ordered by every customer
fun Shop.getSetOfProductsOrderedByEveryCustomer(): Set<Product> {

    val allOrderedProducts = customers
            .flatMap(Customer::orders)
            .flatMap(Order::products)
            .toSet()

    // Attempt #1 - filters allOrderedProducts then convert to Set
/*
    return allOrderedProducts
            .filter(this::allCustomersHaveOrdered)
            .toSet()
*/

    // Attempt #2 - uses fold but uses (ugly?) mutableSet as accumulator and a conditional
    return allOrderedProducts.fold(mutableSetOf()) { productsOrderedByAll, product ->
        if (allCustomersHaveOrdered(product)) {
            productsOrderedByAll.add(product)
        }
        productsOrderedByAll
    }

    // Solution as given by Koans:

/*
    val allProducts: Set<Product> = customers.flatMap { it.orders.flatMap { it.products } }.toSet()

    return customers.fold(allProducts, { orderedByAll: Set<Product>, customer: Customer ->
        orderedByAll.intersect(customer.orders.flatMap { it.products }.toSet())
    })
*/

    // Using intersect will create a lot more intermediate objects, since it returns a new Set
    // which is not the best thing. I doubt would have come up with their solution without a
    // hint about using intersect...

}

private fun Shop.allCustomersHaveOrdered(product: Product): Boolean {
    return customers.all { customer ->
        customer.orders.any { order -> order.products.contains(product) }
    }
}
