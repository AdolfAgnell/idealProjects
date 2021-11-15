package tests;

import static org.junit.Assert.*;

import com.sun.javafx.css.CssError;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

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

        //Clicar em um link que possui a class "me"
        navegador.findElement(By.className("me")).click();

        //Clicar em unm link que possuii o texto "MORE DATA ABOUT YOU"
        navegador.findElement(By.linkText("MORE DATA ABOUT YOU")).click();
    }
    // @Test
    public void testAdicionarUmaInformacaoAdicionalDoUsuario () {

        //Clicar no botao atraves do seu xpath //button[@data-target="addmoredata"]
        navegador.findElement(By.xpath("//button[@data-target=\"addmoredata\"]")).click();

        //Identificar a popup onde esta o formulario de id addmoredata
        WebElement popupAddMoreData = navegador.findElement(By.id("addmoredata"));

        //Na combo de name "type" escolher a opcao "Phone"
        WebElement campoType = popupAddMoreData.findElement(By.name("type"));
        new Select(campoType).selectByVisibleText("Phone");

        //No campo de name "contact"  digitar +5511988050796
        popupAddMoreData.findElement(By.name("contact")).sendKeys("+5511988210565");

        //Clicar no link de text "SAVE" que esta na popup
        popupAddMoreData.findElement(By.linkText("SAVE")).click();

        //Na mensagem de id "toast-container" validar que o texto e "Your contact has been added!"
        WebElement mensagemPop = navegador.findElement(By.id("toast-container"));
        String mensagem = mensagemPop.getText();
        assertEquals( "Your contact has been added!", mensagem);


    }

    @Test
    public void removerUmContatoDeUmUsuario() {
       // CLicar no elemento pelo seu xpath //span[text()="+551166669999"]/following-sibling::a
        navegador.findElement(By.xpath("//span[text()=\"+551166669999\"]/following-sibling::a")).click();

        //Confirmar a janela javascript
        navegador.switchTo().alert().accept();

        //Validar que a mensagem apresentada foi Rest in peace, dear phone!
        WebElement mensagemPop = navegador.findElement(By.id("toast-container"));
        String mensagem = mensagemPop.getText();
        assertEquals( "Rest in peace, dear phone!", mensagem);

        //Aguarda ate 10 segundos para quye a janela desapareca
        WebDriverWait aguardar = new WebDriverWait(navegador, 10);
        aguardar.until(ExpectedConditions.stalenessOf(mensagemPop));

        //Clicar no link com texto "Logout"
        navegador.findElement(By.linkText("Logout")).click();
    }

    // Informacoes que vao ocorrer apos os testes finalizados
    @After
    public void tearDown() {
        //Fechar o navegador ( fecha todas as abas)
        //navegador.close();
        //Fechar todas as aba aberta {navegador.quit();
        //test
    }
}
