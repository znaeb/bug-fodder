/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import static org.junit.Assert.assertArrayEquals;
//import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Benjamin Nimchinsky.
 */
public class SieveTest {
    
  public SieveTest() {
  }

  @BeforeClass
  public static void setUpClass() {
  }

  @AfterClass
  public static void tearDownClass() {
  }

  @Before
  public void setUp() {
  }

  @After
  public void tearDown() {
  }


  /**
   * Test of convertResults method, of class Sieve.
   */
  @Test
  public void testConvertResults20() {
    System.out.println("convertResults20");
    int[] results = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
    boolean[] prime = {false,true,true,false,true,false,true,false,false,false,
      true,false,true,false,false,false,true,false,true,false};
    int[] expResult = {2,3,5,7,11,13,17,19};
    int[] result = Sieve.convertResults(results, prime);
    assertArrayEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
  }
  /**
   * Test of convertResults method, of class Sieve.
   */
  @Test
  public void testConvertResults30() {
    System.out.println("convertResults30");
    int[] results = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,
      22,23,24,25,26,27,28,29,30};
    boolean[] prime = {false,true,true,false,true,false,true,false,false,
      false,true,false,true,false,false,false,true,false,true,false,
      false,false,true,false,false,false,false,false,true,false};
    int[] expResult = {2,3,5,7,11,13,17,19,23,29};
    int[] result = Sieve.convertResults(results, prime);
    assertArrayEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
  }


}
