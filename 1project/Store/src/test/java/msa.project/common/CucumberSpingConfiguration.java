package msa.project.common;

import io.cucumber.spring.CucumberContextConfiguration;
import msa.project.StoreApplication;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { StoreApplication.class })
public class CucumberSpingConfiguration {}
