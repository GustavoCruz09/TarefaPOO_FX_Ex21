import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AlunoTela extends Application {
    
    private AlunoControl control = new AlunoControl();

    public static void main(String[] args) {
        //System.out.println("Hello Wolrd");
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane painel = new GridPane();
        painel.setHgap(15);
        painel.setVgap(15);

        Scene scn = new Scene(painel, 400, 210);

        Label lblId = new Label("Id:");
        TextField idTf = new TextField();
        idTf.setPrefWidth(280);
        painel.add(lblId, 1, 1);
        painel.add(idTf, 2, 1);

        Label lblRa = new Label("Ra:");
        TextField raTf = new TextField();
        painel.add(lblRa, 1, 2);
        painel.add(raTf, 2, 2);

        Label lblNome = new Label("Nome:");
        TextField nomeTf = new TextField();
        painel.add(lblNome, 1, 3);
        painel.add(nomeTf, 2, 3);

        Label lblNascimento = new Label("Nascimento:");
        TextField nascimentoTf = new TextField();
        painel.add(lblNascimento, 1, 4);
        painel.add(nascimentoTf, 2, 4);

        Button btnAdicionar = new Button("Adicionar");
        painel.add(btnAdicionar, 1, 5);

        Button btnPesquisar = new Button("Pesquisar");
        painel.add(btnPesquisar, 2, 5);

        Bindings.bindBidirectional(control.idProperty(), idTf.textProperty());
        Bindings.bindBidirectional(control.raProperty(), raTf.textProperty());
        Bindings.bindBidirectional(control.nomeProperty(), nomeTf.textProperty());
        Bindings.bindBidirectional(control.dataNascimentoProperty(), nascimentoTf.textProperty());

        btnAdicionar.setOnMouseClicked(
            e -> {
                control.salvarAluno();
            }
        );

        btnPesquisar.setOnMouseClicked(
            e -> {
                control.procurar();
            }
        );

        primaryStage.setScene(scn);
        primaryStage.setTitle("Gestão de Alunos");
        primaryStage.show();
    }

}
