import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TDD {
    //基本的牌面判断 假设输入都是按顺序的
    //对子
    @Test
    public void Pair() {
//        assertEquals(3, new Utils().hasPair(new String[]{"2h", "3h", "4h", "5h", "5h"}));
//        assertEquals(-1, new Utils().hasPair(new String[]{"2h", "2h", "2h", "4h", "5h"}));
        assertEquals(3, new Utils().hasPair(new String[]{"2h", "2h", "2h", "4h", "4h"}));
    }

    @Test
    public void DoublePair() {
        assertEquals(0, Utils.hasDoublePair(new String[] {"2h", "2h", "3h", "4h", "4h"}));
        assertEquals(0, Utils.hasDoublePair(new String[] {"2h", "3h", "3h", "4h", "4h"}));
        assertEquals(-1, Utils.hasDoublePair(new String[] {"2h", "2h", "2h", "2h", "4h"}));
    }

    //三条
    @Test
    public void Triple() {
        assertEquals(-1, new Utils().hasTriple(new String[]{"2h", "3h", "4h", "5h", "5h"}));
        assertEquals(1, new Utils().hasTriple(new String[]{"2h", "3h", "3h", "3e", "6h"}));
        assertEquals(-1, Utils.hasTriple(new String[]{"3h", "3h", "3h", "3e", "6h"}));
    }

    @Test
    public void Irondev() {
        assertEquals(0, Utils.hasIrondev(new String[]{"3h", "3h", "3h", "3e", "6h"}));
    }
    //顺子
    @Test
    public void Sequences() {
        assertEquals(-1, new Utils().hasSequences(new String[]{"2h", "3h", "4h", "5h", "7h"}));
        assertEquals(0, new Utils().hasSequences(new String[]{"2h", "3h", "4h", "5h", "6h"}));
    }

    @Test
    public void ColorSequence() {
        assertEquals(0, Utils.hasSameColor(new String[] {"2h", "2h", "3h", "2h", "2h"}));
    }
    //同花顺
    @Test
    public void Flush() {
        assertEquals(0, new Utils().hasFlush(new String[]{"2h", "3h", "4h", "5h", "6h"}));
        assertEquals(-1, new Utils().hasFlush(new String[]{"2h", "3h", "4h", "5h", "6d"}));
        assertEquals(-1, new Utils().hasFlush(new String[]{"2h", "3h", "4h", "5h", "6c"}));
    }

    //葫芦
    @Test
    public void Gourd() {
        assertEquals(0, new Utils().hasGourd(new String[]{"2h", "2h", "4h", "4h", "4h"}));
        assertEquals(0, new Utils().hasGourd(new String[]{"2h", "2h", "2h", "4h", "4h"}));
    }

    //散牌
    @Test
    public void HighCard() {
        assertEquals(-1, new Utils().hasHighCard(new String[]{"2h", "3h", "6h", "8h", "9h"}));
        assertEquals(-1, new Utils().hasHighCard(new String[]{"2h", "2h", "6h", "8h", "9h"}));
        assertEquals(-1, new Utils().hasHighCard(new String[]{"2h", "3h", "6h", "8h", "9c"}));
    }

    //字符串转化测试，字母转成连续的
//    @Test
//    public void Change() {
//        assertEquals(new String[]{":h", ";h", "<h", "=h", ">h"},new Utils().change(new String[]{"Th", "Jh", "Qh", "Kh", "Ah"}));
//    }
    //
    @Test
    public void Compare() {
        String[] black = new String[]{"2H", "3D", "5S", "9C", "KD"};
        String[] white = new String[]{"2C", "3H", "4S", "8C", "AH"};
//        Comparer c = new Comparer(black, white);
//        assertEquals(1, c.compare());
//        black = new String[]{"2H", "2D", "4S", "4C", "4H"};
//        white = new String[]{"2S", "3S","8S", "QS", "AS"};
//        Comparer c1 = new Comparer(black, white);
//        assertEquals(0, c1.compare());
        black = new String[]{"2H", "3D", "5S", "9C", "KD"};
        white = new String[]{"2C", "3H", "4S", "8C", "KH"};
        Comparer c2 = new Comparer(black, white);
        assertEquals(0, c2.compare());
    }
}
