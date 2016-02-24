package com.qianxiaofeng.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.Executors;

public class FastSort {
	
	private static Random random = new Random();
	
	public static int [] getRandomDatas(int size){
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 0 ; i < size ; i++){
			int randomData = random.nextInt(1000);
			while(list.contains(randomData)){
				randomData = random.nextInt(1000);
			}
			list.add(randomData);
		}
		
		int [] datas = new int [size];
		int index = 0;
		for(int v : list){
			datas[index++]=v;
		}
		return datas;
	}

	public static void fastSort(int [] datas){
		fastSort(datas, 0, datas.length - 1);
	}
	
	public static void fastSort(int [] datas, int startIndex, int endIndex){
		if(startIndex >= endIndex){
			return;
		}
		int pIndex = startIndex;
		int p = datas[startIndex];
		for(int index = startIndex ;index <= endIndex; index++){
			int data = datas[index];
			if(data < p){
				// 如果发现有值小于P且和P之间存在其他元素，则将该值和P右侧的值交换位置
				int nextPIndex = pIndex + 1;
				if(index > nextPIndex){
					datas[index] = datas[nextPIndex];
				}
				// 将小于P的元素置于P左侧，并移动P游标
				datas[pIndex++] = data;
				datas[pIndex] = p;
			}
		}
		fastSort(datas, startIndex, pIndex - 1);
		fastSort(datas, pIndex + 1, endIndex);
	}
	
	
	public static void quickSort(int [] datas){
		quickSort(datas, 0, datas.length -1);
	}
	
	
	public static void quickSort(int [] datas, int startIndex, int endIndex){
		if(startIndex > endIndex) return;
		int i = startIndex,  j = endIndex,  p = datas[startIndex], pIndex = startIndex;
		while(i < j){
			while( i < j && datas[j] >= p){
				j--;
			}
			datas[pIndex] = datas[j];
			pIndex = j;
			
			while (i < j && datas[i] <=p){
				i++;
			}
			datas[pIndex] = datas[i];
			pIndex = i;
		}
		datas[pIndex] = p;
		
		quickSort(datas, startIndex, pIndex-1);
		quickSort(datas, pIndex + 1, endIndex);
	}
	
	public static void printData(int [] datas, int lineDataSize){
		int lineCounter = 0;
		for(int data : datas){
			System.out.print(data);
			System.out.print(" ");
			if(lineCounter++ > lineDataSize){
				lineCounter = 0;
				System.out.println();
			}
		}
	}
	
	public static void main(String[] args) {
		//int [] datas = {7,1,9,6,5,8,2,3};
		int [] datas = getRandomDatas(200);
		printData(datas, 20);
		//fastSort(datas);
		quickSort(datas);
		System.out.println();
		System.out.println("==================排序后===================");
		printData(datas, 20);
	}
	
	
}
