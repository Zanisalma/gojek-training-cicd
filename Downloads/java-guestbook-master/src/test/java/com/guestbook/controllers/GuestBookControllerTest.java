package com.guestbook.controllers;


import com.google.gson.Gson;
import com.guestbook.models.CommentRequest;
import com.guestbook.services.GuestBookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import spark.Request;
import spark.Response;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class GuestBookControllerTest {

    @Mock
    private GuestBookService serviceMock;

    private Gson gson = new Gson();

    @Mock
    private Request requestMock;

    @Mock
    private Response responseMock;

    @Test
    public void shouldCallGuestBookService() {
        when(requestMock.body()).thenReturn("{\"name\":\"name\", \"comment\":\"comment\"}");

        GuestBookController controller = new GuestBookController(gson, serviceMock);
        ArgumentCaptor<CommentRequest> captor = ArgumentCaptor.forClass(CommentRequest.class);

        controller.save(requestMock, responseMock);
        verify(serviceMock, times(1)).save(captor.capture());
        assertEquals("name", captor.getValue().getName());
        assertEquals("comment", captor.getValue().getComment());

    }
}