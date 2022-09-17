package com.ic.projects.laudoecia.view.utils;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConfigurandoMensagem {

	public void EnviandoArquivo(WebDriver driver, String caminho, String numero) {		
		try{
			driver.get("https://web.whatsapp.com");
			
			String clip = "span[data-icon='clip']";
			String chat = "span[data-icon='chat']";
			
			WebDriverWait wait = new WebDriverWait(driver, 59);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(chat)));
			
			driver.get(driver.getCurrentUrl() + "send?phone=55" + numero );
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(clip)));		
			driver.findElement(By.cssSelector(clip)).click();
			driver.findElement(By.cssSelector("input[type='file']")).sendKeys(caminho);
		} catch (Exception e){
			driver.quit();
			JOptionPane.showMessageDialog(null, "QRCODE não foi escaneado!! tente novamente");
		}
	}
	
}
