package customer.inbound.exception;

import customer.outbound.entity.common.exception.RepositoryException;
import org.eclipse.microprofile.rest.client.ext.ResponseExceptionMapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Provider
public class ExceptionHandlerRest implements ResponseExceptionMapper<RepositoryException> {
    @Override
    public RepositoryException toThrowable(Response response) {
        return switch (response.getStatus()) {
            case 400 -> new RepositoryException("400");
            case 404 -> new RepositoryException("404");
            default -> new RepositoryException("500");
        };
    }
}
