package DFS;
import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 *
 */
public class _17_电话号码的字母组合 {

    /// 数字键盘对应字符数组
    private char[][] lettersArr = {
            {'a', 'b', 'c'}, {'d', 'e', 'f'},
            {'g', 'h', 'i'}, {'j', 'k', 'l'},
            {'m', 'n', 'o'}, {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}
    };

    /// 最重 拼车的字符串数组
    private List<String> list;

    /// 传入的字符串转成的字符数组
    private char[] chars;

    /// 拼接过程中的字符数组
    private char[] string;

    public List<String> letterCombinations(String digits) {
        if (digits == null) {
            return null;
        }
        list = new ArrayList<>();
        if (digits.length() == 0) {
            return list;
        }
        // 传入字符串转成数组
        chars = digits.toCharArray();
        // 拼接字符串
        string = new char[chars.length];
        // 开始递归 从传入字符串的第一个字符开始
        dfs(0);
        return list;
    }

    private void dfs(int idx) {
        // 拼接到最后一个字符 切记生成新的字符串放入数组 不然后边放进去的都是同一个字符串
        if (idx == chars.length) {
            list.add(new String(string));
            return;
        }

        // 从数字2 开始有对应字母 并且数组下标从0开始  所以减'2'  比如 '4' - '2'
        // 取出当前字符对应的字符数组
        char[] letters = lettersArr[chars[idx] - '2'];
//        for (int i = 0; i < letters.length; i++) {
//            string[idx] = letters[i];
//            dfs(idx+1);
//        }
        for (char letter : letters) {
            // 遍历拼入 递归到下一层
            string[idx] = letter;
            dfs(idx+1);
        }
    }
}
