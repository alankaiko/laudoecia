package com.ic.projects.laudoecia.view.utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class EnvioZap {
	private WebDriver driver;
	private String caminhochrome = DiretorioDoSistemaUtil.PegaDiretorioChrome() + "\\chromedriver.exe";

	@SuppressWarnings("deprecation")
	public EnvioZap() throws IOException {
		System.setProperty("webdriver.chrome.driver", this.caminhochrome);
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("test-type");
		//options.addArguments("start-maximized");
		options.addArguments("user-data-dir=C:/temp/temporario");
		options.addArguments("--ignore-certificate-errors");
		options.addArguments("--disable-popup-blocking");
		capabilities.setCapability("chrome.binary", this.caminhochrome);
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		this.driver = new ChromeDriver(capabilities);

	}

	public void EnviandoPara(String numero, String caminho) throws InterruptedException {
		ConfigurandoMensagem vm = new ConfigurandoMensagem();
		vm.EnviandoArquivo(this.driver, caminho, numero);
	}
}
