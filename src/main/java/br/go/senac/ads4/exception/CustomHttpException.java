package br.go.senac.ads4.exception;

/**
 * Classe principal para todas as exceções HTTP personalizadas.
 * Contém subclasses para cada código de status HTTP.
 */
public class CustomHttpException extends RuntimeException {
    public CustomHttpException(String message) {
        super(message);
    }

    // 1xx Informational
    public static class ContinueException extends CustomHttpException {
        public ContinueException(String message) {
            super(message);
        }
    }

    public static class SwitchingProtocolsException extends CustomHttpException {
        public SwitchingProtocolsException(String message) {
            super(message);
        }
    }

    public static class ProcessingException extends CustomHttpException {
        public ProcessingException(String message) {
            super(message);
        }
    }

    // 2xx Success
    public static class OkException extends CustomHttpException {
        public OkException(String message) {
            super(message);
        }
    }

    public static class CreatedException extends CustomHttpException {
        public CreatedException(String message) {
            super(message);
        }
    }

    public static class AcceptedException extends CustomHttpException {
        public AcceptedException(String message) {
            super(message);
        }
    }

    public static class NoContentException extends CustomHttpException {
        public NoContentException(String message) {
            super(message);
        }
    }

    // 3xx Redirection
    public static class MultipleChoicesException extends CustomHttpException {
        public MultipleChoicesException(String message) {
            super(message);
        }
    }

    public static class MovedPermanentlyException extends CustomHttpException {
        public MovedPermanentlyException(String message) {
            super(message);
        }
    }

    public static class FoundException extends CustomHttpException {
        public FoundException(String message) {
            super(message);
        }
    }

    public static class SeeOtherException extends CustomHttpException {
        public SeeOtherException(String message) {
            super(message);
        }
    }

    public static class NotModifiedException extends CustomHttpException {
        public NotModifiedException(String message) {
            super(message);
        }
    }

    // 4xx Client Error
    public static class BadRequestException extends CustomHttpException {
        public BadRequestException(String message) {
            super(message);
        }
    }

    public static class UnauthorizedException extends CustomHttpException {
        public UnauthorizedException(String message) {
            super(message);
        }
    }

    public static class ForbiddenException extends CustomHttpException {
        public ForbiddenException(String message) {
            super(message);
        }
    }

    public static class NotFoundException extends CustomHttpException {
        public NotFoundException(String message) {
            super(message);
        }
    }

    public static class MethodNotAllowedException extends CustomHttpException {
        public MethodNotAllowedException(String message) {
            super(message);
        }
    }

    public static class ConflictException extends CustomHttpException {
        public ConflictException(String message) {
            super(message);
        }
    }

    public static class UnsupportedMediaTypeException extends CustomHttpException {
        public UnsupportedMediaTypeException(String message) {
            super(message);
        }
    }

    // 5xx Server Error
    public static class InternalServerErrorException extends CustomHttpException {
        public InternalServerErrorException(String message) {
            super(message);
        }
    }

    public static class NotImplementedException extends CustomHttpException {
        public NotImplementedException(String message) {
            super(message);
        }
    }

    public static class BadGatewayException extends CustomHttpException {
        public BadGatewayException(String message) {
            super(message);
        }
    }

    public static class ServiceUnavailableException extends CustomHttpException {
        public ServiceUnavailableException(String message) {
            super(message);
        }
    }

    public static class GatewayTimeoutException extends CustomHttpException {
        public GatewayTimeoutException(String message) {
            super(message);
        }
    }
}

