/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Cliente
 */
public class CriaSVG {

    private final File modelo;
    private final File arquivo;

    public CriaSVG() throws IOException, ClassNotFoundException {

        modelo = new File("Modelo.svg");
        arquivo = new File("Saida.svg");

        if (!arquivo.exists()) {
            arquivo.createNewFile();
        }
    }

    public void criaArquivo(String viewBox, String geometria1, String geometria2) throws FileNotFoundException, IOException {

        FileReader fileReader = new FileReader(modelo);
        BufferedReader reader = new BufferedReader(fileReader);

        FileWriter fw = new FileWriter(arquivo, false);
        PrintWriter pw = new PrintWriter(fw);

        copiarNLinhas(pw, reader, 3);

        pw.write(viewBox);

        copiarNLinhas(pw, reader, 2);

        pw.write(geometria1);

        copiarNLinhas(pw, reader, 2);

        pw.write(geometria2);

        copiarNLinhas(pw, reader, 2);

        reader.close();
        pw.close();

    }

    private void copiarNLinhas(PrintWriter pw, BufferedReader reader, int quant) throws IOException {
        for (int i = 0; i < quant; i++) {
            pw.println(reader.readLine());
        }
    }

}
