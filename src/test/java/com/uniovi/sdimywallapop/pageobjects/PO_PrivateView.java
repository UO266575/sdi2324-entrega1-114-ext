package com.uniovi.sdimywallapop.pageobjects;

import com.uniovi.sdimywallapop.util.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PO_PrivateView extends PO_NavView {
    static public void fillFormAddOffer(WebDriver driver, String titlep, String descriptionp, String detailsp,
                                        String pricep)
    {
        //Esperamos 5 segundo a que carge el DOM porque en algunos equipos falla
        SeleniumUtils.waitSeconds(driver, 5);
        //Rellenemos el campo de título
        WebElement title = driver.findElement(By.name("title"));
        title.clear();
        title.sendKeys(titlep);
        //Rellenemos el campo de descripción
        WebElement description = driver.findElement(By.name("description"));
        description.clear();
        description.sendKeys(descriptionp);
        //Rellenemos el campo de detalles
        WebElement details = driver.findElement(By.name("details"));
        details.clear();
        details.sendKeys(detailsp);
        //Rellenemos el campo de detalles
        WebElement price = driver.findElement(By.name("price"));
        price.clear();
        price.sendKeys(pricep);
        By boton = By.className("btn");
        driver.findElement(boton).click();
    }

    static public void fillFormAddHighlightOffer(WebDriver driver, String titlep, String descriptionp, String detailsp,
                                        String pricep)
    {
        //Esperamos 5 segundo a que carge el DOM porque en algunos equipos falla
        SeleniumUtils.waitSeconds(driver, 5);
        //Rellenemos el campo de título
        WebElement title = driver.findElement(By.name("title"));
        title.clear();
        title.sendKeys(titlep);
        //Rellenemos el campo de descripción
        WebElement description = driver.findElement(By.name("description"));
        description.clear();
        description.sendKeys(descriptionp);
        //Rellenemos el campo de detalles
        WebElement details = driver.findElement(By.name("details"));
        details.clear();
        details.sendKeys(detailsp);
        //Rellenemos el campo de detalles
        WebElement price = driver.findElement(By.name("price"));
        price.clear();
        price.sendKeys(pricep);
        WebElement highlight = driver.findElement(By.name("destacado"));
        highlight.click();
        By boton = By.className("btn");
        driver.findElement(boton).click();
    }

    static public void fillFormAddOfferWithImage(WebDriver driver, String titlep, String descriptionp, String detailsp,
                                        String pricep, String image)
    {
        //Esperamos 5 segundo a que carge el DOM porque en algunos equipos falla
        SeleniumUtils.waitSeconds(driver, 5);
        //Rellenemos el campo de título
        WebElement title = driver.findElement(By.name("title"));
        title.clear();
        title.sendKeys(titlep);
        //Rellenemos el campo de descripción
        WebElement description = driver.findElement(By.name("description"));
        description.clear();
        description.sendKeys(descriptionp);
        //Rellenemos el campo de detalles
        WebElement details = driver.findElement(By.name("details"));
        details.clear();
        details.sendKeys(detailsp);
        //Rellenemos el campo de detalles
        WebElement price = driver.findElement(By.name("price"));
        price.clear();
        price.sendKeys(pricep);
        //Rellenemos el campo de la image
        WebElement imagen = driver.findElement(By.name("image"));
        imagen.clear();
        imagen.sendKeys(image);
        By boton = By.className("btn");
        driver.findElement(boton).click();
    }
    
    static public void refactorLogging(WebDriver driver, String email, String password) {
        //Vamos al formulario de logueo.
        PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
        //Rellenamos el formulario
        PO_LoginView.fillLoginForm(driver, email, password);
    }

    static public void refactorLogout(WebDriver driver, String text) {
        String loginText = PO_HomeView.getP().getString("signup.message", PO_Properties.getSPANISH());
        PO_PrivateView.clickOption(driver, text, "text", loginText);
    }

    public static void clickElement(WebDriver driver, String s, int i) {
        List<WebElement> elements = PO_View.checkElementBy(driver, "free", s);
        elements.get(i).click();
    }

    public static void changeLanguage(WebDriver driver, String language) {
        if (language.equals("Spanish")) {
            driver.findElement(By.xpath("//*[@id=\"btnLanguage\"]")).click();
            driver.findElement(By.xpath("//*[@id=\"btnSpanish\"]")).click();
        } else if (language.equals("English")) {
            driver.findElement(By.xpath("//*[@id=\"btnLanguage\"]")).click();
            driver.findElement(By.xpath("//*[@id=\"btnEnglish\"]")).click();
        }

    }
}

