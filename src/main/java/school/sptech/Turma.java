package school.sptech;

public class Turma {
    private String nome;
    private Double mensalidade;
    private Integer qtdAluno;
    private Boolean ativa;

    public Turma(String nome, Double mensalidade) {
        this.nome = nome;
        this.mensalidade = mensalidade;
        qtdAluno = 0;
        ativa = true;
    }

    public void matricular(Integer qtd) {
        if (qtd != null && qtd > 0 && ativa) {
            qtdAluno += qtd;
        } else {
            System.out.println("Não foi possível realizar a matrícula");
        }
    }

    public Integer cancelar(Integer qtd) {
        if (qtd != null && qtd > 0 && qtd <= qtdAluno && ativa) {
            qtdAluno -= qtd;
            return qtd;
        } else {
            return null;
        }
    }

    public Integer desativar() {
        if (ativa) {
            ativa = false;
            Integer qtdAlunoAntiga = qtdAluno;
            qtdAluno = 0;
            return qtdAlunoAntiga;
        } else {
            return null;
        }
    }

    public void transferir(Turma destino, Integer qtdATransferir) {
        if (qtdATransferir != null
                && destino != null
                && qtdATransferir > 0
                && destino.ativa
                && qtdATransferir <= qtdAluno
                && ativa) {
            qtdAluno -= qtdATransferir;
            destino.qtdAluno += qtdATransferir;
        } else {
            System.out.println("Não foi possível realizar a transferência");
        }
    }

    public Boolean reajustarMensalidade(Double reajuste) {
        if (reajuste != null && reajuste > 0) {
            mensalidade *= (1 + reajuste);
            return true;
        } else {
            return false;
        }
    }

    public String getNome() {
        return nome;
    }

    public Double getMensalidade() {
        return mensalidade;
    }

    public Integer getQtdAluno() {
        return qtdAluno;
    }

    public Boolean getAtiva() {
        return ativa;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
