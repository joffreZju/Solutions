package basicAlgorithms;

import leetcode.util.ListNode;

import java.util.Arrays;

public class Sort {
    /** 快排
     * 当快排有很多重复元素时，可以使用三向切分，左边小于pivot，中间等于pivot，右边大于pivot
     * 返回 pos 时，带上 pivot 的左边界和边界，这样中间等于pivot的一段就不需要处理了。
     */
    public static void quickSort(int[] nums, int low, int high) {
        if (low >= high) return;
        int pos = partition(nums, low, high);
        quickSort(nums, low, pos - 1);
        quickSort(nums, pos + 1, high);
    }

    private static int partition(int[] nums, int low, int high) {
        int tmp = nums[low];
        while (low < high) {
            while (low < high && nums[high] >= tmp) high--;
            nums[low] = nums[high];

            while (low < high && nums[low] <= tmp) low++;
            nums[high] = nums[low];
        }
        nums[low] = tmp;
        return low;
    }

    // 单链表快排
    public static void quickSort(ListNode head, ListNode tail) {
        if (head != tail) {
            ListNode pos = partition(head, tail);
            quickSort(head, pos);
            quickSort(pos.next, tail);
        }
    }

    private static ListNode partition(ListNode head, ListNode tail) {
        ListNode p = head, q = head.next;
        while (q != tail) {
            if (q.val < head.val) {
                p = p.next;
                swap(q, p);
            }
            q = q.next;
        }
        swap(p, head);
        return p;
    }

    private static void swap(ListNode n1, ListNode n2) {
        int tmp = n1.val;
        n1.val = n2.val;
        n2.val = tmp;
    }

    // 大顶堆: left = 2 * i + 1, right = 2 * i + 2, parent = (i - 1) / 2
    private static void swap(int[] nums, int i, int j) {
        int t = nums[j];
        nums[j] = nums[i];
        nums[i] = t;
    }

    private static void adjustUp(int[] nums, int k) {
        // 插入元素之后向上调整，排序时用不到
        for (int i = (k - 1) / 2; i >= 0; i = (i - 1) / 2) {
            if (nums[k] > nums[i]) {
                swap(nums, i, k);
                k = i;
            } else break;
        }
    }

    private static void adjustDown(int[] nums, int k, int end) {
        for (int i = k * 2 + 1; i <= end; i = i * 2 + 1) {
            // 左右子节点选一个较大的，和父节点交换
            if (i + 1 <= end && nums[i] < nums[i + 1]) i++;

            if (nums[k] < nums[i]) {
                swap(nums, k, i);
                k = i;
            } else break;
        }
    }

    public static void heapSort(int[] nums) {
        int len = nums.length;
        // 建立大顶堆
        for (int i = (len - 1 - 1) / 2; i >= 0; i--) {
            adjustDown(nums, i, len - 1);
        }
        System.out.println(Arrays.toString(nums));
        // 每次交换nums[0]，nums[i]，然后重新调整堆nums[0……i-1]
        for (int i = len - 1; i > 0; i--) {
            swap(nums, 0, i);
            adjustDown(nums, 0, i - 1);
        }
    }

    // 归并
    private static void merge(int[] nums, int low, int mid, int high) {
        int[] tab = new int[nums.length]; // 存储数组应该使用全局变量
        System.arraycopy(nums, low, tab, low, high - low + 1);
        // for (int i = low; i <= high; i++) tab[i] = nums[i];

        int i = low, j = mid + 1, k = low;
        while (i <= mid && j <= high) {
            if (tab[i] < tab[j]) nums[k++] = tab[i++];
            else nums[k++] = tab[j++];
        }
        while (i <= mid) nums[k++] = tab[i++];
        while (j <= high) nums[k++] = tab[j++];
    }

    public static void mergeSort(int[] nums, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            mergeSort(nums, low, mid);
            mergeSort(nums, mid + 1, high);
            merge(nums, low, mid, high);
        }
    }

    // 单链表归并，快慢指针找 mid，然后 merge
    private static ListNode merge(ListNode l1, ListNode l2) {
        // 递归 merge
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.val < l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        } else {
            l2.next = merge(l1, l2.next);
            return l2;
        }

        // 非递归 merge
        // ListNode fake = new ListNode(0), cur = fake;
        // while (l1 != null && l2 != null) {
        //     if (l1.val < l2.val) {
        //         cur.next = l1;
        //         l1 = l1.next;
        //     } else {
        //         cur.next = l2;
        //         l2 = l2.next;
        //     }
        //     cur = cur.next;
        // }
        // if (l1 != null) cur.next = l1;
        // if (l2 != null) cur.next = l2;
        // return fake.next;
    }

    public static ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode right = slow.next;
        slow.next = null;
        return merge(mergeSort(head), mergeSort(right));
    }


    public static void main(String[] args) {
        int[] nums1 = {1, 9, 2, 8, 3, 7, 4, 6, 5, 0};
        int[] nums2 = {1, 9, 2, 8, 3, 7, 4, 6, 5};
        ListNode head1 = ListNode.parse(nums1);
        ListNode head2 = ListNode.parse(nums2);


        // quickSort(nums1, 0, nums1.length - 1);
        // quickSort(nums2, 0, nums2.length - 1);

        // quickSort(head1, null);
        // quickSort(head2, null);

        // heapSort(nums1);
        // heapSort(nums2);

        // mergeSort(nums1, 0, nums1.length - 1);
        // mergeSort(nums2, 0, nums2.length - 1);

        ListNode.printListNode(mergeSort(head1));
        ListNode.printListNode(mergeSort(head2));


        // ListNode.printListNode(head1);
        // ListNode.printListNode(head2);

        // System.out.println(Arrays.toString(nums1));
        // System.out.println(Arrays.toString(nums2));

    }
}
