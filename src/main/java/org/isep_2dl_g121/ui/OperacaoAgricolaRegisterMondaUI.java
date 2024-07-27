package org.isep_2dl_g121.ui;

import org.isep_2dl_g121.controller.OperacaoAgricolaRegisterController;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class OperacaoAgricolaRegisterMondaUI implements Runnable {

    private OperacaoAgricolaRegisterController controller;

    public OperacaoAgricolaRegisterMondaUI() {
        controller = new OperacaoAgricolaRegisterController();
    }

    public void run() {
        try {
            System.out.println("Registar uma nova Operação Agricola");

            Scanner scanner = new Scanner(System.in);
            //System.out.print("Tipo Operação: ");
            String tipoOperacao = "Monda";

            System.out.print("Caderno de Campo id: ");
            int id_caderno_campo = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Data de realização (dd-mm-yyyy): ");
            String strData = scanner.next();
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            Date data_operacao = formatter.parse(strData);

            System.out.print("Quantidade: ");
            double quantidade_operacao = scanner.nextDouble();
            scanner.nextLine();

            System.out.print("Unidade: ");
            String unidade_operacao = scanner.nextLine();

            System.out.print("Parcela Designação: ");
            String parcela = scanner.nextLine();

            System.out.print("Nome do produto: ");
            String produto_agricola_nome = scanner.nextLine();

            System.out.print("Tipo de Monda: ");
            String tipo = scanner.nextLine();

            controller.operacaoAgricolaRegisterMonda(tipoOperacao, id_caderno_campo,data_operacao, quantidade_operacao,
                    unidade_operacao, parcela,produto_agricola_nome,tipo);
            System.out.println("\nOperacao Agricola registered.");;
        } catch (ParseException|SQLException e ) {
            System.out.println("\nOperacao Agricola not registered!\n" + e.getMessage());
        }
    }
}
