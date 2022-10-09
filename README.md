# Validação automática de atributos com Reflexão

O objetivo deste projeto é validar atributos de uma classe de formulário
em requsições de POST e PUT através do uso de anotações e reflexão com Spring Boot.

A ideia deste projeto é automatizar as validações implementadas 
[neste projeto](https://github.com/paulocromano/validations-with-refletion-in-java)
através do uso da Programação Orientada a Aspectos (AOP).

```java
//Interface para habilitar as validações de uma classe utilizada em requisições de POST e PUT

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface EnableValidation {

    boolean enable() default true;
}
```

```java
//Classe responsável por interceptar os métodos que possuem classes de formulários para validação

@Aspect
@Component
@ConditionalOnExpression("${aspect.enabled:true}")
public class ValidationClassAspect { /* métodos */ }
```