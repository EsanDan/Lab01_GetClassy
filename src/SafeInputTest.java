public class SafeInputTest {
    public static void main(String[] args) {
        SafeInputObj safeInputObj = new SafeInputObj();

        String s = safeInputObj.getNonZeroLenString("String");
        System.out.println("result: " + s);

        int r = safeInputObj.getRangedInt("Number 1-10", 1, 10);
        System.out.println("result: " + r);

        r = safeInputObj.getInt("Number");
        System.out.println("result: " + r);

        double d = safeInputObj.getRangedDouble("Number 1-10", 1, 10);
        System.out.println("result: " + d);

        d = safeInputObj.getDouble("Number");
        System.out.println("result: " + d);

        boolean b = safeInputObj.getYNConfirm("Yes or No");
        System.out.println("result: " + b);

        s = safeInputObj.getRegExString("Enter a string that starts with a letter and ends with a number", "^[a-zA-Z].*[0-9]$");
        System.out.println("result: " + s);

    }
}
