package com.ccsi;

public class Main {

    public static void main(String[] args) {
	    int[] array={3,2,5,1,7};
        quickSort(array,0,array.length-1);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
    //1.bubble sort(O(n^2))        //将最大值放到最后，第二大方到倒数第二位。。。。
    public static void bubbleSort(int[] array){
       if(array==null||array.length<=1)return;
        for (int i = array.length-1; i >=1 ; i--) {
            for (int j = 0; j < i; j++) {
                if(array[j]>array[j+1]){
                    int temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                }
            }
        }
    }
    //2.selection sort //将最小值放到一位，倒数第二小放到第二位。。。。。
    public static void selecttionSort(int[] array){
        if(array==null||array.length<=1)return;
        for (int p = 0; p < array.length - 2; p++) {
            for (int q = p+1; q <array.length; q++) {
                if(array[p]>array[q]){
                    int temp=array[p];
                    array[p]=array[q];
                    array[q]=temp;
                }
            }
        }
    }
    //3.Insertion Sort  //
    public static void insertionSort(int[] array){
        if(array==null||array.length<=1)return;
        for (int p = 1; p <=array.length-1; p++) {
            for (int q = p; q >=1 ; q--) {
                if(array[q]<array[q-1]){
                    int temp=array[q];
                    array[q]=array[q-1];
                    array[q-1]=temp;
                }
            }
        }
    }
    //4.mergeSort
    public static void mergeSort(int[] array,int li,int hi){
        if(li>=hi) return;
        int mi=li+(hi-li)/2;
        mergeSort(array,li,mi);
        mergeSort(array,mi+1,hi);
        merge(array,li,hi);
    }
    public static void merge(int[] array,int li,int hi){
        int mi=li+(hi-li)/2;
        int p=li;
        int q=mi+1;
        int i=li;
        int[] aux=array.clone();
        while(p<=mi||q<=hi){
            if(p==mi+1){
                array[i++]=aux[q++];
            }else if(q==hi+1){
                array[i++]=aux[p++];
            }else if(aux[p]<aux[q]){
                array[i++]=aux[p++];
            }else{
                array[i++]=aux[q++];
            }
        }
    }
    //5.quickSort
    public static void quickSort(int[] array,int li,int hi){
        if(li>=hi)return;
        int qi=partition(array,li,hi);
        quickSort(array,li,qi);
        quickSort(array,qi+1,hi);
    }
    public static int partition(int[] array,int li,int hi){
        int pivot=array[li];
        int p=li;
        int q=hi+1;
        while(true){
            while(array[++p]<pivot&&p<=hi);
            while(array[--q]>pivot&&q>li);
            if(p<q){
                exchange(array,p,q);
            }else break;
        }
        exchange(array,li,q);
        return q;
    }
    public static void exchange(int[] array,int li,int hi){
        int temp=array[li];
        array[li]=array[hi];
        array[hi]=temp;
    }

}
