package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features", // direktori file" feature
        glue = "step", // inisialisasi memanggil file" stepDef, disini kita memulai defini folder cucumber setelah folder java
        plugin = {"html:target/HTML_report.html"} // membuat report berbentuk HTML
)
public class RunStep {
}
