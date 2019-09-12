package elie29.learning.kata.shadok;

import java.util.ArrayList;
import java.util.List;

import static elie29.learning.kata.shadok.Shadok.BU;
import static elie29.learning.kata.shadok.Shadok.GA;

public class ShadokAdditioner
{

   private static final String MEU = "MEU";

   public String add(String left, String right)
   {
      List leftCode = extract(left);
      List rightCode = extract(right);

      return sum(leftCode, rightCode);
   }

   private List extract(String value)
   {
      List<Shadok> shadoks = new ArrayList();
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
         shadoks.add(shadok);
      } while (index < value.length());

      return shadoks;
   }

   private String sum(List<Shadok> left, List<Shadok> right)
   {
      StringBuffer res = new StringBuffer();
      Shadok carry = GA;

      adjustListSize(left, right);

      /* Add all shadoks from right to left */
      for (int i = left.size() - 1; i >= 0; i -= 1) {
         Shadok sL = left.get(i);
         Shadok sR = right.get(i);

         // add carry + left + right
         ShadokSum lr = sL.add(sR);
         ShadokSum clr = carry.add(lr.shadok);

         // set carry for the next iteration
         carry = (lr.hasCarry || clr.hasCarry) ? BU : GA;

         res.insert(0, clr.shadok);
      }

      // Check carry for the last shadok
      if (carry == BU) {
         res.insert(0, BU);
      }

      return res.toString();
   }

   private void adjustListSize(List<Shadok> left, List<Shadok> right)
   {
      int diff = left.size() - right.size();

      if (diff < 0) {
         fill(left, -diff);
      } else if (diff > 0) {
         fill(right, diff);
      }
   }

   private void fill(List<Shadok> list, int count)
   {
      for (int i = 0; i < count; i += 1) {
         list.add(0, GA);
      }
   }
}
