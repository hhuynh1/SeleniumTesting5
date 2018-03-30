import org.junit.Assert;
import org.junit.Test;

public class TuitionTest {

    @Test
    public static void InstateTuitionTest() {

    }

    @Test
    public static void outOfstateTuitionTest() {
        GGCTuition tuition = new GGCTuition();
        Assert.assertEquals(16348, tuition.outOfStateTuition);

    }
}
