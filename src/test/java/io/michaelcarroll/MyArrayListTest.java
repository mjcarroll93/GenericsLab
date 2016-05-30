package io.michaelcarroll;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class MyArrayListTest {

    MyArrayList<String> myArrayListDefaultSize;
    MyArrayList<Integer> myArrayListCustomSize;


    @Before
    public void setUp() throws Exception {
        myArrayListDefaultSize = new MyArrayList<>();
       myArrayListCustomSize = new MyArrayList<>(5);
    }

    @Test
    public void add() throws Exception {
        myArrayListDefaultSize.add("Mike");
        String expectedValue = "Mike";
        String actualValue = myArrayListDefaultSize.get(0);
        assertEquals("The expected value is Mike", expectedValue, actualValue);
    }

    @Test
    public void addWhenArrayIsFull(){
        for (int i = 0; i < 12; i++) {
            myArrayListDefaultSize.add("Mike");
        }
        String expectedValue = "Mike";
        String actualValue = myArrayListDefaultSize.get(11);
        assertEquals("The expected value is Mike", expectedValue, actualValue);
    }

    @Test
    public void addAtASpecificIndex() throws Exception {
        myArrayListDefaultSize.add(5, "Mike");
        String expectedValue = "Mike";
        String actualValue = myArrayListDefaultSize.get(5);
        assertEquals("The expected value is Mike", expectedValue, actualValue);
    }

    @Test
    public void get() throws Exception {
        myArrayListDefaultSize.add("John");
        String expectedValue = "John";
        String actualValue = myArrayListDefaultSize.get(0);
        assertEquals("The expected value is John", expectedValue, actualValue);
    }

    @Test
    public void remove() throws Exception {
        myArrayListDefaultSize.add("John");
        myArrayListDefaultSize.remove(0);
        String expectedValue = null;
        String actualValue = myArrayListDefaultSize.get(0);
        assertEquals("The expected value is null", expectedValue, actualValue);
    }

    @Test
    public void set() throws Exception {
        myArrayListDefaultSize.add("Mikey Rocks");
        myArrayListDefaultSize.set(0, "Johnny Cash");
        String expectedValue = "Johnny Cash";
        String actualValue = myArrayListDefaultSize.get(0);
        assertEquals("The expected value is Johnny Cash", expectedValue, actualValue);
    }

    @Test
    public void isNotEmptyTestWhenElementIsAdded() throws Exception {
        myArrayListDefaultSize.add("Mikey Rocks");
        assertFalse(myArrayListDefaultSize.isEmpty());
    }

    @Test
    public void isEmptyTestWhenNoElementIsAddedTest() throws Exception {
        assertTrue(myArrayListDefaultSize.isEmpty());
    }

    @Test
    public void contains() throws Exception {
        myArrayListDefaultSize.add("Mikey");
        System.out.println(myArrayListDefaultSize.get(0));
        assertTrue(myArrayListDefaultSize.contains("Mikey"));
    }

}