package com.uniovi.sdimywallapop.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PO_ConversationView extends PO_NavView {
    static public void sendMessage(WebDriver driver, String offerName, String message) {
        // Buscamos por título
        WebElement input = driver.findElement(By.name("searchText"));
        input.click();
        input.clear();
        input.sendKeys(offerName);
        // Seleccionamos buscar
        driver.findElement(By.xpath("//*[@id=\"main-container\"]/form/button")).click();
        // Abrimos la ventana de iniciar conversación
        driver.findElement(By.xpath("//*[@id=\"tableOffers\"]/tbody/tr/td[7]/a")).click();
        // Escribimos un mensaje y lo enviamos
        input = driver.findElement(By.name("text"));
        input.click();
        input.clear();
        input.sendKeys(message);
        By boton = By.id("sendMessage");
        driver.findElement(boton).click();
    }
}
