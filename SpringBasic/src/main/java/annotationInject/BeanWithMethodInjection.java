package annotationInject;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "singleton")
public abstract class BeanWithMethodInjection {

    @Lookup
    public abstract BeanZ getBeanZ();
}
