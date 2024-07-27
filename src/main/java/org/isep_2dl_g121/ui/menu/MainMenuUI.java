package org.isep_2dl_g121.ui.menu;

import org.isep_2dl_g121.ui.*;
import org.isep_2dl_g121.ui.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class MainMenuUI implements Runnable {

    public MainMenuUI(){
    }



    @Override
    public void run() {
        List<MenuItem> options = new ArrayList<MenuItem>();
        options.add(new MenuItem("Database Connection Test", new DatabaseConnectionTestUI()));
        //options.add(new MenuItem("Register a Sailor", new SailorRegisterUI()));
        options.add(new MenuItem("Register a Operacao Agricola-Semeadura", new OperacaoAgricolaRegisterSemeaduraUI()));
        options.add(new MenuItem("Register a Operacao Agricola-Monda", new OperacaoAgricolaRegisterMondaUI()));
        options.add(new MenuItem("Register a Operacao Agricola-Colheita", new OperacaoAgricolaRegisterColheitaUI()));
        options.add(new MenuItem("Register a Operacao Agricola-Aplicação Fator Produção", new OperacaoAgricolaRegisterFatorProduçãoUI()));
        //options.add(new MenuItem("Delete a Sailor", new SailorDeleteUI()));
        //options.add(new MenuItem("Show List of Sailors", new SailorsListUI()));
        options.add(new MenuItem("Exit", new ExitUI()));

        //System.out.println("0. Exit"); //Opção 0 também sai do Menu

        int option = 0;
        do {
            option = Utils.showAndSelectIndex(options, "\n\nMain Menu");

            if ((option >= 0) && (option < options.size())) {

                if(option != options.size()) {options.get(option).run(); }
                break;


            }
        } while (option != -1);
    }
}
