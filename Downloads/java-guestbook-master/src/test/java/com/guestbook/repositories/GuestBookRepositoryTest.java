package com.guestbook.repositories;

import com.guestbook.models.GuestBook;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class GuestBookRepositoryTest {

    @Test
    public void shouldIncreaseSizeAndId() {
        GuestBookRepository guestBookRepository = new GuestBookRepository();
        Integer savedId = guestBookRepository.save("faizal", "comment");

        assertEquals((Integer) 1, savedId);
        assertEquals(1, guestBookRepository.guestBookList.size());
    }

    @Test
    public void shouldGetAllDataFromList() {
        GuestBookRepository guestBookRepository = new GuestBookRepository();
        Integer savedId = guestBookRepository.save("faizal", "comment");

        List<GuestBook> guestBookList = guestBookRepository.get();

        assertEquals(1, guestBookList.size());
        assertEquals("faizal", guestBookList.get(0).getName());
        assertEquals("comment", guestBookList.get(0).getComment());
    }
}
