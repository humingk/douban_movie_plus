package org.humingk.movie.common.exception.translator;

import org.humingk.movie.common.exception.MyOauth2Exception;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.security.oauth2.provider.error.WebResponseExceptionTranslator;
import org.springframework.stereotype.Component;

import static org.humingk.movie.common.enumeration.CodeAndMsg.SUCCESS;
import static org.humingk.movie.common.enumeration.CodeAndMsg.UNAUTHORIZED;

/**
 * 将oauth2Exception等异常转化为自定义异常MyOauth2Exception
 * <p>
 * 使用方式： endpoints的exceptionTranslator方法
 *
 * @author humingk
 */
@Component
public class MyOauth2Translator implements WebResponseExceptionTranslator {
    @Override
    public ResponseEntity<OAuth2Exception> translate(Exception e) throws Exception {
        if (e instanceof OAuth2Exception) {
            OAuth2Exception oAuth2Exception = (OAuth2Exception) e;
            return ResponseEntity
                    .status(oAuth2Exception.getHttpErrorCode())
                    .body(new MyOauth2Exception(oAuth2Exception.getMessage()));
        } else if (e instanceof AuthenticationException) {
            AuthenticationException authenticationException = (AuthenticationException) e;
            return ResponseEntity
                    .status(UNAUTHORIZED.code)
                    .body(new MyOauth2Exception(authenticationException.getMessage()));
        }
        return ResponseEntity
                .status(SUCCESS.code)
                .body(new MyOauth2Exception(e.getMessage()));
    }
}
