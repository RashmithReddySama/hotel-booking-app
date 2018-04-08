package pages

import java.util.concurrent.TimeUnit

import org.openqa.selenium.{By, WebDriver}
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.support.ui.{FluentWait, Wait}

import scala.util.Try

trait BasePage {

  implicit val driver = Driver.createDriver()
  val waitForPageToBELoaded = driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)

  def clickOn(locator:By) = {
    driver.findElement(locator).click()
  }

  def moveToElement(locator:By) = {
    val element = driver.findElement(locator)
    var actions : Actions = new Actions(driver)
    actions.moveToElement(element).click().perform()
  }

  val fluentWait: Wait[WebDriver] = new FluentWait[WebDriver](driver)
    .withTimeout(10, TimeUnit.SECONDS)
    .pollingEvery(1, TimeUnit.SECONDS)

  sys addShutdownHook{
    Try(driver.quit())
  }
}
