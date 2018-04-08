package pages

import java.util.concurrent.TimeUnit

import org.openqa.selenium.By
import org.openqa.selenium.interactions.Actions

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

  sys addShutdownHook{
    Try(driver.quit())
  }
}
