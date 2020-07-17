package testRunnerTestNG;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.PickleEventWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

@CucumberOptions(
       //  features = "./features"
        features = "E:\\CUCUMBER BIBLIOTEKI I WSZYSTKO\\ProjektMavenTestNGwithCucumber\\src\\main\\java\\featuresTestNG"
      // zle  features = {"E:\\CUCUMBER BIBLIOTEKI I WSZYSTKO\\ProjektMavenTestNGwithCucumber\\src\\test\\java\\featuresTestNG"}
      //  , glue = {"E:\\CUCUMBER BIBLIOTEKI I WSZYSTKO\\ProjektMavenTestNGwithCucumber\\src\\main\\java\\stepsDefinitionsTestNG"}
       , glue = {"stepsDefinitionsTestNG"}
      // zle  , glue = {"E:\\CUCUMBER BIBLIOTEKI I WSZYSTKO\\ProjektMavenTestNGwithCucumber\\src\\test\\java\\stepsDefinitionsTestNG"}
      //  , tags = {"@grupaScenariuszy"}
      //  , tags = {"@test5_DodaniePrzedmiotuDoKoszyka"}
     //   , tags = {"@test1_poprawneLogowanie"}
     //   , plugin = {"pretty", "html:target/site/cucumber-pretty", "json:target/cucumber.json"}
      //  , tags = {"@test5_DodaniePrzedmiotuDoKoszyka"}

        , tags = {"@test_z_waiterem"}


     //   , monochrome = true
)



public class RunnerTestNG {



    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass(alwaysRun = true)
    public void setUpClass() throws Exception {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }






    @Test(dataProvider =  "features")
    public void feature(PickleEventWrapper eventwrapper, CucumberFeatureWrapper cucumberFeature) throws Throwable {
        //testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
        testNGCucumberRunner.runScenario(eventwrapper.getPickleEvent());
    }



    @DataProvider//(parallel=true)
    public Object[][] features() {
        // return testNGCucumberRunner.provideFeatures();
        return testNGCucumberRunner.provideScenarios();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() throws Exception {
        testNGCucumberRunner.finish();
    }



}
