package com.uniovi.sdimywallapop.pageobjects;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PO_LoginView extends PO_NavView {
    static public void fillLoginForm(WebDriver driver, String usernamep, String passwordp) {
        WebElement username = driver.findElement(By.name("username"));
        username.click();
        username.clear();
        username.sendKeys(usernamep);
        WebElement password = driver.findElement(By.name("password"));
        password.click();
        password.clear();
        password.sendKeys(passwordp);
        // Pulsar el boton de Alta.
        By boton = By.id("enviar");
        driver.findElement(boton).click();
    }

    static public void fillForm(WebDriver driver, String emailp, String passwordp) {
        //Vamos al formulario de registro
        clickOption(driver, "login", "class", "btn btn-primary");
        WebElement dni = driver.findElement(By.name("email"));
        dni.click();
        dni.clear();
        dni.sendKeys(emailp);
        WebElement password = driver.findElement(By.name("password"));
        password.click();
        password.clear();
        password.sendKeys(passwordp);
        //Pulsar el boton de Alta.
        By boton = By.className("btn");
        driver.findElement(boton).click();
    }

    public static void loginAsAdmin(WebDriver driver) {

        //Rellenamos el formulario.
        fillForm(driver, "admin@email.com", "admin");
        String text = "Los usuarios que actualmente figuran en el sistema son los siguientes:";
        List<WebElement> result = checkElementBy(driver, "text", text);
        Assertions.assertEquals(text, result.get(0).getText());
    }
}