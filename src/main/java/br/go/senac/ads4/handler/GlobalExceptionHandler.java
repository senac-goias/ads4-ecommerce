package br.go.senac.ads4.handler;

import br.go.senac.ads4.exception.CustomHttpException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Controlador global de tratamento de exceções para capturar e tratar todos os códigos de status HTTP.
 * Esta classe fornece manipuladores específicos para cada código de status HTTP com explicações detalhadas.
 */
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    // Variável de configuração para habilitar ou desabilitar a impressão da stack trace
    @Value("${feature.toggle.print-stacktrace:false}")
    private boolean printStackTraceEnabled;

    // 1xx Respostas Informativas

    @ExceptionHandler(CustomHttpException.ContinueException.class)
    public final ResponseEntity<ErrorResponse> handleContinueException(CustomHttpException.ContinueException ex, WebRequest request) {
        return buildErrorResponse(ex, HttpStatus.CONTINUE, "O servidor recebeu os cabeçalhos da solicitação e o cliente deve continuar enviando o corpo da solicitação.", request);
    }

    @ExceptionHandler(CustomHttpException.SwitchingProtocolsException.class)
    public final ResponseEntity<ErrorResponse> handleSwitchingProtocolsException(CustomHttpException.SwitchingProtocolsException ex, WebRequest request) {
        return buildErrorResponse(ex, HttpStatus.SWITCHING_PROTOCOLS, "O cliente solicitou ao servidor para mudar de protocolo, e o servidor aceitou a mudança.", request);
    }

    @ExceptionHandler(CustomHttpException.ProcessingException.class)
    public final ResponseEntity<ErrorResponse> handleProcessingException(CustomHttpException.ProcessingException ex, WebRequest request) {
        return buildErrorResponse(ex, HttpStatus.PROCESSING, "O servidor recebeu e está processando a solicitação, mas ainda não há resposta disponível.", request);
    }

    // 2xx Respostas de Sucesso

    @ExceptionHandler(CustomHttpException.OkException.class)
    public final ResponseEntity<ErrorResponse> handleOkException(CustomHttpException.OkException ex, WebRequest request) {
        return buildErrorResponse(ex, HttpStatus.OK, "A solicitação foi bem-sucedida e o servidor respondeu com os dados solicitados.", request);
    }

    @ExceptionHandler(CustomHttpException.CreatedException.class)
    public final ResponseEntity<ErrorResponse> handleCreatedException(CustomHttpException.CreatedException ex, WebRequest request) {
        return buildErrorResponse(ex, HttpStatus.CREATED, "A solicitação foi bem-sucedida e um novo recurso foi criado como resultado.", request);
    }

    @ExceptionHandler(CustomHttpException.AcceptedException.class)
    public final ResponseEntity<ErrorResponse> handleAcceptedException(CustomHttpException.AcceptedException ex, WebRequest request) {
        return buildErrorResponse(ex, HttpStatus.ACCEPTED, "A solicitação foi recebida, mas ainda não foi processada. É um status não-commitivo.", request);
    }

    @ExceptionHandler(CustomHttpException.NoContentException.class)
    public final ResponseEntity<ErrorResponse> handleNoContentException(CustomHttpException.NoContentException ex, WebRequest request) {
        return buildErrorResponse(ex, HttpStatus.NO_CONTENT, "A solicitação foi bem-sucedida, mas não há conteúdo para retornar na resposta.", request);
    }

    // 3xx Redirecionamento

    @ExceptionHandler(CustomHttpException.MultipleChoicesException.class)
    public final ResponseEntity<ErrorResponse> handleMultipleChoicesException(CustomHttpException.MultipleChoicesException ex, WebRequest request) {
        return buildErrorResponse(ex, HttpStatus.MULTIPLE_CHOICES, "Há múltiplas opções para o recurso solicitado que o cliente pode seguir.", request);
    }

    @ExceptionHandler(CustomHttpException.MovedPermanentlyException.class)
    public final ResponseEntity<ErrorResponse> handleMovedPermanentlyException(CustomHttpException.MovedPermanentlyException ex, WebRequest request) {
        return buildErrorResponse(ex, HttpStatus.MOVED_PERMANENTLY, "O URI do recurso solicitado foi alterado permanentemente.", request);
    }

    @ExceptionHandler(CustomHttpException.FoundException.class)
    public final ResponseEntity<ErrorResponse> handleFoundException(CustomHttpException.FoundException ex, WebRequest request) {
        return buildErrorResponse(ex, HttpStatus.FOUND, "O URI do recurso solicitado foi movido temporariamente para uma nova localização.", request);
    }

    @ExceptionHandler(CustomHttpException.SeeOtherException.class)
    public final ResponseEntity<ErrorResponse> handleSeeOtherException(CustomHttpException.SeeOtherException ex, WebRequest request) {
        return buildErrorResponse(ex, HttpStatus.SEE_OTHER, "A resposta à solicitação pode ser encontrada sob outro URI usando o método GET.", request);
    }

    @ExceptionHandler(CustomHttpException.NotModifiedException.class)
    public final ResponseEntity<ErrorResponse> handleNotModifiedException(CustomHttpException.NotModifiedException ex, WebRequest request) {
        return buildErrorResponse(ex, HttpStatus.NOT_MODIFIED, "O recurso não foi modificado desde a última solicitação.", request);
    }

    // 4xx Erro do Cliente

    @ExceptionHandler(CustomHttpException.BadRequestException.class)
    public final ResponseEntity<ErrorResponse> handleBadRequestException(CustomHttpException.BadRequestException ex, WebRequest request) {
        return buildErrorResponse(ex, HttpStatus.BAD_REQUEST, "O servidor não pôde entender a solicitação devido à sintaxe inválida.", request);
    }

    @ExceptionHandler(CustomHttpException.UnauthorizedException.class)
    public final ResponseEntity<ErrorResponse> handleUnauthorizedException(CustomHttpException.UnauthorizedException ex, WebRequest request) {
        return buildErrorResponse(ex, HttpStatus.UNAUTHORIZED, "O cliente deve se autenticar para obter a resposta solicitada.", request);
    }

    @ExceptionHandler(CustomHttpException.ForbiddenException.class)
    public final ResponseEntity<ErrorResponse> handleForbiddenException(CustomHttpException.ForbiddenException ex, WebRequest request) {
        return buildErrorResponse(ex, HttpStatus.FORBIDDEN, "O cliente não tem direitos de acesso ao conteúdo.", request);
    }

    @ExceptionHandler(CustomHttpException.NotFoundException.class)
    public final ResponseEntity<ErrorResponse> handleNotFoundException(CustomHttpException.NotFoundException ex, WebRequest request) {
        return buildErrorResponse(ex, HttpStatus.NOT_FOUND, "O servidor não conseguiu encontrar o recurso solicitado.", request);
    }

    @ExceptionHandler(CustomHttpException.MethodNotAllowedException.class)
    public final ResponseEntity<ErrorResponse> handleMethodNotAllowedException(CustomHttpException.MethodNotAllowedException ex, WebRequest request) {
        return buildErrorResponse(ex, HttpStatus.METHOD_NOT_ALLOWED, "O método da solicitação é conhecido pelo servidor, mas não é suportado pelo recurso.", request);
    }

    @ExceptionHandler(CustomHttpException.ConflictException.class)
    public final ResponseEntity<ErrorResponse> handleConflictException(CustomHttpException.ConflictException ex, WebRequest request) {
        return buildErrorResponse(ex, HttpStatus.CONFLICT, "A solicitação não pôde ser processada devido a um conflito com o estado atual do recurso.", request);
    }

    @ExceptionHandler(CustomHttpException.UnsupportedMediaTypeException.class)
    public final ResponseEntity<ErrorResponse> handleUnsupportedMediaTypeException(CustomHttpException.UnsupportedMediaTypeException ex, WebRequest request) {
        return buildErrorResponse(ex, HttpStatus.UNSUPPORTED_MEDIA_TYPE, "O tipo de mídia da solicitação não é suportado pelo servidor.", request);
    }

    // 5xx Erro do Servidor

    @ExceptionHandler(CustomHttpException.InternalServerErrorException.class)
    public final ResponseEntity<ErrorResponse> handleInternalServerErrorException(CustomHttpException.InternalServerErrorException ex, WebRequest request) {
        return buildErrorResponse(ex, HttpStatus.INTERNAL_SERVER_ERROR, "O servidor encontrou uma condição inesperada que o impediu de atender à solicitação.", request);
    }

    @ExceptionHandler(CustomHttpException.NotImplementedException.class)
    public final ResponseEntity<ErrorResponse> handleNotImplementedException(CustomHttpException.NotImplementedException ex, WebRequest request) {
        return buildErrorResponse(ex, HttpStatus.NOT_IMPLEMENTED, "O servidor não suporta a funcionalidade necessária para atender à solicitação.", request);
    }

    @ExceptionHandler(CustomHttpException.BadGatewayException.class)
    public final ResponseEntity<ErrorResponse> handleBadGatewayException(CustomHttpException.BadGatewayException ex, WebRequest request) {
        return buildErrorResponse(ex, HttpStatus.BAD_GATEWAY, "O servidor recebeu uma resposta inválida do servidor upstream.", request);
    }

    @ExceptionHandler(CustomHttpException.ServiceUnavailableException.class)
    public final ResponseEntity<ErrorResponse> handleServiceUnavailableException(CustomHttpException.ServiceUnavailableException ex, WebRequest request) {
        return buildErrorResponse(ex, HttpStatus.SERVICE_UNAVAILABLE, "O servidor está temporariamente indisponível devido a manutenção ou sobrecarga.", request);
    }

    @ExceptionHandler(CustomHttpException.GatewayTimeoutException.class)
    public final ResponseEntity<ErrorResponse> handleGatewayTimeoutException(CustomHttpException.GatewayTimeoutException ex, WebRequest request) {
        return buildErrorResponse(ex, HttpStatus.GATEWAY_TIMEOUT, "O servidor não recebeu uma resposta a tempo do servidor upstream.", request);
    }

    /**
     * Tratamento genérico para qualquer outra exceção não mapeada explicitamente.
     * Caso nenhuma das exceções específicas seja correspondida, este método será chamado, retornando
     * um status HTTP 500 Internal Server Error.
     *
     * @param ex      exceção genérica.
     * @param request a solicitação web atual.
     * @return a entidade de resposta com status 500.
     */
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorResponse> handleAllExceptions(Exception ex, WebRequest request) {
        return buildErrorResponse(ex, HttpStatus.INTERNAL_SERVER_ERROR, "Erro interno no servidor. Consulte o administrador do sistema.", request);
    }

    @ExceptionHandler(Throwable.class)
    public final ResponseEntity<ErrorResponse> handleThrowable(Throwable ex, WebRequest request) {
        return buildErrorResponse(new Exception(ex), HttpStatus.INTERNAL_SERVER_ERROR, "Erro não identificado ocorreu.", request);
    }

    /**
     * Método auxiliar para criar a resposta de erro.
     *
     * @param ex a exceção lançada.
     * @param status o status HTTP a ser retornado.
     * @param message a mensagem específica do código de status.
     * @param request a solicitação web atual.
     * @return a entidade de resposta com detalhes do erro.
     */
    private ResponseEntity<ErrorResponse> buildErrorResponse(Exception ex, HttpStatus status, String message, WebRequest request) {
        // Converte o stack trace para String somente se a feature toggle estiver habilitada
        String stackTrace = printStackTraceEnabled ? getStackTraceAsString(ex) : null;

        // Cria a resposta de erro personalizada
        ErrorResponse errorResponse = createErrorResponse(
                status,
                message,
                stackTrace,
                request.getDescription(false) // Pode adicionar dados adicionais, se necessário
        );

        // Retorna a resposta de erro com o status apropriado
        return new ResponseEntity<>(errorResponse, status);
    }

    /**
     * Método auxiliar para criar um objeto ErrorResponse com todos os detalhes.
     *
     * @param status o status HTTP do erro.
     * @param message a mensagem de erro.
     * @param stackTrace o stack trace como uma String.
     * @param data dados adicionais sobre o erro.
     * @return um objeto ErrorResponse completo.
     */
    private ErrorResponse createErrorResponse(HttpStatus status, String message, String stackTrace, Object data) {
        return new br.go.senac.ads4.handler.ErrorResponse(status, message, stackTrace, data);
    }

    /**
     * Método auxiliar para converter o stack trace de uma exceção para uma String.
     *
     * @param e a exceção cuja stack trace será convertida.
     * @return o stack trace como uma String.
     */
    private String getStackTraceAsString(Exception e) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        e.printStackTrace(printWriter);
        return stringWriter.toString();
    }
}

