package trabalho.validationswithaop.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Component;
import trabalho.validationswithaop.valid.EnableValidation;
import trabalho.validationswithaop.valid.TratamentoValidacao;

import java.util.Arrays;
import java.util.Optional;

@Aspect
@Component
@ConditionalOnExpression("${aspect.enabled:true}")
public class ValidationClassAspect {

    @Pointcut("within(@org.springframework.web.bind.annotation.RestController *)")
    public void beanAnnotatedWithRestController() { }

    @Pointcut("execution(public * *(..)) && @annotation(org.springframework.web.bind.annotation.PostMapping)")
    public void publicMethodAnnotatedWithPostMapping() { }

    @Pointcut("execution(public * *(..)) && @annotation(org.springframework.web.bind.annotation.PutMapping)")
    public void publicMethodAnnotatedWithPutMapping() { }


    @Around("beanAnnotatedWithRestController() && (publicMethodAnnotatedWithPostMapping() || publicMethodAnnotatedWithPutMapping())")
    public Object aroundRestController(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        final MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        final Object[] parametersMethod = proceedingJoinPoint.getArgs();

        Optional<Object> parameterForValidation = Arrays.stream(parametersMethod)
                .filter(parameter -> parameter.getClass().isAnnotationPresent(EnableValidation.class))
                .findFirst();

        if (parameterForValidation.isPresent()) {
            TratamentoValidacao.executarValidacoesEmClasses(parameterForValidation.get());
        }

        return proceedingJoinPoint.proceed();
    }
}
