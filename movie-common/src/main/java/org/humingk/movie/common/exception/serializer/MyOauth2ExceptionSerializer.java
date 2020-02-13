package org.humingk.movie.common.exception.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.humingk.movie.common.exception.MyOauth2Exception;

import java.io.IOException;

/**
 * MyOauth2Exception的序列化实现
 *
 * @author humingk
 */
public class MyOauth2ExceptionSerializer extends StdSerializer<MyOauth2Exception> {
  public MyOauth2ExceptionSerializer() {
    super(MyOauth2Exception.class);
  }

  @Override
  public void serialize(
      MyOauth2Exception e, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
      throws IOException {
    jsonGenerator.writeStartObject();
    jsonGenerator.writeNumberField("state", e.getHttpErrorCode());
    jsonGenerator.writeStringField("message", e.getOAuth2ErrorCode());
    jsonGenerator.writeObjectField("date", e.getMessage());
    jsonGenerator.writeEndObject();
  }
}
