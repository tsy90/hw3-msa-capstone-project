package msa.project.common;

import io.cucumber.spring.CucumberContextConfiguration;
import msa.project.DeliveryApplication;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { DeliveryApplication.class })
public class CucumberSpingConfiguration {}
