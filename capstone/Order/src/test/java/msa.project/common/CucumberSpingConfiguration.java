package msa.project.common;

import io.cucumber.spring.CucumberContextConfiguration;
import msa.project.OrderApplication;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { OrderApplication.class })
public class CucumberSpingConfiguration {}
