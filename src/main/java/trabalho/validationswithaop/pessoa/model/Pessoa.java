package trabalho.validationswithaop.pessoa.model;

import lombok.*;
import trabalho.validationswithaop.valid.EnableValidation;
import trabalho.validationswithaop.valid.validations.NotNull;
import trabalho.validationswithaop.valid.validations.Size;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EnableValidation
public class Pessoa {

    @NotNull(message = "O campo 'id' não pode ser nulo!")
    private Long id;

    @NotNull(message = "O campo 'nome' não pode ser nulo!")
    @Size(min = 1, max = 100, message = "O campo 'nome' possui tamanho inválido!")
    private String nome;

    private String dataNascimento;
}
