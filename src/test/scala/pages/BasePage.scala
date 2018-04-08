package pages

import java.lang
import java.util.concurrent.TimeUnit

import org.openqa.selenium.{By, WebDriver}
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.support.ui.{ExpectedConditions, FluentWait, Wait}

import scala.util.Try

trait BasePage {

  implicit val driver: WebDriver = Driver.createDriver()

  val waitForPageToBELoaded: WebDriver.Timeouts = driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)

  def clickOn(locator: By): Unit = {
    driver.findElement(locator).click()
  }

  def moveToElement(locator: By): Unit = {
    val element = driver.findElement(locator)
    var actions: Actions = new Actions(driver)
    actions.moveToElement(element).click().perform()
  }

  val fluentWait: Wait[WebDriver] = new FluentWait[WebDriver](driver)
    .withTimeout(10, TimeUnit.SECONDS)
    .pollingEvery(1, TimeUnit.SECONDS)

  def refreshPage(): Unit = driver.navigate().refresh()

  def waitForElementInvisible(locator: By): lang.Boolean = fluentWait.until(ExpectedConditions.invisibilityOfElementLocated(locator))

  sys addShutdownHook {
    Try(driver.quit())
  }
}
