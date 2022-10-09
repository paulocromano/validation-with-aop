package trabalho.validationswithaop.valid;

import java.lang.annotation.Annotation;

public interface Valid<T extends Annotation> {

    String getMessagemErro();

    void setAnnotation(T t);

    boolean campoInvalido(Object object);
}
