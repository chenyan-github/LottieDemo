package com.huobi.cy.mockitodemo;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testMockito() {
        //mock creation
        List mockedList = Mockito.mock(List.class);

        //using mock object
        mockedList.add("one");
        mockedList.clear();

        //verification
        Mockito.verify(mockedList).add("one");
        Mockito.verify(mockedList).clear();

        Mockito.when(mockedList.get(0)).thenReturn("first");
        Mockito.when(mockedList.get(Mockito.anyInt())).thenReturn("first");
//        Mockito.when(mockedList.get(1)).thenThrow(new RuntimeException());

        //following prints "first"
        System.out.println(mockedList.get(0));

        //following throws runtime exception
        System.out.println(mockedList.get(1));

        //following prints "null" because get(999) was not stubbed
        System.out.println(mockedList.get(999));

        //Although it is possible to verify a stubbed invocation, usually it's just redundant
        //If your code cares what get(0) returns, then something else breaks (often even before verify() gets executed).
        //If your code doesn't care what get(0) returns, then it should not be stubbed. Not convinced? See here.
        Mockito.verify(mockedList).get(0);


        //using mock
        mockedList.add("once");

        mockedList.add("twice");
        mockedList.add("twice");

        mockedList.add("three times");
        mockedList.add("three times");
        mockedList.add("three times");

        //following two verifications work exactly the same - times(1) is used by default
        Mockito.verify(mockedList).add("once");
        Mockito.verify(mockedList, Mockito.times(1)).add("once");

        //exact number of invocations verification
        Mockito.verify(mockedList, Mockito.times(2)).add("twice");
        Mockito.verify(mockedList, Mockito.times(3)).add("three times");

        //verification using never(). never() is an alias to times(0)
        Mockito.verify(mockedList, Mockito.never()).add("never happened");

        //verification using atLeast()/atMost()
        Mockito.verify(mockedList, Mockito.atLeastOnce()).add("three times");
        Mockito.verify(mockedList, Mockito.atLeast(3)).add("three times");
        Mockito.verify(mockedList, Mockito.atMost(5)).add("three times");

    }
}