package org.isep_2dl_g121.domain;

public class Sensor {
    private int ID;
    private String Marca;
    private String Modelo;
    private String TipoSensor;
    private String TipoLeitura;
    private int EstacaoMeteorologicaID;

    public Sensor(int ID, String Marca, String Modelo, String TipoSensor, String TipoLeitura, int EstacaoMeteorologicaID) {
        this.ID = ID;
        this.Marca = Marca;
        this.Modelo = Modelo;
        this.TipoSensor = TipoSensor;
        this.TipoLeitura=TipoLeitura;
        this.EstacaoMeteorologicaID = EstacaoMeteorologicaID;
    }

    public int getID() {
            return ID;
        }
    public String getMarca() {
            return Marca;
        }
    public String getModelo() {
            return Modelo;
        }
    public String getTipoSensor(){
            return TipoSensor;
        }
    public String getTipoLeitura() {
        return TipoLeitura;
    }
    public int getEstacaoMeteorologicaID() {
            return EstacaoMeteorologicaID;
        }
}