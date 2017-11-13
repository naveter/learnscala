
import example.Multiply;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import example.*;

import java.io.IOException;

public class AnnotationsTest {
    public AnnotationsTest() {
    }

//    @BeforeClass
//    public static void setUpClass() {
//        System.out.println("setUpClass");
//    }
//
//    @AfterClass
//    public static void tearDownClass() {
//        System.out.println("tearDownClass");
//    }
//
//    @Before
//    public void setUp() {
//        System.out.println("setUp");
//    }
//
//    @After
//    public void tearDown() {
//        System.out.println("tearDown");
//    }

    @Test
    public void testFind1() {
        example.Multiply mm = new Multiply(2, 4);
        assertEquals(8, mm.multiply());

        Ex05 ex5 = new Ex05();
        try {
            String s05 = ex5.fileToString("/ch09_ex07.txt");
            System.out.println(s05);
        }
        catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
