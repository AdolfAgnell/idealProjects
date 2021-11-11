package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class InformacoesUsuarioTest {
    private  WebDriver navegador;

// Informacoes que vao ocorrer antes de iniciar o test
    @Before
    public void setUp() {
// Abrindo o navegador
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\drivers\\chromedriver.exe");
        navegador = new ChromeDriver();
        // Aplicando um timeout para aguarda a resposta da pagina
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        // Maximizar o navegador abrindo uma janela
        navegador.manage().window().maximize();

    // Navegando para a pagina do taskit
        navegador.get("http://www.juliodelima.com.br/taskit/");
    }
    @Test
    public void testAdicionarUmaInformacaoAdicionalDoUsuario () {
        // Clicar no link que possui o texto "Sign in"
        navegador.findElement(By.linkText("Sign in")).click();

        // Identificando o formulario de login
        WebElement formularioSignINBox = navegador.findElement(By.id("signinbox"));

        // Digitar no campo com name "login" que esta dentro do formulario de id "signinbox"o texto  "Julio0001"
        formularioSignINBox.findElement(By.name("login")).sendKeys("julio0001");

        // Digitar no campo com name "password" que esta dentro do formulario de id "signinbox" o texto "123456"
        formularioSignINBox.findElement(By.name("password")).sendKeys("123456");
        //Clicar no link com o texto "SIGN IN"
        navegador.findElement(By.linkText("SIGN IN")).click();
        // Validar que dentro do elemento com class "me" esta o texto " Hi, Julio"
        WebElement me = navegador.findElement(By.className("me"));
        String textoNoElementoMe = me.getText();
        assertEquals("Hi, Julio", textoNoElementoMe);
    }
    // Informacoes que vao ocorrer apos os testes finalizados
    @After
    public void tearDown() {
        //Fechar o navegador ( fecha todas as abas)
        navegador.close();
        //Fechar todas as aba aberta {navegador.quit();
    }
}
