package elie29.learning.kata.shadok;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@RunWith(JUnitParamsRunner.class)
public class ShadokAdditionerTest
{
   private ShadokAdditioner additioner;

   @Before
   public void setUp()
   {
      additioner = new ShadokAdditioner();
   }

   @Test
   public void nothing_should_return_nothing() throws Exception
   {
      assertThat(additioner.add("GA", "GA"), is("GA"));
   }

   @Test
   @Parameters({
      "GA,BU,BU",
      "BU,GA,BU",
      "GA,ZO,ZO",
      "ZO,GA,ZO",
      "GA,MEU,MEU",
      "MEU,GA,MEU",
   })
   public void something_with_nothing_return_something(String left, String right, String expected)
   {
      assertThat(additioner.add(left, right), is(expected));
   }

   @Test
   @Parameters({
      "BU,BU,ZO",
      "BU,ZO,MEU",
      "BU,MEU,BUGA",
      "ZO,ZO,BUGA",
      "ZO,MEU,BUBU",
      "MEU,MEU,BUZO",
      "BUBUGA,ZOBUGA,MEUZOGA",
      "MEUZOBU,MEUZOBUGA,BUGABUMEUBU",
      "MEUZOBUGA,MEUZOBUGA,BUMEUGAZOGA",
   })
   public void something_with_something_return_something(String left, String right, String expected)
   {
      assertThat(additioner.add(left, right), is(expected));
      assertThat(additioner.add(right, left), is(expected));
   }
}
