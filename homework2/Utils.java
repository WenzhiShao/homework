public class Utils {
    public static int hasPair(String[] cards) {
        for (int i = 0; i < 4; i++) {
            if (cards[i].charAt(0) == cards[i + 1].charAt(0)) {
                if (i + 2 < 5) {
                    if (cards[i].charAt(0) != cards[i + 2].charAt(0))
                        return i;
                    else
                        i += 2;
                } else
                    return i;
            }
        }
        return -1;
    }

    public static int hasDoublePair(String[] cards) {
        int count = 0;
        int [] pos = new int[2];
        int j = 0;
        for(int i = 0; i < 4; i++) {
            if(cards[i].charAt(0) == cards[i + 1].charAt(0)) {
                pos[j++] = i;
                count++;
                i += 1;
            }
        }

        if(count == 2) {
            if(pos[1] - pos[0] == 2 && cards[pos[0]].charAt(0) == cards[pos[1]].charAt(0))
                return -1;
            return 0;
        }
        return -1;
    }

    public static int hasTriple(String[] cards) {
        for (int i = 0; i < 3; i++) {
            char c1 = cards[i].charAt(0);
            char c2 = cards[i + 1].charAt(0);
            char c3 = cards[i + 2].charAt(0);
            if (c1 == c2 && c2 == c3) {
                if(i + 3 < 5){
                    char c4 = cards[i + 3].charAt(0);
                    if(c4 == c3)
                        return -1;
                    else
                        return i;
                }
                return i;
            }
        }
        return -1;
    }

    public static int hasSequences(String[] cards) {
        for (int i = 0; i < 4; i++) {
            if (cards[i].charAt(0) != cards[i + 1].charAt(0) - 1) {
                return -1;
            }
        }
        return 0;
    }

    public static int hasIrondev(String[] cards) {
        char [] tmp = new char[4];
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 4; j++) {
                tmp[j] = cards[i + j].charAt(0);
            }
            if(tmp[0] == tmp[1] && tmp[0] == tmp[2] && tmp[0] == tmp[3])
                return i;
        }
      return -1;
    }
    public static int hasFlush(String[] cards) {
        if (hasSequences(cards) == 0) {
            for (int i = 0; i < 4; i++) {
                if (cards[i].charAt(1) != cards[i + 1].charAt(1))
                    return -1;
            }
            return 0;
        }
        return -1;
    }

    public static int hasGourd(String[] cards) {
        int pairPos = hasPair(cards);
        int triplePos = hasTriple(cards);

        if (pairPos - triplePos == 3 || triplePos - pairPos == 2)
            return 0;
        return -1;
    }

    public static int hasHighCard(String[] cards) {
        if(hasFlush(cards) != -1)
            return -1;
        if(hasIrondev(cards) != -1)
            return -1;
        if(hasGourd(cards) != -1)
            return -1;
        if(hasSameColor(cards) != -1)
            return -1;
        if(hasSequences(cards) != -1)
            return -1;
        if(hasTriple(cards) != -1)
            return -1;
        if(hasDoublePair(cards) != -1)
            return -1;
        if(hasPair(cards) != -1)
            return -1;
        return 0;
    }

    public static int hasSameColor(String [] cards) {
        char color = cards[0].charAt(1);

        for(int i = 1; i < 5; i++) {
            if(cards[i].charAt(1) != color)
                return -1;
        }
        return 0;
    }

    public static String [] change(String[] cards) {
        String [] newStr = new String[cards.length];
        for(int i = 0; i < 5; i++) {
            StringBuffer tmp = new StringBuffer(cards[i]);
            switch(tmp.charAt(0)){
                case 'T':
                    tmp.setCharAt(0,':');
                    break;
                case 'J':
                    tmp.setCharAt(0,';');
                    break;
                case 'Q':
                    tmp.setCharAt(0,'<');
                    break;
                case 'K':
                    tmp.setCharAt(0,'=');
                    break;
                case 'A':
                    tmp.setCharAt(0,'>');
                    break;
            }
            newStr[i] = tmp.toString();
        }
        return newStr;
    }
}
