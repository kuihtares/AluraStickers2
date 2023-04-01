import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class GeradoraDeFigurinhas {
    public static void cria(InputStream inputStream, String nomeArquivo) throws Exception {
        // Leitura da imagem
        BufferedImage imagemOriginal = ImageIO.read(inputStream);

        // Redimensionar imagem para um tamanho padrão de 800 x 600 pixels
        int largura = 800;
        int altura = 1000;
        Image imagemRedimensionada = imagemOriginal.getScaledInstance(largura, altura, Image.SCALE_SMOOTH);

        // Cria nova imagem em memória com transparência
        int novaAltura = altura + 200;
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        // Copiar a imagem redimensionada para a nova imagem em memória
        Graphics2D graphics = (Graphics2D) novaImagem.createGraphics();
        graphics.drawImage(imagemRedimensionada, 0, 0, null);

        // Fonte
        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 75);
        graphics.setColor(Color.YELLOW);
        graphics.setFont(fonte);

        // Escrever uma frase na nova imagem
        graphics.drawString("⭐TOPZERA⭐", 110, novaAltura - 100);

        // Escrever a imagem em um arquivo

        var file = new File("Saida");
        if (!file.exists())
            file.mkdir();
         ImageIO.write(novaImagem, "png", new File(nomeArquivo));

    }
}
