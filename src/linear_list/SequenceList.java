package linear_list;

/**
 * Created by imliu on 2016/7/7.
 * 线性表的顺序存储及其操作
 */
public class SequenceList {
    private int[] array;

    public int length;

    //Constructor
    public SequenceList(){}

    public SequenceList(int[] array){
        this.array = array;
        length = array.length;
    }

    public boolean isEmpty(){
        if(array == null || length == 0)
            return true;
        return false;
    }

    public void clearList(){
        array = null;
        length = 0;
    }

    public int getElem(int index){
        return  array[index];
    }

    public int locateElem(int elem){
        for(int i = 0; i < length; ++i){
            if(array[i] == elem)
                return i;
        }
        return -1;
    }

    public void listInsert(int index, int elem){

        //扩大数组+1
        int[] tmpArray = new int[length + 1];

        //如果插入位置在线性表末尾+，则插入到末尾
        if(index >= length){
            //移动原数组成员到新扩建的数组
            for(int i = 0; i < length; ++i){
                tmpArray[i] = array[i];
            }
            tmpArray[length] = elem;
            array = tmpArray;
            ++length;
            return;
        }

        //线性表1~n之间插入
        //index位置前的元素原封不动的迁移到新扩建的数组
        for(int i = 0; i < index; ++i){
            tmpArray[i] = array[i];
        }
        //插入elem到index
        tmpArray[index] = elem;
        //整体移动剩余元素到原位置+1的位置上
        for(int i = index + 1; i < tmpArray.length; ++i){
            tmpArray[i] = array[i - 1];
        }
        array = tmpArray;
        ++length;
        return;
    }

    public int listDelete(int index){

        int tmp;

        //不存在的位置
        if(index >= length){
            throw new IllegalArgumentException("非法位置");
        }

        tmp = array[index];
        //直接使用后继元素附带index位置的元素
        for(int i = index + 1; i < length; ++i){
            array[i - 1] = array[i];
        }
        --length;
        return tmp;
    }

    public int listLength(){
        return length;
    }
}
