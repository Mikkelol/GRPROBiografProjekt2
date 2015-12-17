import controller.ControllerTest;
import controller.InstanciatorTest;
import model.*;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * Created by Olaleo on 17-12-2015.
 */
public class MainTest
{
    public static void main(String[] args)
    {
        Result result = JUnitCore.runClasses(CustomerTest.class);
        for (Failure failure : result.getFailures())
        {
            System.out.println(failure.toString());
        }

        result = JUnitCore.runClasses(ReservationTest.class);
        for (Failure failure : result.getFailures())
        {
            System.out.println(failure.toString());
        }

        result = JUnitCore.runClasses(ShowTest.class);
        for (Failure failure : result.getFailures())
        {
            System.out.println(failure.toString());
        }

        result = JUnitCore.runClasses(TheaterTest.class);
        for (Failure failure : result.getFailures())
        {
            System.out.println(failure.toString());
        }

        result = JUnitCore.runClasses(ControllerTest.class);
        for (Failure failure : result.getFailures())
        {
            System.out.println(failure.toString());
        }

        result = JUnitCore.runClasses(InstanciatorTest.class);
        for (Failure failure : result.getFailures())
        {
            System.out.println(failure.toString());
        }
    }
}

