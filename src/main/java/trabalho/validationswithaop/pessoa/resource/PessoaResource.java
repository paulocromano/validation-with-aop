package trabalho.validationswithaop.pessoa.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trabalho.validationswithaop.pessoa.model.Pessoa;
import trabalho.validationswithaop.pessoa.repository.PessoaRepository;

import java.util.List;

@RestController
@RequestMapping(path = "/pessoa")
public class PessoaResource {

    @Autowired
    private PessoaRepository pessoaRepository;


    @GetMapping
    public ResponseEntity<List<Pessoa>> buscarPessoas() {
        return ResponseEntity.ok(pessoaRepository.getPessoas());
    }

    @PostMapping
    public ResponseEntity<Void> cadastrarPessoa(@RequestBody Pessoa pessoa) {
        pessoaRepository.adicionarPessoa(pessoa);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
