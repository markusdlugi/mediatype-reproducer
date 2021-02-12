package com.example.haljson.working;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;

import javax.inject.Inject;
import javax.ws.rs.ConstrainedTo;
import javax.ws.rs.Produces;
import javax.ws.rs.RuntimeType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

import com.fasterxml.jackson.databind.ObjectMapper;

@Provider
@Produces({ "application/hal" })
@ConstrainedTo(RuntimeType.SERVER)
public class SecureJacksonHalProvider implements MessageBodyWriter<Object> {
    private static final String PREFIX = ")]}',\n";

    @Inject
    ObjectMapper mapper;

    @Override
    public boolean isWriteable(final Class type, final Type genericType, final Annotation[] annotations,
            final MediaType mediaType) {
        return true;
    }

    @Override
    public void writeTo(final Object o, final Class type, final Type genericType, final Annotation[] annotations,
            final MediaType mediaType, final MultivaluedMap httpHeaders, final OutputStream entityStream)
            throws IOException {
        entityStream.write(PREFIX.getBytes(StandardCharsets.UTF_8));
        entityStream.write(mapper.writeValueAsBytes(o));
        entityStream.close();
    }
}
