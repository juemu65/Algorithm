package N;

public class longestCommonPrefix {
    /*
    * 14.最长公共前缀
    * 查找字符串数组中的最长公共前缀。
    *
    * */
    public String longestCommonP(String[] strs) {
        if (strs .length==0) return "";
        char[] chars1 = strs[0].toCharArray();
        int last = chars1.length;
        for (int i = 1; i < strs.length; i++) {
            char[] chars2 = strs[i].toCharArray();
            if (chars2.length < last) last = chars2.length;
            int temp = 0;
            for (int j = 0; j < last; j++) {
                if (chars1[j] == chars2[j]) {
                    temp += 1;
                } else {
                    break;
                }
            }
            if (last > temp) last = temp;
        }
        if (last <= 0) {
            return "";
        }
        char[] chars = new char[last];
        System.arraycopy(chars1, 0, chars, 0, last);
        return String.valueOf(chars);

    }
/*

    */
}
