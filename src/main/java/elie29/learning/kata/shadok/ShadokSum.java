package elie29.learning.kata.shadok;

public class ShadokSum
{
   public final Shadok shadok;
   public final boolean hasCarry;

   public ShadokSum(Shadok shadok, boolean hasCarry)
   {
      this.shadok = shadok;
      this.hasCarry = hasCarry;
   }

   public ShadokSum(Shadok shadok)
   {
      this(shadok, false);
   }
}
