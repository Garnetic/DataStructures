public class JavaHw2 {
    public static void main(String[] args) {
        int[] v1 = {2, 4, 3, 3, 1, 11};
        System.out.println(versionFinder(v1));

        int[] v2 = {6, 2, 4, 7, 9, 11};
        System.out.println(versionFinder(v2));

        int[] v3 = {2, 8, 6, 9, 7, 11, 13};
        System.out.println(versionFinder(v3));
    }

    public static int versionFinder(int[] versions) {
        int left = 1;
        int right = versions.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(versions[mid])) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return versions[left];
    }

    public static boolean isBadVersion(int version) {
        return version % 2 == 1;
    }
}
