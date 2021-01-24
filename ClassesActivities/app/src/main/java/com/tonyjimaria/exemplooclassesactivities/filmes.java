package com.tonyjimaria.exemplooclassesactivities;

public class filmes {
    private int idFilme;
    private String mNomeFilme;
    private String mSinopse;
    private int mDuracaoMinutos;
    private String mCategoria;

    //GET e SET nome**************************
    public String getmNomeFilme() {
        return mNomeFilme;
    }

    public void setmNomeFilme(String mNomeFilme) {
        this.mNomeFilme = mNomeFilme;
    }

    //GET e SET sinopse**************************
    public String getmSinopse() {
        return mSinopse;
    }

    public void setmSinopse(String msinopse) {
        this.mSinopse = mSinopse;
    }

    //GET e SET duração**************************
    public int getmDuracaoMinutos() {
        return mDuracaoMinutos;
    }

    public void setMduracaoMinutos(int mDuracaoMinutos) {
        this.mDuracaoMinutos = mDuracaoMinutos;
    }

    //GET e SET categoria**************************
    public String getCategoria() {
        return mCategoria;
    }

    public void setCategoria(String mCategoria) {
        this.mCategoria = mCategoria;
    }

    //converte minutos em horas
    //a variavel minutos recebe o GET dos Mminutos
    //getMinutos é o atributo da classe, ou seja, ja foi digitado
    //com os minutos na variavel minutos agora calculam-se as horas
    //retornando o resultado disso para a chamada do metodo

    public float convertMinutos(float minutos){
        minutos = this.getmDuracaoMinutos();
        float horas = minutos / 60;
        return horas;
    }

}
