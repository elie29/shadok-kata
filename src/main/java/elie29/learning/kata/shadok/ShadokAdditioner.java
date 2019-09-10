package elie29.learning.kata.shadok;

public class ShadokAdditioner
{

   private static final String ZERO = "0";
   private static final String MEU = "MEU";

   public String add(String left, String right)
   {
      StringBuffer leftCode = extract(left);
      StringBuffer rightCode = extract(right);

      AdjustStringLength(leftCode, rightCode);

      return sum(leftCode, rightCode);
   }

   private StringBuffer extract(String value)
   {
      StringBuffer sb = new StringBuffer();
      Shadok shadok;
      int index = 0;

      do {
         if (value.startsWith(MEU, index)) {
            shadok = Shadok.MEU;
            index += 3;
         } else {
            shadok = Shadok.from(value.substring(index, index + 2));
            index += 2;
         }
         sb.append(shadok.getIndex());
      } while (index < value.length());

      return sb;
   }

   private void AdjustStringLength(StringBuffer leftCode, StringBuffer rightCode)
   {
      // left and right string should have same length
      int diff = leftCode.length() - rightCode.length();

      if (diff < 0) {
         leftCode.insert(0, ZERO.repeat(-diff));
      } else if (diff > 0) {
         rightCode.insert(0, ZERO.repeat(diff));
      }
   }

   private String sum(StringBuffer left, StringBuffer right)
   {
      StringBuffer res = new StringBuffer();
      int carry = 0;

      /* Add all numerals from right to left */
      for (int i = left.length() - 1; i >= 0; i -= 1) {
         /* Add decimal values of numerals and carry */
         int num = carry + toInt(left.charAt(i)) + toInt(right.charAt(i));

         /* Check if we have carry for next addition of numerals */
         carry = 0;
         if (num >= 4) {
            carry = 1;
            num -= 4;
         }

         res.insert(0, Shadok.from(num));
      }

      // Check carry for the last number
      if (carry == 1) {
         res.insert(0, Shadok.BU);
      }

      return res.toString();
   }

   private int toInt(char value)
   {
      return value - '0';
   }
}
