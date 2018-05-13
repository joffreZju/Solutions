package company.tencent;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	private static class Node {
		int time, level;
	}
	// TODO 题目出来跑一下
	// 多个机器完成多个任务
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt(), m = in.nextInt();
		
		Node[] machines = new Node[n];
		Node[] tasks = new Node[m];
		
		for (int i = 0; i < n; i++) {
			machines[i] = new Node();
			machines[i].time = in.nextInt();
			machines[i].level = in.nextInt();
		}
		for (int i = 0; i < m; i++) {
			tasks[i] = new Node();
			tasks[i].time = in.nextInt();
			tasks[i].level = in.nextInt();
		}
		
		Arrays.sort(tasks, (a, b) -> {
			if (a.time == b.time) return b.level - a.level;
			else return b.time - a.time;
		});
		Arrays.sort(machines, (a, b) -> {
			if (a.time == b.time) return b.level - a.level;
			else return b.time - a.time;
		});
		
		int[] level = new int[105];
		long profit = 0, count = 0;
		int j = 0;
		for (int i = 0; i < m; i++) {
			while (j < n && machines[j].time >= tasks[i].time) {
				level[machines[j].level]++;
				j++;
			}
			for (int k = tasks[i].level; k <= 100; k++) {
				if (level[k] > 0) {
					profit += tasks[i].time * 500 + tasks[i].level * 2;
					level[k]--;
					count++;
					break;
				}
			}
		}
		System.out.println(count + " " + profit);
	}
}
