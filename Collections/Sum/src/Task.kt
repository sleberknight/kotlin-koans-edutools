// Return the sum of prices of all products that a customer has ordered.
// Note: the customer may order the same product for several times.
fun Customer.getTotalOrderPrice(): Double = orders
        .flatMap(Order::products)
        .toSet()
        .sumByDouble(Product::price)
