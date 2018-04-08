package stepdefs

import cucumber.api.DataTable
import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.By
import org.scalatest.Matchers
import pages.BasePage

import scala.collection.JavaConversions._

class BookingsStepDef extends BasePage with ScalaDsl with EN with Matchers {

  Given("""^I am on the hotel booking form page$""") { () =>
    go to baseUrl
    pageTitle shouldBe homePageTitle
  }

  When("""^I create the following bookings$""") { (dataTable: DataTable) =>
    createBooking(dataTable)
  }

  Then("""^I should see the bookings created on the list of bookings$""") { (dataTable: DataTable) =>
    var index = 0
    for (data: java.util.Map[String, String] <- dataTable.asMaps(classOf[String], classOf[String])) {
      driver.findElement(By.xpath(s"//div[@id='${rowIdList.get(index).getOrElse()}']/div[1]/p")).getText shouldBe (data.get("First name"))
      index = index + 1
    }
  }

  When("""^I delete recently created bookings$""") { (dataTable: DataTable) =>
    for (id <- rowIdList) {
      click on (xpath(s"//div[@id='$id']//div[@class='col-md-1']//input[@type='button']"))
      refreshPage()
    }
  }

  Then("""^the bookings should be deleted from the list of bookings$""") { () =>
    for (id <- rowIdList) {
      refreshPage()
      waitForElementInvisible(By.xpath(s"//div[@id='${id}']/div[1]/p"))
    }
  }
}

