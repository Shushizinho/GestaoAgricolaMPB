package org.isep_2dl_g121;

import graph.MyAlgorithms;
import org.isep_2dl_g121.dataAccess.DatabaseConnection;
import org.isep_2dl_g121.ui.DataBaseLink;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println();
            System.out.println("========Menu========");
            System.out.println("1. Xlsx para Sql");
            System.out.println("2. Criar plano de rega");
            System.out.println("3. Verificar plano de rega");
            System.out.println("4. Caderno de Campo");
            System.out.println("5. Base de dados");
            System.out.println("6. Horários de funcionamento de hubs");
            System.out.println("0. Sair");
            System.out.println("====================");

            System.out.printf("=> ");
            int n = sc.nextInt();

            switch (n) {
                case 1:
                    XLSXtoSQL.sqlInserts();
                    break;
                case 2:
                    WateringPlan.regaInsert();
                    break;
                case 3:
                    WateringPlan.planoInsert();
                    break;
                case 4:
                    FieldNotebook.planoInsert();
                    break;
                case 5:
                    DataBaseLink.link();
                    break;
                case 6:
                    HorariosHubs.dadosHorariosHubs();
                    break;
                case -1:
                    Debug.USEI03();
                    break;
                case -2:
                    Debug.USEI02();
                    break;
                case -3:
                    Debug.Tests();
                    break;
                case -4:
                    Debug.TestsB();
                    break;
                case 0:
                    DatabaseConnection.getInstance().closeConnection();
                    System.out.println("Sair do programa.");
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }

        }
    }
}