import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;

public class AlunoControl {
    private StringProperty id = new SimpleStringProperty("");
    private StringProperty ra = new SimpleStringProperty("");
    private StringProperty nome = new SimpleStringProperty("");
    private StringProperty dataNascimento = new SimpleStringProperty("");

    private List<Aluno> lista = new ArrayList<>();

    public void salvar(Aluno a){
        lista.add(a);
    }

    public Aluno pesquisar(String nome){
        for(Aluno a : lista){
            if(a.getNome().equals(nome)){
                return a;
            }
        }
        return null;
    }

    public void procurar() {
        Aluno a = pesquisar( nome.get() );
        fromEntity(a);
    }

    public void salvarAluno(){
        salvar(toEntity());
        limpaTela();
    }

    public Aluno toEntity(){
        Aluno a = new Aluno();
        a.setId(id.get());
        a.setRa(ra.get());
        a.setNome(nome.get());
        a.setDataNascimento(dataNascimento.get());
        return a;
    }

    public void limpaTela(){
        id.set("");
        ra.set("");
        nome.set("");
        dataNascimento.set("");
    }

    public void fromEntity(Aluno a){
        if(a != null) {
            id.set(a.getId());
            ra.set(a.getRa());
            nome.set(a.getNome());
            dataNascimento.set(a.getDataNascimento());
        } else {
            Alert alert = new Alert(AlertType.ERROR, "Aluno não encontrado", new ButtonType("Ok"));

            alert.show();
        }
    }

    public String getId() {
        return this.id.get(); // continuar daqui -------------------------------------------------------------------------------------------
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public StringProperty idProperty() {
        return this.id;
    }

    public String getRa() {
        return this.ra.get();
    }

    public void setRa(String ra) {
        this.ra.set(ra);;
    }

    public StringProperty raProperty() {
        return this.ra;
    }

    public String getNome() {
        return this.nome.get();
    }

    public void setNome(String nome) {
        this.nome.set(nome);
    }

    public StringProperty nomeProperty() {
        return this.nome;
    }

    public String getDataNascimento() {
        return this.dataNascimento.get();
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento.set(dataNascimento);
    }

    public StringProperty dataNascimentoProperty() {
        return this.dataNascimento;
    }
    
}
