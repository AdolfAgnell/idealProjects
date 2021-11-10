package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InformacoesUsuarioTest {
    @Test
    public void testAdicionarUmaInformacaoAdicionalDoUsuario () {
        // Abrindo o navegador
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\drivers\\chromedriver.exe");
        WebDriver navegador = new ChromeDriver();

        // Navegando para a pagina do youtube!


        navegador.manage().window().maximize();
        navegador.get("http://www.youtube.com.br");


        assertEquals(1,1);
    }
}
