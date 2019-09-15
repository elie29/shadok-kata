package elie29.learning.kata.shadok;

public enum Shadok
{
   GA {
      @Override
      public ShadokSum next()
      {
         return new ShadokSum(BU);
      }

      @Override
      public ShadokSum add(Shadok shadok)
      {
         return new ShadokSum(shadok);
      }
   },
   BU {
      @Override
      public ShadokSum next()
      {
         return new ShadokSum(ZO);
      }

      @Override
      public ShadokSum add(Shadok shadok)
      {
         return shadok.next();
      }
   },
   ZO {
      @Override
      public ShadokSum next()
      {
         return new ShadokSum(MEU);
      }

      @Override
      public ShadokSum add(Shadok shadok)
      {
         if (shadok == GA) return BU.next();
         if (shadok == BU) return next();

         Shadok result = shadok == ZO ? GA : BU;
         return new ShadokSum(result, true);
      }
   },
   MEU {
      @Override
      public ShadokSum next()
      {
         return new ShadokSum(GA, true);
      }

      @Override
      public ShadokSum add(Shadok shadok)
      {
         if (shadok == GA) return ZO.next();
         if (shadok == BU) return next();

         Shadok result = shadok == ZO ? BU : ZO;
         return new ShadokSum(result, true);
      }
   };

   public abstract ShadokSum next();

   public abstract ShadokSum add(Shadok shadok);

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

}
