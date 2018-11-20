import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\Admin\\IdeaProjects\\Tea\\src\\test\\java\\TeaTesting.feature")
public class teaTest {

    static ExtentReports report;
    static ExtentTest test;

    @BeforeClass
    public static void setup(){
        report = new ExtentReports("C:\\Users\\Admin\\IdeaProjects\\Tea\\src\\test\\java\\report.html", true);
    }


    @AfterClass
    public static void tearDown(){
        report.flush();
    }


}
