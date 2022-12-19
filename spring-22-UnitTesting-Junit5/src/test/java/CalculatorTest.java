import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
@BeforeAll // execute before all test methods
    static void setUpAll(){
    System.out.println("BeforeAll is executed");
}
@AfterAll // execute after all test methods
    static void tearDownAll(){
    System.out.println("AfterAll is executed");
}
@BeforeEach //execute before each test method
    void setUpEach(){
    System.out.println("BeforeEach is executed");

}
@AfterEach // execute after each test method
void tearDownEach(){
    System.out.println("AfterEach is executed");
}


@Test
    @DisplayName("MyMethod")// the display name of the method is not add but MyMethod
    void add(){
    System.out.println("Add method");
    int actual=Calculator.add(2,3);
    assertEquals(5,actual,"test failed");
}
@Test
    void add2(){
    System.out.println("add2 method");
    assertThrows(IllegalArgumentException.class,()->Calculator.add2(3,2)); // returns assertThrows(expected class,executable) Executable functional interface in junit
  //  Executable is a functional interface that can be used to implement any generic block of code that potentially throws a Throwable.
//If no exception is thrown, or if an exception of a different type is thrown, this method will fail.

//    assertThrows(IllegalArgumentException.class,()->Calculator.add2(2,3));
//    assertThrows(AccessDeniedException.class,()->Calculator.add2(3,2));
}
@Test
    void testCase1(){
    fail("Not implemented yet"); // mark a test that is incomplete, it fails and warns until it is complete
    // to make sure an exception is thrown
}
@Test
    void testCase2(){
    System.out.println("Test case 2");
    assertEquals("add",Calculator.operator); // operator is a field in the calculator class
    assertTrue(Calculator.operator.equals("add"));
}
@Test
    void testCase3(){
    System.out.println("Test case 3");
    assertArrayEquals(new int[]{1,2,3},new int[]{1,3,2},"Arrays are not the same");

}
@Test
    void testCase4(){
    System.out.println("Test case 4");
    String nullString=null;
    String notNullString="Cydeo";

    assertNull(nullString);// actual value is null
    assertNotNull(notNullString);// actual value is not null
//    assertNull(notNullString);
//    assertNotNull(nullString);
}


@Test
void testCase5(){
    System.out.println("Test case 5");
    Calculator c1=new Calculator();
    Calculator c2=c1;
    Calculator c3=new Calculator();
    assertSame(c1,c2); //asserts that the expected value and the actual value  refer to the same object.
    assertNotSame(c1,c3); //asserts that the expected value and the actual value DO NOT refer to the same object.
}}