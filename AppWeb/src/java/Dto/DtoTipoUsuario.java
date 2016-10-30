package Dto;

public class DtoTipoUsuario {
    private int TPUS_ID;
    private String TPUS_Descricao;

    public DtoTipoUsuario() {
    }    
    
    public DtoTipoUsuario(int TPUS_ID, String TPUS_Descricao) {
        this.TPUS_ID = TPUS_ID;
        this.TPUS_Descricao = TPUS_Descricao;
    }

    public String getTPUS_Descricao() {
        return TPUS_Descricao;
    }

    public void setTPUS_Descricao(String TPUS_Descricao) {
        this.TPUS_Descricao = TPUS_Descricao;
    }

    public int getTPUS_ID() {
        return TPUS_ID;
    }

    public void setTPUS_ID(int TPUS_ID) {
        this.TPUS_ID = TPUS_ID;
    }    
}
