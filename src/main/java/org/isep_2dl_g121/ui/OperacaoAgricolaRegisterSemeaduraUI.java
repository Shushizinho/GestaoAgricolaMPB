package org.isep_2dl_g121.ui;

import org.isep_2dl_g121.controller.OperacaoAgricolaRegisterController;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class OperacaoAgricolaRegisterSemeaduraUI implements Runnable {

    private OperacaoAgricolaRegisterController controller;

    public OperacaoAgricolaRegisterSemeaduraUI() {
        controller = new OperacaoAgricolaRegisterController();
    }

    public void run() {
        try {
            System.out.println("Registar uma nova Operação Agricola");

            Scanner scanner = new Scanner(System.in);
            //System.out.print("Tipo Operação: ");
            String tipoOperacao = "Semeadura";

            System.out.print("Caderno de Campo id: ");
            int id_caderno_campo = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Data de realização (dd-mm-yyyy): ");
            String strData = scanner.next();
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            Date data_operacao = formatter.parse(strData);
            scanner.nextLine();

            System.out.print("Parcela Nome: ");
            String parcela_nome = scanner.nextLine();

            System.out.print("Planta Nome: ");
            String planta_nome = scanner.nextLine();

            System.out.print("Quantidade Operação: ");
            double quantidade_operacao = scanner.nextDouble();
            scanner.nextLine();

            System.out.print("Unidade Operação: ");
            String unidade_operacao = scanner.nextLine();;

            System.out.print("Quantidade Cultura: ");
            double quantidade_cultura = scanner.nextDouble();
            scanner.nextLine();

            System.out.print("Unidade Cultura: ");
            String unidade_cultura = scanner.nextLine();


            controller.operacaoAgricolaRegisterSemeadura(tipoOperacao, id_caderno_campo,data_operacao, quantidade_operacao,
                    unidade_operacao,quantidade_cultura, unidade_cultura,planta_nome,parcela_nome);
            System.out.println("\nOperacao Agricola registered.");;
        } catch (ParseException|SQLException e ) {
            System.out.println("\nOperacao Agricola not registered!\n" + e.getMessage());
        }
    }
}
