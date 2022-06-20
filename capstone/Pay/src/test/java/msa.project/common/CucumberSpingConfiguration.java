package msa.project.common;

import io.cucumber.spring.CucumberContextConfiguration;
import msa.project.PayApplication;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { PayApplication.class })
public class CucumberSpingConfiguration {}
