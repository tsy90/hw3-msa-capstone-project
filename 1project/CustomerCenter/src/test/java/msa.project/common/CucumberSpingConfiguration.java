package msa.project.common;

import io.cucumber.spring.CucumberContextConfiguration;
import msa.project.CustomerCenterApplication;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { CustomerCenterApplication.class })
public class CucumberSpingConfiguration {}
