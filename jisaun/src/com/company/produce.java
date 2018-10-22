package com.company;

import java.util.*;

public class produce {
    public int[] num;          //运算数
    public String[] operator;  //运算符
    public int char_name = 3;     //运算个数
    public int answer = 0;         //答案
    public produce(){
        do {
            createExercise();
        }while (answer < 0);
    }

    /**
     * 习题初始化
     */
    private void createExercise(){
        Random rand =new Random();
        this.num = new int[char_name];
        this.operator = new String[char_name];
            for (int i = 0; i < char_name; i++) {
                this.num[i] = rand.nextInt(100);
                int oper = rand.nextInt(4);
                if (i == char_name - 1) {
                    this.operator[char_name - 1] = "=";
                } else {
                    switch (oper) {
                        case 0:
                            this.operator[i] = "+";
                            break;
                        case 1:
                            this.operator[i] = "-";
                            break;
                        case 2:
                            this.operator[i] = "*";
                            break;
                        case 3:
                            this.operator[i] = "/";
                            break;
                    }
                }
            }
    }

    /**
     * 计算算式答案
     * 返回答案字符串
     */
    public String getAnswer(){
        int answer = 0;
        List<Integer> answer_num = new ArrayList<Integer>();
        List<String> answer_operator = new ArrayList<String>();
        for (int i = 0;i < num.length;i++){
            answer_num.add(num[i]);
            answer_operator.add(operator[i]);
        }
        for (int i = 0; i < answer_operator.size(); ){  //先乘除
            if (answer_operator.get(i).equals("*")){
                answer = answer_num.get(i) * answer_num.get(i+1);
                answer_num.set(i,answer);
                answer_num.remove(i+1);
                answer_operator.remove(i);
            }else if (answer_operator.get(i).equals("/")){
                answer = answer_num.get(i) /answer_num.get(i+1);
                answer_num.set(i,answer);
                answer_num.remove(i+1);
                answer_operator.remove(i);
            }else
                i++;
        }
        for (int i = 0; i < answer_operator.size(); ){  //后加减
            if (answer_operator.get(i).equals("+")){
                answer = answer_num.get(i) + answer_num.get(i+1);
                answer_num.set(i,answer);
                answer_num.remove(i+1);
                answer_operator.remove(i);
            }else if (answer_operator.get(i).equals("-")){
                answer = answer_num.get(i) - answer_num.get(i+1);
                answer_num.set(i,answer);
                answer_num.remove(i+1);
                answer_operator.remove(i);
            }else
                i++;
        }
        return answer+"";
    }

    //设置题目难度
    private void setDegree(int degree){
        this.char_name = degree;
    }

}
