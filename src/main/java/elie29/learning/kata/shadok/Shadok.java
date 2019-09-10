package elie29.learning.kata.shadok;

import lombok.Getter;

public enum Shadok
{
   GA(0),
   BU(1),
   ZO(2),
   MEU(3);

   @Getter
   private final int index;

   Shadok(int index)
   {
      this.index = index;
   }

   public static Shadok from(String code)
   {
      switch (code) {
         case "GA":
            return GA;
         case "BU":
            return BU;
         case "ZO":
            return ZO;
         default:
            return MEU;
      }
   }

   public static Shadok from(int index)
   {
      switch (index) {
         case 0:
            return GA;
         case 1:
            return BU;
         case 2:
            return ZO;
         default:
            return MEU;
      }
   }
}
