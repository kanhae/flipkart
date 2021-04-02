package packag;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class flipkart {
  @Test
  public void flipkart() throws InterruptedException {
	  //Launch Chrome Browser
	  
	  System.setProperty("webdriver.chrome.driver","/home/pratyush/Music/chromedriver_linux64/chromedriver");
		 WebDriver driver = new ChromeDriver();
		 
		//Move to mobile section apple mobile below 40000
		  driver.get("https://www.flipkart.com/search?sid=tyy%2C4io&otracker=CLP_Filters&p%5B%5D=facets.brand%255B%255D%3DAPPLE&p%5B%5D=facets.price_range.from%3DMin&p%5B%5D=facets.price_range.to%3D50000");
		  driver.manage().window().maximize();   
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  Thread.sleep(3000);
		  
		  //Count the number of pages available for above searches with required filter
		  List<WebElement> web = driver.findElements(By.xpath("//div[@class='_2MImiq']/nav/a"));
		  
		 //Start operation from page number 1 and onwards
		  for(int n=1; n< web.size();n++)
	         {
			  //Find the available number of searches from page 1 and onwards
			  List<WebElement> web1 = driver.findElements(By.xpath("//*[@class='_1YokD2 _3Mn1Gg'][@style='flex-grow:1;overflow:auto']/div")); 
		     	 for(int i=1; i< web1.size();i++)
		     	 {
		     		
		     	int	j=i+1;
		     		 try {
		     			 //Find the phone price 
		     			WebElement price= driver.findElement(By.xpath("//*[@class='_1YokD2 _3Mn1Gg'][@style='flex-grow:1;overflow:auto']/div["+j+"]/div/div/div/a/div[2]/div[2]/div[1]/div/div"));
		     		   
		     			String s=price.getText();
		     			
		     			//Convert phone price to integer from string
                        String newStr=s.replaceAll("[₹,]", "");
		         		int p=Integer.parseInt(newStr);
		         		
		         		//Find out the phone name with storage
		         		WebElement phonename= driver.findElement(By.xpath("//*[@class='_1YokD2 _3Mn1Gg'][@style='flex-grow:1;overflow:auto']/div[2]/div/div/div/a/div[2]/div/div["+i+"]"));
		         		
		         		//Find rating of the phone
		         		WebElement rating= driver.findElement(By.xpath("//*[@class='_1YokD2 _3Mn1Gg'][@style='flex-grow:1;overflow:auto']/div["+j+"]/div/div/div/a/div[2]/div/div[2]"));
		         		//Print those phone names whose price are below 40000
		         		if (p<40000) {
		         			
		         			System.out.println(phonename.getText());
		         			System.out.println(rating.getText());
		         			 System.out.println(p);
		         		}
		     		 } catch (Exception e) {
						// TODO: handle exception
					}
	         
		     	 }}}}
	         
	         
