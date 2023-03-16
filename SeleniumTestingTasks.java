package proPractice;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
public class SeleniumTestingTasks {
	public static void main(String[] args) throws Throwable {
		WebDriver driver = new EdgeDriver();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://timvroom.com/selenium/playground/");
		
//		1.Grab page title and place title text in answer slot #1
		String T1 = driver.getTitle();
		driver.findElement(By.xpath("//input[@id=\"answer1\"]")).sendKeys(T1);
		
//	    2.Fill out name section of form to be Kilgore Trout
	    driver.findElement(By.xpath("//input[@id=\"name\"]")).sendKeys("Kilgore Trout");
	    
//	    3.Set occupation on form to Sci-Fi Author
	    WebElement ocu = driver.findElement(By.name("occupation"));
	    Select T3 = new Select(ocu);
	    T3.selectByIndex(2);
	    
//	    4.Count number of blue_boxes on page after form and enter into answer box #4
	   List<WebElement> allbox = driver.findElements(By.xpath("//span[@class=\"bluebox\"]"));
	   int count=0;
	   for(WebElement b1:allbox) {
		   count++;
	   }
	   driver.findElement(By.id("answer4")).sendKeys(String.valueOf(count));
	   
//	   5.Click link that says 'click me'
	   driver.findElement(By.xpath("//a[text()=\"click me\"]")).click();
	   
//	   6.Find red box on its page find class applied to it, and enter into answer box #6
	  String T6 = driver.findElement(By.id("redbox")).getAttribute("class");
	   driver.findElement(By.xpath("//input[@id=\"answer6\"]")).sendKeys(T6);
	   
//	   7.Run JavaScript function as: ran_this_js_function() from your Selenium script
	   JavascriptExecutor js=(JavascriptExecutor) driver;
	   js.executeScript("ran_this_js_function();");
	   
	   Thread.sleep(2000);
	   
//	   8.Run JavaScript function as: got_return_from_js_function() from your Selenium script,
//	   take returned value and place it in answer slot #8
	   
	   Object returnValue = js.executeScript("return got_return_from_js_function();");
	   driver.findElement(By.xpath("//input[@id=\"answer8\"]")).sendKeys(returnValue.toString());
	   
	   Thread.sleep(2000);
	   
//	   9.Mark radio button on form for written book? to Yes
	   ocu.sendKeys(Keys.TAB,Keys.SPACE);
	   
//     10.Get the text from the Red Box and place it in answer slot #10
	   String T10 = driver.findElement(By.xpath("//span[@id='redbox']")).getText();
       driver.findElement(By.xpath("//input[@id='answer10']")).sendKeys(T10);
      
       Thread.sleep(2000);
       
//	   11.Which box is on top? orange or green -- place correct color in answer slot #11
        Point orange = driver.findElement(By.id("orangebox")).getLocation();
        Point green = driver.findElement(By.id("greenbox")).getLocation();
        Thread.sleep(2000);
       if(orange.getX()>green.getX()) {
    	   driver.findElement(By.xpath("//input[@id='answer11']")).sendKeys("orange");
       }
       else {
    	   driver.findElement(By.xpath("//input[@id='answer11']")).sendKeys("green");
       } 
       
       Thread.sleep(1000);
       
//	   12.Set browser width to 850 and height to 650 
       Dimension dim=new Dimension(850,650);
       driver.manage().window().setSize(dim);
       
       Thread.sleep(2000);
       
//	   13.Type into answer slot 13 yes or no depending on whether item by id of ishere is on the page
       List<WebElement>  ishere= driver.findElements(By.xpath("//div[@id='ishere']"));
       int count1=0;
	for( WebElement T13:ishere) {
		count++;
	}
       if(count1==1)
       {
    	   driver.findElement(By.id("answer13")).sendKeys("yes");
       }
       else {
    	   driver.findElement(By.id("answer13")).sendKeys("no");
       }
       
       Thread.sleep(2000);
       
//	   14.Type into answer slot 14 yes or no depending on whether item with id of purplebox is visible
    WebElement purplebox = driver.findElement(By.id("purplebox"));
   if(purplebox.isDisplayed())
   {
	   driver.findElement(By.id("answer14")).sendKeys("yes");
   }
   else {
	   driver.findElement(By.id("answer14")).sendKeys("no");
   }
   
        Thread.sleep(1000);
   
//	   15.Waiting game: click the link with link text of 'click then wait' a random wait will occur (up to 10 seconds) 
//       and then a new link will get added with link text of 'click after wait' - 
//       click this new link within 500 ms of it appearing to pass this test
       driver.findElement(By.xpath("//a[text()='click then wait']")).click();
       Thread.sleep(100);
       driver.findElement(By.xpath("//a[text()='click after wait']")).click();
       
//	   16.Click OK on the confirm after completing task 15
       driver.switchTo().alert().accept();
       
       Thread.sleep(2000);
       
//	   17.Click the submit button on the form
       driver.findElement(By.id("submitbutton")).submit();
       
//       Checkresults
       driver.findElement(By.id("checkresults")).click();
	}

}
