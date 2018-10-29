import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Subject {
    int result;                                                 //答案
    public String[] subject = new String[20];                  //题目是数组
    public int[] answer = new int[5];                         //答案数组
    char[]h={'+','-','*','/'},h1={'(',')','!'};              //符号数组

    public Subject(){}

    public Subject(int number) {
        for(int i = 0;i<number;i++){
            subject[i] = new String();
            star(i);
        }
    }

    void star(int ii)
    {
        int number_1=(int) (Math.random()*200-100);      //random出来的数为0-1之间，然后取-99到99的整数
        int number_2=(int) (Math.random()*200-100);
        int number_3=(int) (Math.random()*200-100);
        int judge=(int) (Math.random()*200-100);           //判断是阶层还是普通算术
        int j=(int) (Math.random()*4);
        int k=(int) (Math.random()*4);
        if(judge<0)
        {
            number_1=(int) (Math.random()*9+1);//随机产生一个整数 范围是0-9(包括0和9)
            subject[ii]=String.valueOf(number_1)+String.valueOf(h1[2])+"=";//获取这个数进行阶乘
            result=1;
            for(int i=1;i<=number_1;i++)//从1开始一直乘到这个数字本身
            {
                result=result*i;
            }
        }
        else
        {
            if(number_2>=0&&number_3>=0)
            {
                //将变量转换成字符串
                subject[ii]=String.valueOf(number_1)+String.valueOf(h[j])+String.valueOf(number_2)+String.valueOf(h[k])+String.valueOf(number_3)+"=";
            }
            else if(number_2<0&&number_3>=0)
            {
                //检测到number_2小于0，为负数，给b的左右两边加上括号运算
                subject[ii]=String.valueOf(number_1)+String.valueOf(h[j])+String.valueOf(h1[0])+String.valueOf(number_2)+String.valueOf(h1[1])+String.valueOf(h[k])+String.valueOf(number_3)+"=";
            }
            else if(number_2>=0&&number_3<0)
            {
                //检测到number_3小于0，为负数，给c的左右两边加上括号运算
                subject[ii]=String.valueOf(number_1)+String.valueOf(h[j])+String.valueOf(number_2)+String.valueOf(h[k])+String.valueOf(h1[0])+String.valueOf(number_3)+String.valueOf(h1[1])+"=";
            }
            else
            {
                //检测到number_2、number_3都小于0，都为负数，给number_2、number_3的左右两边都加上括号运算
                subject[ii]=String.valueOf(number_1)+String.valueOf(h[j])+String.valueOf(h1[0])+String.valueOf(number_2)+String.valueOf(h1[1])+String.valueOf(h[k])+String.valueOf(h1[0])+String.valueOf(number_3)+String.valueOf(h1[1])+"=";
            }
            if(k>1)  //后面的计算符为乘除，先算后面两个数;k=0时为加，k=1时为减
            {
                if(k==2)
                {
                    result=number_2*number_3;
                }
                else if(k==3)
                {
                    result=number_2/number_3;
                }
                if(j==0)
                {
                    result=result+number_1;
                }
                else if(j==1)
                {
                    result=number_1-result;
                }
                else if(j==2)
                {
                    result=number_1*result;
                }
                else if(j==3)
                {
                    result=number_1/result;
                }
            }
            else if(k<2)
            {
                if(j==0)
                {
                    result=number_2+number_1;
                }
                else if(j==1)
                {
                    result=number_1-number_2;
                }
                else if(j==2)
                {
                    result=number_1*number_2;
                }
                else if(j==3)
                {
                    result=number_1/number_2;
                }
                if(k==0)
                    result=result+number_3;
                if(k==1)
                    result=result-number_3;
            }
        }
        answer[ii] = result;
    }
}

