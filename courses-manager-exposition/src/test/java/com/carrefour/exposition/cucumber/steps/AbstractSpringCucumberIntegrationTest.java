package com.carrefour.exposition.cucumber.steps;

import com.carrefour.exposition.cucumber.PixcelProxyCucumberSuiteRunnerTest;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ActiveProfiles({ "test" })
@SpringBootTest(classes = {
        CucumberConfiguration.class,
    PixcelProxyCucumberSuiteRunnerTest.class
    },
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public abstract class AbstractSpringCucumberIntegrationTest {

}
