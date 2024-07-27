package org.isep_2dl_g121.controller;

import org.isep_2dl_g121.dataAccess.Repositories;
import org.isep_2dl_g121.dataAccess.CulturaRepository;
import org.isep_2dl_g121.domain.Cultura;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class CulturaListController {

    private CulturaRepository culturaRepository;

    public CulturaListController(){
        getCulturaRepository();
    }

    private CulturaRepository getCulturaRepository() {
        if (Objects.isNull(culturaRepository)) {
            Repositories repositories = Repositories.getInstance();
            culturaRepository = repositories.getCulturaRepository();
        }
        return culturaRepository;
    }

    public List<Cultura> getCulturasByParcela(String parcela_nome, String produto_nome, Date data_operacao) throws SQLException {
        return culturaRepository.getCulturasByParcela(parcela_nome,produto_nome,data_operacao);
    }

    public List<Cultura> getCulturasByParcelaOnly(String parcelaNome, Date dataOperacao) throws SQLException {
        return culturaRepository.getCulturasByParcelaOnly(parcelaNome,dataOperacao);
    }
}
