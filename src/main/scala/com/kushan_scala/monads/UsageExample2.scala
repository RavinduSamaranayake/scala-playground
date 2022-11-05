package com.kushan_scala.monads

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.Success

object UsageExample2 extends App {
//async fetch
  case class User(id: String)
  case class Product(sku:String,price:Double)

  def getUser(url: String): Future[User] = Future {
    User("Kushan") //sample implementation
  }

  def getLastOrder(userId: String): Future[Product] = Future {
    Product(s"123-34-$userId",123.90)
  }
  val webUrl = "kushan.ravindu.org/users/kushan"
  //Normal Way to fetch
  getUser(webUrl).onComplete{ //Notice we have the ETW pattern over and over again
    case Success(User(id)) =>
      val lastOrder: Unit = getLastOrder(id).onComplete{
        case Success(Product(sku,price)) =>
          val vatIncludePrice = 1.9*price
          println(s"Send Email to User : $id  with Order ID: $sku and Price : $vatIncludePrice")
      }
  } // this approach really bad,very nested,hard to read and doesn't cover all the cases any where, so you needs to accounts for failures as well

  //notice you following same pattern over and over again and you can compress that to flatMap
  val vatIncludedPrice: Future[Double] = getUser(webUrl).flatMap(user => getLastOrder(user.id))
    .map(order => order.price.*(1.9))

  vatIncludedPrice.onComplete(value => println(value))

  println(s"Price from FlatMap approach : $vatIncludedPrice")

  //using for comprehensive
  val vatIncludedPriceFor: Future[Double] = for {
    user <- getUser(webUrl)
    product <- getLastOrder(user.id)
  } yield product.price.*(1.9)

  println(s"Price from For comprehensive approach : $vatIncludedPriceFor")
}
