package entidades;

public class ProdutoImportado extends Produto{

    private Double semAlfandegas;

    public ProdutoImportado(String nome, Double preco, Double semAlfandegas) {
        super(nome, preco);
        this.semAlfandegas = semAlfandegas;
    }

    public Double getSemAlfandegas() {
        return semAlfandegas;
    }

    public void setSemAlfandegas(Double semAlfandegas) {
        this.semAlfandegas = semAlfandegas;
    }

    public double precoTotal(){
        return getPreco() + semAlfandegas;
    }

    @Override
    public String etiquetaDePreco(){
        return getNome() + " $ " + String.format("%.2f", precoTotal()) + "(Sem Alfandegas: $ " + String.format("%.2f",semAlfandegas) + ")";

    }
}
