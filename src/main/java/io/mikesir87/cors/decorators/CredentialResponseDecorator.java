package io.mikesir87.cors.decorators;

import io.mikesir87.cors.CorsConfiguration;
import io.mikesir87.cors.ResponseHandler;
import io.mikesir87.cors.validators.CorsRequestContext;

/**
 * A {@link ResponseDecorator} that adds the <code>Access-Control-Allow-Credentials</code> header if configuration
 * allows.
 *
 * @author Michael Irwin
 */
public class CredentialResponseDecorator implements ResponseDecorator {

  private static final String HEADER_NAME = "Access-Control-Allow-Credentials";
  private static final String HEADER_VALUE = "true";

  @Override
  public void decorateResponse(ResponseHandler responseHandler,
                               CorsRequestContext requestContext,
                               CorsConfiguration configuration) {
    if (configuration.allowCredentials()) {
      responseHandler.addHeader(HEADER_NAME, HEADER_VALUE);
    }
  }
}
