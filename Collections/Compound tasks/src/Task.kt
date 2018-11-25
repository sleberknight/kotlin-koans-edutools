// Return the most expensive product among all delivered products
// (use the Order.isDelivered flag)
fun Customer.getMostExpensiveDeliveredProduct(): Product? {
    return orders
            .filter(Order::isDelivered)
            .flatMap(Order::products)
            .toSet()
            .maxBy(Product::price)
}

// Return how many times the given product was ordered.
// Note: a customer may order the same product for several times.
fun Shop.getNumberOfTimesProductWasOrdered(product: Product): Int {
    return customers
            .flatMap(Customer::orders)
            .flatMap(Order::products)
            .filter { it == product }
            .count()
}


