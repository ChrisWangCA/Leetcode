package src.string;

public class KMP {

    public static int getIndexOf(String s, String m) {
        if (s == null || m == null || m.length() < 1 || s.length() < m.length()) {
            return -1;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = m.toCharArray();
        int i1 = 0;
        int i2 = 0;
        int[] next = getNextArray(str2); //o(N)
        //O(N)
        while (i1 < str1.length && i2 < str2.length) {
            //如果string1的当前数和string2的当前数相等就都往后移动，如果不想等string2就往前跳
            if (str1[i1] == str2[i2]) {
                i1++;
                i2++;
            } else if (next[i2]==-1) { //等于-1说明到了0位置，因为-1是人为规定的 i2等于0说明以及到最前面了无法再往前面跳了
                i1++; //然后让string1换个开头看接下来能不能往下配
            } else {
                i2 = next[i2]; //如果不相等并且还能往前跳就往前跳
            }
        }
        // i1越界或者i2越界了
        return i2 == str2.length ? i1 - i2 : -1; //i2等于str2的长度说明越界了然后i1减去i2的长度得到一个开头位置
    }

    //第一个位置人为规定为-1,1位置为0，2位置根据0和1来决定，3根据0,1,2位置来决定....

    public static int[] getNextArray(char[] ms) {
        if (ms.length == 1) { //长度为1的时候
            return new int[] { -1 }; //人为规定为-1
        }
        //如果长度超过了1到达了2或2以上，人为规定0位置是-1，1位置是0
        int[] next = new int[ms.length];
        next[0] = -1;
        next[1] = 0;
        int i = 2; //next数组的位置
        int cn = 0; //cn是拿哪个位置的字符和i-1的字符比，为什么是0，因为i是2，cn是0和i-1也就是1的位置比
        while (i < next.length) {
            if (ms[i - 1] == ms[cn]) {
                next[i++] = ++cn;  //因为对比的是i-1的位置所以i需要先++到达本来i的位置（也就是i原本的位置是cn+1），然后cn也加加了之后在继续比较i-1和cn是否相等
            } else if (cn > 0) {//当前跳到cn位置的字符，和i-1位置的字符不相等
                cn = next[cn];
            } else {
                next[i++] = 0; //没法往前跳了那么i位置信息就是0
            }
        }
        return next;
    }

    public static void main(String[] args) {
        String str = "abcabcababaccc";
        String match = "ababa";
        System.out.println(getIndexOf(str, match));




    }

}

