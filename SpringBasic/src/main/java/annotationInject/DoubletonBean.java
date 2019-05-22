package annotationInject;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "doubleton")
public class DoubletonBean {
}
