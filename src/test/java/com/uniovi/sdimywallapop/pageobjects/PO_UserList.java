package com.uniovi.sdimywallapop.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.uniovi.sdimywallapop.util.SeleniumUtils;

import java.util.List;

public class PO_UserList extends PO_View {

    public static void goToPage(WebDriver driver) {
        List<WebElement> elementos = PO_View.checkElementBy(driver, "free",
                "//li[contains(@id, 'users-menu')]/a");
        elementos.get(0).click();
        elementos = PO_View.checkElementBy(driver, "free",
                "//a[contains(@href, 'user/list')]");
        elementos.get(0).click();
    }

    public static void deleteUser(WebDriver driver, int... indexes) {
        List<WebElement> checkboxes = PO_View.checkElementBy(driver, "class",
                "checkBox");
        for (int i : indexes)
            checkboxes.get(i).click();
        List<WebElement> btnDelete = PO_View.checkElementBy(driver, "id",
                "delete");
        btnDelete.get(0).click();
    }

    static public void checkChangeIdiom(WebDriver driver, String textIdiom1,
                                        String textIdiom2, int locale1, int locale2) {
        SeleniumUtils.EsperaCargaPagina(driver, "text",
                p.getString("user.title", locale1), getTimeout());
        SeleniumUtils.EsperaCargaPagina(driver, "text",
                p.getString("user.system", locale1), getTimeout());
        SeleniumUtils.EsperaCargaPagina(driver, "text",
                p.getString("delete.button", locale1), getTimeout());
        // Cambiamos a segundo idioma
        PO_NavView.changeLanguage(driver, textIdiom2);
        SeleniumUtils.EsperaCargaPagina(driver, "text",
                p.getString("user.title", locale2), getTimeout());
        SeleniumUtils.EsperaCargaPagina(driver, "text",
                p.getString("user.system", locale2), getTimeout());
        SeleniumUtils.EsperaCargaPagina(driver, "text",
                p.getString("delete.button", locale2), getTimeout());
        // Volvemos a Español.
        PO_NavView.changeLanguage(driver, textIdiom1);
        SeleniumUtils.EsperaCargaPagina(driver, "text",
                p.getString("user.title", locale1), getTimeout());
        SeleniumUtils.EsperaCargaPagina(driver, "text",
                p.getString("user.system", locale1), getTimeout());
        SeleniumUtils.EsperaCargaPagina(driver, "text",
                p.getString("delete.button", locale1), getTimeout());
    }
}