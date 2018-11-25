
import koans.util.toMessage
import org.junit.Assert
import org.junit.Test

class K_Compound_Tasks {

    // Commented out line gives compilation error:
    //   "Assigning single elements to varargs in named form is forbidden"
    //
    // To fix, had to replace commented out line with *arrayOf
    @Test fun testMostExpensiveDeliveredProduct() {
        val testShop = shop("test shop for 'most expensive delivered product'",
                customer(lucas, Canberra,
//                        order(isDelivered = false, products = idea),
                        order(isDelivered = false, products = *arrayOf(idea)),
                        order(reSharper)
                )
        )
        Assert.assertTrue("getMostExpensiveDeliveredProduct".toMessage(), reSharper == testShop.customers[0].getMostExpensiveDeliveredProduct())
    }

    @Test fun testNumberOfTimesEachProductWasOrdered() {
        Assert.assertTrue("getNumberOfTimesProductWasOrdered".toMessage(), 3 == shop.getNumberOfTimesProductWasOrdered(reSharper))
    }
}
