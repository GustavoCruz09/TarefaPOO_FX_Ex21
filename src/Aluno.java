public class Aluno {
    private String id;
    private String ra;
    private String nome;
    private String dataNascimento;

   //DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String data) {
        if(data.contains("/")){
            this.dataNascimento = data;
        } else {
            String vt[] = data.split("");
            data = vt[0]+vt[1]+"/"+vt[2]+vt[3]+"/"+vt[4]+vt[5]+vt[6]+vt[7];
            this.dataNascimento = data;
        }
    }

    @Override
    public String toString() {
        return "TarefaPOO_FX_Ex21_Aluno [id=" + id + ", ra=" + ra + ", nome=" + nome + ", dataNascimento="
                + dataNascimento + "]";
    }
    
}
