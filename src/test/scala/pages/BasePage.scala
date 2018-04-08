package pages

import java.lang
import java.util.concurrent.TimeUnit

import cucumber.api.DataTable
import org.openqa.selenium.support.ui._
import org.openqa.selenium.{By, WebDriver}
import org.scalatest.selenium.WebBrowser

import scala.collection.JavaConversions._
import scala.util.Try

trait BasePage extends WebBrowser with PagePaths{

  implicit val driver: WebDriver = Driver.createDriver()

  var rowIdList = scala.collection.mutable.MutableList[String]()

  val fluentWait: Wait[WebDriver] = new FluentWait[WebDriver](driver)
    .withTimeout(10, TimeUnit.SECONDS)
    .pollingEvery(1, TimeUnit.SECONDS)

  def refreshPage(): Unit = driver.navigate().refresh()

  def waitForElementInvisible(locator: By): lang.Boolean = new WebDriverWait(driver,10).until(ExpectedConditions.invisibilityOfElementLocated(locator))

  def createBooking(dataTable:DataTable) = {
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
      refreshPage()
      driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS)
      rowIdList += driver.findElement(By.xpath(s"//div[@id='bookings']/div/div/p[contains(text(),'$name')]/ancestor::div[@class='row']")).getAttribute("id")
    }
  }

  sys addShutdownHook {
    Try(driver.quit())
  }
}
