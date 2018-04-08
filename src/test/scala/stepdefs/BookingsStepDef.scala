package stepdefs

import java.util.concurrent.TimeUnit

import cucumber.api.DataTable
import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.support.ui.{ExpectedConditions, FluentWait, Select, Wait}
import org.openqa.selenium.{By, WebDriver}
import org.scalatest.Matchers
import org.scalatest.concurrent.Eventually
import org.scalatest.selenium.WebBrowser
import pages.BasePage

import scala.collection.JavaConversions._

class BookingsStepDef extends WebBrowser with Eventually with BasePage with ScalaDsl with EN with Matchers {

  val fluentWait: Wait[WebDriver] = new FluentWait[WebDriver](driver)
    .withTimeout(10, TimeUnit.SECONDS)
    .pollingEvery(1, TimeUnit.SECONDS)

  var rouIdList = scala.collection.mutable.MutableList[String]()

  def waitForElementInvisible(locator: By) = fluentWait.until(ExpectedConditions.invisibilityOfElementLocated(locator))

  Given("""^I am on the hotel booking form page$""") { () =>
    go to ("http://hotel-test.equalexperts.io/")
    pageTitle shouldBe "Hotel booking form"
  }


  When("""^I create the following bookings$""") { (dataTable: DataTable) =>

    for (data: java.util.Map[String, String] <- dataTable.asMaps(classOf[String], classOf[String])) {
      var name = data.get("First name")
      textField("firstname").value = data.get("First name")
      textField("lastname").value = data.get("Surname")
      textField("totalprice") value = data.get("Price")
      val select = new Select(driver.findElement(By.id("depositpaid")))
      select.selectByVisibleText(data.get("Deposit"))
      textField("checkin") value = data.get("Check in")
      textField("checkout") value = data.get("Check in")
      click on (xpath("//*[@value=' Save ']"))
      driver.navigate().refresh()
      rouIdList += driver.findElement(By.xpath(s"//div[@id='bookings']/div/div/p[contains(text(),'$name')]/ancestor::div[@class='row']")).getAttribute("id")
    }
    print("@@@@@@@@@@@@@@ " + rouIdList)
  }

  Then("""^I should see the bookings created on the list of bookings$""") { (dataTable: DataTable) =>
    var index = 0
    for (data: java.util.Map[String, String] <- dataTable.asMaps(classOf[String], classOf[String])) {

      driver.findElement(By.xpath(s"//div[@id='${rouIdList.get(index).getOrElse()}']/div[1]/p")).getText shouldBe (data.get("First name"))
      index = index + 1
    }
  }

  When("""^I delete recently created bookings$""") { (dataTable: DataTable) =>
    for (id <- rouIdList) {
      click on (xpath(s"//div[@id='$id']//div[@class='col-md-1']//input[@type='button']"))
      driver.navigate().refresh()
    }

  }

  Then("""^the bookings should be deleted from the list of bookings$""") { () =>
    for (id <- rouIdList) {
      driver.navigate().refresh()
      waitForElementInvisible(By.xpath(s"//div[@id='${id}']/div[1]/p"))
    }
  }
}

