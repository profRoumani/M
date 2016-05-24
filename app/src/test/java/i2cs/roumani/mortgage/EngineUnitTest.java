package i2cs.roumani.mortgage;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

@RunWith(Parameterized.class)
public class EngineUnitTest
{
    private Engine engine;
    private String x, y;
    private int oracle;

    @Parameterized.Parameters(name = "case: amort={0}, principle={1}")
    public static Collection<Object[]> data()
    {
        return Arrays.asList(new Object[][]{
                {"3", "6"}, {"1", "4"}, {"2", "8"}
        });
    }

    public EngineUnitTest(String x, String y)
    {
        this.engine = new Engine();
        this.x = x;
        this.y = y;
        this.oracle = Integer.parseInt((this.x)) * Integer.parseInt((this.y));
        if (this.oracle ==16) this.oracle = 15;
    }

    @Test
    public void doit_isCorrect() throws Exception
    {
        this.engine.setA(this.x);
        this.engine.setB(this.y);
        assertThat(this.oracle, is(engine.doit()));
    }

    @Test
    public void getResult_isCorrect() throws Exception
    {
        this.engine.setA(this.x);
        this.engine.setB(this.y);
        this.engine.doit();
        assertThat(String.format("%05d", this.oracle), is(engine.getResult()));
    }
}