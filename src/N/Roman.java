package N;

public class Roman {
    public String intToRoman(int num) {
        if(num <= 0) {
            return "";
        }
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder res = new StringBuilder();
        int digit=0;
        while (num > 0) {
            int times = num / nums[digit];
            num -= nums[digit] * times;
            for ( ; times > 0; times--) {
                res.append(symbols[digit]);
            }
            digit++;
        }
        return res.toString();
    }

    /*
    public String intToRoman(int n) {
        // Write your code here
        String M[] = {"", "M", "MM", "MMM"};
        String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return M[n / 1000] + C[(n / 100) % 10] + X[(n / 10) % 10] + I[n % 10];
    }*/

    /*public int romanToInt(String s) {
	    if (s == null || s.length()==0) {
                return 0;
	    }
	    Map<Character, Integer> m = new HashMap<Character, Integer>();
	    m.put('I', 1);
	    m.put('V', 5);
	    m.put('X', 10);
	    m.put('L', 50);
	    m.put('C', 100);
	    m.put('D', 500);
	    m.put('M', 1000);

	    int length = s.length();
	    int result = m.get(s.charAt(length - 1));
	    for (int i = length - 2; i >= 0; i--) {
	        if (m.get(s.charAt(i + 1)) <= m.get(s.charAt(i))) {
	            result += m.get(s.charAt(i));
	        } else {
	            result -= m.get(s.charAt(i));
	        }
	    }
	    return result;
	}*/

    /*public int romanToInt(String s) {
        // Write your code here
        int ans;
        char[] sc = s.toCharArray();
        ans = toInt(sc[0]);                        //0 special
        for (int i = 1; i < s.length(); i++) {
            ans += toInt(sc[i]);
            if (toInt(sc[i - 1]) < toInt(sc[i])) {
                ans -= toInt(sc[i - 1]) * 2;
            }
        }
        return ans;
    }

    int toInt(char s) {
        switch(s) {
            case 'I':return 1;
            case 'V':return 5;
            case 'X':return 10;
            case 'L':return 50;
            case 'C':return 100;
            case 'D':return 500;
            case 'M':return 1000;
        }
        return 0;
    }*/
}
