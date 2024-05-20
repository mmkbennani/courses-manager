package com.carrefour.exposition.cucumber.steps;


import org.junit.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

public class InitSteps extends AbstractSpringCucumberIntegrationTest implements CommandLineRunner {
    private static final Logger log = LoggerFactory.getLogger(InitSteps.class);

    @Autowired
    private ApplicationContext appContext;

   
    public InitSteps() {
    }

    @Before()
    public void reset() {
//        resetMock(sendOptionsConfigurationsService);
    }

    /**
     * Log the list of the beans loaded in Spring Context on startup
     *
     * @param args
     * @throws Exception
     */
    public void run(String... args) throws Exception {

        String[] beans = appContext.getBeanDefinitionNames();
        Arrays.sort(beans);
        for (String bean : beans) {
            log.debug("{}", bean);
        }

    }
}
