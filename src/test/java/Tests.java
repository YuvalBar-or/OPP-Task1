import observer.ConcreteMember;
import observer.GroupAdmin;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Tests {
    public static final Logger logger = LoggerFactory.getLogger(Tests.class);
    // stub method to check external dependencies compatibility
    GroupAdmin groupAdmin = new GroupAdmin();
    ConcreteMember one = new ConcreteMember();
    ConcreteMember second = new ConcreteMember();

    @BeforeEach
    void setUp() {
        groupAdmin.register(one);
        groupAdmin.register(second);
    }
    @AfterEach
    void testMemory(){
        logger.info(JvmUtilities::jvmInfo);
    }
    // check register and unregister size
    @Test
    public void testMemoryRegisterChanges(){

        logger.info(() -> JvmUtilities.objectFootprint(groupAdmin));
        groupAdmin.unregister(one);
        logger.info(() -> JvmUtilities.objectFootprint(groupAdmin));
        groupAdmin.unregister(second);
        logger.info(() -> JvmUtilities.objectFootprint(groupAdmin));
    }
    @Test
    public void test1(){
        String s1 = "Alice";
        String s2 = "Bob";

        logger.info(()->JvmUtilities.objectFootprint(s1));

        logger.info(()->JvmUtilities.objectFootprint(s1,s2));

        logger.info(()->JvmUtilities.objectTotalSize(s1));

        logger.info(() -> JvmUtilities.jvmInfo());
    }

    @Test
    public void testMemoryStrings(){

        groupAdmin.append("Hello");
        logger.info(() -> JvmUtilities.objectFootprint(groupAdmin));
        groupAdmin.append(" world!");
        logger.info(() -> JvmUtilities.objectFootprint(groupAdmin));
        groupAdmin.delete(0,5);
        logger.info(() -> JvmUtilities.objectFootprint(groupAdmin));
        groupAdmin.insert(0,"Hello");
        logger.info(() -> JvmUtilities.objectFootprint(groupAdmin));
        groupAdmin.undo();
        logger.info(() -> JvmUtilities.objectFootprint(groupAdmin));
    }

    @Test
    public void Test2() {
        GroupAdmin tester =new GroupAdmin();
        logger.info(() -> JvmUtilities.objectTotalSize(tester));
        tester.append("Great");
        logger.info(() -> JvmUtilities.objectTotalSize(tester));
        ConcreteMember c1 = new ConcreteMember();
        ConcreteMember c2 = new ConcreteMember();
        ConcreteMember c3 = new ConcreteMember();
        ConcreteMember c4 = new ConcreteMember();
        tester.register(c1);
        tester.register(c2);
        tester.register(c3);
        tester.register(c4);
        tester.register(c4); // return  message about duplicate
        tester.append("!!!");
        //Checking if they have the same size
        logger.info(() -> JvmUtilities.objectTotalSize(c1));
        logger.info(() -> JvmUtilities.objectTotalSize(c2));
        assertEquals(JvmUtilities.objectTotalSize(c1), JvmUtilities.objectTotalSize(c2));
        tester.undo();
        assertEquals("Great", c1.toString());
        tester.unregister(c4);
        tester.delete(0, 1);
        assertEquals("reat", c1.toString());
        assertEquals(c2.toString(), c3.toString());
        logger.info(() -> (" Size before unregister is:"));
        logger.info(() -> JvmUtilities.objectTotalSize(tester));
        tester.unregister(c3);
        logger.info(() -> ("Size  after unregister:"));
        logger.info(() -> JvmUtilities.objectTotalSize(tester));
    }



}
