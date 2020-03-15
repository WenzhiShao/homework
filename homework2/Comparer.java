enum Type{HighCard, OnePair, DoublePair, Triple, Sequence, Flush, Gourd, IronBranch,  StraightFlush}
public class Comparer {
    //同花顺＞铁支＞葫芦＞同花＞顺子＞三条＞两对＞对子＞散牌
     private String [] black;
     private String [] white;
     private Type [] types;

     public Comparer(String [] black, String [] white) {
         this.black = Utils.change(black);
         this.white = Utils.change(white);
         types = new Type[2];
     }
     public int compare() {
         types[0] = type(black);
         types[1] = type(white);
         if(types[0].ordinal() > types[1].ordinal())
             return 0;
         if(types[0].ordinal() < types[1].ordinal())
             return 1;
         if(types[0].ordinal() == types[1].ordinal()) {
             if(black[4].charAt(0) > white[4].charAt(0))
                 return 0;
             if(black[4].charAt(0) < white[4].charAt(0))
                 return 1;
         }
         return 2;
     }

//     private sameJudge() {
//
//     }
     private Type type(String [] cards) {
         if(Utils.hasFlush(cards) != -1)
             return Type.StraightFlush;
         if(Utils.hasIrondev(cards) != -1)
             return Type.IronBranch;
         if(Utils.hasGourd(cards) != -1)
             return Type.Gourd;
         if(Utils.hasSameColor(cards) != -1)
             return Type.Flush;
         if(Utils.hasSequences(cards) != -1)
             return Type.Sequence;
         if(Utils.hasTriple(cards) != -1)
             return Type.Triple;
         if(Utils.hasDoublePair(cards) != -1)
             return Type.DoublePair;
         if(Utils.hasPair(cards) != -1)
             return Type.OnePair;
         
         return Type.HighCard;
     }
}
