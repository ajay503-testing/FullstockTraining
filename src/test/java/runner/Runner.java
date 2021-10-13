package runner;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="D:\\FullStackTesterTraining\\RealityDomain\\Feature\\RETC_003.feature",glue= {"stepdefination"})

public class Runner {

}
