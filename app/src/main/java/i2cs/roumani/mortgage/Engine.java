package i2cs.roumani.mortgage;

/**
 * Created by roumani on 16-05-18.
 */
public class Engine
{
    private int a;
    private int b;
    private int result;

    public Engine()
    {
        a = b = 0;
    }

    public int doit()
    {
         this.result = this.a * this.b;
        return this.result;
    }
    public String getResult()
    {
        return String.format("%05d", this.result);
    }

    public void setA(String a)
    {
        this.a = Integer.parseInt(a);
    }

    public void setB(String b)
    {
        this.b = Integer.parseInt(b);
    }
}
