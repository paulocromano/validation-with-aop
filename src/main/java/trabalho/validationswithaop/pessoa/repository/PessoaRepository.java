package trabalho.validationswithaop.pessoa.repository;

import org.springframework.stereotype.Repository;
import trabalho.validationswithaop.pessoa.model.Pessoa;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PessoaRepository {

    private static List<Pessoa> pessoas = new ArrayList<>();

    static {
        pessoas.add(new Pessoa(1L, "Adriana", "10/10/1992"));
        pessoas.add(new Pessoa(2L, "Matheus", "22/05/1990"));
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void adicionarPessoa(Pessoa pessoa) {
        pessoas.add(pessoa);
    }
}
