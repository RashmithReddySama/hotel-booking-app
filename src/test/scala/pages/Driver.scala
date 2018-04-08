package pages

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.{ChromeDriver, ChromeDriverService}
import org.openqa.selenium.firefox.{FirefoxDriver, FirefoxOptions, FirefoxProfile}

object Driver {

  lazy val isMac: Boolean = System.getProperty("os.name").startsWith("Mac")

  if (isMac) {
    System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver")
    System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY,"./drivers/chromedriver")
  }

  val browser = System.getProperty("browser", "chrome")

  def createDriver(): WebDriver = browser match {
    case "firefox" => createFirefoxDriver()
    case "chrome" => createChromeDriver()
  }

  def createFirefoxDriver(): WebDriver = {
    System.setProperty("webdriver.gecko.driver", "./drivers/firefox/geckodriver")
    val options: FirefoxOptions = new FirefoxOptions()
    System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true")
    System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null")
    val profile: FirefoxProfile = new FirefoxProfile()
    profile.setPreference("javascript.enabled", true)
    profile.setAcceptUntrustedCertificates(true)
    options.setProfile(profile)
    options.setAcceptInsecureCerts(true)
    val driver = new FirefoxDriver(options)
    //    println(s"Browser version is ${capabilities.getVersion}")
    driver
  }

  def createChromeDriver(): WebDriver = {
    val driver = new ChromeDriver()
    driver
  }

}
