package Optional;

public class MethodDemo {
    interface UseString{
        String use(String str, int start, int length);
    }
    public static class UserString implements UseString{

        @Override
        public String use(String str, int start, int length) {
            return str.substring(start, length);
        }
    }
    public static String subAuthorName(String str, UseString useString){
        int start = 0;
        int length = 1;
        return useString.use(str, start, length);
    }

    public static void main(String[] args) {
        UserString userString = new UserString();
        userString.use("林北", 0, 1);
        subAuthorName("林北", String::substring);
    }
}
