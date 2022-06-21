package msa.project.common;

import io.cucumber.spring.CucumberContextConfiguration;
import msa.project.StoreCenterApplication;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { StoreCenterApplication.class })
public class CucumberSpingConfiguration {}
