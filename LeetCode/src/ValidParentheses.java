public class ValidParentheses {
    public ValidParentheses() {
    }

    boolean isValidJavaParentheses(String s) {
        if (s.length() % 2 != 0) {
            return false;
        } else {
            boolean isValid = false;

            for(int i = (s.length() - 1) / 2; i >= 0; --i) {
                if (s.charAt(i) != s.charAt(s.length() - 1 - i) - 1 && s.charAt(i) != s.charAt(s.length() - 1 - i) - 2) {
                    isValid = false;
                } else {
                    isValid = true;
                }
            }

            return isValid;
        }
    }

    boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        } else {
            boolean isValid = false;

            for(int i = 0; i < s.length(); i += 2) {
                if (s.charAt(i) != s.charAt(i + 1) - 1 && s.charAt(i) != s.charAt(i + 1) - 2) {
                    isValid = false;
                } else {
                    isValid = true;
                }
            }

            return isValid;
        }
    }

    public static void main(String[] args) {
        ValidParentheses validParentheses = new ValidParentheses();
        System.out.println(validParentheses.isValid("[]{}()]]"));
    }
}
