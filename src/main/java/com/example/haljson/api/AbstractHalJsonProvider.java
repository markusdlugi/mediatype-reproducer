package com.example.haljson.api;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;

import javax.inject.Inject;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;

import com.fasterxml.jackson.databind.ObjectMapper;

public class AbstractHalJsonProvider implements MessageBodyWriter<Object> {

    private final String message;

    @Inject
    ObjectMapper mapper;

    public AbstractHalJsonProvider() {
        message = this.getClass().getSimpleName() + " called!\n";
    }

    @Override
    public boolean isWriteable(final Class type, final Type genericType, final Annotation[] annotations,
            final MediaType mediaType) {
        return true;
    }

    @Override
    public void writeTo(final Object o, final Class type, final Type genericType, final Annotation[] annotations,
            final MediaType mediaType, final MultivaluedMap httpHeaders, final OutputStream entityStream)
            throws IOException {
        entityStream.write(message.getBytes(StandardCharsets.UTF_8));
        entityStream.write(mapper.writeValueAsBytes(o));
        entityStream.close();
    }
}
